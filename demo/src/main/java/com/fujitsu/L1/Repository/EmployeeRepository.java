package com.fujitsu.L1.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import com.fujitsu.L1.Pojo.*;


@Repository
public class EmployeeRepository {
	@PersistenceContext
    private EntityManager entityManager;

    /*
    * @Autowired private AppTypeProperties prop;
    */
    protected Session getCurrentSession() {
            return entityManager.unwrap(Session.class);
    }

	public  List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		Session session= getCurrentSession();
		session.clear();
		
		String sql= "select * from employees";
		List<Employee> emplist= session.createSQLQuery(sql).addEntity(Employee.class).getResultList();
		return emplist;
	}

	public Employee getempById(long empid) {
		// TODO Auto-generated method stub
		Session session= getCurrentSession();
		session.clear();
		
		String sql= "select * from employees where emp_id=:eid";
		List<Employee> emplist= session.createSQLQuery(sql).addEntity(Employee.class).setParameter("eid", empid).getResultList();
		if(!emplist.isEmpty())
		return emplist.get(0);
		else
		return new Employee();
	}

	public String delete(long empid) {
		// TODO Auto-generated method stub
		Session session =getCurrentSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         Employee employee = (Employee)session.get(Employee.class, empid);
	         session.delete(employee); 
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
		return "Success";
		
		
		
	}

	public Employee saveOrUpdate(Employee emp) {
		// TODO Auto-generated method stub
		Session session =getCurrentSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	       //  Employee employee = 
	        //           (Employee)session.get(Employee.class, emp.getEmp_id()); 
	        // employee.setSalary( salary );
	         // if need to update particular item
	         session.saveOrUpdate(emp); 
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
		return emp;
	}

	
}

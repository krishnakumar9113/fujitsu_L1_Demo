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
public class EmployeeHistoryRepository {
	
	@PersistenceContext
    private EntityManager entityManager;

    /*
    * @Autowired private AppTypeProperties prop;
    */
    protected Session getCurrentSession() {
            return entityManager.unwrap(Session.class);
    }

	public  List<EmployeeHistory> getEmpHistoryForEmp(long empid) {
		// TODO Auto-generated method stub
		Session session= getCurrentSession();
		session.clear();
		String sql= "select * from employment_history where emp_id=:eid";
		List<EmployeeHistory> emphistlist= session.createSQLQuery(sql).addEntity(EmployeeHistory.class).setParameter("eid",empid).getResultList();
		return emphistlist;
	}

	public EmployeeHistory saveOrUpdate(EmployeeHistory emphist,long empid) {
		// TODO Auto-generated method stub
		Session session =getCurrentSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         Employee employee = (Employee)session.get(Employee.class, empid); 
	        // employee.setSalary( salary );
	         // if need to update particular item
	         emphist.setEmployee(employee );
	         session.saveOrUpdate(emphist); 
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
		return emphist;
	}

	/*
	 * public String delete(long empid) { // TODO Auto-generated method stub Session
	 * session =getCurrentSession(); Transaction tx = null; try{ tx =
	 * session.beginTransaction(); EmployeeHistory employeehist =
	 * (EmployeeHistory)session.find(EmployeeHistory.class, empid);
	 * session.delete(employee); tx.commit(); }catch (HibernateException e) { if
	 * (tx!=null) tx.rollback(); e.printStackTrace(); }finally { session.close(); }
	 * return "Success";
	 * 
	 * 
	 * 
	 * }
	 */
	
}

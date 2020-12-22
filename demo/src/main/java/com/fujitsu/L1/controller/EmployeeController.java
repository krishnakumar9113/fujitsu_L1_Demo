package com.fujitsu.L1.controller;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.websocket.server.PathParam;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fujitsu.L1.Pojo.Employee;
import com.fujitsu.L1.Repository.EmployeeRepository;

@RestController
@CrossOrigin
//@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeRepository emprepo;

	@GetMapping("/employees")
	private ResponseEntity getAllEmployees() {
		List<Employee> emps = emprepo.getAllEmployees();
		if (emps.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(createmessage(" Sorry, employee record could not be found!!"));
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(emps);
		}

	}

	@GetMapping("/employeefilter")
	private ResponseEntity getemp_name_gender(@PathParam("empname") String empname,
			@PathParam("gender") String gender) {
		List<Employee> emps = emprepo.getEmpByNameGender(empname, gender);
		if (emps.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(createmessage(" Sorry, employee record could not be found!!"));
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(emps);
		}
		// return emprepo.getEmpByNameGender(empname,gender);
	}

	@GetMapping("/employee/{empid}")
	private ResponseEntity getEmployee(@PathVariable("empid") int empid) {

		Employee emp = emprepo.getempById(empid);
		if (emp == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(createmessage(" Sorry, employee record could not be found!!"));
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(emp);
		}

	}

	@DeleteMapping("/employee/{empid}")
	private ResponseEntity deleteEmployee(@PathVariable("empid") long empid) {
		if (emprepo.delete(empid).equals("Success")) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(createmessage("Employee record has been deleted successfully"));
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(createmessage("Error has encounterd, failed to delete record."));
		}

	}

	@PostMapping("/employee")
	private ResponseEntity saveEmployee(@Valid @RequestBody Employee emp, BindingResult bindingResult)

	{
		try {
			List<FieldError> be= new ArrayList<FieldError>();
			if(!emprepo.EmailValidation(emp.getEmail_id())) {
				
				FieldError fe= new FieldError("employee", "email_id", "Email id is already taken!");
				be.add(fe);
			}
			 if(!emprepo.officeEmailIDValidation(emp.getOffice_mail())) {

				FieldError fe= new FieldError("employee", "office_mail", " Office Email id is already taken!");
				be.add(fe);
			}
			 if (bindingResult.hasErrors()) {
				be.addAll(bindingResult.getFieldErrors());
			 }
			if(be.isEmpty()) {
				String createdemp = emprepo.saveOrUpdate(emp);
				return ResponseEntity.status(HttpStatus.CREATED)
						.body(createmessage("Employee record has been saved successfully"));
			
			} else {
				
				System.out.println("error hit -POST");
				
				return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(be);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest()
					.body(createmessage("Server error has encountered, failed to save the record"));
		}
	}

	// creating put mapping that updates the book detail
	@PutMapping("/employee")
	private ResponseEntity updateEmployee(@Valid @RequestBody Employee emp, BindingResult bindingResult) {
		
		try {
			List<FieldError> be= new ArrayList<FieldError>();
			if(emp.getEmail_id().equals(emprepo.getempById(emp.getEmp_id()).getEmail_id())) {
				
				//No Error, SInce its a put request
			}else
			{
				if(!emprepo.EmailValidation(emp.getEmail_id())) {
					
					FieldError fe= new FieldError("employee", "email_id", "Email id is already taken!");
					be.add(fe);
				}
			}
			if(emp.getOffice_mail().equals(emprepo.getempById(emp.getEmp_id()).getOffice_mail())) {
				
			}else
			{
				 if(!emprepo.officeEmailIDValidation(emp.getOffice_mail())) {
	
					FieldError fe= new FieldError("employee", "office_mail", " Office Email id is already taken!");
					be.add(fe);
				}
			}
			 if (bindingResult.hasErrors()) {
				be.addAll(bindingResult.getFieldErrors());
			 }
		
				if(be.isEmpty()) {
					String createdemp = emprepo.saveOrUpdate(emp);
					return ResponseEntity.status(HttpStatus.CREATED)
							.body(createmessage("Employee record has been updated successfully"));
				
				} else {
					
					System.out.println("error hit -PUT");
					
					return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(be);
				}

			} catch (Exception e) {
				e.printStackTrace();
				return ResponseEntity.badRequest()
						.body(createmessage("Server error has encountered, failed to save the record"));
			}
		
		
		

	}

	@RequestMapping(value = "/download", method = RequestMethod.POST)
	public ResponseEntity<InputStreamResource> download_Recommendations()// method details and urldetails
			throws IOException {
		return downloadReport();
	}

	public String createmessage(String msg) {
		return "{\"msg\":\"" + msg + "\"}";
	}

	// CSV Download

	public ResponseEntity<InputStreamResource> downloadReport() throws IOException {
		// Delimiter used in CSV file
		String NEW_LINE_SEPARATOR = "\n";

		// CSV file header
		Object[] FILE_HEADER = { "Emp Id", "Name", "Doj", "Post", "Level", "Mobile", "Personal mail", "office mail",
				"Dob", "Blood Group", "Pan No", "Aadhaar No" };

		String csvFilePath = System.getProperty("user.dir") + "\\Report_" + UUID.randomUUID().toString() + ".csv";
		File f = new File(csvFilePath);
		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		FileWriter fileWriter = null;

		CSVPrinter csvFilePrinter = null;
		// Create the CSVFormat object with "\n" as a record delimiter
		CSVFormat csvFileFormat = CSVFormat.DEFAULT.withRecordSeparator(NEW_LINE_SEPARATOR);
		try {
			// initialize FileWriter object
			fileWriter = new FileWriter(csvFilePath);

			// initialize CSVPrinter object
			csvFilePrinter = new CSVPrinter(fileWriter, csvFileFormat);

			// Create CSV file header
			csvFilePrinter.printRecord(FILE_HEADER);

			List<Employee> emps = emprepo.getAllEmployees();
			for (Employee emp : emps) {
				List emptDataRecord = new ArrayList();
				emptDataRecord.add(emp.getEmp_id());
				emptDataRecord.add(emp.getFirst_name() + " " + emp.getLast_name());
				emptDataRecord.add(emp.getDoj());
				emptDataRecord.add(emp.getPost_name());
				emptDataRecord.add(emp.getEmp_level());
				emptDataRecord.add(emp.getMobile_num());
				emptDataRecord.add(emp.getEmail_id());

				emptDataRecord.add(emp.getOffice_mail());
				emptDataRecord.add(emp.getDob());
				emptDataRecord.add(emp.getBlood_group());
				emptDataRecord.add(emp.getPan_num());
				emptDataRecord.add(emp.getAadhaar_num());

				csvFilePrinter.printRecord(emptDataRecord);
			}

			System.out.println("CSV file was created successfully !!!");

		} catch (Exception e) {
			System.out.println("Error in CsvFileWriter !!!");
			e.printStackTrace();
		} finally {
			try {
				fileWriter.flush();
				fileWriter.close();
				csvFilePrinter.close();
			} catch (IOException e) {
				System.out.println("Error while flushing/closing fileWriter/csvPrinter !!!");
				e.printStackTrace();
			}
		}
		return downloadfile(csvFilePath, "Employee_Report", "csv");

	}

	public ResponseEntity<InputStreamResource> downloadfile(String filePath, String Filename, String type) {
		HttpHeaders headers = new HttpHeaders();
		byte[] buf = null;
		File f = new File(filePath);
		try {

			buf = readFileToByteArray(f);

			headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
			headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + Filename + "." + type);
			headers.add("Pragma", "no-cache");

			headers.add("Expires", "0");
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			
			  //delete the file
			File fw= new File (filePath); 
			if(fw.exists()) {
			  if(fw.delete()) {
			  System.out.println("File deleted:"+f.getAbsolutePath()+"\\"+f.getName()); };
			  }
			 

		}
		return ResponseEntity.ok().headers(headers).contentLength(buf.length)
				.contentType(MediaType.parseMediaType("application/octet-stream"))
				.body(new InputStreamResource(new ByteArrayInputStream(buf)));

	}

	public static byte[] readFileToByteArray(File file) {
		FileInputStream fis = null;
		// Creating a byte array using the length of the file
		// file.length returns long which is cast to int
		byte[] bArray = new byte[(int) file.length()];
		try {
			fis = new FileInputStream(file);
			fis.read(bArray);
			fis.close();

		} catch (IOException ioExp) {
			ioExp.printStackTrace();
		}
		return bArray;
	}
}

package com.example;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author predix -
 */
@RestController
@SpringBootApplication
public class SpringDemoApplication {
	
	@Autowired
	private IDepartment departRepo;
	
	@Autowired
	private IEmployee empRepo;

	@RequestMapping("/")
	@ResponseBody
	String home() {
		return "Hello World!";
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringDemoApplication.class, args);
	}

	@RequestMapping(value = "/getStaffDetails/{name}", method = RequestMethod.GET)
	public @ResponseBody List<Department> getDeptDetailsJSON(
			@PathVariable String name) {

		List<Department> dept = new ArrayList<Department>();

		Department department = new Department();

		department.setEmployeeID(1);
		department.setDepartname("GE-Aviation");
		department.setStaffName("Ajaya");

		Department department1 = new Department();

		department1.setEmployeeID(2);
		department1.setDepartname("GE-Transport");
		department1.setStaffName("Tara");

		Department departmen2 = new Department();

		departmen2.setEmployeeID(3);
		departmen2.setDepartname("GE-Healthcare");
		departmen2.setStaffName("Manoj");

		Department departmen3 = new Department();

		departmen3.setEmployeeID(4);
		departmen3.setDepartname("GE-Corporate");
		departmen3.setStaffName("Rakesh");
		
		
		Department departmen4 = new Department();

		departmen4.setEmployeeID(4);
		departmen4.setDepartname("GE-Corporate");
		departmen4.setStaffName("Sapan");

		dept.add(department);
		dept.add(department1);
		dept.add(departmen2);
		dept.add(departmen3);

		/*
		 * int employeeID[]= {11,22,33,44,55}; department.setDepartname(new
		 * String[]{"GE-Aviation",
		 * "GE-Transport","GE-Healthcare","GE-Corporate","GE-Power"});
		 * department.setStaffName(new String[]{"Ajaya",
		 * "Tara","Manoj","Rakesh","Sapan"});
		 * department.setEmployeeID(employeeID);
		 */

		// call DB
		return dept;

	}
	
	@RequestMapping(value = "/getStaffDetailsFromDB/", method = RequestMethod.GET)
	public @ResponseBody List<Department> getStaffDetailsFromDB(
			) {
		System.out.println("Sinside **************");
		List<Department> dept = new ArrayList<Department>();

	
		List<Departmentnew> deptList = departRepo.findAll();
		System.out.println("SpringDemoApplication.getStaffDetailsFromDB()" + deptList.size());
		for(Departmentnew deptNew  : deptList){
			Department department = new Department();
			department.setEmployeeID(deptNew.getEmpId().intValue());
			department.setDepartname(deptNew.getDeptName());
			department.setStaffName(deptNew.getStaffName());
			dept.add(department);
		}
		
		return dept;

	}
	
	@RequestMapping(value = "/getEmployeeFromDB/", method = RequestMethod.GET)
	public @ResponseBody List<EmployeeVO> getEmployeeFromDB(
			) {
		System.out.println("inside **************");
		List<EmployeeVO> emp = new ArrayList<EmployeeVO>();

	
		List<Employee> empList = empRepo.findAll();
		System.out.println("SpringDemoApplication.getStaffDetailsFromDB()" + empList.size());
		for(Employee empNew  : empList){
			EmployeeVO empVO = new EmployeeVO();
		
			
			empVO.setEmployeeID(empNew.getEmpId().intValue());
			empVO.setDeptId(empNew.getDeptId());
			empVO.setLastname(empNew.getLastname());
			empVO.setEmpName(empNew.getEmpName());
			emp.add(empVO);
		}
		
		return emp;

	}
}

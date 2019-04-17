package tungpzostar.springhibernatejsf.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import tungpzostar.springhibernatejsf.entity.Employee;
import tungpzostar.springhibernatejsf.service.EmployeeService;

@Controller
@Component(value = "employeeView")
@ViewScoped
public class EmployeeController {

	private List<Employee> lstEmp;

	@Autowired
	private EmployeeService employeeService;

	private String jobName;
	private Date hireDate;

	public List<Employee> getLstEmp() {
		return lstEmp;
	}

	public void setLstEmp(List<Employee> lstEmp) {
		this.lstEmp = lstEmp;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	@PostConstruct
	public void init() {
		lstEmp = employeeService.getAll();
	}
	
	public void delete(int id) {
		employeeService.delete(id);
		lstEmp = employeeService.getAll();
	}
	
	public void addOrUpdate(Employee emp) {
		employeeService.addOrUpdate(emp);
		lstEmp = employeeService.getAll();
	}

	public void formatList(String jobName, Date hireDate) throws Exception {
		System.out.println(jobName + "" +hireDate);
		lstEmp = employeeService.formatList(jobName, hireDate);
		System.out.println("size: "+lstEmp.size());
	}
	
	public void exportExcel(List<Employee> lstEmp) throws Exception {
		employeeService.exportExcel(lstEmp);
	}
}
package tungpzostar.springhibernatejsf.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tungpzostar.springhibernatejsf.dao.EmployeeDAO;
import tungpzostar.springhibernatejsf.dao.FileDAO;
import tungpzostar.springhibernatejsf.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;
	
	@Autowired
	private FileDAO fileDAO;
	
	@Override
	@Transactional
	public List<Employee> getAll() {
		return employeeDAO.getAll();
	}
	
	@Override
	public Employee get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public void delete(int id) {
		employeeDAO.delete(id);
	}

	@Override
	@Transactional
	public void addOrUpdate(Employee emp) {
		System.out.println(emp.geteName());
		employeeDAO.addOrUpdate(emp);
	}

	@Override
	@Transactional
	public void formatList(String jobName, Date hireDate) throws Exception {
		if(jobName == "") jobName = null;
		System.out.println("=================>" +jobName +" /" +hireDate);
		List<Employee> lstEmp = employeeDAO.formatList(jobName, hireDate);
		System.out.println(lstEmp.size());
		System.out.println("Service layer: "+jobName + " "+hireDate);
		fileDAO.writeExcelFile(lstEmp);
	}

}

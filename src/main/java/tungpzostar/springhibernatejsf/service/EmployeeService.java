package tungpzostar.springhibernatejsf.service;

import java.util.Date;
import java.util.List;

import tungpzostar.springhibernatejsf.entity.Employee;

public interface EmployeeService {

	List<Employee> getAll();
	Employee get(int id);
	void delete(int id);
	void addOrUpdate(Employee emp);
	List<Employee> formatList(String jobName, Date hireDate);
	void exportExcel(List<Employee> lstEmp) throws Exception;
}

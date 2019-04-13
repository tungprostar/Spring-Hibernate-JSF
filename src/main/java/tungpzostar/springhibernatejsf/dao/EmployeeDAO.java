package tungpzostar.springhibernatejsf.dao;

import java.util.Date;
import java.util.List;

import tungpzostar.springhibernatejsf.entity.Employee;

public interface EmployeeDAO {

	List<Employee> getAll();
	Employee get(int id);
	void update(Employee emp);
	void delete(int id);
	void add(Employee emp);
	String formatDate(Date d);
}

package tungpzostar.springhibernatejsf.service;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.primefaces.component.row.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tungpzostar.springhibernatejsf.dao.EmployeeDAO;
import tungpzostar.springhibernatejsf.entity.Employee;

@Service
//@ManagedBean(name = "employeeService")
@Component(value="employeeService")
@SessionScoped
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;
	
	private List<Employee> lstEmp;
	
	private Employee emp = new Employee();
	
	private String name = "easdas";
	@Override
	@Transactional
	public List<Employee> getAll() {
		System.out.println("===============> INSIDE getAll() method from service layer");
		if(lstEmp == null) {
			lstEmp = employeeDAO.getAll();
		}
		return lstEmp;
	}

	@Override
	public Employee get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Employee emp) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void add(Employee emp) {
		employeeDAO.add(emp);
	}

	@Override
	public String formatDate(Date d) {
		return employeeDAO.formatDate(d);
	}

//	@Override
//	public int unboxing(Integer i) {
//		return employeeDAO.unboxing(i);
//	}
//
//	@Override
//	public float unboxing(Float f) {
//		return employeeDAO.unboxing(f);
//	}
//

	
}

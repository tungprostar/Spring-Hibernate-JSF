package tungpzostar.springhibernatejsf.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import tungpzostar.springhibernatejsf.dao.EmployeeDAO;
import tungpzostar.springhibernatejsf.entity.Employee;

@Service
@Component(value = "employeeService")
@SessionScoped
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;

	private List<Employee> lstEmp;

	@Override

	public List<Employee> getAll() {
		lstEmp = employeeDAO.getAll();
		return lstEmp;
	}

	@PostConstruct
	public void init() {
		lstEmp = employeeDAO.getAll();
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
	public String formatDate(Date d) {
		return employeeDAO.formatDate(d);
	}

	public static void onRowCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Employee Edited", "" + ((Employee) event.getObject()).getEmpNo());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public List<Employee> getLstEmp() {
		return lstEmp;
	}

	public void setLstEmp(List<Employee> lstEmp) {
		this.lstEmp = lstEmp;
	}

}

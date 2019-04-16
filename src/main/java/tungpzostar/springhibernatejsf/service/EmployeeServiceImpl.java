package tungpzostar.springhibernatejsf.service;

import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tungpzostar.springhibernatejsf.dao.EmployeeDAO;
import tungpzostar.springhibernatejsf.entity.Employee;

@Service
@Component(value = "employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;

	private List<Employee> lstEmp;
	
	@Override
	@Transactional
	public List<Employee> getAll() {
		return employeeDAO.getAll();
	}

	// Lazy load
	@Transactional
	public List<Employee> getSampleAll(){
		if(lstEmp == null) {
			lstEmp = employeeDAO.getAll();
		}
		return lstEmp;
	}
	
	public void reset() {
		lstEmp = null;
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

}

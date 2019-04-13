package tungpzostar.springhibernatejsf.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tungpzostar.springhibernatejsf.entity.Employee;
import tungpzostar.springhibernatejsf.service.EmployeeServiceImpl;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	private Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	private SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Employee> getAll() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query query = currentSession.createQuery("from Employee", Employee.class);
		List<Employee> lstEmp = query.getResultList();
		System.out.println("lstEmp size: " +lstEmp.size());
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
	@Transactional
	public void add(Employee emp) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(emp);
	}

	@Override
	public String formatDate(Date d) {
		String date = format.format(d);
		return date;
	}

}

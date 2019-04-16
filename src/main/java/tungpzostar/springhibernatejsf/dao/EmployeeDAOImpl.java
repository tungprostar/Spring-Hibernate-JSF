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
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import tungpzostar.springhibernatejsf.entity.Department;
import tungpzostar.springhibernatejsf.entity.Employee;
import tungpzostar.springhibernatejsf.service.EmployeeServiceImpl;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	private Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	private SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

	@Autowired
	private EntityManager entityManager;

	@Override
	@Transactional
	public List<Employee> getAll() {
		Session currentSession = entityManager.unwrap(Session.class);

		// Fix no session error using JOIN FETCH
		Query query = currentSession.createQuery("select e from Employee e" + " JOIN FETCH e.dept", Employee.class);
		List<Employee> lstEmp = query.list();
		return lstEmp;
	}

	@Override
	public Employee get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) {
		Session currentSession = entityManager.unwrap(Session.class);

		Employee emp = currentSession.find(Employee.class, id);
		currentSession.remove(emp);
	}

	@Override
	public void addOrUpdate(Employee emp) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.merge(emp);
	}

	@Override
	public String formatDate(Date d) {
		String date = format.format(d);
		return date;
	}

	@Override
	public List<Employee> formatList(String jobName, Date hireDate) {
		Session currentSession = entityManager.unwrap(Session.class);
		if (jobName == null && hireDate == null) {
			return getAll();
		} else {
			String strQuery = "select e from Employee e" + " JOIN FETCH e.dept";
			if (jobName != null)
				strQuery += " where e.job = :job";
			if (hireDate != null)
				strQuery += " where e.hireDate = :hireDate";
			if (jobName != null && hireDate != null) {
				strQuery = "select e from Employee e JOIN FETCH e.dept where e.job = :job and e.hireDate = :hireDate";
			}
			System.out.println(strQuery);
			Query query = currentSession.createQuery(strQuery, Employee.class);
			if (jobName != null && hireDate != null) {
				query.setParameter("hireDate", hireDate);
				query.setParameter("job", jobName);
			}
			if (hireDate != null)
				query.setParameter("hireDate", hireDate);
			if (jobName != null)
				query.setParameter("job", jobName);
			List<Employee> lstEmp = query.getResultList();
			return lstEmp;
		}
	}

}

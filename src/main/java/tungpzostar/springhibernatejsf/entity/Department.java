package tungpzostar.springhibernatejsf.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="dept")
@Component
public class Department implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="deptno")
	private int deptNo;
	
	@Column(name="dname")
	private String dName;
	
	@Column(name="loc")
	private String loc;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "dept")
	private List<Employee> lstEmployees;
	
	public Department() {
	}

	public Department(int deptNo, String dName, String loc) {
		this.deptNo = deptNo;
		this.dName = dName;
		this.loc = loc;
	}

	public int getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}

	public String getdName() {
		return dName;
	}

	public void setdName(String dName) {
		this.dName = dName;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public List<Employee> getLstEmployees() {
		return lstEmployees;
	}

	public void setLstEmployees(List<Employee> lstEmployees) {
		this.lstEmployees = lstEmployees;
	}
	
	//Helper method
	public void addEmployee(Employee e) {
		if(lstEmployees == null) {
			lstEmployees = new ArrayList<Employee>();
		}
		lstEmployees.add(e);
		e.setDept(this);
	}
}

package tungpzostar.springhibernatejsf.entity;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="dept")
@ManagedBean(name="department")
public class Department {

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
	
}

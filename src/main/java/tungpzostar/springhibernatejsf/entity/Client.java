package tungpzostar.springhibernatejsf.entity;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@ManagedBean
//@Component
@Entity
@Table(name = "client")
public class Client implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLIENT_SEQUENCE")
	@SequenceGenerator(sequenceName = "cli_seq", name="CLIENT_SEQUENCE", allocationSize = 1)
	private int id;
	
	@Column(name="client_name")
	private String clientName;
	
	@Column(name="client_phonenumber")
	private String clientPhoneNumber;

	public Client() {
	}

	public Client(String clientName, String clientPhoneNumber) {
		this.clientName = clientName;
		this.clientPhoneNumber = clientPhoneNumber;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientPhoneNumber() {
		return clientPhoneNumber;
	}

	public void setClientPhoneNumber(String clientPhoneNumber) {
		this.clientPhoneNumber = clientPhoneNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}

package tungpzostar.springhibernatejsf.entity;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Client {

	private String clientName;
	
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
	
}

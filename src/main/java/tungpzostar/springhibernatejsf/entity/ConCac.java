package tungpzostar.springhibernatejsf.entity;

import javax.faces.bean.ManagedBean;

import org.springframework.stereotype.Component;

@ManagedBean
public class ConCac {

	private String name = "sadasd";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

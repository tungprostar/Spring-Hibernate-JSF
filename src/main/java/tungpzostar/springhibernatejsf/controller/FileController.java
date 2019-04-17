package tungpzostar.springhibernatejsf.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import tungpzostar.springhibernatejsf.dao.ClientDAO;
import tungpzostar.springhibernatejsf.dao.FileDAO;
import tungpzostar.springhibernatejsf.entity.Client;
import tungpzostar.springhibernatejsf.service.ClientService;

@Controller
@Component(value = "fileView")
@RequestScoped
public class FileController {

	@Autowired
	private FileDAO fileDAO;
	
	@Autowired
	private ClientService clientService;
	
	private UploadedFile uploadedFileDM;

	private List<Client> lstClient ;
	
	private String clientName;
	
	private String clientPhoneNumber;

	public List<Client> getLstClient() {
		return lstClient;
	}

	public void setLstClient(List<Client> lstClient) {
		this.lstClient = lstClient;
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

	public UploadedFile getUploadedFileDM() {
		return uploadedFileDM;
	}

	public void setUploadedFileDM(UploadedFile uploadedFileDM) {
		this.uploadedFileDM = uploadedFileDM;
	}
	
	public void upload() {
        if(uploadedFileDM != null) {
            FacesMessage message = new FacesMessage("Succesful", uploadedFileDM.getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);
            lstClient = fileDAO.processFile(uploadedFileDM);
            clientService.insertAll(lstClient);
        }
    }
	
    public void handleFileUpload(FileUploadEvent event) {
        FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

}

package tungpzostar.springhibernatejsf.service;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import tungpzostar.springhibernatejsf.dao.FileDAO;
import tungpzostar.springhibernatejsf.entity.Client;

@Service
@Component(value="fileService")
@Scope("session")
public class FileServiceImpl implements FileService {

	private UploadedFile file;
	
	private List<Client> lstClient;
	
	@Autowired
	private FileDAO fileDAO;
	
	@Override
	public List<Client> processFile() throws Exception {
//		System.out.println("=====================>");
//		if(file != null) {
//			System.out.println("File not null");
//			file.write(".\\filesupload\\" +file.getFileName() +".txt");
//			lstClient = fileDAO.processFile(file);
//		}
//		else System.out.println("file is null");
		return lstClient;
	}
	
	public void upload() {
        if(file != null) {
            FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

}

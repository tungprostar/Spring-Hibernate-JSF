package tungpzostar.springhibernatejsf.service;

import java.util.List;

import org.primefaces.model.UploadedFile;

import tungpzostar.springhibernatejsf.entity.Client;

public interface FileService {

	List<Client> processFile() throws Exception;
}

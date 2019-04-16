package tungpzostar.springhibernatejsf.dao;

import java.util.List;

import org.primefaces.model.UploadedFile;

import tungpzostar.springhibernatejsf.entity.Client;

public interface FileDAO {

	List<Client> processFile(UploadedFile f);
}

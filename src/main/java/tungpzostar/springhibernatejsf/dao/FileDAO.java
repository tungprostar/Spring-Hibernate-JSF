package tungpzostar.springhibernatejsf.dao;

import java.util.List;

import org.primefaces.model.UploadedFile;

import tungpzostar.springhibernatejsf.entity.Client;
import tungpzostar.springhibernatejsf.entity.Employee;

public interface FileDAO {

	List<Client> processFile(UploadedFile f);
	void writeExcelFile(List<Employee> lstEmp)  throws Exception;
}

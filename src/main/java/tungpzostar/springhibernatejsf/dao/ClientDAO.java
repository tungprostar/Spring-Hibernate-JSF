package tungpzostar.springhibernatejsf.dao;

import java.util.List;

import tungpzostar.springhibernatejsf.entity.Client;

public interface ClientDAO {
	void insertAll(List<Client> lstClient);
}

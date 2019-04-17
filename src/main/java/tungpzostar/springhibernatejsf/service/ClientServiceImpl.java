package tungpzostar.springhibernatejsf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tungpzostar.springhibernatejsf.dao.ClientDAO;
import tungpzostar.springhibernatejsf.entity.Client;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientDAO clientDAO;
	
	@Override
	@Transactional
	public void insertAll(List<Client> lstClient) {
		clientDAO.insertAll(lstClient);
	}

}

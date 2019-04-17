package tungpzostar.springhibernatejsf.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tungpzostar.springhibernatejsf.entity.Client;

@Repository
public class ClientDAOImpl implements ClientDAO {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public void insertAll(List<Client> lstClient) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		for(int i = 0; i<lstClient.size(); i++) {
			Client client = lstClient.get(i);
			currentSession.merge(client);
			if(i % 100 == 0) {
				currentSession.flush();
				currentSession.clear();
			}
		}
	}

}

package tungpzostar.springhibernatejsf.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.primefaces.model.UploadedFile;
import org.springframework.stereotype.Repository;

import tungpzostar.springhibernatejsf.entity.Client;

@Repository
public class FileDAOImpl implements FileDAO {

	@Override
	public List<Client>  processFile(UploadedFile f) {
		String line = null;
		List<Client> lstClient = new ArrayList<Client>();
		try {
			BufferedReader bf = new BufferedReader(new InputStreamReader(f.getInputstream()));
			while((line = bf.readLine()) != null) {
				String strArr[] = line.split(",");
				Client client = new Client(strArr[0], strArr[1]);
				lstClient.add(client);
			}
			bf.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lstClient;
	}

}

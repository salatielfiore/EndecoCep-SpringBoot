package br.com.fiore.endereco;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EnderecoService {
	
	@SuppressWarnings("unchecked")
	public Endereco getEndereco(String cep) {
		
		String url = "https://brasilapi.com.br/api/cep/v1/" + cep ;
		Endereco endereco = new Endereco();
		
		try {
			
			RestTemplate restTemplate = new RestTemplate();
			Map<String, String> response = restTemplate.postForObject(url, null, Map.class);
			
			endereco.setCep(response.get("cep"));
			endereco.setState(response.get("state"));
			endereco.setCity(response.get("city"));
			endereco.setNeighborhood(response.get("neighborhood"));
			endereco.setStreet(response.get("street"));
			
		} catch (Exception e) {
			
		}
		return endereco;

	}
	
}

package br.com.fiore.endereco;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EnderecoController {
	
	@Autowired
	private EnderecoService enderecoService;
	
	@GetMapping(path = "/")
	public String index(@Nullable @RequestParam("cep") String cep, Model model) {
		
		Endereco endereco = enderecoService.getEndereco(cep);
		model.addAttribute("endereco", endereco);
		
		return "index";
	}
	
	@GetMapping(path = "/endereco")
	public String getEndereco(@RequestParam("cep") String cep, Model model) {
		
		 Endereco endereco = enderecoService.getEndereco(cep);
		 model.addAttribute("endereco", endereco);
		
		return "index";
	}
}

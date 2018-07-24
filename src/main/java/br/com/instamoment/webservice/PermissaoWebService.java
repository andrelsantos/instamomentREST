package br.com.instamoment.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.instamoment.model.Permissao;
import br.com.instamoment.model.ResponseModel;
import br.com.instamoment.repository.PermissaoRepository;

@RestController
@RequestMapping("/service")
public class PermissaoWebService {

	@Autowired
	private PermissaoRepository permissaoRepository;
	
	@RequestMapping(value="/permissao", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel salvar(@RequestBody Permissao permissao){
		this.permissaoRepository.save(permissao);
		 
		return new ResponseModel(1,"Permissao salva com sucesso!");

	}
	
}

package br.com.instamoment.webservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.instamoment.model.ResponseModel;
import br.com.instamoment.model.Usuario;
import br.com.instamoment.serviceImplementation.UsuarioServiceImpl;

@RestController
public class UsuarioWebService {
	
	@Autowired
	private UsuarioServiceImpl usuarioServiceImpl;
	
/*	//consultar usuario
	@RequestMapping(value="/registro", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody List<Usuario> consultar(){
		
		System.out.println("passou_get");
 
		return this.usuarioServiceImpl.buscarUsuarios();
	}*/
	
	//salvar usuario
	@RequestMapping(value="/registro", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel salvar(@RequestBody Usuario usuario){
 
		System.out.println("passou_post");
		
		try {
			if (usuarioServiceImpl.buscarUsuarioEmail(usuario.getEmail()) != null) {
				return new ResponseModel(2,"Usuário ja cadastrado!");
			
			} else {
 
				this.usuarioServiceImpl.salvarUsuario(usuario);
	 
				return new ResponseModel(1,"Usuário salvo com sucesso!");
			}
 
		}catch(Exception e) {
 
			return new ResponseModel(0,e.getMessage());			
		}
	}
}

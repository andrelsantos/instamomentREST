package br.com.instamoment.webservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.instamoment.model.Evento;
import br.com.instamoment.model.ResponseModel;
import br.com.instamoment.serviceImplementation.EventoServiceImpl;

@RestController
@RequestMapping("/service")
public class EventoWebService {

	@Autowired
	private EventoServiceImpl eventoServiceImpl;
	
	//consultar eventos
	@RequestMapping(value="/evento", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody List<Evento> consultar(){
 
		return this.eventoServiceImpl.buscarEventos();
	}
	
	@RequestMapping(value="/evento", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel salvar(@RequestBody Evento evento){
		try {
			this.eventoServiceImpl.salvarEvento(evento);
			
			return new ResponseModel(1,"Usuário salvo com sucesso!");
			
		}catch(Exception e){
			return new ResponseModel(0,e.getMessage());	
		}
	}
}

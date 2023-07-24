package com.EC03.DavidQC;
    
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.lang.String;


@Controller	
@RequestMapping(path="/") 
public class MainController {
	@Autowired
	private InstrumentoRepository repository;

    @GetMapping(path="/")
	public @ResponseBody String home() {
		return "DAVID CALDAS";
	}   

	@PostMapping(path="/api/instrumento/nuevo")
	public @ResponseBody String nuevo (@RequestParam String nombre) {
		Instrumento n = new Instrumento();
		n.setNombre(nombre);
		repository.save(n);
		return "Instrumento Guardado";
	}

	@DeleteMapping(path="/api/instrumento/eliminar")
	public @ResponseBody String eliminar (@RequestParam Integer id) {
		Instrumento n = new Instrumento();
		n.setId(id);
		repository.delete(n);
		return "Instrumento Borrado";
	}

	@GetMapping(path="/api/instrumento/listar")
	public @ResponseBody Iterable<Instrumento> listar() {
		return repository.findAll();
	}   
}

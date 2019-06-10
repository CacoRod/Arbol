package springFinal.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import springFinal.dto.PersonDTO;
import springFinal.exception.ExistingPersonException;
import springFinal.service.DemoService;

@Controller
public class DemoController {

	@Autowired
	private DemoService service;

	@GetMapping("/")
	public ModelAndView getIndex() {
		return new ModelAndView("cargar");
	}

	@GetMapping("/Listar")
	public ModelAndView listarUsuarios() {
		ModelAndView modelAndView = new ModelAndView("Listar");
		List<PersonDTO> users = service.listUsers();
		modelAndView.addObject("users", users);
		return modelAndView;
	}
	
	@GetMapping("/arbol")
	public ModelAndView mostrarArbol() {
		return new ModelAndView("arbol");
	}
	
	@GetMapping("/editar")
	public ModelAndView editarPersona() {
		return new ModelAndView("editar");
	}



	@GetMapping("/addUserOld")
	public ModelAndView addUser(@RequestParam("name") String name, @RequestParam("surname") String surname) {
		long id = service.addUser(name, surname);

		ModelAndView modelAndView = new ModelAndView("success");
		modelAndView.addObject("id", id);
		return modelAndView;
	}

	@PostMapping("/addUser")
	public ModelAndView addUser(PersonDTO dto) {
		try {
			long id = service.addUser(dto);
			ModelAndView modelAndView = new ModelAndView("success");
			modelAndView.addObject("id", id);
			return modelAndView;
		} catch (ExistingPersonException e) {
			ModelAndView modelAndView = new ModelAndView("error");
			modelAndView.addObject("msg", "Usuario existente");
			return modelAndView;
		}

	}

}

package springFinal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import springFinal.dto.PersonDTO;
import springFinal.service.Servicio;

@Controller
public class Controlador {

	@Autowired
	private Servicio service;

	@GetMapping("/")
	public ModelAndView getIndex() {
		ModelAndView modelAndView = new ModelAndView("cargar");
		List<PersonDTO> maleUsers = service.listMen();
		List<PersonDTO> femaleUsers = service.listWomen();
		modelAndView.addObject("maleUsers", maleUsers);
		modelAndView.addObject("femaleUsers", femaleUsers);
		return modelAndView;
	}

	@GetMapping("/listar")
	public ModelAndView listarUsuarios() {
		ModelAndView modelAndView = new ModelAndView("listar");
		List<PersonDTO> users = service.listUsers();
		modelAndView.addObject("users", users);
		return modelAndView;
	}
	
	@PostMapping("/arbol")
	public ModelAndView mostrarArbol(PersonDTO dto) {
		ModelAndView modelAndView = new ModelAndView("relaciones");
		List<PersonDTO> padres = service.findPadres(dto.getDni());
		modelAndView.addObject("padres", padres);
		return modelAndView;
	}
	
	@PostMapping("/editar")
	public ModelAndView editarPersona(PersonDTO dto) {
		ModelAndView modelAndView = new ModelAndView("editar");
		PersonDTO edit = service.buildDTO(dto.getDni());
		List<PersonDTO> maleUsers = service.listMen();
		List<PersonDTO> femaleUsers = service.listWomen();
		maleUsers.remove(edit);
		femaleUsers.remove(edit);
		modelAndView.addObject("maleUsers", maleUsers);
		modelAndView.addObject("femaleUsers", femaleUsers);
		modelAndView.addObject("edit",edit);
		return modelAndView;
	}

	@PostMapping("/addUser")
	public ModelAndView addUser(PersonDTO dto) {
		if (!service.containsDni(dto.getDni())) {
			service.addUser(dto);
			ModelAndView modelAndView = new ModelAndView("success");
			modelAndView.addObject("id", dto.toString());
			return modelAndView;
		}
		return new ModelAndView("error");
	}
	@PostMapping("/updateUser")
	public ModelAndView updateUser(PersonDTO dto) {
			service.updateUser(dto);
			ModelAndView modelAndView = new ModelAndView("success");
			modelAndView.addObject("id", dto.toString());
			return modelAndView;
	}
}

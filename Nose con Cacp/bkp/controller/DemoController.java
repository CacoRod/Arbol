package ar.edu.ub.progiii.mvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.ub.progiii.mvc.dto.PersonDTO;
import ar.edu.ub.progiii.mvc.exception.ExistingPersonException;
import ar.edu.ub.progiii.mvc.service.DemoService;

@Controller
public class DemoController {

	@Autowired
	private DemoService service;

	@GetMapping("/")
	public ModelAndView getIndex() {
		return new ModelAndView("index");
	}

	@GetMapping("/list")
	public ModelAndView listarUsuarios() {
		ModelAndView modelAndView = new ModelAndView("list");
		List<PersonDTO> users = service.listUsers();
		modelAndView.addObject("users", users);
		return modelAndView;
	}

	@GetMapping("/listmethod")
	public ModelAndView listarUsuariosByMethod(@RequestParam("name") String name, @RequestParam("surname") String surname, @RequestParam("method") String method) {
		ModelAndView modelAndView = new ModelAndView("list");
		List<PersonDTO> users = service.list(new PersonDTO(name,surname), method);
		modelAndView.addObject("users", users);
		return modelAndView;
	}

	@GetMapping("/listmethod2")
	public ModelAndView listarUsuariosByMethod2(PersonDTO dto, @RequestParam("method") String method) {
		ModelAndView modelAndView = new ModelAndView("list");
		List<PersonDTO> users = new ArrayList<>();
		PersonDTO user= new PersonDTO();
		service.list(dto, method, users,user);
		if(",padre,madre,".contains(","+method+",")) {
			modelAndView.addObject("singleUser", user);
		}else {
			modelAndView.addObject("users", users);
		}
		
		return modelAndView;
	}

	@GetMapping("/addUserOld")
	public ModelAndView addUser(@RequestParam("name") String name, @RequestParam("surname") String surname) {
		long id = service.addUser(name, surname);

		ModelAndView modelAndView = new ModelAndView("success");
		modelAndView.addObject("id", id);
		return modelAndView;
	}

	@GetMapping("/addUser")
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

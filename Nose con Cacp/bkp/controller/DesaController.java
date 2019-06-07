package ar.edu.ub.progiii.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.ub.progiii.mvc.service.DemoService;

@Profile("dev")
@Controller
public class DesaController {

	@Autowired
	private DemoService service;

	@GetMapping("/save/{fileName}")
	public ModelAndView save(@PathVariable("fileName") String fileName) {
		service.save(fileName == null ? "persons.ser" : fileName + ".ser");
		return new ModelAndView("index");
	}

	@GetMapping("/read/{fileName}")
	public ModelAndView read(@PathVariable("fileName") String fileName) {
		service.read(fileName == null ? "persons.ser" : fileName + ".ser");
		return new ModelAndView("index");
	}
}

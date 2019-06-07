package ar.edu.ub.progiii.mvc.service;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.ub.progiii.mvc.dto.PersonDTO;
import ar.edu.ub.progiii.mvc.exception.ExistingPersonException;
import ar.edu.ub.progiii.mvc.model.Person;
import ar.edu.ub.progiii.mvc.repository.PersonRepository;

@Service
public class DemoService {

	@Autowired
	private PersonRepository personRepository;
	
	
	public long addUser(String name, String surname) {
		Person person = new Person(name, surname);
		return personRepository.addPerson(person);
	}

	public long addUser(PersonDTO dto) throws ExistingPersonException {
		if(personRepository.findUserByNameAndSurname(dto.getName(), dto.getSurname()) == null) {
			Person person = new Person(dto.getName(), dto.getSurname());
			return personRepository.addPerson(person);
		}
		throw new ExistingPersonException();
	}


	public List<PersonDTO> listUsers() {
		List<Person> list = personRepository.findAll();
		return buildDTOs(list);
	}

	private List<PersonDTO> buildDTOs(List<Person> list) {
		List<PersonDTO> dtos= new ArrayList<>();
		for(Person person : list)
			dtos.add(buildDTO(person));
		
		return dtos;
	}

	private PersonDTO buildDTO(Person person) {
		return new PersonDTO(person.getName(),person.getSurname());
	}
	
	public List<PersonDTO> list(PersonDTO dto, String method) {
		
		method= "get"+method.substring(0, 1).toUpperCase()+method.substring(1);
		
		Person person = personRepository.findUserByNameAndSurname(dto.getName(), dto.getSurname());
		try {
			Method declaredMethod = Person.class.getDeclaredMethod(method);
			if(declaredMethod.getReturnType().isAssignableFrom(Person.class)) {
				Person invoke = (Person) declaredMethod.invoke(person);
				PersonDTO buildDTO = buildDTO(invoke);
				List<PersonDTO> buildDTOs = new ArrayList<>();
				buildDTOs.add(buildDTO);
				return buildDTOs;
			}else {
				@SuppressWarnings("unchecked")
				List<Person> invoke = (List<Person>) declaredMethod.invoke(person);
				return  buildDTOs(invoke);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public void list(PersonDTO dto, String method, List<PersonDTO> dtos, PersonDTO out) {
		
		method= "get"+method.substring(0, 1).toUpperCase()+method.substring(1);
		
		Person person = personRepository.findUserByNameAndSurname(dto.getName(), dto.getSurname());
		try {
			Method declaredMethod = Person.class.getDeclaredMethod(method);
			if(declaredMethod.getReturnType().isAssignableFrom(Person.class)) {
				Person invoke = (Person) declaredMethod.invoke(person);
				out.setName(invoke.getName());
				out.setName(invoke.getName());
				out.setName(invoke.getName());
				out.setName(invoke.getName());
			}else {
				@SuppressWarnings("unchecked")
				List<Person> invoke = (List<Person>) declaredMethod.invoke(person);
				dtos.addAll(buildDTOs(invoke));
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
	
	
	
	public void save(String fileName) {
		personRepository.save(fileName);
	}

	public void read(String fileName) {
		personRepository.read(fileName);
	}
}

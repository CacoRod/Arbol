package ar.edu.ub.progiii.mvc.repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import ar.edu.ub.progiii.mvc.model.Person;

@Repository
public class PersonRepository {
	
	private List<Person> persons=new ArrayList<>();

	public long addPerson(Person person) {
		getPersons().add(person);
		return getPersons().size() -1;
	}
	
	private List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	public List<Person> findAll() {
		return new ArrayList<>(getPersons());
	}
	
	public Person findUserByNameAndSurname(String name, String surname) {
		for(Person person : getPersons())
			if(person.hasName(name) && person.hasSurname(surname))
				return person;
		
		return null;
		
	}

	public void save(String fileName) {
		try(ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(new File(fileName)))){
			stream.writeObject(persons);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public void read(String fileName) {
		try(ObjectInputStream stream= new ObjectInputStream(new FileInputStream(new File(fileName)))){
			persons =  (List<Person>) stream.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	
}

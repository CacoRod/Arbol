package springFinal.model;

import java.time.LocalDate;
import java.util.Collection;
//import java.util.Collections;
import java.util.TreeSet;

public abstract class Persona implements Comparable<Persona>{
	private String dni;
	private String nombre;
	private String apellido;
	private Persona padre;
	private Persona madre;
	private TreeSet<Persona> hijos;
	private TreeSet<Persona> hijas;
	private LocalDate fnac;
	private LocalDate fdec;
	private String nacionalidad;
	private String domicilio;
 	
	public Persona(String dni, String nombre, String apellido, String nacionalidad, String domicilio, LocalDate fnac) {
		setDni(dni);
		setNombre(nombre);
		setApellido(apellido);
		setFnac(fnac);
		setNacionalidad(nacionalidad);
		setDomicilio(domicilio);
		setFdec(null);
		hijos = new TreeSet<Persona>();
		hijas = new TreeSet<Persona>();
		setPadre(new Unknown());
		setMadre(new Unknown());
	}

	public Persona() {
		this.nombre = "Unknown";
		this.apellido= "Person";
		this.hijos = new TreeSet<Persona>();
		this.hijas = new TreeSet<Persona>();
	}


	public TreeSet<Persona> getHijas() {
		return hijas;
	}

	public void setHijas(TreeSet<Persona> hijas) {
		this.hijas = hijas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Persona getPadre() {
		return padre;
	}

	public void setPadre(Persona padre) {
		this.padre = padre;
	}

	public void setMadre(Persona madre) {
		this.madre = madre;
	}

	
	public Persona getMadre() {
		return madre;
	}

	public TreeSet<Persona> getHijos() {
		return hijos;
	}

	public void setHijos(TreeSet<Persona> hijos) {
		this.hijos = hijos;
	}
	
	protected void agregarHombre(TreeSet<Persona> lista) {
	}
	
	protected void agregarMujer(TreeSet<Persona> lista) {
	}


	public void addHijo(Persona hijo) {

		this.hijos.add(hijo);
	}
	
	public void addHija(Persona hija) {
		this.hijas.add(hija);
	}
		
	public void addIfNotUnknow(Collection<Persona> collection) {
		collection.add(this);
	}
	
	public TreeSet<Persona> getPadres(){
		TreeSet<Persona> lista = new TreeSet<Persona>();
		getMadre().addIfNotUnknow(lista);;
		getPadre().addIfNotUnknow(lista);;
		
		return lista;
	}
	
	public TreeSet<Persona> getHermanos() {
	
		TreeSet<Persona> lista = new TreeSet<>();
		
		for(Persona p : getPadres())
			lista.addAll(p.getHijos());
		
		lista.remove(this);
		return lista;
	}
	
	public TreeSet<Persona> getHermanas() {
		TreeSet<Persona> lista = new TreeSet<Persona>();
		for(Persona p : getPadres())
			lista.addAll(p.getHijas());
		
		lista.remove(this);
		return lista;
	}
	
	public TreeSet<Persona> getTios(){
		TreeSet<Persona> lista = new TreeSet<>();

		for(Persona p : getPadres())
			lista.addAll(p.getHermanos());
		
		return lista;
	}
	
	public TreeSet<Persona>getTias(){
		TreeSet<Persona> lista = new TreeSet<>();

		for(Persona p : getPadres())
			lista.addAll(p.getHermanas());
		
		
		return lista;
		
	}
	
	public TreeSet<Persona> getPrimos(){
		TreeSet<Persona> listaFinal = new TreeSet<Persona>();
		TreeSet<Persona> lista = getTios();
		lista.addAll(getTias());
		for (Persona a : lista){
			listaFinal.addAll(a.getHijos());
		}
		return listaFinal;
	}

	public TreeSet<Persona> getPrimas(){
		TreeSet<Persona> listaFinal = new TreeSet<Persona>();
		TreeSet<Persona> lista = getTios();
		lista.addAll(getTias());
		for (Persona a : lista){
			listaFinal.addAll(a.getHijas());
		}
		return listaFinal;
	}

	public TreeSet<Persona> getNietos(){
		TreeSet<Persona> listaFinal = new TreeSet<Persona>();
		TreeSet<Persona> lista = getHijos();
		lista.addAll(getHijas());
		for (Persona a : lista){
			listaFinal.addAll(a.getHijos());
		}
		return listaFinal;
	}
	
	public TreeSet<Persona> getNietas(){
		TreeSet<Persona> listaFinal = new TreeSet<Persona>();
		TreeSet<Persona> lista = getHijos();
		lista.addAll(getHijas());
		for (Persona a : lista) {
			listaFinal.addAll(a.getHijas());
		}		
		return listaFinal;
	}
	
	
	public TreeSet<Persona> getAbuelos(){
		TreeSet<Persona> listaFinal = new TreeSet<Persona>();
		for (Persona a : getPadres()){
			listaFinal.add(a.getPadre());
		}
		return listaFinal;
	}
	
	public TreeSet<Persona> getAbuelas(){
		TreeSet<Persona> listaFinal = new TreeSet<Persona>();
		for (Persona a : getPadres()){
			listaFinal.add(a.getMadre());
		}
		return listaFinal;
	}
	
	public TreeSet<Persona> getSobrinos(){
		TreeSet<Persona> listaFinal = new TreeSet<Persona>();
		TreeSet<Persona> lista = getHermanos();
		lista.addAll(getHermanas());
		for (Persona a : lista){
			listaFinal.addAll(a.getHijos());
		}
		return listaFinal;
	}

	public TreeSet<Persona> getSobrinas(){
		TreeSet<Persona> listaFinal = new TreeSet<Persona>();
		TreeSet<Persona> lista = getHermanos();
		lista.addAll(getHermanas());
		for (Persona a : lista){
			listaFinal.addAll(a.getHijas());
		}
		return listaFinal;
	}
	
	public static void listarNombres(TreeSet<Persona> lista) {
		for (Persona a : lista) {
			System.out.println(a.getNombre() + " " + a.getApellido());
		}
		if (lista.size() == 0) System.out.println("No se encontraron Personas");
	}
	@Override
	public int compareTo(Persona o) {
		if (o instanceof Unknown) return 1;
		return (getDni().compareTo(o.getDni()));
		
	}

	public LocalDate getFnac() {
		return fnac;
	}

	public void setFnac(LocalDate fnac) {
		this.fnac = fnac;
	}

	public LocalDate getFdec() {
		return fdec;
	}

	public void setFdec(LocalDate fdec) {
		this.fdec = fdec;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

}

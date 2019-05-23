package arbolGenealogico;

import java.util.TreeSet;

public abstract class Persona implements Comparable<Persona>{
	private String nombre;
	private String apellido;
	private Persona padre;
	private Persona madre;
	private TreeSet<Persona> hijos;
	private TreeSet<Persona> hijas;
	private TreeSet<Persona> parejas;
	private boolean casado;
 	
	public Persona(String nombre, String apellido) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.hijos = new TreeSet<Persona>();
		this.hijas = new TreeSet<Persona>();
		this.parejas = new TreeSet<Persona>();
		this.setPadre(new Unknown());
		this.setMadre(new Unknown());
		casado = false;
	}
	
	public Persona() {
		this.nombre = "Unknown";
		this.apellido= "Person";
		this.hijos = new TreeSet<Persona>();
		this.hijas = new TreeSet<Persona>();
	}
	
	
	
	
	public TreeSet<Persona> getParejas() {
		return parejas;
	}

	public void setParejas(TreeSet<Persona> parejas) {
		this.parejas = parejas;
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
		
	public TreeSet<Persona> getHermanos() {
		TreeSet<Persona> lista = getPadre().getHijos();
		lista.addAll(getMadre().getHijos());
		lista.remove(this);
		return lista;
	}
	
	public TreeSet<Persona> getHermanas() {
		TreeSet<Persona> lista = getPadre().getHijas();
		lista.addAll(getMadre().getHijas());
		lista.remove(this);
		return lista;
	}
	
	public TreeSet<Persona> getTios(){
		TreeSet<Persona> lista = getPadre().getHermanos();
		lista.addAll(getMadre().getHermanos());
		
		return lista;
	}
	
	public TreeSet<Persona>getTias(){
		TreeSet<Persona> lista = getPadre().getHermanas();
		lista.addAll(getMadre().getHermanas());
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
	
	public TreeSet<Persona> getPadres(){
		TreeSet<Persona> lista = new TreeSet<Persona>();
		lista.add(getMadre());
		lista.add(getPadre());
		
		return lista;
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
	
	public TreeSet<Persona> getBisabuelos(){
		TreeSet<Persona> listaFinal = new TreeSet<Persona>();
		TreeSet<Persona> lista = getAbuelos();
		lista.addAll(getAbuelas());
		for (Persona a : lista){
			listaFinal.add(a.getPadre());
		}
		return listaFinal;
	}
	
	public TreeSet<Persona> getBisabuelas(){
		TreeSet<Persona> listaFinal = new TreeSet<Persona>();
		TreeSet<Persona> lista = getAbuelos();
		lista.addAll(getAbuelas());
		for (Persona a : lista){
			listaFinal.add(a.getMadre());
		}
		return listaFinal;
	}
	
	public TreeSet<Persona> getBisnietas(){
		TreeSet<Persona> listaFinal = new TreeSet<Persona>();
		TreeSet<Persona> lista = getNietos();
		lista.addAll(getNietas());
		for (Persona a : lista){
			listaFinal.addAll(a.getHijas());
		}
		return listaFinal;
	}
	
	public TreeSet<Persona> getBisnietos(){
		TreeSet<Persona> listaFinal = new TreeSet<Persona>();
		TreeSet<Persona> lista = getNietos();
		lista.addAll(getNietas());
		for (Persona a : lista){
			listaFinal.addAll(a.getHijos());
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
	
	public Persona getPareja() { 
		if (casado) return this.parejas.last();
		return null;		
	}
	
	public TreeSet<Persona> getExparejas() {
		TreeSet<Persona> lista = getParejas();
		if (casado) lista.remove(lista.last());
		return lista;		
	}
	
	public Persona getSuegro() {
		return getPareja().getPadre();
	}
	
	public Persona getSuegra() {
		return getPareja().getMadre();
	}
	
	public TreeSet<Persona> getCuniados(){
		return getPareja().getHermanos();
	}
	
	public TreeSet<Persona> getCuniadas(){
		return getPareja().getHermanas();
	}
	
	public TreeSet<Persona> getYernos(){
		TreeSet<Persona> listaFinal = new TreeSet<Persona>();
		TreeSet<Persona> lista = getHijas();
		lista.addAll(getHijos());
		for (Persona a : lista) {
			a.getPareja().agregarHombre(listaFinal);
		}
		return listaFinal;
	}
	
	public TreeSet<Persona> getNueras(){
		TreeSet<Persona> listaFinal = new TreeSet<Persona>();
		TreeSet<Persona> lista = getHijas();
		lista.addAll(getHijos());
		for (Persona a : lista) {
			a.getPareja().agregarMujer(listaFinal);
		}
		return listaFinal;
	}
	
	public TreeSet<Persona> getPadrastros(){
		TreeSet<Persona> listaFinal = new TreeSet<Persona>();
		TreeSet<Persona> lista = getPadres();
		for (Persona a : lista) {
			if (a.getPareja() instanceof Hombre && a.getPareja() != this.getPadre()) listaFinal.add(a.getPareja());
		}
		return listaFinal;
	}
	
	public TreeSet<Persona> getMadrastras(){
		TreeSet<Persona> listaFinal = new TreeSet<Persona>();
		TreeSet<Persona> lista = getPadres();
		for (Persona a : lista) {
			if (a.getPareja() instanceof Mujer && a.getPareja() != this.getMadre()) listaFinal.add(a.getPareja());
		}
		return listaFinal;
	}
	
	public TreeSet<Persona> getHermanastros(){
		TreeSet<Persona> listaFinal = new TreeSet<Persona>();
		TreeSet<Persona> lista = getPadrastros();
		lista.addAll(getMadrastras());
		for (Persona a : lista) {
			for (Persona b : a.getHijos()) {
				if (!a.getPareja().getHijos().contains(b)) listaFinal.add(b);
			}
		}
		return listaFinal;
	}
	
	public TreeSet<Persona> getHermanastras(){
		TreeSet<Persona> listaFinal = new TreeSet<Persona>();
		TreeSet<Persona> lista = getPadrastros();
		lista.addAll(getMadrastras());
		for (Persona a : lista) {
			for (Persona b : a.getHijas()) {
				if (!a.getPareja().getHijas().contains(b)) listaFinal.add(b);
			}
		}
		return listaFinal;
	}
	
	public TreeSet<Persona> getAncestros(){
		TreeSet<Persona> listaFinal = new TreeSet<Persona>();
		listaFinal.addAll(getPadres());
		listaFinal.addAll(getAbuelos());
		listaFinal.addAll(getAbuelas());
		listaFinal.addAll(getBisabuelas());
		listaFinal.addAll(getBisabuelos());
		return listaFinal;
	}
	
	public TreeSet<Persona> getDescendientes(){
		TreeSet<Persona> listaFinal = new TreeSet<Persona>();
		listaFinal.addAll(getHijos());
		listaFinal.addAll(getHijas());
		listaFinal.addAll(getNietos());
		listaFinal.addAll(getNietas());
		listaFinal.addAll(getBisnietos());
		listaFinal.addAll(getBisnietas());
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
		int i = 0;
		if (o instanceof Unknown) return 1;
		return (getApellido().compareTo(o.getApellido()) == 0 ? getNombre().compareTo(o.getNombre()) : i);
		
	}


}

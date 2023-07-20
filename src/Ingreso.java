public class Ingreso extends Dinero {

	public double ingreso;
	public String description;
	
	public Ingreso(double ingreso, String description) {
		
		setDinero(ingreso);
		setDescription(description);
	}

	@Override
	public String toString() {
		return "Ingreso [ingreso=" + getDinero() + ", description=" + getDescription() + "]";
	}
	
	
	
}

import java.util.ArrayList;
import java.util.List;

public class Cuenta {

	private double saldo;
	private Usuario usuario;
	private List <Ingreso> ingresos=new ArrayList<>();
	private List <Gasto> gastos=new ArrayList<>();
	
	
	
	public Cuenta(Usuario usuario) {
		
		this.setUsuario(usuario);//Creamos la cuenta con el usuario creado inicialmente
		this.setSaldo(0);//Establecemos el saldo inicial en 0
	}


	public double getSaldo() {
		return saldo;
	}


	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public double addIngresos(String description, double cantidad) {
		ingresos.add(new Ingreso(cantidad, description));
		saldo=saldo+cantidad;
		return saldo;
		
	}
	
	public double addGastos(String description, double cantidad)throws GastoException {
		
		if(cantidad>saldo) {
			throw new GastoException();
		}
		gastos.add(new Gasto(cantidad,description));
		saldo=saldo-cantidad;
		return saldo;
		
	}

	public List<Ingreso> getIngresos() {
		return ingresos;
	}

	public List<Gasto> getGastos() {
		return gastos;
	}

	@Override
	public String toString() {
		return "Cuenta [saldo=" + saldo + ", usuario=" + usuario + ", gastos=" + gastos + ", ingresos=" + ingresos
				+ "]";
	}

	

	
	
	
	
	
}

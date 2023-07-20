import java.util.List;
import java.util.Scanner;

public class Main {
	static Scanner sc=new Scanner(System.in);
	static int opcion;
	
	public static void main(String[] args) {
		
		//Creación del Scanner para ingresar datos
		
		
		/*Creación del usuario mediante el método crearUsuario, método que recibirá
		el scanner como parámetro*/
		Usuario nuevoUsuario=crearUsuario(sc);
		
		Cuenta nuevaCuenta=new Cuenta(nuevoUsuario);//Creación de una nueva Cuenta 
		
		realizarAccion(sc,nuevaCuenta);//Recogemos y ejecutamos la acción seleccionada por el usuario en la cuenta que se le ha creado
		
		
		
	}
	
	/*El método crearUsuario se encargará de instanciar el usuario que va a acceder
	 *a la aplicación pidiendo nombre, edad y DNI mediante el Scanner y asignando
	 *sus respectivos valores mediante el setter correspondiente
	 */
	public static Usuario crearUsuario(Scanner sc) {
		
		Usuario usuario=new Usuario();
		
		System.out.println("Introduzca su nombre:");
		String nombre=sc.nextLine();
		usuario.setNombre(nombre);
		
		System.out.println("Introduzca su edad:");
		int edad=sc.nextInt();
		sc.nextLine();
		usuario.setEdad(edad);
		/*Se crea la variable booleana DNI_Valido para controlar que se vuelve
		 * a pedir el DNI en caso de no escribirse en el formato correcto mediante un bucle
		 * do While*/
		boolean DNI_Valido;
		do {
			System.out.println("Introduce tu DNI");
			String DNI=sc.nextLine();
			DNI_Valido=usuario.setDNI(DNI);
				if(!DNI_Valido) {
					System.out.println("El formato del DNI no es correcto. Por favor, introduce 8 caracteres numéricos seguidos de una letra mayúscula");
				}
			}while(!DNI_Valido);/*Cuando el DNI no sigue el formato requerido no se sale del bucle
			y se vuelve a pedir al usuario que introduzca su DNI*/
		System.out.println("Bienvenido:"+usuario.toString());
		return usuario; //Se devuelve el usuario creado
	}
	
	//Método que muestra el menú de acciones del programa
	public static int opcionEscogida() {
		int opcion;
		System.out.println();
		System.out.println("Realiza una nueva acción");
		System.out.println("1 Introduce un nuevo gasto");
		System.out.println("2 Introduce un nuevo ingreso");
		System.out.println("3 Mostrar gastos");
		System.out.println("4 Mostrar ingresos");
		System.out.println("5 Mostrar saldo");
		System.out.println("0 Salir");
		
		opcion=sc.nextInt();
		sc.nextLine();
		
		return opcion;
	}
	
	public static void realizarAccion(Scanner sc, Cuenta nuevaCuenta) {
	    int opcionMenu;
	    do {
	        opcionMenu = opcionEscogida();

	        switch(opcionMenu) { 

	        case 1: 
	            introducirGasto(nuevaCuenta, sc);
	            break;

	        case 2:
	            introducirIngreso(nuevaCuenta, sc);
	            break;
	            
	        case 3:
	        	mostrarGastos(nuevaCuenta);
	        	break;
	        
	        case 4:
	        	mostrarIngresos(nuevaCuenta);
	        	break;
	        	
	        case 5:
	        	mostrarSaldo(nuevaCuenta);
	        	break;
	        	
	        case 0:
	        	System.out.println("Fin del programa.\r\n"
	        			+ "Gracias por utilizar la aplicación.");
	        	break;
	        	
	        default:
	        	System.out.println("Opción incorrecta");
	        	break;
	        	}
	        	
	    } while(opcionMenu != 0);
	}

		
	public static void introducirGasto(Cuenta nuevaCuenta, Scanner sc) {
		try {
			System.out.println("Introduce el concepto del nuevo gasto");
			String description=sc.nextLine();
			System.out.println("Introduce la cantidad a gastar");
			double gasto=sc.nextInt();
			sc.nextLine();
			nuevaCuenta.addGastos(description,gasto);
			System.out.println("El saldo actual es: "+nuevaCuenta.getSaldo());
			}catch(GastoException e) {
				System.err.println(e.getMessage());
			}
	}
	
	public static void introducirIngreso(Cuenta nuevaCuenta, Scanner sc) {
		System.out.println("Introduce el concepto del nuevo ingreso");
		String description=sc.nextLine();
		System.out.println("Introduce la cantidad a ingresar");
		double ingreso=sc.nextDouble();
		sc.nextLine();
		nuevaCuenta.addIngresos(description, ingreso);
		System.out.println("Su saldo actual es: "+nuevaCuenta.getSaldo());
	}
	
	public static void mostrarGastos(Cuenta nuevaCuenta) {
		
        System.out.println(nuevaCuenta.getGastos());
	}
	
	public static void mostrarIngresos(Cuenta nuevaCuenta) {
		
		System.out.println(nuevaCuenta.getIngresos());
	}
	
	public static void mostrarSaldo(Cuenta nuevaCuenta) {
		
		System.out.println(nuevaCuenta.getSaldo());
	}
	
	
	}
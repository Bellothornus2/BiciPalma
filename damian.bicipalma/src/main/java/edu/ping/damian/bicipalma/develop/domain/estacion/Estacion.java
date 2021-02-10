package edu.ping.damian.bicipalma.develop.domain.estacion;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

import edu.ping.damian.bicipalma.develop.domain.bicicleta.Movil;
import edu.ping.damian.bicipalma.develop.domain.tarjetausuario.Autenticacion;

public class Estacion {

	private final int id;
	private final String direccion;
	private final Anclajes anclajes;
	
	/** 
	 * Estacion tiene una (has-a) ADT anclajes, sea cual sea
	 * El ADT ha de estar en su clase anclajes por SRP.
	 * La estación de divide en centralita /lógica y hardware /anclajes
	 * que es la interfaz con el usuario/a.
	 * Hardware anclaje no es una capa de acceso a datos... pero casi
	 * Este diseño se ve influido por el diseño de la BBDD: 
	 * Entidades libro UML Quique
	 */

	public Estacion(int id, String direccion, int numAnclajes) {
		this.id = id;
		this.direccion = direccion;
		this.anclajes = new Anclajes(numAnclajes);
	}

	private int getId() {
		return id;
	}

	private String getDireccion() {
		return direccion;
	}

	@Override
	public String toString() {
		return 	"id: " + getId() + '\n' +
				"direccion: " + getDireccion() + '\n' +
				"numeroAnclajes: " + numAnclajes();
	}

	/**
	 * Acceso a anclajes
	 */

	private Anclaje[] anclajes() {
		return this.anclajes.anclajes();
	}

	private int numAnclajes() {
		return this.anclajes.numAnclajes();
	}

	/**
	 * Lógica
	 */

	public void consultarEstacion() {
		System.out.println(this);
	}

	public long anclajesLibres() {
		/*
		int anclajesLibres = 0;
		for (Anclaje anclaje : anclajes()) {
			// si el registro del array es null => anclaje libre
			anclajesLibres = anclaje.isOcupado()? anclajesLibres: ++anclajesLibres;
		}
		*/
		return Arrays.stream(anclajes()).filter(a -> !a.isOcupado()).count();
	}

	public void anclarBicicleta(Movil bici) {
		// insertar el objeto bicicleta en el primer registro libre del array
		/*
		int posicion = 0;
		int numeroAnclaje = posicion + 1;

		for (Anclaje anclaje : anclajes()) {
			if (!anclaje.isOcupado()) { // leer anclaje
				anclajes.ocuparAnclaje(posicion, bici); // set anclaje
				mostrarAnclaje(bici, numeroAnclaje);
				break;
			} else {
				posicion++;
			}
			numeroAnclaje++;
		}
		*/
		Optional<Anclaje> anclajeLibre = Arrays.stream(anclajes()).filter(a -> !a.isOcupado()).findAny();
		if (anclajeLibre.isPresent()){
			anclajeLibre.get().anclarBici(bici);
		} else {
			System.out.println("No existen anclajes disponibles para bici" + bici);
		}
	}

	public boolean leerTarjetaUsuario(Autenticacion tarjetaUsuario) {
		return tarjetaUsuario.isActivada();
	}

	public void retirarBicicleta(Autenticacion tarjetaUsuario) {
		// genero un número de anclaje random = posicion en array
		// y retiro bici => poner a null

		if (leerTarjetaUsuario(tarjetaUsuario)) {
			/*
			boolean biciRetirada = false;
			while (!biciRetirada) {

				int posicion = anclajes.seleccionarAnclaje();
				int numeroAnclaje = posicion + 1;

				if (anclajes.isAnclajeOcupado(posicion)) { // leer anclaje
					mostrarBicicleta(anclajes.getBiciAt(posicion), numeroAnclaje);
					anclajes.liberarAnclaje(posicion); // set anclaje
					biciRetirada = true;
				} else{
					//hola
				}
				// generamos nuevo número de anclaje;
			}
		*/
		String[] stringArray = { "Damian", "Ivanov", "Kotchev" }; 
		Stream<String> stream = Arrays.stream(stringArray); 
        // Displaying elements in Stream 
        stream.forEach(str -> System.out.print(str + " "));
		Optional<Anclaje> anclajeOcupado = Arrays.stream(anclajes()).filter(Anclaje::isOcupado).findAny();
		if (anclajeOcupado.isPresent()){
			mostrarBicicleta(anclajeOcupado.get().getBici());
			anclajeOcupado.get().liberarBici();
		}
		} else {
			System.out.println("Tarjeta de usuario inactiva :(");
		}
		/*
		Los Lambdas se pueden encapsular en (parámetros) -> {Expresión}
		para poder ejecutar bloques de código en una sola línia si hace falta.
		Ahora lo entiendo, los parámetros no son mas que una abreviación o nombre para los valores
		que nos pasa el stream o el forEach de Array o cualquier función que implique iteración
		y la expresión es qu ees lo que hacemos con esos parámetros.
		*/ 
	}

	private void mostrarBicicleta(Movil bicicleta /*, int numeroAnclaje*/) {
		System.out.println("bicicleta retirada: " + bicicleta.getId() 
							/*+ " del anclaje: " + numeroAnclaje*/);
	}

	private void mostrarAnclaje(Movil bicicleta, int numeroAnclaje) {
		System.out.println("bicicleta " + bicicleta.getId() 
							+ " anclada en el anclaje " + numeroAnclaje);
	}

	public void consultarAnclajes() {
		// Recorre el array anclajes y 
		// Muestra si está libre o el id de la bici anclada 
		/*
		int posicion = 0;
		int numeroAnclaje = 0;

		for (Anclaje anclaje : anclajes()) {
			numeroAnclaje = posicion + 1;
			if (anclaje.isOcupado()) {
				System.out.println("Anclaje " + numeroAnclaje + " " + anclaje.getBici().getId());
			} else {
				System.out.println("Anclaje " + numeroAnclaje + " " + " libre");
			}
			posicion++;
		}
		*/
		Arrays.stream(anclajes()).map(a -> Optional.ofNullable(a.getBici()))
			.forEach(bici -> System.out.print("Anclaje "+ (bici.isPresent()? bici.get(): "libre") + "\n"));
	}
}
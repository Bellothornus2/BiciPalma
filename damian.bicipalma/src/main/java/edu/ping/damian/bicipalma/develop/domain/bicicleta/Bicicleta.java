package edu.ping.damian.bicipalma.develop.domain.bicicleta;

public class Bicicleta implements Movil {

	private final int id;

	public Bicicleta(int id) {
		this.id = id;
	}

	@Override // Override de Movil
	public int getId() {
		return this.id;
	}

	@Override //Override de Object
	public String toString() {
		return Integer.toString(getId());
	}
}
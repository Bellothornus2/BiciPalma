package edu.ping.damian.bicipalma.develop.domain.estacion;

import edu.ping.damian.bicipalma.develop.domain.bicicleta.Movil;
import edu.ping.damian.bicipalma.develop.domain.bicicleta.Bicicleta;

class Anclaje {

    private boolean ocupado = false;
    // Anclaje tiene una / has-a Bicicleta
    private Movil bici = null;
    /*
    private Movil bici = new Bicileta(1); 
    Una variable puede tener a su izquierda algo superior de lo que tiene a su derecha
    */

    Anclaje(int bicicletaId) {
        this.bici = new Bicicleta(bicicletaId);
        this.ocupado = true;
    }

    boolean isOcupado() {
        return this.ocupado;
    }

    Movil getBici() {
        return this.bici;
    }

    void anclarBici(Movil bici) {
        this.bici = bici;
        this.ocupado = true;
    }

    void liberarBici() {
        this.bici = null;
        this.ocupado = false;
    }

    @Override //Override de Object
    public String toString() {
        return "ocupado: " + Boolean.toString(isOcupado());
    }
}
package edu.ping.damian.bicipalma.develop.domain.estacion;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EstacionTest {

    private int id;
	private String direccion;
    private int numAnclajes;
    private Estacion estacion;

    @Before
    public void setupEstacion(){
        this.id = 1;
        this.direccion = "direccion de prueba";
        this.numAnclajes = 5;
        this.estacion = new Estacion(this.id, this.direccion, this.numAnclajes);
    }

    @Test
    public void getIdTest(){
        Assert.assertEquals(1, this.estacion.getId());
    }
}

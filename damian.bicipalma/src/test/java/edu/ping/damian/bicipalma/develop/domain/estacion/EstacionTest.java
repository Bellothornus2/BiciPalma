package edu.ping.damian.bicipalma.develop.domain.estacion;

import java.io.ByteArrayOutputStream; // recoge el system out print
import java.io.PrintStream; //lo transforma en algo legible

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EstacionTest {

    private int id;
	private String direccion;
    private int numAnclajes;
    private Estacion estacion;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    
    @Before
    public void setupEstacion(){
        System.setOut(new PrintStream(outContent));
        this.id = 1;
        this.direccion = "direccion de prueba";
        this.numAnclajes = 5;
        this.estacion = new Estacion(this.id, this.direccion, this.numAnclajes);
    }
    
    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void toStringTest(){
        Assert.assertEquals(
        "id: " + 1 + '\n' +
        "direccion: " + "direccion de prueba" + '\n' +
        "numeroAnclajes: " + 5,
        this.estacion.toString());
    }

    @Test
    public void consultarEstacionTest(){
        System.out.print(this.estacion);
        Assert.assertEquals(this.outContent.toString(), this.estacion);
    }
}

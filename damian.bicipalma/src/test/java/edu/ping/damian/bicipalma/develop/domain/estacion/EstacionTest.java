package edu.ping.damian.bicipalma.develop.domain.estacion;

import java.io.ByteArrayOutputStream; // recoge mucha mierda
import java.io.PrintStream; //de la mucha mierda recoge los System.out.print (y similares)

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
    public void toStringTest(){
        Assert.assertEquals(
        "id: " + 1 + '\n' +
        "direccion: " + "direccion de prueba" + '\n' +
        "numeroAnclajes: " + 5,
        this.estacion.toString());
    }

    @Test
    public void consultarEstacionTest(){
        PrintStream originalOut = System.out;
        //Redirige la salida estándar de los System.out al original(como debe ser)
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        //Y esto captura todo el Output y lo transforma en un array de bytes
        //que despues podemos invocar tal cual o convertirlo en String
        System.setOut(new PrintStream(outContent));
        //Y con esto redirigimos el output a un PrintStream que hemos declarado antes
        this.estacion.consultarEstacion();
        //Aquí invoco el System.out.println que quiero comprobar y lo capturo
        Assert.assertEquals(outContent.toString().trim(), this.estacion.toString());
        //aquí invoco una lo que he capturado del consultarEstacion y lo comparo
        //con "this.estacion.toString" necesitaba el trim porque 
        //daba espacios y salto de línia inseperados
        System.setOut(originalOut);
        //Aquí vuelvo a redirigir el output estándar al original que sería la consola
        //o lo que java haya decidido por defecto
    }

    @Test
    public void anclajesLibresTest(){
        Assert.assertEquals(0,estacion.anclajesLibres());
    }
}

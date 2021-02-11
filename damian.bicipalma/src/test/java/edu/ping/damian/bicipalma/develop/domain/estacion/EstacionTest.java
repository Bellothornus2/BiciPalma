package edu.ping.damian.bicipalma.develop.domain.estacion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream; // recoge mucha mierda
import java.io.PrintStream; //de la mucha mierda recoge los System.out.print (y similares)

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.ping.damian.bicipalma.develop.domain.bicicleta.Bicicleta;
import edu.ping.damian.bicipalma.develop.domain.bicicleta.Movil;
import edu.ping.damian.bicipalma.develop.domain.tarjetausuario.Autenticacion;
import edu.ping.damian.bicipalma.develop.domain.tarjetausuario.TarjetaUsuario;

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
        Assert.assertEquals(0,this.estacion.anclajesLibres());
    }

    @Test
    public void anclarBicicletaTest(){
        Autenticacion tarjetaUsuario = new TarjetaUsuario("hoasdasdasd", true);
        Movil bicicleta = new Bicicleta(456);
        this.estacion.retirarBicicleta(tarjetaUsuario);
        Assert.assertEquals(1, this.estacion.anclajesLibres());
        this.estacion.anclarBicicleta(bicicleta);
        Assert.assertEquals(0, this.estacion.anclajesLibres());
    }


    @Test
    public void leerTarjetaUsuarioTest(){
        Autenticacion tarjetaUsuario = new TarjetaUsuario("Walid", true);
        Assert.assertEquals(true,
        this.estacion.leerTarjetaUsuario(tarjetaUsuario));
    }

    @Test
    public void retirarBicicleta(){
        Autenticacion tarjetaUsuario = new TarjetaUsuario("hoasdasdasd", true);
        this.estacion.retirarBicicleta(tarjetaUsuario);
        Assert.assertEquals(1, this.estacion.anclajesLibres());
    }
    @Test
    //TODO: No funca
    public void consultarAnclajeTest(){
        PrintStream originalOut = System.out;
        ByteArrayOutputStream contentOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(contentOut));
        this.estacion.consultarAnclajes();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Anclaje 1 0\n");
        stringBuffer.append("Anclaje 2 1\n");
        stringBuffer.append("Anclaje 3 2\n");
        stringBuffer.append("Anclaje 4 3\n\n");
        stringBuffer.append("Anclaje 5 4");
        assertEquals(stringBuffer.toString(), contentOut.toString().trim());
        assertTrue(stringBuffer.toString().equals(contentOut.toString().trim()));
        System.setOut(originalOut);
        System.out.print(stringBuffer.toString().trim().equals(contentOut.toString().trim()));
        
    }
}

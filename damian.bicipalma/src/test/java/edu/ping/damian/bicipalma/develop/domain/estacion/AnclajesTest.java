package edu.ping.damian.bicipalma.develop.domain.estacion;

import edu.ping.damian.bicipalma.develop.domain.bicicleta.Bicicleta;
import edu.ping.damian.bicipalma.develop.domain.bicicleta.Movil;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



public class AnclajesTest {

    private Anclajes anclajes; //coleccion de Anclaje
    private int numAnclajes = 5; //número de Anclajes en la colección
    private Movil bici = new Bicicleta(5);

    @Before
    public void setupAnclaje(){
        this.anclajes = new Anclajes(numAnclajes);
        //cada vez que se crea un anclaje se crea un bici por defecto;
    }
    @Test
    public void crearAnclajesTest(){
        Assert.assertTrue(this.anclajes.anclajes() instanceof Anclaje[]);
        Assert.assertEquals(numAnclajes,this.anclajes.anclajes().length);
    }

    @Test
    public void numAnclajesTest(){
        Assert.assertEquals(numAnclajes, this.anclajes.anclajes().length);
    }

    @Test
    public void ocuparAnclajeTest(){
        this.anclajes.ocuparAnclaje(0, bici);
        Assert.assertEquals(bici, this.anclajes.anclajes()[0].getBici());
        Assert.assertEquals(true, this.anclajes.anclajes()[0].isOcupado());
    }

    @Test
    public void isAnclajeOcupadoTest(){
        Assert.assertEquals(true, this.anclajes.isAnclajeOcupado(0));
    }

    @Test
    public void getBiciAtTestNotNull(){
        Assert.assertEquals(0, this.anclajes.getBiciAt(0).getId());
    }

    @Test
    public void liberarAnclajeTest(){
        this.anclajes.liberarAnclaje(0);
        Assert.assertEquals(null, this.anclajes.anclajes()[0].getBici());
        Assert.assertEquals(false, this.anclajes.anclajes()[0].isOcupado());
    }

    @Test
    public void getBiciAtTestNull(){
        this.anclajes.liberarAnclaje(1);
        Assert.assertEquals(null, this.anclajes.getBiciAt(1));
    }

    @Test
    public void toStringTest(){
        Assert.assertEquals("Numero de anclajes: 5", this.anclajes.toString());
    }
}

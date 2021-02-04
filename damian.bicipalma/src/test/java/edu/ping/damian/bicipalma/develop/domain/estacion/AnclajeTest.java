package edu.ping.damian.bicipalma.develop.domain.estacion;

import edu.ping.damian.bicipalma.develop.domain.bicicleta.Bicicleta;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class AnclajeTest {
    private Anclaje anclaje = null;

    @Before
    public void setupAnclaje(){
        this.anclaje = new Anclaje();
        assertNotNull(anclaje);
    }

    @Test
    public void getBiciIdTest(){
        if (this.anclaje.getBici() == null){
            assertEquals(null, this.anclaje.getBici());
        } else{
            assertEquals(1, this.anclaje.getBici().getId());
        }
        
    }

    @Test
    public void getOcupadoTest(){
        assertEquals(false, this.anclaje.isOcupado());
    }

    @Test
    public void liberarBiciTest(){
        this.anclaje.liberarBici();
        assertEquals(false, this.anclaje.isOcupado());
        assertEquals(null, this.anclaje.getBici());
    }

    @Test
    public void anclarBiciTest(){
        Bicicleta bicicleta = new Bicicleta(1);
        this.anclaje.anclarBici(bicicleta);
        assertEquals(bicicleta, this.anclaje.getBici());
        assertEquals(true, this.anclaje.isOcupado());
    }
}

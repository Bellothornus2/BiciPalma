package edu.ping.damian.bicipalma.develop.domain.estacion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class AnclajeTest {
    private Anclaje anclaje = null;

    @Before
    public void setupAnclaje(){
        this.anclaje = new Anclaje(1);
        assertNotNull(anclaje);
    }

    @Test
    public void getAnclajeId(){
        assertEquals(1, this.anclaje.getBici().getId());
    }
}

package edu.ping.damian.bicipalma.develop.domain.bicicleta;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class BicicletaTest {
    
    private int id;
    private Movil bici;

    @Before
    public void setupBicicleta(){
        this.id = 3;
        this.bici = new Bicicleta(this.id);
    }
    @Test
    public void getIdTest(){
        Assert.assertEquals(this.id, this.bici.getId());
    }

    @Test
    public void toStringTest(){
        Assert.assertEquals(Integer.toString(this.id), this.bici.toString());
    }
}

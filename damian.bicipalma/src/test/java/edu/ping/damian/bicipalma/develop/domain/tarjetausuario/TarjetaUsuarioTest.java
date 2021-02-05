package edu.ping.damian.bicipalma.develop.domain.tarjetausuario;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TarjetaUsuarioTest {

    private String id;
    private boolean activada = false;
    private TarjetaUsuario tarjeta;

    @Before
    public void setupTarjetaUsuario(){
        this.id = "Hola";
        this.tarjeta = new TarjetaUsuario(this.id, this.activada);
    }

    @Test
    public void isActivadaTest(){
        Assert.assertEquals(false, this.tarjeta.isActivada());
    }

    @Test
    public void setActivadaTest(){
        this.tarjeta.setActivada(true);
        Assert.assertEquals(true, this.tarjeta.isActivada());
    }
}

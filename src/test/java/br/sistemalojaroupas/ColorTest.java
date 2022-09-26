package br.sistemalojaroupas;

import br.sistemalojaroupas.model.entities.Color;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.validation.constraints.AssertTrue;

public class ColorTest {
    @Test
    public void setColorName() {
        Color color = new Color();
        color.setName("vermelho");
        Assertions.assertEquals("vermelho", color.getName());
    }
}

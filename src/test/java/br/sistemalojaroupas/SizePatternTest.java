package br.sistemalojaroupas;

import br.sistemalojaroupas.model.entities.SizePattern;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;
import static org.junit.jupiter.api.Assertions.*;

public class SizePatternTest {

    @BeforeEach
    public void sizeBeforeMessage() {
        System.out.println("Size verification in progress!!");

    }

    @AfterEach
    public void sizeAfterMessage() {
        System.out.println("Size verification finished!!");

    }

    @Test
    public void setSizesTest() {
        SizePattern sizes = new SizePattern();
        sizes.addNewSize("36");
        sizes.addNewSize("37");
        sizes.addNewSize("38");
        sizes.addNewSize("39");    //Available sizes for this product.
        sizes.addNewSize("40");
        sizes.addNewSize("41");

        List<Boolean> validSizes = sizes.getSizes().stream()
                .filter(item -> item != null)
                .map((item) -> (parseInt(item) >= 36 && parseInt(item) <= 41))
                .collect(Collectors.toList());

        List<Boolean> expectedList = new ArrayList<>();

        expectedList.add(true);
        expectedList.add(true);
        expectedList.add(true);
        expectedList.add(true);
        expectedList.add(true);
        expectedList.add(true);

        assertEquals(expectedList, validSizes);

    }

    @Test
    public void setSizesFormatTest() {
        SizePattern sizes = new SizePattern();
        sizes.addNewSize("P");
        sizes.addNewSize("M");      //Available size format for this product.
        sizes.addNewSize("G");


        List<Boolean> validSizes = sizes.getSizes().stream()
                .map((item) -> item.matches(".*\\d.*"))
                .collect(Collectors.toList());

        List<Boolean> expectedList = new ArrayList<>();

        expectedList.add(false);
        expectedList.add(false);
        expectedList.add(false);

        Assertions.assertEquals(expectedList, validSizes);
    }
}

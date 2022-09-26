package sistemalojaroupatest;

import br.sistemalojaroupas.model.entities.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class ProductTest {




    @Test
    public void setPrice(){

        Product product = new Product("Camisa", "Masculino", "M", "Azul", 80.0, 150.0, 50);

        product.setSalePrice(150.0);

        Assertions.assertEquals(150.0, 150.0);


    }





}

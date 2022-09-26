package br.sistemalojaroupas;


import br.sistemalojaroupas.model.entities.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class CustomerTest {
    @Test
    public void setPhoneTest() {
        Customer customer = new Customer("09579542473", "Victor", "victor.luna@gmail.com", "92891385");
        Assertions.assertEquals("92891385", customer.getPhone());
    }

    @Test
    public void setPhoneByMethodTest() {
        Customer customer = new Customer();
        customer.setPhone("92891385");
        Assertions.assertEquals("92891385", customer.getPhone());
    }

    @Test
    public void getCustomerPhoneLength() {
        Customer customer = new Customer();
        customer.setPhone("92891385");
        boolean resultado = customer.getPhone().length() == 8;
        Assertions.assertTrue(resultado);
    }

    @Test
    public void getCustomerPhoneChar() {
        Customer customer = new Customer();
        customer.setPhone("876543ab");

        String regex = "[0-9]+";

        boolean resultado = customer.getPhone().matches(regex);
        Assertions.assertFalse(resultado);
    }
}

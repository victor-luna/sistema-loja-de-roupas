package br.sistemalojaroupas;

import br.sistemalojaroupas.model.entities.Address;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

 public class AddressTest {

     Address address;

    /*@BeforeAll
    public void cepTest(){
        this.address = new Address("cep"+address.getCep());
    }
    */

    @BeforeEach
    public  void systemInfo(){
        String street = "Rua do Principe";
        System.out.println("Seu endereço - " + toString(street));
    }

     private String toString(String street) {
         return street;
     }

     @Test
    public void AddressCepTest() {
        Address recebe = new Address("54800-000" );
        String valido = "54800-000";
        String obtido = recebe.getCep();
        Assertions.assertEquals(valido, obtido);

    }
}
package sistemalojaroupatest;

import br.sistemalojaroupas.model.entities.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserTest {



    @Test
    public void setUser() {

        User user = new User("Joao", "1234,", 333);
        user.setUserName("Joao");

        Assertions.assertEquals("Joao", user.getUserName());


    }

    @Test
    public void setUserPassword() {

        User user = new User("Joao", "1234", 333);
        user.setPassword("1234");

        Assertions.assertEquals("1234", user.getPassword());
    }

    @Test
    public void setUserPasswordFalse(){

        User user = new User();

        user.setPassword("1234");
        Assertions.assertFalse(user.getPassword("4321"));

    }




}

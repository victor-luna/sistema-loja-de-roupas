package br.sistemalojaroupas;

import br.sistemalojaroupas.model.entities.Address;
import br.sistemalojaroupas.model.entities.Employee;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EmployeeTest {

    @Test
    public void mudancaEmailEmployeeTest(){

        Employee employee = new Employee("1234567890", "Jose", "jose@hotmail.com", "8888888", new Date(10011990), new Date(10052000), 455.84, new Address("55884", "pernambuco", "gegeg", "gg4g4", "4g4g", "g4g4"));
        employee.setEmail("jose@gmail.com");
        Assertions.assertEquals("jose@gmail.com", employee.getEmail());
    }

    @Test
    public void mudancaSalaryEmployeeTest(){

        Employee employee = new Employee();
        employee.setSalary(1000.00);
        Assertions.assertEquals(1000, employee.getSalary(), 0.0);
    }

    @AfterEach
    public void mensagemAE() {
        System.out.println("Essa mensagem deve aparecer logo após a execução de cada teste");

    }

    @Test
    public void valorSalaryEmployeeTest(){

        Employee employee = new Employee("1234567890", "Jose", "gegeg@t3t3.com", "8888888", new Date(10011990), new Date(10052000), 455.84, new Address("55884", "pernambuco", "gegeg", "gg4g4", "4g4g", "g4g4"));
        employee.setSalary(0.00);
        boolean salario = employee.verificaSeSalarioMaiorQueZero();
        Assertions.assertFalse(salario);
    }

    @Test
    public void emailEmployeeTest(){

        Employee employee = new Employee();
        employee.setEmail("employee@gmail.com");
        boolean email = employee.getEmail().contains("@");
        Assertions.assertTrue(email);
    }

    @BeforeEach
    public void mensagemBE() {
        System.out.println("Essa mensagem deve aparecer antes da execução de cada teste");

    }

    @Test
    public void birthDateBeforeAdmissionDateEmployeeTest(){

        Employee employee = new Employee();

        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        String date1 = "10/01/1987";
        String date2 = "11/10/2003";
        Date birthDate = null;
        Date admissionDate = null;
        try {
            birthDate = new SimpleDateFormat("dd/MM/yyyy").parse(date1);
            admissionDate = new SimpleDateFormat("dd/MM/yyyy").parse(date2);
            Date date1convert = (Date)formatter.parse(date1);
            Date date2convert = (Date)formatter.parse(date2);
            employee.setBirthDate(date1convert);
            employee.setAdmissionDate(date2convert);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        boolean comparison = employee.getBirthDate().before(employee.getAdmissionDate());
        System.out.println(comparison);
        Assertions.assertTrue(comparison);
    }






}

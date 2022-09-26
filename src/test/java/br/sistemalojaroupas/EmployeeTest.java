package br.sistemalojaroupas;

import br.sistemalojaroupas.model.entities.Address;
import br.sistemalojaroupas.model.entities.Employee;
import org.junit.jupiter.api.*;

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
        System.out.println("Teste realizado com sucesso.");

    }

    @Test
    public void valorSalaryEmployeeTest(){

        Employee employee = new Employee("1234567890", "Jose", "gegeg@t3t3.com", "8888888", new Date(10011990), new Date(10052000), 455.84, new Address("55884", "pernambuco", "gegeg", "gg4g4", "4g4g", "g4g4"));
        employee.setSalary(0.00);
        boolean salario = employee.salarioPrecisaSerMaiorQueZero();
        Assertions.assertFalse(salario);
    }

    @Test
    public void emailComArrobaEmployeeTest(){

        Employee employee = new Employee();
        employee.setEmail("employee@gmail.com");
        boolean email = employee.getEmail().contains("@");
        Assertions.assertTrue(email);
    }

    @Test
    public void valorSalaryMaiorSalarioMinimoEmployeeTest(){

        Employee employee = new Employee();
        employee.setSalary(500.00);
        Double salarioMinimo = 1212.00;
        Assertions.assertFalse(employee.getSalary() > salarioMinimo);
    }

    @BeforeEach
    public void mensagemBE() {

        System.out.println("Iniciando teste...");

    }

    @Test
    public void birthDateBeforeAdmissionDateEmployeeTest(){

        Employee employee = new Employee();

        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        String date1Birth = "10/01/1987";
        String date2Admission = "11/10/2003";
        try {
            new SimpleDateFormat("dd/MM/yyyy").parse(date1Birth);
            new SimpleDateFormat("dd/MM/yyyy").parse(date2Admission);
            Date date1convert = formatter.parse(date1Birth);
            Date date2convert = formatter.parse(date2Admission);
            employee.setBirthDate(date1convert);
            employee.setAdmissionDate(date2convert);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        boolean compararDatas = employee.getBirthDate().before(employee.getAdmissionDate());
        System.out.println(compararDatas);
        Assertions.assertTrue(compararDatas);
    }


    @Test
    public void cpfApenasNumerosEmployeeTest(){

        Employee employee = new Employee();
        employee.setCpf("54c8058a450b87");
        boolean cpf = employee.getCpf().matches("[a-zA-Z]+");
        Assertions.assertFalse(cpf);
    }

    @Test
    public void verificaNomeEmployeeTest(){

        Employee employee = new Employee("1234567890", "Jose", "jose@hotmail.com", "8888888", new Date(10011990), new Date(10052000), 455.84, new Address("55884", "pernambuco", "gegeg", "gg4g4", "4g4g", "g4g4"));
        String nome = employee.getName();
        Assertions.assertEquals("Jose", nome);
    }

    @Test
    public void verificaCpfInseridoEmployeeTest(){

        Employee employee = new Employee();
        employee.setCpf("55588877722");
        Assertions.assertEquals("55588877722", employee.getCpf());
    }

}

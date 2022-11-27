package com.calderon.TestJava;

import com.calderon.TestJava.entitis.Clientes;
import com.calderon.TestJava.repository.ClienteRepository;
import com.calderon.TestJava.util.Util;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestJavaApplicationTests {

    @Autowired
    ClienteRepository clienteRepository;
    @Autowired
    Util util;

    Clientes clientes;

    @BeforeEach
    void initMetodoTest() {
        this.clientes = new Clientes();
        System.out.print("Iniciando prueba");
    }

    @AfterEach
    void tearDown() {
        System.out.print("Prueba finalizada");
    }

    @Test
    @DisplayName("Validador de Nombre del objeto cliente")
    void ClienteTestNombre() {
        clientes.setNombre("Juan");
        Assertions.assertEquals("Juan", clientes.getNombre());
        Assertions.assertNotEquals("Carlos", clientes.getNombre());
    }

    @Disabled("Disabled")
    @Test
    @DisplayName("Validador de Apellido del objeto cliente")
    void ClienteTest() {
        clientes.setApellido("Potter");
        Assertions.assertEquals("Potter", clientes.getApellido());
        Assertions.assertNotEquals("Slidering", clientes.getNombre());
    }

    @Test
    @DisplayName("Validador la lista del repository")
    void respositoyTestList() {
        List<Clientes> obj = clienteRepository.findAll();
        Assertions.assertNotNull(obj);
        Assertions.assertEquals(7, obj.size());
    }

    @Test
    @DisplayName("Validador el serivicio get del repository")
    void respositoyTestGet() {
        Clientes obj = clienteRepository.findById(1L).get();
        Assertions.assertNotNull(obj);
        Assertions.assertEquals("test", obj.getNombre());
    }

    @Nested
    class ingresRegistroTest {

        @Test
        @DisplayName("Validador el serivicio get del repository")
        void ingresar() {
            clientes.setNombre("Harry");
            clientes.setApellido("Potter");
            clientes.setDireccion("Privet Drive");
            clientes.setEmail("hpotter@howarts.com");
            clientes.setCelular("3001234567");

            Clientes respuesta = clienteRepository.save(clientes);
            Assertions.assertTrue(respuesta.getCelular().equals(clientes.getCelular()));
        }

        @Test
        @DisplayName("Validador la lista del repository")
        void respositoyTestIngresa() {
            List<Clientes> obj = clienteRepository.findAll();
            Assertions.assertEquals(8, obj.size());
        }

        @Test
        @DisplayName("Validador la lista del repository")
        void respositoyTestGetNombre() {
            Optional<Clientes> obj = clienteRepository.findByNombre(clientes.getNombre());
            System.out.print(obj.get().getId());
            clienteRepository.delete(obj.get());
        }

        @Test
        @DisplayName("Validador la lista del repository")
        void respositoyTestPosIngresa() {
            List<Clientes> obj = clienteRepository.findAll();
            Assertions.assertEquals(7, obj.size());
        }
    }

    @Test
    @DisplayName("Validador correo verdadero")
    void validadorCorreTestTrue() {
        boolean valida = util.validaCorreo("hpotter@howarts.com");
        Assertions.assertTrue(valida);
    }

    @Test
    @DisplayName("Validador correo falso")
    void validadorCorreTestFalse() {
        boolean valida = util.validaCorreo("hpotterhowarts.com");
        Assertions.assertNotEquals(true, valida);
    }
}

package net.javaguides.springboot_webflux_tutorial;

import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import net.javaguides.springboot_webflux_tutorial.dto.EmployeeDto;
import net.javaguides.springboot_webflux_tutorial.repository.EmployeeRepository;
import net.javaguides.springboot_webflux_tutorial.service.EmployeeService;
import reactor.core.publisher.Mono;

// used to start the server and test on random port
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeeControllerIntegrationTests {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeRepository employeeRepository;
    // for testing reactive webflux
    @Autowired
    private WebTestClient webTestClient;

    @BeforeEach
    public void before() {
        System.out.println("Before Each Test");
        employeeRepository.deleteAll().subscribe();
    }

    @Test
    public void testSaveEmployee() {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setFirstName("jastin");
        employeeDto.setLastName("samuvel");
        employeeDto.setEmail("jastinsamu@gmail.com");

        // webTestClient.post().uri("/api/employees")
        // .contentType(MediaType.APPLICATION_JSON)
        // .accept(MediaType.APPLICATION_JSON)
        // .body(Mono.just(employeeDto), EmployeeDto.class)
        // .exchange()
        // .expectStatus().isCreated()
        // .expectBody()
        // .consumeWith(System.out::println)
        // .jsonPath("$.firstName").isEqualTo(employeeDto.getFirstName())
        // .jsonPath("$.lastName").isEqualTo(employeeDto.getLastName())
        // .jsonPath("$.email").isEqualTo(employeeDto.getEmail());

        webTestClient.post().uri("/api/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(employeeDto), EmployeeDto.class)
                .exchange()
                .expectStatus().isCreated()
                .expectBody()
                .consumeWith(System.out::println)
                .jsonPath("$.firstName").isEqualTo(employeeDto.getFirstName())
                .jsonPath("$.lastName").isEqualTo(employeeDto.getLastName())
                .jsonPath("$.email").isEqualTo(employeeDto.getEmail());
    }

    @Test
    public void testGetSingleEmployee() {

        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setFirstName("Meena");
        employeeDto.setLastName("fadatare");
        employeeDto.setEmail("meena@gmail");

        EmployeeDto savedEmployee = employeeService.saveEmployee(employeeDto).block();

        webTestClient.get().uri("/api/employees/{id}", Collections.singletonMap("id", savedEmployee.getId()))
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .consumeWith(System.out::println)
                .jsonPath("$.id").isEqualTo(savedEmployee.getId())
                .jsonPath("$.firstName").isEqualTo(employeeDto.getFirstName())
                .jsonPath("$.lastName").isEqualTo(employeeDto.getLastName())
                .jsonPath("$.email").isEqualTo(employeeDto.getEmail());

    }

    @Test
    public void testGetAllEmployees() {
        webTestClient.get().uri("/api/employees")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(EmployeeDto.class)
                .consumeWith(System.out::println);
    }

    @Test
    public void testUpdateEmployee() {

        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setFirstName("kiran");
        employeeDto.setLastName("kumar");
        employeeDto.setEmail("kirankumar@gmail.com");

        EmployeeDto savedEmployee = employeeService.saveEmployee(employeeDto).block();

        EmployeeDto updatedEmployee = new EmployeeDto();
        updatedEmployee.setFirstName("Ram");
        updatedEmployee.setLastName("kumar");
        updatedEmployee.setEmail("RamKumar@gmail.com");

        webTestClient.put().uri("/api/employees/{id}", Collections.singletonMap("id", savedEmployee.getId()))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(updatedEmployee), EmployeeDto.class)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .consumeWith(System.out::println)
                .jsonPath("$.firstName").isEqualTo(updatedEmployee.getFirstName())
                .jsonPath("$.lastNmae").isEqualTo(updatedEmployee.getLastName())
                .jsonPath("$.email").isEqualTo(updatedEmployee.getEmail());
    }

    @Test
    public void testDeleteEmployee() {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setFirstName("kiran");
        employeeDto.setLastName("kumar");
        employeeDto.setEmail("kirankumar@gmail.com");

        EmployeeDto savedEmployee = employeeService.saveEmployee(employeeDto).block();

        webTestClient.delete().uri("/api/employees/{id}", Collections.singletonMap("id", savedEmployee.getId()))
                .exchange()
                .expectStatus().isNoContent()
                .expectBody()
                .consumeWith(System.out::println);

    }
}

package br.com.desafiopotiguar.DesafioPotiguar;

import br.com.desafiopotiguar.DesafioPotiguar.entity.Bobina;
import br.com.desafiopotiguar.DesafioPotiguar.repository.BobinaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DesafioPotiguarApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private BobinaRepository repository;

	@Autowired
	private ObjectMapper objectMapper;

	private static Long bobinaId;

	@Test
	@Order(9)
	void deveSalvarBobinaNoBanco() {
		Bobina b = new Bobina();
		b.setNome("B-001");

		Bobina salvo = repository.save(b);
		long bobinaId = salvo.getId();

		assertEquals(b.getNome(), salvo.getNome());
		assertEquals("B-001", salvo.getNome());
	}

	@Test
	@Order(2)
	void deveBuscarBobinaPorId() {
		Integer bobinaId = 1;
		assertTrue(repository.findById(bobinaId).isPresent());
	}
}

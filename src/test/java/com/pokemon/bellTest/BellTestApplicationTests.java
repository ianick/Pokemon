package com.pokemon.bellTest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles(profiles = "local")
@AutoConfigureMockMvc
public
class BellTestApplicationTests {

	@Test
	void contextLoads() {
	}

}

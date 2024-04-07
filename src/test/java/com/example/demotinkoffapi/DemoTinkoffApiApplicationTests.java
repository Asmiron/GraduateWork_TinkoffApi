package com.example.demotinkoffapi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import ru.tinkoff.piapi.core.InvestApi;

@SpringBootTest

class DemoTinkoffApiApplicationTests {

	@Test
	void contextLoads() {
		String token = System.getenv("ssoToken");
		var api = InvestApi.create(token);
		var order = api.getInstrumentsService().getAllBonds();

	}

}

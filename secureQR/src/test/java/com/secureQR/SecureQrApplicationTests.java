package com.secureQR;

import com.secureQR.Domain.DTO.ReqDTO;
import com.secureQR.Domain.DTO.ResDTO;
import com.secureQR.Service.SecureQrService_Impl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SecureQrApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void test_service_instance() {
		SecureQrService_Impl sec = new SecureQrService_Impl();
		Assertions.assertNotNull(sec);
	}

	@Test
	void test_reqDTO_instance() {
		ReqDTO req = new ReqDTO();
		Assertions.assertNotNull(req);
	}

	@Test
	void test_resDTO_instance() {
		ResDTO res = new ResDTO();
		Assertions.assertNotNull(res);
	}
}

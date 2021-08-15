package com.secureQR;


import com.secureQR.Domain.DTO.ReqDTO;
import lombok.extern.slf4j.Slf4j;
import com.secureQR.Service.SecureQrService_Impl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
@SpringBootTest
class SecureQrApplicationTests {

	@Test
	void contextLoads() {
	}

	/**
	 * 비즈니스 로직이 담긴 Service 패키지의 SecureQrServicef를 구현한
	 * SecureQrService_Impl의 객체 선언이 잘 되는지 테스트한다
	 */
	@Test
	void test_service_instance(){
		SecureQrService_Impl sec = new SecureQrService_Impl();
		assertNotNull(sec);
		log.info("Test : SecureQrService_Impl instance is valid");
	}

	/**
	 * 데이터를 옮기는데 사용되는 request DTO 인 reqDTO 클래스의 객체가
	 * 제대로 생성되는지 테스트한다.
	 */
	@Test
	void test_reqDTO_instance(){
		ReqDTO req = new ReqDTO();
		assertNotNull(req);
		log.info("Test : ReqDTO instance is valid");
	}

}

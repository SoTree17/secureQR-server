package com.secureQR;

import com.secureQR.Domain.DTO.ReqDTO;
import com.secureQR.Domain.DTO.ResDTO;
import lombok.extern.slf4j.Slf4j;
import com.secureQR.Service.SecureQrService_Impl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class SecureQrApplicationTests {

	@Test
	void contextLoads() {
	}

	/**
	 * 비즈니스 로직이 담긴 Service 패키지의 SecureQrServicef를 구현한
	 * SecureQrService_Impl의 객체 선언이 잘 되는지 테스트한다
	@Test
	void test_service_instance(){
		SecureQrService_Impl sec = new SecureQrService_Impl();
		assertNotNull(sec);
		log.info("Test : SecureQrService_Impl instance is valid");
	}

	*//**
	 * 데이터를 옮기는데 사용되는 request DTO 인 reqDTO 클래스의 객체가
	 * 제대로 생성되는지 테스트한다.
	 *//*
	@Test
	void test_reqDTO_instance(){
		ReqDTO req = new ReqDTO();
		assertNotNull(req);
		log.info("Test : reqDTO instance is valid");
	}
	*//**
	 * 응답 데이터를 위해 사용되는 reponse DTO 인 resDTO 클래스의 객체가
	 * 제대로 생성되는지 테스트한다.
	 *//*
	@Test
	void test_resDTO_instance(){
		ResDTO res = new ResDTO();
		assertNotNull(res);
		log.info("Test : resDTO instance is vaild");
	}
*/
}

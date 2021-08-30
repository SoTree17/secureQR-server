package com.secureQR.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Handle Major Business Logic here
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class SecureQrService_Impl implements SecureQrService {

    @Override
    public String modifyURL(String before) { //초기 테스터
        log.info("This is testing URL converter...");
        return before + "/testing";
    }
}

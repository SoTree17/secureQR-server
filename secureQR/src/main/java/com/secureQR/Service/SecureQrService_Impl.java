package com.secureQR.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class SecureQrService_Impl implements SecureQrService {
    @Override
    public String modifyURL(String before) { //initial Test code
        log.info("This is testing URL converter...");
        return before + "/testing";
    }
}

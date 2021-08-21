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

    @Autowired
    private ParsingPattern regx;

    @Override
    public String modifyURL(String before) { //초기 테스터
        log.info("This is testing URL converter...");
        return before + "/testing";
    }

    @Override
    public Matcher getParsing(String req) {
        Matcher m = null;
        if (is_encrypt(req)) {
            log.info("Valid SecureQR Request");
            Pattern ptrn = Pattern.compile(regx.getRegx());
            m = ptrn.matcher(req);
        }
        return m;
    }

    @Override
    public boolean is_encrypt(String req) {
        return Pattern.matches(regx.getRegx(), req);
    }

    @Override
    public String getDecryptedUrl(Matcher m) {
        String result = "";
        if (m != null) {
            int method = Integer.parseInt(m.group(0));
            switch (method) {
                case 0:
                    break;
                case 1:
                    // RSA 방식 decrypto 방식 호출
                    // 구현하기
                    break;
                case 2:
                    //AES256 방식 decrypto 방식 호출
                    // 구현하기
                default:
                    break;
            }
        }

        return result;
    }

}

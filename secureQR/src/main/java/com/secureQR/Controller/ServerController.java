package com.secureQR.Controller;

import com.secureQR.Domain.DTO.QrDTO;
import com.secureQR.Domain.DTO.QrImage;
import com.secureQR.Domain.DTO.ReqDTO;
import com.secureQR.Domain.DTO.ResDTO;
import com.secureQR.Service.SecureQR.QrService;
import com.secureQR.Service.SecureQrService;
import crypto.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import qr.authentication.AuthQR;

import javax.servlet.http.HttpServletRequest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/secureQR")
@RequiredArgsConstructor
@Slf4j
public class ServerController {

    @Autowired
    private QrService qrService;
    private SecureQrCryptoArray arr = new SecureQrCryptoArray();
    private SecureQrService secQR;
    HttpStatus status;

    /* testing sample */
    @PostMapping(value = "")
    public ResponseEntity<ResDTO> modifyURL(@RequestBody ReqDTO reqDTO) {
        ResDTO result = new ResDTO();
        result.setResURL(secQR.modifyURL(reqDTO.getReqURL()));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /* Web Client - Server */
    @PostMapping(value = "/generator")
    public ResponseEntity<QrImage> generateQR(@RequestBody QrDTO qrDTO, HttpServletRequest httpRequest) throws Exception {
        log.info("클라이언트로부터 secureQR 이미지 생성 요청 받음");
        log.info("클라이언트 IP : " + httpRequest.getRemoteAddr());

        QrImage result = new QrImage();

        byte[] qr_byte = qrService.createSecureQRCode(arr, qrDTO);
        result.setBinary(qr_byte);
        // qrService.createQRImage(qr_byte, "C:\\TestQR\\qrImg\\Test3.png");

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /* Android - Server */
    @PostMapping("/authQR")
    public ResponseEntity<ResDTO> authQrAndResponse(@RequestBody Map<String, String> param, HttpServletRequest httpRequest) throws Exception {
        log.info("클라이언트로부터 AUTH QR 인증 요청 받음");
        log.info("클라이언트 IP : " + httpRequest.getRemoteAddr());

        AuthQR authQR = new AuthQR(arr);

        int c_index = Integer.parseInt(param.get("c_index"));
        int d_index = Integer.parseInt(param.get("d_index"));
        String data = param.get("data");

        ResDTO res = new ResDTO();
        res.setResURL(authQR.getOriginData(data, c_index,d_index));
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    /**
     * 서버의 SecureQrCryptoArray 에 암호화 방식 추가
     */
    @PostMapping("/addCrypto")
    public ResponseEntity addCryptoToArray(@RequestBody Map<String, String> param) throws Exception {
        try {
            int c_num = Integer.parseInt(param.get("crypto"));
            int h_num = Integer.parseInt(param.get("hash"));

            SecureQrCrypto crypto = null;
            SecureQrHash hash = null;

            if (c_num == 0) crypto = new SecureQrCryptoAES256();
            else if (c_num == 1) crypto = new SecureQrCryptoRSA();

            if (h_num == 0) hash = new SecureQrHashMD5();
            else if (h_num == 1) hash = new SecureQrHashSHA256();

            this.arr.add(hash, crypto);
            log.info("현재 arr 사이즈 : " + arr.crypto_size());

            return new ResponseEntity(HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

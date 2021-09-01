package com.secureQR.Controller;

import com.secureQR.Domain.DTO.QrDTO;
import com.secureQR.Domain.DTO.QrImage;
import com.secureQR.Domain.DTO.ReqDTO;
import com.secureQR.Domain.DTO.ResDTO;
import com.secureQR.Service.SecureQR.QrService;
import com.secureQR.Service.SecureQrService;
import crypto.SecureQrCryptoArray;
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

    /* 0828 클라이언트 QR이미지 요청시 응답하기 */
    @PostMapping(value = "/generator")
    public ResponseEntity<QrImage> generateQR(@RequestBody QrDTO qrDTO) throws Exception {
        log.info("클라이언트로부터 secureQR 이미지 생성 요청 받음");
        QrImage result = new QrImage();
        result.setBinary(qrService.createSecureQRCode(arr, qrDTO));
        //HttpHeaders header = new HttpHeaders();
        //header.add("Content-type", "image/png");

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /* TODO WRITE authQR here*/
    // 아마 반환 ReponseEntity 형식으로 해야할 수도 있음
    @PostMapping("/authQR")
    public String authQrAndResponse(@RequestBody Map<String, String> param) throws Exception {
        AuthQR authQR = new AuthQR(arr);
        int c_index = Integer.parseInt(param.get("c_index"));
        int d_index = Integer.parseInt(param.get("d_index"));
        String data = param.get("data");

        return authQR.getOriginData(data, c_index,d_index);
    }


}

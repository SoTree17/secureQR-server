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

@RestController
@RequestMapping("/api/v1/secureQR")
@RequiredArgsConstructor
@Slf4j
public class MainController {

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
    @PostMapping(value="/generator")
    public ResponseEntity<QrImage> generateQR(@RequestBody QrDTO qrDTO) throws Exception{
        log.info("클라이언트로부터 secureQR 이미지 생성 요청 받음");
        QrImage result = new QrImage();
        result.setBinary(qrService.createSecureQRCode(arr, qrDTO));
        //HttpHeaders header = new HttpHeaders();
        //header.add("Content-type", "image/png");

        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    /* 0826 secureQR module 라이브러리 API 호출*/
   /* @PostMapping(value="/createQR")
    public byte[] createQR(@RequestBody QrDTO qrDTO) throws IOException {
        Generator gen = new Generator();
        SecureQrCryptoAES256 aes256 = new SecureQrCryptoAES256();
        aes256.setKey("00000000000000000000000000000000");
        arr.add(new SecureQrHashMD5(), aes256);

        //TODO NULL 체크해주기
        return gen.createSecureQRCode(arr, qrDTO.getAuthUrl(),
                qrDTO.getData(), qrDTO.getIndex(), qrDTO.getWidth(), qrDTO.getHeight());
    }*/

    /* secureQR module 라이브러리 적용 서비스 호출 */
   /* @PostMapping(value = "/getDecryptedURL")
    public ResponseEntity<ResDTO> getDecrpytedURL(@RequestBody ReqDTO reqDTO) {
        ResDTO result = new ResDTO();

        result.setResURL(secQR.getDecryptedUrl(secQR.getParsing(reqDTO.getReqURL())));
        if(!result.getResURL().equals("")){
            status = HttpStatus.OK;
        }else{
            status = HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity<>(result, status);
    }*/

}

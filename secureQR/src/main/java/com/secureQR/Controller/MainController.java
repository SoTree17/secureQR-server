package com.secureQR.Controller;

import com.secureQR.Domain.DTO.ReqDTO;
import com.secureQR.Service.SecureQrService;
import lombok.RequiredArgsConstructor;
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
public class MainController {

    @Autowired
    private SecureQrService secQR;

    /* testing sample */
    @PostMapping(value="")
    public ResponseEntity<String> modifyURL(@RequestBody ReqDTO reqDTO){
        String result = secQR.modifyURL(reqDTO.getReqURL());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}

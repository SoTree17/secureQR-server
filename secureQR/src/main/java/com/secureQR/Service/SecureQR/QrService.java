package com.secureQR.Service.SecureQR;

import com.secureQR.Domain.DTO.QrDTO;
import crypto.SecureQrCryptoArray;

import java.io.IOException;

public interface QrService {
    byte[] createSecureQRCode(SecureQrCryptoArray arr, QrDTO qrDTO) throws IOException;
    void createQRImage(byte[] qr_byte_arr, String path);
    boolean isNull(QrDTO qrDTO);
}

package com.secureQR.Service;

import java.util.regex.Matcher;

// Purpose : Handle QR url with a hashing method to produce our project goal - the secure QR
public interface SecureQrService {
    String modifyURL(String before);
}

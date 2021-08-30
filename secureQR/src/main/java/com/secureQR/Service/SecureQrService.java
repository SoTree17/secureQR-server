package com.secureQR.Service;

import java.util.regex.Matcher;

// Purpose : Handle QR url with a hashing method to produce our project goal - the secure QR
public interface SecureQrService {

    String modifyURL(String before);
    /**
     * basic test method
     */
    //Matcher getParsing(String req);
    /**
     * parsing request URL
     *
     * @param req
     * @return String[0], String[1]
     * String[0] : encryption method
     * String[1] : encrypted data
     */

    //boolean is_encrypt(String req);
    /**
     * @return whether encrypted request or not
     */

    //String getDecryptedUrl(Matcher m);
    /**
     * get specific decrypt method by m.group(0)
     * get encrypted URL datas by m.group(1)
     * Finally, decrypt by its number
     * and Response with a decrypted URL
     */


}

package qrreader;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@SpringBootApplication
public class QrReaderApplication {
	// conver url to QR Code (width*height)
	// can return image to http request
	public byte[] createSecureQRCode(String url, int width, int height) {
		QRCodeWriter qrCodeWriter = new QRCodeWriter();
		BitMatrix bitMatrix = qrCodeWriter.encode(url, BarcodeFormat.QR_CODE, width, height);

		ByteArrayOutputStream bytearraystream = new ByteArrayOutputStream();
		MatrixToImageWriter.writeToStream(bitMatrix, "PNG", bytearraystream);
		// to byte array
		byte[] pngArray = bytearraystream.toByteArray();
		return pngArray;
	}

	// get File object for decoding
	public String readSecureQRCode(File qrCodeimage) throws IOException {
		try {
		BufferedImage bf = ImageIO.read(qrCodeimage);
		LuminanceSource source = new BufferedImageLuminanceSource(bf);
		BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));


			Result result = new MultiFormatReader().decode(bitmap);
			return result.getText();
		} catch (NotFoundException e) {
			System.out.println("There is no QR code in the image");
			return null;
		}
	}

	// get string path to the file for decoding
	public String readSecureQRCode(String filepath) throws IOException {
		BufferedImage bf = ImageIO.read(new FileInputStream(filepath));
		LuminanceSource source = new BufferedImageLuminanceSource(bf);
		BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

		try {
			Result result = new MultiFormatReader().decode(bitmap);
			return result.getText();
		} catch (NotFoundException e) {
			System.out.println("There is no QR code in the image");
			return null;
		}
	}
}

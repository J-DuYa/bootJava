package com.example.demo.controller;

import com.google.zxing.WriterException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.image.BufferedImage;
import java.io.IOException;

import static com.example.demo.QR.Common.encodeQRCode;
import static com.example.demo.QR.ImageQR.*;

@RestController
@RequestMapping("/qr")
public class QRCodeController {

	@GetMapping("/common")
	public void getProject() {
		String filePath = "/Users/duya/Desktop/java/demo/common.png";
		String text = "https://github.com/J-DuYa/code-doc";
		// 生成二维码
		encodeQRCode(text, filePath);
	}

	@GetMapping("/imageQR")
	public void getQR() throws IOException, WriterException {
		BufferedImage code = createImage("https://github.com/J-DuYa/code-doc", null, false);
		System.out.println(code);
		combineCodeAndPicToFile("/Users/duya/Desktop/java/demo/download.png", code);
	}

}

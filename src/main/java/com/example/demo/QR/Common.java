package com.example.demo.QR;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Common {

	private static Logger log = LoggerFactory.getLogger(Common.class);

	// 生成二维码
	public static void encodeQRCode(String text, String path) {
		encodeQRCode(text, path, null, null, null);
	}

	public static void encodeQRCode(String text, String path, Integer width, Integer height, String format) {
		try {
			File file = new File(path);

			if (!file.getParentFile().exists()) {
				log.info("目标文件所在目录不存在，准备创建它！");
				if (!file.getParentFile().mkdirs()) {
					log.info("创建目标文件所在目录失败！");
					return;
				}
				return;
			}

			// 宽
			if (width == null) {
				width = 300;
			}
			// 高
			if (height == null) {
				height = 300;
			}
			// 图片格式
			if (format == null) {
				format = "png";
			}

			Map<EncodeHintType, Object> hints = new HashMap<>();
			hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
			// 生成二维码矩阵
			BitMatrix bitMatrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, width, height, hints);
			// 二维码路径
			Path outputPath = Paths.get(path);
			// 写入文件
			MatrixToImageWriter.writeToPath(bitMatrix, format, outputPath);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}

	public static String decodeQRCode(String filePath) {
		try {

			// 读取图片
			BufferedImage image = ImageIO.read(new File(filePath));

			// 多步解析
			LuminanceSource source = new BufferedImageLuminanceSource(image);
			Binarizer binarizer = new HybridBinarizer(source);
			BinaryBitmap binaryBitmap = new BinaryBitmap(binarizer);

			// 设置字符集编码
			Map<DecodeHintType, String> hints = new HashMap<>();
			hints.put(DecodeHintType.CHARACTER_SET, "UTF-8");

			System.out.println("binaryBitmap " + binaryBitmap + "   " + hints);

			// 对图像进行解码
			Result result = new MultiFormatReader().decode(binaryBitmap, hints);
			System.out.println("result " + result.getText());
			String content = result.getText();
			// 解码内容

//			System.out.println("图片内容：  ");
//			System.out.println("content： " + content.toJSONString());
			System.out.println("图片中格式：  ");
			System.out.println("encode： " + result.getBarcodeFormat());

			return content;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}

		return null;
	}
}

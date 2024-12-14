package com.marktech.foodApp.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.Hashtable;

@Service
public class QrCodeService {


    public ByteArrayOutputStream generateQRCode(String text) throws Exception {
        int size = 250;
        Hashtable<EncodeHintType, Object> hints = new Hashtable<>();
        hints.put(EncodeHintType.ERROR_CORRECTION, com.google.zxing.qrcode.decoder.ErrorCorrectionLevel.L);
        hints.put(EncodeHintType.MARGIN, 1);

        // Create the QR Code
        MultiFormatWriter writer = new MultiFormatWriter();
        BitMatrix bitMatrix = writer.encode(text, BarcodeFormat.QR_CODE, size, size, hints);


        BufferedImage image = getBufferedImage(size, bitMatrix);

        // Convert image to byte array and return
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        javax.imageio.ImageIO.write(image, "PNG", byteArrayOutputStream);
        return byteArrayOutputStream;
    }

    private static BufferedImage getBufferedImage(int size, BitMatrix bitMatrix) {
        BufferedImage image = new BufferedImage(size, size, BufferedImage.TYPE_INT_RGB);
        image.createGraphics();
        Graphics2D graphics = (Graphics2D) image.getGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, size, size);
        graphics.setColor(Color.BLACK);

        // Draw the QR code on the image
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (bitMatrix.get(i, j)) {
                    image.setRGB(i, j, Color.BLACK.getRGB());
                }
            }
        }
        return image;
    }
}

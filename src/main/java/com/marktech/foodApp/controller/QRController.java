package com.marktech.foodApp.controller;

import com.marktech.foodApp.model.FoodItem;
import com.marktech.foodApp.service.MenuService;
import com.marktech.foodApp.service.QrCodeService;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QRController {

    private final MenuService menuService;
    private QrCodeService qrCodeService;
    public QRController(QrCodeService qrCodeService, MenuService menuService) {
        this.qrCodeService = qrCodeService;
        this.menuService = menuService;
    }

@GetMapping("/qr")
    public ResponseEntity<ByteArrayResource> getQR() throws Exception {
    String domainName="http://localhost:8080/menu";
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.parseMediaType("image/jpeg"));
    ByteArrayResource byteArrayResource=new ByteArrayResource(qrCodeService.generateQRCode(domainName).toByteArray());
    return new ResponseEntity<>(byteArrayResource,headers, HttpStatus.OK);
}

}

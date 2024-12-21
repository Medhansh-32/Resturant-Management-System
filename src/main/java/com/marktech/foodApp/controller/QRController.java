package com.marktech.foodApp.controller;

import com.marktech.foodApp.model.FoodItem;
import com.marktech.foodApp.service.MenuService;
import com.marktech.foodApp.service.QrCodeService;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
public class QRController {

    private static final Logger log = LoggerFactory.getLogger(QRController.class);
    private final MenuService menuService;
    private QrCodeService qrCodeService;
    public QRController(QrCodeService qrCodeService, MenuService menuService) {
        this.qrCodeService = qrCodeService;
        this.menuService = menuService;
    }

@GetMapping("")
    public ResponseEntity<ByteArrayResource> getQR(HttpServletRequest request) throws Exception {
    String domainName = ServletUriComponentsBuilder.fromContextPath(request).path("/menu").toUriString();
    log.info(domainName);
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.parseMediaType("image/jpeg"));
    ByteArrayResource byteArrayResource=new ByteArrayResource(qrCodeService.generateQRCode(domainName).toByteArray());
    return new ResponseEntity<>(byteArrayResource,headers, HttpStatus.OK);
}

}

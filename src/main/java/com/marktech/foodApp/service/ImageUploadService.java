package com.marktech.foodApp.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Service
public class ImageUploadService {

    private static final Logger log = LoggerFactory.getLogger(ImageUploadService.class);
    private final String CLIENT_ID;

    public ImageUploadService(@Value("${client-id}") String CLIENT_ID) {
        this.CLIENT_ID = CLIENT_ID;
    }

    public String uploadImage(MultipartFile imageFile) {
        // RestTemplate instance
        RestTemplate restTemplate = new RestTemplate();

        // Imgur upload endpoint
        String uploadUrl = "https://api.imgur.com/3/upload";

        // Headers with Authorization
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Client-ID " + CLIENT_ID);
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        try {
            MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
            body.add("image", convertToResource(imageFile));
            HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);


            ResponseEntity<Map> responseEntity = restTemplate.exchange(
                    uploadUrl,
                    HttpMethod.POST,
                    requestEntity,
                    Map.class
            );

            Map<String, Object> responseBody = responseEntity.getBody();
            if (responseBody != null && Boolean.TRUE.equals(responseBody.get("success"))) {
                Map<String, Object> data = (Map<String, Object>) responseBody.get("data");
                log.info(data.get("link").toString());
                return data.get("link").toString();
            } else {
                throw new RuntimeException("Failed to upload image: " + responseBody);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error occurred while uploading image: " + e.getMessage());
        }
    }

    // Helper to convert MultipartFile to a Resource
    private Resource convertToResource(MultipartFile file) throws Exception {
        return new ByteArrayResource(file.getBytes()) {
            @Override
            public String getFilename() {
                return file.getOriginalFilename();
            }
        };
    }
}

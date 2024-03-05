package com.example.webdav.controller;

import com.example.webdav.service.FileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URISyntaxException;
@Slf4j
@RestController
@RequestMapping("/api/files")
@RequiredArgsConstructor

public class FileController {
    private final FileService fileService;
    @PostMapping("item")
    public ResponseEntity<Boolean> updateFile(@RequestParam("file") MultipartFile multipartFile){
        String path = "/" + multipartFile.getOriginalFilename();
        try {
            fileService.uploadFile(path, multipartFile.getBytes());
            return ResponseEntity.ok(true);
        } catch (URISyntaxException | IOException e) {
            log.error(e.getMessage());
        }
        return ResponseEntity.ok(false);
    }
}

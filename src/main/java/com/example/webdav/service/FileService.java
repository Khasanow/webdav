package com.example.webdav.service;

import com.example.webdav.config.WebDavConfig;
import com.github.sardine.Sardine;
import lombok.RequiredArgsConstructor;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
//import org.springframework.web.util.UriBuilder;

@Service
@RequiredArgsConstructor
public class FileService {
    private final Sardine sardine;
    private final WebDavConfig webDavConfig;

    public void uploadFile(String path, byte[] bytes) throws IOException, URISyntaxException {
        String fullPath = new URIBuilder(webDavConfig.getRoot()).setPath(path).toString();
        sardine.put(fullPath, bytes);
    }
}

package com.example.demo.storage;

import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.*;
import java.util.UUID;

public class FileStorage {

    private static final Path ROOT = Paths.get("uploads");

    public static String saveImage(MultipartFile file) throws IOException {
        if (file == null || file.isEmpty()) return null;
        Files.createDirectories(ROOT);
        String original = StringUtils.cleanPath(file.getOriginalFilename());
        String ext = "";
        int dot = original.lastIndexOf('.');
        if (dot >= 0) ext = original.substring(dot);
        String filename = UUID.randomUUID() + ext.toLowerCase();
        Path dest = ROOT.resolve(filename);
        Files.copy(file.getInputStream(), dest, StandardCopyOption.REPLACE_EXISTING);
        // URL pública
        return "/uploads/" + filename;
    }
}

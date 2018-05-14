package shaomai.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface UploadService {
    void uploadFile(MultipartFile file, String title, String author) throws IOException;

    String saveFile(MultipartFile file) throws IOException;
    String parseFile(String filePath) throws IOException;

    void saveArtInfo(String title, String author, String head, String relativePath);

}

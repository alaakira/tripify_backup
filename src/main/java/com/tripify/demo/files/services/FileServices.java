package com.tripify.demo.files.services;

import com.tripify.demo.files.model.DBFile;
import com.tripify.demo.files.payloads.responses.UploadFileResponse;
import com.tripify.demo.files.repositories.FilesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Objects;

@Service
public class FileServices {

    @Autowired
    private FilesRepository dbFileRepository;

    public DBFile storeFile(MultipartFile file) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));

        try {
            // Check if the file's name contains invalid characters
//            if(fileName.contains("..")) {
//                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
//            }

            DBFile dbFile = new DBFile(fileName, file.getContentType(), file.getBytes());

            return dbFileRepository.save(dbFile);
        } catch (IOException ex) {
//            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
            ex.printStackTrace();
        }
        return null;
    }

    public DBFile getFile(Long fileId) {
        return dbFileRepository.findById(fileId).orElse(null);
//                .orElseThrow(() -> new MyFileNotFoundException("File not found with id " + fileId));
    }

    public void deleteFile(Long fileId){
        dbFileRepository.deleteById(fileId);
    }

    public DBFile update(Long id, MultipartFile file) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));

        try {
            // Check if the file's name contains invalid characters
//            if(fileName.contains("..")) {
//                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
//            }

            DBFile dbFile = new DBFile(fileName, file.getContentType(), file.getBytes());
            dbFile.setId(id);
            return dbFileRepository.save(dbFile);
        } catch (IOException ex) {
//            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
            ex.printStackTrace();
        }
        return null;
    }
}

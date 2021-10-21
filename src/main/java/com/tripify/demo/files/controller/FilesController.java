package com.tripify.demo.files.controller;

import com.tripify.demo.consts.TablesNames;
import com.tripify.demo.files.model.DBFile;
import com.tripify.demo.files.payloads.responses.UploadFileResponse;
import com.tripify.demo.files.services.FileServices;
import com.tripify.demo.message_handler.ResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(TablesNames.files)
public class FilesController {


    @Autowired
    private FileServices dbFileStorageService;

    @PostMapping("/uploadFile")
    public ResponseBody<UploadFileResponse> uploadFile(@RequestParam("file") MultipartFile file) {
        DBFile dbFile = dbFileStorageService.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(dbFile.getId().toString())
                .toUriString();

        return new ResponseBody<>(new UploadFileResponse()); //dbFile.getFileName(), fileDownloadUri,
//                file.getContentType(), file.getSize());
    }

    @PostMapping("/uploadMultipleFiles")
    public List<UploadFileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
//        return Arrays.asList(files)
//                .stream()
//                .map(file -> uploadFile(file))
//                .collect(Collectors.toList());
        return new ArrayList<>();
    }

//    @GetMapping("/downloadFile/{fileId}")
//    public ResponseEntity<Resource> downloadFile(@PathVariable String fileId) {
//        // Load file from database
////        DBFile dbFile = dbFileStorageService.getFile(fileId);
////
////        return ResponseEntity.ok()
////                .contentType(MediaType.parseMediaType(dbFile.getFileType()))
////                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dbFile.getFileName() + "\"")
////                .body(new ByteArrayResource(dbFile.getData()));
//        return new ResponseEntity<>(null);
//    }
}

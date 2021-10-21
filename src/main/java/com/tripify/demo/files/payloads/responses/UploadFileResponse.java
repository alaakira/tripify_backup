package com.tripify.demo.files.payloads.responses;

import com.tripify.demo.consts.URLs;
import com.tripify.demo.files.model.DBFile;
import com.tripify.demo.files.services.URIUtils;

public class UploadFileResponse {

    public String name;

    public String type;

    public String uri;

    public String size;

    public UploadFileResponse(DBFile file) {
        name = file.getFileName();
        type = file.getFileType();
        size = Long.toString(file.getData().length / 1024) + " KB";
        uri = URIUtils.buildURI(URLs.FILES_PATH+"/",file.getId().toString());
    }

    public UploadFileResponse() {
    }
}

package com.tripify.demo.files.model;

import com.tripify.demo.consts.TablesNames;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = TablesNames.files)
@Data
public class DBFile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String fileName;

    private String fileType;

    @Lob
    private byte[] data;

    public DBFile() {

    }

    public DBFile(String fileName, String fileType, byte[] data) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.data = data;
    }
}

package com.tripify.demo.files.repositories;

import com.tripify.demo.files.model.DBFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilesRepository extends JpaRepository<DBFile,Long> {
}

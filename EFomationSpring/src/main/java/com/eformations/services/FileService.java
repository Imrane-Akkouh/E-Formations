package com.eformations.services;

import java.io.IOException;

import com.eformations.entities.File;
import com.eformations.repository.FileRepository;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;



@Service
public class FileService {
 
    @Autowired
    private FileRepository fileRepo;
 
    public String addCV(String name, MultipartFile file) throws IOException {
    	
        File newfile = new File(name); 
        newfile.setFile(
          new Binary(BsonBinarySubType.BINARY, file.getBytes()));
        
        File existingFile = fileRepo.findByName(name);
        if(existingFile!=null) {
        	fileRepo.deleteById(existingFile.getId());
        }
        newfile = fileRepo.save(newfile);
        
        return newfile.getId(); 
    }
 
    public File getCV (String username) { 
        return fileRepo.findByName(username); 
    }
}
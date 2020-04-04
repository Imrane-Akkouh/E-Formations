package com.eformations.jwt.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.eformations.jwt.api.entity.File;
import com.eformations.jwt.api.service.FileService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class UploadController {
	
	@Autowired
	FileService fileService;

	@PostMapping("/savefile")
	public String addPhoto(@RequestParam("username") String username,@RequestParam("file") MultipartFile file)
	  throws IOException {
		try{
			
			String id = fileService.addCV(username, file);
			System.out.println(username + " " + file + "yoho");
			return id;
		}catch(IOException e) {
			throw e;
		}
	    
	    
	}
	
	@GetMapping("/getfile")
	public File getPhoto(@RequestParam("username") String username) {
	    File file = fileService.getCV(username);
	    return file;
	}
}
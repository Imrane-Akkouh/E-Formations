package com.eformations.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import com.eformations.entities.File;
import com.eformations.service.FileService;

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
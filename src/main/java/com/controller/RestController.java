package com.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.dao.ImgDao;

@Controller
public class RestController {
	
	@Resource
	protected ImgDao imgDao;

    @RequestMapping(value="/upload.do", method=RequestMethod.GET)
    public @ResponseBody String provideUploadInfo() {
        return "You can upload a file by posting to this same URL.";
    }

    @RequestMapping(value="/upload.do", method=RequestMethod.POST)
    public String handleFileUpload(@RequestParam("name") String name,
            @RequestParam("file") MultipartFile file,Model model){

    	System.out.println(name);
        if (!file.isEmpty()) {
            try {
                imgDao.insert(file, name);
              
               
                model.addAttribute("imgshow", file.getOriginalFilename());
                return "show";
            } catch (Exception e) {
            	e.printStackTrace();
                return "You failed to upload " + name + " => " + e.getMessage();
            }
        } else {
            return "You failed to upload " + name + " because the file was empty.";
        }
    }

}
package com.dao;

import java.io.File;
import java.io.IOException;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Transactional
public interface ImgDao {
	public void insert(MultipartFile file, String name) throws IOException;
	//public byte[] get();

}

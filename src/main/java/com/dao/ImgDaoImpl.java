package com.dao;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.transaction.annotation.Transactional;

import com.domain.Avatar;

@Repository
@Transactional
public class ImgDaoImpl implements ImgDao{
	@Resource
	private SessionFactory sessionFactory;
	
	protected Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void insert(MultipartFile file, String name) throws IOException {
		byte[] b = file.getBytes();
	    //byte[] upLoadFile = new byte[(int)((File) file).length()];
		try{
			FileInputStream fileInputStream = new FileInputStream(new Date().toString());
			fileInputStream.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	    for(byte bb: b){
	    	System.out.println(bb);
	    }
		Avatar avatar= new Avatar();
		avatar.setImage(b);
		avatar.setType(file.getOriginalFilename());
		
		getSession().save(avatar);
		
	}

}

package com.testDatabase;

import java.io.File;
import java.io.FileInputStream;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.dao.ImgDaoImpl;
import com.domain.Avatar;


@Transactional
public class TestingDatabase {
 private ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//测试SessionFactory
 
 @Autowired
 private Avatar avatar;
 
 @Resource
 private ImgDaoImpl imgDaoImpl;
	@Test
	public void testSessionFactory() throws Exception{
		
		SessionFactory sf =(SessionFactory)ac.getBean("sessionFactory");
		System.out.println("aa");
		Session s = sf.openSession();
		File file = new File("C:/Users/michaelzhao007/Pictures/res/beef1.jpg");
	    byte[] upLoadFile = new byte[(int)file.length()];
		try{
			FileInputStream fileInputStream = new FileInputStream(file);
			fileInputStream.read(upLoadFile);
			fileInputStream.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	    for(byte b: upLoadFile){
	    	System.out.println(b);
	    }
		Avatar avatar= new Avatar();
		avatar.setImage(upLoadFile);
	
		s.save(avatar);
	}


}

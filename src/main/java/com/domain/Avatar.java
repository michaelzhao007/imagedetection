package com.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;



//@Entity
//@Table(name="Avatar")
public class Avatar implements Serializable{
  private static final long serialVersionUID = 1L;
//	@Id
//   @GeneratedValue
//   @Column(name="avaId")
	private int avaId;
//   @Lob
//   @Column(name="image")
   private byte[] image;
//   @Column(name="type")
   private String type;
public int getAvaId() {
	return avaId;
}
public void setAvaId(int avaId) {
	this.avaId = avaId;
}
public byte[] getImage() {
	return image;
}
public void setImage(byte[] image) {
	this.image = image;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
   
   
}

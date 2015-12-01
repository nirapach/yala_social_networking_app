package com.image.action;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;
import com.opensymphony.xwork2.ActionSupport;

public class ImageAction extends ActionSupport implements ServletRequestAware {

	byte[] imageInByte = null;
	String imageId, imageName;
	
	private HttpServletRequest servletRequest;
	
	public String getImageId() {
		return imageId;
	}
	
	public String getImageName() {
		return imageName;
	}
	
	public void setImageId(String imageId) {
		this.imageId = imageId;
	}
	
	public void setImageName(String imageName) {
		this.imageName= imageName;
	}
	
	public String execute() {
		return "success";
	}
	
	public byte[] getCustomImageInBytes() {
		
		BufferedImage originalImage;
		
		try {
			originalImage = ImageIO.read(getClass().getResource("/profile/" + this.imageName));
			
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(originalImage, "jpg", baos);
			baos.flush();
			imageInByte = baos.toByteArray();
			baos.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		return imageInByte;
	}
	
	public String getCustomContentType() {
		return "image/jpg";
	}
	
	public void setServletRequest(HttpServletRequest request) {
		this.servletRequest = request;
	}
}

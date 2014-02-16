package org.iiitb.action.editprofile;
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.dispatcher.mapper.ActionMapping;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.commons.io.FileUtils;
import org.iiitb.action.dao.EditProfileDAO;
import org.iiitb.model.User;

import com.opensymphony.xwork2.ActionSupport;
public class EditProfileAction extends ActionSupport implements SessionAware
{
	String name;
	String rollno;
	String password;
	File fileUpload;
	String fileUploadContentType;
	String fileUploadFileName;
	List<String> interests;
	private Map<String, Object> session;
	public String getFileUploadContentType() {
		return fileUploadContentType;
	}
 
	public void setFileUploadContentType(String fileUploadContentType) {
		this.fileUploadContentType = fileUploadContentType;
	}
 
	public String getFileUploadFileName() {
		return fileUploadFileName;
	}
 
	public void setFileUploadFileName(String fileUploadFileName) {
		this.fileUploadFileName = fileUploadFileName;
	}
 
	public File getFileUpload() {
		return fileUpload;
	}
 
	public void setFileUpload(File fileUpload) {
		this.fileUpload = fileUpload;
	}
	
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getRollno()
	{
		return rollno;
	}

	public void setRollno(String rollno)
	{
		this.rollno = rollno;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public List<String> getInterests()
	{
		return interests;
	}

	public void setInterests(List<String> interests)
	{
		this.interests = interests;
	}

	public Map<String, Object> getSession()
	{
		return session;
	}

	public void setSession(Map<String, Object> session)
	{
		this.session = session;
	}

	public String execute()
	{
		User user = (User) session.get("user");
		EditProfileDAO edp = new EditProfileDAO(user.getUserId());
		String destpath="/home/saikrishna/git/studentInfo/WebContent/layout/resources";
		File destFile  = new File(destpath, fileUploadFileName);
    	try {
			FileUtils.copyFile(fileUpload, destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		}  
		edp.setName(name);
		edp.setPassword(password);
		edp.setInterests(interests);
		edp.setPhoto(fileUploadFileName);
		return SUCCESS;
	}

	

}
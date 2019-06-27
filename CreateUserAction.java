package com.internousdev.red.action;

import java.util.Map;
import java.util.Objects;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class CreateUserAction extends ActionSupport implements SessionAware{

	Map<String,Object> session;

	private String sei;
	private String mei;
	private String seikana;
	private String meikana;
	private int seibetu;
	private String mail;
	private String userId;
	private String password;

	public String execute(){

		// セッションタイムアウトの判定
		if(Objects.isNull(session.get("userId")) && Objects.isNull(session.get("tempUserId"))){
			return "sessionTimeout";
		}
		else{
			return SUCCESS;
		}

	}

	public String getSei(){
		return this.sei;
	}

	public void setSei(String sei){
		this.sei = sei;
	}

	public String getMei(){
		return this.mei;
	}

	public void setMei(String mei){
		this.mei = mei;
	}

	public String getSeikana(){
		return this.seikana;
	}

	public void setSeikana(String seikana){
		this.seikana = seikana;
	}

	public String getMeikana(){
		return this.meikana;
	}

	public void setMeikana(String meikana){
		this.meikana = meikana;
	}

	public int getSeibetu(){
		return this.seibetu;
	}

	public void setSeibetu(int seibetu){
		this.seibetu = seibetu;
	}

	public String getMail(){
		return this.mail;
	}

	public void setMail(String mail){
		this.mail = mail;
	}

	public String getUserId(){
		return this.userId;
	}

	public void setUserId(String userId){
		this.userId = userId;
	}

	public String getPassword(){
		return this.password;
	}

	public void setPassword(String password){
		this.password = password;
	}

	@Override
	public void setSession(Map<String, Object> session){
		this.session = session;
	}

}

package com.internousdev.red.dto;

public class UserInfoDTO{

	private int id;
	private String userId;
	private String password;
	private String sei;
	private String mei;
	private String seikana;
	private String meikana;
	private int seibetu;
	private String mail;
	private int logined;

	public int getId(){
		return this.id;
	}

	public void setId(int id){
		this.id = id;
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

	public int getLogined(){
		return this.logined;
	}

	public void setLogined(int logined){
		this.logined = logined;
	}

}

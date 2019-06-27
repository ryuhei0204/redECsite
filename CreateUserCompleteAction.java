package com.internousdev.red.action;

import java.util.Map;
import java.util.Objects;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.red.dao.UserInfoDAO;
import com.opensymphony.xwork2.ActionSupport;

public class CreateUserCompleteAction extends ActionSupport implements SessionAware{

	String result;

	int checkcount;

	private String sei;
	private String mei;
	private String seikana;
	private String meikana;
	private String mail;
	private int seibetu;
	private String userId;
	private String password;
	private Map<String,Object>session;

	public String execute(){

		// セッションタイムアウトの判定
		if(Objects.isNull(session.get("userId")) && Objects.isNull(session.get("tempUserId"))){
			return "sessionTimeout";
		}
		sei = String.valueOf(session.get("sei"));
		mei = String.valueOf(session.get("mei"));
		seikana = String.valueOf(session.get("seikana"));
		meikana = String.valueOf(session.get("meikana"));
		mail = String.valueOf(session.get("mail"));
		seibetu = Integer.parseInt(String.valueOf(session.get("seibetu")));
		userId = String.valueOf(session.get("userIdForCreateUser"));
		password = String.valueOf(session.get("password"));

		session.remove("sei");
		session.remove("mei");
		session.remove("seikana");
		session.remove("meikana");
		session.remove("mail");
		session.remove("seibetu");
		session.remove("userIdForCreateUser");
		session.remove("password");

		//checkcountはuserInfoDAOのcreateUserで成功したsql文の数
		UserInfoDAO userInfoDAO = new UserInfoDAO();
		checkcount = userInfoDAO.createUser(sei, mei, seikana, meikana, seibetu, mail, session.get("userIdForCreateUser").toString(), session.get("password").toString());

		if(checkcount == 0){
			result = ERROR;
		}
		else{
			result = SUCCESS;
		}

		return result;

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

	public String getMail(){
		return this.mail;
	}
	public void setMail(String mail){
		this.mail = mail;
	}

	public int getSeibetu(){
		return this.seibetu;
	}
	public void setSeibetu(int seibetu){
		this.seibetu = seibetu;
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
	public void setSession(Map<String, Object>session){
		this.session = session;

	}

}

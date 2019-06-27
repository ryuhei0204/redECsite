package com.internousdev.red.action;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.red.dao.UserInfoDAO;
import com.internousdev.red.util.CommonUtility;
import com.internousdev.red.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;

public class CreateUserConfirmAction extends ActionSupport implements SessionAware{

	private String sei;
	private String mei;
	private String seikana;
	private String meikana;
	private int seibetu;
	private String mail;
	private String userId;
	private String password;
	private String concealPassword;
	private String errorMessage;
	private List<String>listSei;
	private List<String>listMei;
	private List<String>listSeikana;
	private List<String>listMeikana;
	private List<String>listMail;
	private List<String>listUserId;
	private List<String>listPassword;
	private Map<String,Object>session;

	public String execute(){

		String result = ERROR;

		session.put("sei", sei);
		session.put("mei",mei);
		session.put("seikana", seikana);
		session.put("meikana", meikana);
		session.put("seibetu", seibetu);
		session.put("mail", mail);
		session.put("userId", userId);
		session.put("concealPassword", concealPassword);

		// セッションタイムアウトの判定
		if(Objects.isNull(session.get("userId")) && Objects.isNull(session.get("tempUserId"))){
			return "sessionTimeout";
		}

		if(seibetu != 0 && seibetu != 1){
			return "inputError";
		}

		InputChecker checker = new InputChecker();

		//dochekerメソッドを呼び出して、検証
		listSei = checker.doCheck("姓", sei, 1, 16, true, true, true, false, false, false, false);
		listMei = checker.doCheck("名", mei, 1, 16, true, true, true, false, false, false, false);
		listSeikana = checker.doCheck("姓ふりがな", seikana, 1, 16, false, false, true, false, false, false, false);
		listMeikana = checker.doCheck("名ふりがな", meikana, 1, 16, false, false, true, false, false, false, false);
		listMail = checker.doCheckForEmail("メールアドレス", mail, 10, 32);
		listUserId = checker.doCheck("ユーザーID", userId, 1, 8, true, false, false, true, false, false, false);
		listPassword = checker.doCheck("パスワード", password, 1, 16, true, false, false, true, false, false, false);

		//listに空があればERROR;
		if(listSei.isEmpty() && listMei.isEmpty() && listSeikana.isEmpty() && listMeikana.isEmpty() && listMail.isEmpty() && listUserId.isEmpty() && listPassword.isEmpty()){

			//login時に必要のため
			session.put("userIdForCreateUser", userId);
			session.put("password", password);

			//passwordを伏せるためCommonUtilityのconcealPasswordを呼び出す
			CommonUtility cu = new CommonUtility();
			concealPassword = cu.concealPassword(password);

			UserInfoDAO userInfoDAO = new UserInfoDAO();

			//userIdかぶりのエラーメッセージ
			if(userInfoDAO.isExistsUserInfo(userId)){

				errorMessage = "使用できないユーザーIDです。";

			}else{

				result = SUCCESS;

			}

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

	public List<String> getListSei(){
		return this.listSei;
	}
	public void setListSei(List<String> listSei){
		this.listSei = listSei;
	}

	public List<String> getListMei(){
		return this.listMei;
	}
	public void setListMei(List<String> listMei){
		this.listMei = listMei;
	}

	public List<String> getListSeikana(){
		return this.listSeikana;
	}
	public void setListSeikana(List<String> listSeikana){
		this.listSeikana = listSeikana;
	}

	public List<String> getListMeikana(){
		return this.listMeikana;
	}
	public void setListMeikana(List<String> listMeikana){
		this.listMeikana = listMeikana;
	}

	public List<String> getListMail(){
		return this.listMail;
	}
	public void setListMail(List<String> listMail){
		this.listMail =listMail;
	}

	public List<String> getListUserId(){
		return this.listUserId;
	}
	public void setListUserId(List<String> listUserId){
		this.listUserId = listUserId;
	}

	public List<String> getListPassword(){
		return this.listPassword;
	}
	public void setListPassword(List<String> listPassword){
		this.listPassword = listPassword;
	}

	public String getErrorMessage(){
		return this.errorMessage;
	}

	public void setErrorMessage(String errorMessage){
		this.errorMessage = errorMessage;
	}

	@Override
	public void setSession(Map<String, Object>session){
		this.session = session;

	}

	public int getSeibetu(){
		return this.seibetu;
	}

	public void setSeibetu(int seibetu){
		this.seibetu = seibetu;
	}

	public String getConcealPassword(){
		return this.concealPassword;
	}

	public void setConcealPassword(String concealPassword){
		this.concealPassword = concealPassword;
	}

}


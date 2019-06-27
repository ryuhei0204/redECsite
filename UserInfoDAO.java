package com.internousdev.red.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.red.dto.UserInfoDTO;
import com.internousdev.red.util.DBConnector;

public class UserInfoDAO{

	//executeUpdateの戻り値がint型のため（成功したSQL文の数）
	int success;

	//新規ユーザー登録 情報登録
    public int createUser(String sei, String mei, String seikana, String meikana, int seibetu, String mail, String userId, String password){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String  sql = "INSERT INTO user_info(user_id,password,family_name,first_name,family_name_kana,first_name_kana,sex,email,regist_date,update_date)VALUES(?,?,?,?,?,?,?,?,now(),now())";
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, password);
			ps.setString(3, sei);
			ps.setString(4, mei);
			ps.setString(5, seikana);
			ps.setString(6, meikana);
			ps.setInt(7, seibetu);
			ps.setString(8, mail);

			success = ps.executeUpdate();

		}catch(SQLException e){
			e.printStackTrace();

		}finally{

			try{
				con.close();

			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return success;

	}

    //ログイン機能 ユーザー、パスワードが存在するかの確認 存在すればtrue
	public boolean isExistsUserInfo(String userId,String password){
         DBConnector db = new DBConnector();
		 Connection con = db.getConnection();
		boolean result = false;
		String sql = "select count(*) as count from user_info where user_id = ? and password = ?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				if(rs.getInt("count") > 0){
					result = true;
				}
			}
		}catch(SQLException e){
			e.printStackTrace();

		}finally{

			try{
				con.close();

			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return result;
	}

	// ユーザー登録機能  既に同じuserIdが使われているかどうかの確認
	public boolean isExistsUserInfo(String userId){
		DBConnector dbConnector = new DBConnector();

		Connection connection = dbConnector.getConnection();
		boolean result = false;
		String sql = "select count(*) as count from user_info where user_id=?";
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				if(resultSet.getInt("count") > 0){
					result = true;
				}
			}
		}catch(SQLException e){
			e.printStackTrace();

		}finally{

			try{
				connection.close();

			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return result;
	}

	public UserInfoDTO getUserInfo(String userId, String password){
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		UserInfoDTO userInfoDTO = new UserInfoDTO();
		String sql = "select * from user_info where user_id=? and password=?";
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userId);
			preparedStatement.setString(2, password);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				userInfoDTO.setId(resultSet.getInt("id"));
				userInfoDTO.setUserId(resultSet.getString("user_id"));
				userInfoDTO.setPassword(resultSet.getString("password"));
				userInfoDTO.setSei(resultSet.getString("family_name"));
				userInfoDTO.setMei(resultSet.getString("first_name"));
				userInfoDTO.setSeikana(resultSet.getString("family_name_kana"));
				userInfoDTO.setSeibetu(resultSet.getInt("sex"));
				userInfoDTO.setMail(resultSet.getString("email"));
				userInfoDTO.setLogined(resultSet.getInt("status"));
			}

		}catch(SQLException e){
			e.printStackTrace();

		}finally{

			try{
				connection.close();

			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return userInfoDTO;
	}

	//ログイン機能 userIdの確認 あれば 情報をDTOに格納
	public UserInfoDTO getUserInfo(String userId){
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		UserInfoDTO userInfoDTO = new UserInfoDTO();
		String sql = "select * from user_info where user_id=?";
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				userInfoDTO.setId(resultSet.getInt("id"));
				userInfoDTO.setUserId(resultSet.getString("user_id"));
				userInfoDTO.setPassword(resultSet.getString("password"));
				userInfoDTO.setSei(resultSet.getString("family_name"));
				userInfoDTO.setMei(resultSet.getString("first_name"));
				userInfoDTO.setSeikana(resultSet.getString("family_name_kana"));
				userInfoDTO.setMeikana(resultSet.getString("first_name_kana"));
				userInfoDTO.setSeibetu(resultSet.getInt("sex"));
				userInfoDTO.setMail(resultSet.getString("email"));
				userInfoDTO.setLogined(resultSet.getInt("logined"));
			}

		}catch(SQLException e){
			e.printStackTrace();

		}finally{

			try{
				connection.close();

			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return  userInfoDTO;
	}

	public int resetPassword(String userId, String password){
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		String sql = "update user_info set password=?, update_date=now() where user_id=?";
		int result = 0;
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, password);
			preparedStatement.setString(2, userId);
			result = preparedStatement.executeUpdate();

		}catch(SQLException e){
			e.printStackTrace();

		}finally{

			try{
				connection.close();

			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return result;
	}

	// ログイン機能 ログイン状態(logined = 1にして update_date(更新日)に追加
	public int login(String userId, String password){
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		int result=0;
		String sql = "update user_info set logined=1, update_date=now() where user_id=? and password=?";
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userId);
			preparedStatement.setString(2, password);
			result += preparedStatement.executeUpdate();

		}catch(SQLException e){
			e.printStackTrace();

		}finally{

			try{
				connection.close();

			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return result;
	}

	public int logout(String userId){
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		int result=0;
		String sql = "update user_info set logined=0, update_date=now() where user_id=?";
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userId);
			result = preparedStatement.executeUpdate();

		}catch(SQLException e){
			e.printStackTrace();

		}finally{

			try{
				connection.close();

			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return result;
	}

}

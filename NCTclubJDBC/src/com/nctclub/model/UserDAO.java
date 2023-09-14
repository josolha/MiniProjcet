package com.nctclub.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class UserDAO {
	
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public static final int MEMBER_LOGIN_SUCCESS = 1;
	public static final int MEMBER_LOGIN_NOT_PASSWORD = 0;
	public static final int MEMBER_LOGIN_NOT = -1;
	
//	public void getConnection() {
//		String url = "jdbc:oracle:thin:@localhost:1521:xe";
//		String user = "hr";
//		String pw = "hr";
//		
//		try {
//			//드라이버 로딩 (oracleDriver.class를 찾아서 로딩)
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			
//			// DriverManager 객체에 의해서 관리
//			conn = DriverManager.getConnection(url, user, pw);
//			System.out.println("데이터 베이스 연결!!");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	public Connection getConnection() {
		Context context = null;
		DataSource datasource = null;
		
		try {
			context = new InitialContext();
			datasource = (DataSource) context.lookup("java:comp/env/jdbc_oracle");
			this.conn = datasource.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return conn;
	}
	
	public int userInsert(UserDTO dto) {
		String sql = "INSERT INTO USERS "
				+ "VALUES (USERS_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE)";
		getConnection();
		
		int cnt = -1;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getUserId());
			ps.setString(2, dto.getPassword());
			ps.setString(3, dto.getFullName());
			ps.setString(4, dto.getNickname());
			ps.setDate(5, dto.getBirthdate());
			ps.setString(6, dto.getPhone());
			ps.setString(7, dto.getEmail());
			ps.setString(8, dto.getAddress());
			ps.setString(9, dto.getUserRole().getRole());
			cnt = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return cnt;
	}
	
	// 자원 반납, db 접속 종료
	public void dbClose() {
		try {
			if (rs != null) rs.close();
			if (ps != null) ps.close();
			if (conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
//	public ResultSet userLogin(UserDTO dto) {
//		String sql = "SELECT USER_ID, PASSWORD FROM USERS WHERE USER_ID = ? "
//				+ "AND PASSWORD = ? ";
//		getConnection();
//		
//		ResultSet result = null;
//		
//		try {
//			ps = conn.prepareStatement(sql);
//			ps.setString(1, dto.getUserId());
//			ps.setString(2, dto.getPassword());
//			result = ps.executeQuery();
//			if (result != null) {
//				return result;
//			} else {
//				return false;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			dbClose();
//		}
//	}
	
	// 멤버 체크
	public int memberCheck(String userId, String pw) {
	   int cnt=-1;
	   //  입력 id값과 일치하는 비밀번호를 가져오기
	   String sql = "SELECT PASSWORD FROM USERS WHERE USER_ID=?";
	   conn = getConnection();
	   
	   try {
	      ps = conn.prepareStatement(sql);
	      ps.setString(1, userId);
	      rs = ps.executeQuery();
	      
	      if(rs.next()) {// 참이면 아이디가 존재
	         String dbPw = rs.getString("PASSWORD");
	         
	         if(dbPw.equals(pw)) { // 입력pw와 dbPw가 일치하면 로그인 성공
	            cnt = MEMBER_LOGIN_SUCCESS;
	         } else { // 아이디는 맞고 비밀번호가 틀림
	            cnt = MEMBER_LOGIN_NOT_PASSWORD;
	         }
	      }else { // 아이디가 존재하지 않는 경우
	         cnt = MEMBER_LOGIN_NOT;
	      }
	   } catch (SQLException e) {         
	      e.printStackTrace();
	   } finally {
	      dbClose();
	   }
	   return cnt;
	}
	

}

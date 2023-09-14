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

	
	/*
	 * // DB에 연결하기 위해 Connection 객체 생성 public void getConnection() { String url =
	 * "jdbc:oracle:thin:@localhost:1521:xe"; String user = "hr"; String pw = "hr";
	 * 
	 * try { // 드라이버 로딩 (oracleDriver.class를 찾아서 로딩)
	 * Class.forName("oracle.jdbc.driver.OracleDriver");
	 * 
	 * // DriverManager 객체에 의해서 관리 conn = DriverManager.getConnection(url,user,pw);
	 * System.out.println("데이터 베이스 연결!!");
	 * 
	 * } catch (Exception e) {
	 * 
	 * e.printStackTrace(); } }
	 */
	
	// Connection Pool에 있는 Connection 객체 가져오기
	// JNDI, DBCP
	public Connection getConnection() {
		Context ctx = null;
		DataSource ds = null;
		try {
			// 명부를 관리하는 객체
			ctx = new InitialContext();
			// 명부에서 jdbc_oracle 찾아서 DataSource로 리턴
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc_oracle");
			// 커넥션 요청(톰캣에서 내부적으로 thread를 이용해서 connection객체를 획득해줌)
			this.conn = ds.getConnection();
		} catch (Exception e) {	
			e.printStackTrace();
		}
		return conn;
	}
	
	//회원 등록
	public int userInsert(UserDTO dto) {
		String sql = "INSERT INTO USERS(id, user_id, password, full_name, nickname, birthdate, phone, email, address, user_role, regdate) "
				+ "values(USERS_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,?,sysdate) ";
		getConnection();
		int cnt =-1;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1,dto.getUserId());
			ps.setString(2,dto.getPassword());
			ps.setString(3,dto.getFullName());
			ps.setString(4,dto.getNickname());
			ps.setDate(5,dto.getBirthdate());
			ps.setString(6,dto.getPhone());
			ps.setString(7,dto.getEmail());
			ps.setString(8,dto.getAddress());
			ps.setString(9,dto.getUserRole().getRole());
			
			
			cnt = ps.executeUpdate();
		} catch (SQLException e) {
		e.printStackTrace();
		}finally {
		dbClose();
	}
		return cnt;
	}
	
	//리소스 반납
	public void dbClose() {
		
		try {
			if(rs!= null) rs.close();
			if(ps!= null) ps.close();
			if(conn!= null) conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
}
	

}

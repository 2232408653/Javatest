package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import eneity.UserInfo;
import utils.DBUtil;
import utils.JsonUtils;

public class UserDao {
	public UserInfo selectByuname(String x) {
		UserInfo u=null;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet res=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select * from users where uname=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, x);
			res=ps.executeQuery();
			if(res.next()) {
				u=new UserInfo();
				u.setUname(res.getString("uname"));
				u.setUpwd(res.getString("upwd"));
				u.setUpower(res.getString("upower"));
				u.setUpass(res.getString("upass"));
				System.out.println(u.toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(conn, ps, res);
		}
		return u;
	}
	public boolean pdUname(String x) {
		if(selectByuname(x)==null) {
			return false;
		}
		return true;
	}
	public int insertUserInfo(UserInfo u) {
		boolean b=false;
		Connection conn=null;
		PreparedStatement ps=null;
		int row=0;
		try {
			conn=DBUtil.getConnection();
			String sql="insert into users values(?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, u.getUname());
			ps.setString(2, u.getUpwd());
			ps.setString(3,u.getUpass());
			ps.setString(4,u.getUpower());
			row=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
		
	}
	public int Update(String uname,String upwd,String npwd)  {
		int i=0;
		Connection con=null;
		PreparedStatement sta=null;
		con=DBUtil.getConnection();
		String sql="update users set upwd=? where uname=? and upwd=? ";
		try {
			sta=con.prepareStatement(sql);
		
		sta.setString(1, npwd);
		sta.setString(2, uname);
		sta.setString(3, upwd);
		i=sta.executeUpdate();
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DBUtil.closeAll(con, sta, null);
		}
		return i;
	}
	public int del(String uname,String upwd)  {
		int i=0;
		Connection con=null;
		PreparedStatement sta=null;
		con=DBUtil.getConnection();
		String sql="delete from users where uname=? and upwd = ? ";
		try {
			sta=con.prepareStatement(sql);
		
//		sta.setString(1, npwd);
		sta.setString(1, uname);
		sta.setString(2, upwd);
		i=sta.executeUpdate();
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DBUtil.closeAll(con, sta, null);
		}
		return i;
	}
	public ArrayList<UserInfo> selectAll() throws SQLException{
		ArrayList<UserInfo> users= new ArrayList<UserInfo>();
		UserInfo user1=null;
		Connection con=null;
		PreparedStatement sta=null;
		ResultSet res=null;
		try{
			con=DBUtil.getConnection();
			String sql="select * from users";
			sta=con.prepareStatement(sql);
			sta.execute();
			res = sta.executeQuery();
			while(res.next()) {
				user1 =new UserInfo();
				user1.setUname(res.getString("uname"));
				user1.setUpwd(res.getString("upwd"));
				user1.setUpower(res.getString("upower"));
				user1.setUpass(res.getString("upass"));
				users.add(user1);
			}
			}finally {
				DBUtil.closeAll(con, sta, res);
			}
		return users;
	}
	public String getAllUsersJSON() throws SQLException{
		ArrayList<UserInfo> users= new ArrayList<UserInfo>();
		UserInfo user1=null;
		Connection con=null;
		PreparedStatement sta=null;
		ResultSet res=null;
		try{
			con=DBUtil.getConnection();
			String sql="select * from users";
			sta=con.prepareStatement(sql);
			sta.execute();
			res = sta.executeQuery();
			while(res.next()) {
				user1 =new UserInfo();
				user1.setUname(res.getString("uname"));
				user1.setUpwd(res.getString("upwd"));
				user1.setUpower(res.getString("upower"));
				user1.setUpass(res.getString("upass"));
				users.add(user1);
			}
			}finally {
				DBUtil.closeAll(con, sta, res);
			}
		return JsonUtils.ListToJsonStr(users);
	}
	public static void main(String[] args) throws SQLException {
		String x="123";
		UserDao u=new UserDao();
		System.out.println(u.selectByuname(x).getUpass());
		//u.pdUname(x);
		//System.out.println(u.pdUname("2333"));
		UserInfo u2=new UserInfo();
		u2.setUname("100");
		u2.setUpwd("123456");
		u2.setUpass("false");
		u2.setUpower("high");
		ArrayList<UserInfo> u3=u.selectAll();
		System.out.println(u3.size());
		System.out.println(u3.get(1).toString());
		List<UserInfo> u4=u3;
		System.out.println(u4.toString());
		System.out.println(JsonUtils.ListToJsonStr(u3));
		//u.Update(u2.getUname(), "123456", "123456");
		u2.setUname("added");
		u.del(u2.getUname(), u2.getUpwd());
		if(u.pdUname(u2.getUname())) {
			System.out.println("用户名已存在!");
		}
		else {
			u2.setUname("added");
			System.out.println(u.insertUserInfo(u2));
		}
	}
}

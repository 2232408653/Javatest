package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import test.Address;
import utils.DBUtil;

public class test {
	public static Address selectByID(int id){
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet res=null;
		Address address=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select * from tb_address where rid=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			res=ps.executeQuery();
			if(res.next()) {
				address=new Address();
				address.setRid(res.getInt("rid"));
				address.setUser(res.getString("user_id"));
				address.setAddress(res.getString("address"));
				address.setAdded(res.getDate("added"));
				address.setReceiver(res.getString("receiver"));
				address.setReceiverPhone(res.getString("receiver_phone"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return address;
	}
	public static void main(String[] args) {
	 System.out.println(selectByID(1).getAddress());
	}
}

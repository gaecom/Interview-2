package org.meituan.ans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDao {
	public int getUserCount(String sql){
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement stat = null;
		
		try{
			StringBuilder employId = new StringBuilder();
			con = JdbcUtils.getConnection();
			String[] strs = sql.split("/");
			employId.append(Utils.getCode(strs[1],strs[2]));
			String cityName = strs[3];
			stat = con.prepareStatement("select code from city where name = ?");
			stat.setString(1, cityName);
			rs = stat.executeQuery();
			if(rs.next()){
				String cityCode = rs.getString(1);
				employId.append(cityCode);
			}
			
			System.out.println(employId.toString());
			stat = con.prepareStatement("select count(*) from employee where employId like ?");
			stat.setString(1, employId.append('%').toString());
			rs = stat.executeQuery();
			int count;
			if(rs.next()){
				count = rs.getInt(1);
				System.out.println("the number of employs in department:" + strs[1] + " city:" + cityName + " is " + count);
				return count;
			}
			return -1;
		}catch(SQLException e){
			throw new RuntimeException("sql exception");
		}finally{
			JdbcUtils.free(rs, stat, con);
		}
	}
}

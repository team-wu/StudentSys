package common;

import util.ConnectionUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PageCount {
	
	public Integer findAllCount(String tableName){
		Connection conn=null;
		Statement stat=null;
		Integer pageCount=0;
		try {
			conn=ConnectionUtil.getConnection();
			stat=conn.createStatement();
			ResultSet rs=stat.executeQuery("select count(*) from "+tableName);
			while(rs.next()){
				pageCount=rs.getInt(1);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return pageCount;			
	}
}

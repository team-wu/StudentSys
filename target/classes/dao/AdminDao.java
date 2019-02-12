package dao;

import entity.AdminEntity;
import org.springframework.stereotype.Repository;
import util.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AdminDao {
	
		//遍历所有管理员信息
		public List<AdminEntity>  findAll(){
			Connection conn=null;
			Statement stat=null;
			List<AdminEntity> list =new ArrayList<AdminEntity>();
			try {
				conn=ConnectionUtil.getConnection();
				stat=conn.createStatement();
				ResultSet rs=stat.executeQuery("select * from admin");
				while(rs.next()){
					AdminEntity ae=new AdminEntity();
					ae.setId(Integer.parseInt(rs.getString("id")));
					ae.setName(rs.getString("name"));
					ae.setPassword(rs.getString("password"));
					list.add(ae);
				}
			} catch (SQLException e) {
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
			return list;
		}
		//通过ID查找管理员
		public AdminEntity findById(Integer id){
			Connection conn=null;
			Statement stat=null;
			AdminEntity ae=new AdminEntity();
			try {
				conn=ConnectionUtil.getConnection();
				stat=conn.createStatement();
				ResultSet rs=stat.executeQuery("select * from admin where id="+id);
				while(rs.next()){
					ae.setId(Integer.parseInt(rs.getString("id")));
					ae.setName(rs.getString("name"));
					ae.setPassword(rs.getString("password"));
				}		
			} catch (SQLException e) {
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
			return ae;
		}
		//增加管理员
		public void addAdmin(AdminEntity ae){
			Connection conn=null;
			PreparedStatement ps=null;
			try {
				conn=ConnectionUtil.getConnection();
				ps=conn.prepareStatement("insert into admin (`name`,`password`) values(?,?)");
				ps.setString(1,ae.getName());
				ps.setString(2, ae.getPassword());
				ps.executeUpdate();
			} catch (SQLException e) {		
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
		}
		//删除管理员
		public void delAdmin(Integer id){
			Connection conn=null;
			Statement stat=null;
			try {
				conn=ConnectionUtil.getConnection();
				stat=conn.createStatement();
				stat.executeUpdate("delete from admin where id="+id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				if(conn!=null){
					try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		}
}

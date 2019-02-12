package dao;

import entity.AcademyEntity;
import org.springframework.stereotype.Repository;
import util.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository

public class AcademyDao {
	//增设学院
		public void addAcademy(AcademyEntity ac){
			Connection conn=null;
			PreparedStatement ps=null;
			try {
				conn=ConnectionUtil.getConnection();
				/*stat=conn.createStatement();
				String sql="insert into academy ("+"id,name"+")"+"values('"+ac.getId()
				+"','"+ac.getName()+"',";*/
				ps=conn.prepareStatement("insert into academy (`name`) values(?)");
				//ps.setInt(1, ac.getId());
				ps.setString(1, ac.getName());
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
		//分页显示所有学院
		public List<AcademyEntity> findAllAcademy(Integer page,Integer perPage){
			Connection conn=null;
			Statement stat=null;
			List<AcademyEntity> list=new ArrayList<AcademyEntity>();
			try {
				conn=ConnectionUtil.getConnection();
				stat=conn.createStatement();
				ResultSet rs=stat.executeQuery("select * from academy limit "+(page-1)*perPage+","+perPage);
				while(rs.next()){
					AcademyEntity ac=new AcademyEntity();
					ac.setId(Integer.parseInt(rs.getString("id")));
					ac.setName(rs.getString("name"));
					list.add(ac);
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
		//显示所有
		public List<AcademyEntity> findAllAcademy1(){
			Connection conn=null;
			Statement stat=null;
			List<AcademyEntity> list=new ArrayList<AcademyEntity>();
			try {
				conn=ConnectionUtil.getConnection();
				stat=conn.createStatement();
				ResultSet rs=stat.executeQuery("select * from academy");
				while(rs.next()){
					AcademyEntity ac=new AcademyEntity();
					ac.setId(Integer.parseInt(rs.getString("id")));
					ac.setName(rs.getString("name"));
					list.add(ac);
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
		//修改学院
		public void modifyAcademy(Integer id,AcademyEntity ac){
			Connection conn=null;
			Statement stat=null;
			try {
				conn=ConnectionUtil.getConnection();
				stat=conn.createStatement();
				String sql="update academy set name='"+ac.getName()+"'where id="+id;
				stat.executeUpdate(sql);
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
		//删除学院
		public void delAcademy(Integer id){
			Connection conn=null;
			Statement stat=null;
			try {
				conn=ConnectionUtil.getConnection();
				stat=conn.createStatement();
				stat.executeUpdate("delete from academy where id="+id);
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
		//按照ID查询学院
		public AcademyEntity findById(Integer id){
			Connection conn=null;
			Statement stat=null;
			AcademyEntity ac=new AcademyEntity();
			try {
				conn=ConnectionUtil.getConnection();
				stat=conn.createStatement();
				ResultSet rs=stat.executeQuery("select * from academy where id="+id);
				while(rs.next()){
					ac.setId(Integer.parseInt(rs.getString("id")));
					ac.setName(rs.getString("name"));
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
			return ac;
		}

}

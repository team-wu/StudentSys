package dao;

import entity.MajorEntity;
import org.springframework.stereotype.Repository;
import util.ConnectionUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MajorDao {
	//按id查询专业
	public MajorEntity findById(Integer id){
		Connection conn=null;
		Statement stat=null;
		MajorEntity ma=new MajorEntity();
		try {
			conn=ConnectionUtil.getConnection();
			stat=conn.createStatement();
			String sql="select * from major where id='"+id+"'";		
			ResultSet rs=stat.executeQuery(sql);
			while(rs.next()){
				ma.setId(Integer.parseInt(rs.getString("id")));
				ma.setName(rs.getString("name"));
				ma.setDesc(rs.getString("desc"));
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
		return ma;
	}
	
	//根据ID查询学生
			public boolean findByAId(Integer id){
				Connection conn = null;
				Statement state = null;		
				try {
					conn = ConnectionUtil.getConnection();
					state = conn.createStatement();
					ResultSet rs = state.executeQuery("select * from major where academy_id="+id);
					if (rs.next()) {
						return true;
					} else {
						return false;
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} finally{
					if(conn != null){
						try {
							conn.close();
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
				}
				return true;
			}
	//查询所有记录
	public List<MajorEntity> findAll(){
		Connection conn=null;
		Statement stat=null;
		List<MajorEntity> list=new ArrayList<MajorEntity>();
		try {
			conn=ConnectionUtil.getConnection();
			stat=conn.createStatement();
			ResultSet rs=stat.executeQuery("select * from major");
			while(rs.next()){
				MajorEntity ma = new MajorEntity();
				ma.setId(Integer.parseInt(rs.getString("id")));
				ma.setName(rs.getString("name"));
				ma.setDesc(rs.getString("desc"));
				ma.setAcademyId(Integer.parseInt(rs.getString("academy_id")));
				list.add(ma);
			}			
		}
		catch(SQLException e){
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
		//增加专业
		public void	addMajor(MajorEntity ma){
			Connection conn=null;
			Statement stat=null;
			try {
				conn=ConnectionUtil.getConnection();
				stat=conn.createStatement();
				String sql="insert into major("+"`name`,`desc`,`academy_id`) values('"+ma.getName()+
				"','"+ma.getDesc()+"','"+ma.getAcademyId()+"')";
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
		//删除专业
		public void delMajor(Integer id){
			Connection conn=null;
			Statement stat=null;
			try {
				conn=ConnectionUtil.getConnection();
				stat=conn.createStatement();
				String sql="delete from major where id='"+id+"'";
				stat.execute(sql);
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
		//修改专业
		public void modifyMajor(Integer id,MajorEntity ma){
			Connection conn=null;
			Statement stat=null;
			try {
				conn=ConnectionUtil.getConnection();
				stat=conn.createStatement();
				String sql="update major set `name`='"+ma.getName()+"',`desc`='"+ma.getDesc()+"',`academy_id`='"+ma.getAcademyId()+"',`academy_id`='"+ma.getAcademyId()
				+"'where id='"+id+"'";
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
		
}

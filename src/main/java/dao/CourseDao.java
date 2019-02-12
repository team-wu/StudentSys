package dao;

import entity.CourseEntity;
import org.springframework.stereotype.Repository;
import util.ConnectionUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseDao {
	//添加课程
	public void addcourse(CourseEntity cou){
		Connection conn=null;
		Statement stat=null;		
		try {
			conn=ConnectionUtil.getConnection();
			stat=conn.createStatement();
			String sql="insert into course(" + "name,credit,time,`desc`,type,academy_id) "+"values('"+cou.getName()+"','"+
			cou.getCredit()+"','"+cou.getTime()+"','"+cou.getDesc()+"','"+cou.getType()+"','"+cou.getAcademyId()+"')";
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
	
	//根据ID查询学生
	public boolean findByAId(Integer id){
		Connection conn = null;
		Statement state = null;		
		try {
			conn = ConnectionUtil.getConnection();
			state = conn.createStatement();
			ResultSet rs = state.executeQuery("select * from course where academy_id="+id);
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
	
	//删除课程	
	public void delCourse(Integer id){
		Connection conn=null;
		Statement stat=null;
		try {
			conn=ConnectionUtil.getConnection();
			stat=conn.createStatement();
			String sql="delete  from course where id='"+id+"'";
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
	//查询所有课程
	public List<CourseEntity> findAllCourse(){
		Connection conn=null;
		Statement stat=null;
		List<CourseEntity> coulist=new ArrayList<CourseEntity>();
		try {
			conn=ConnectionUtil.getConnection();
			stat=conn.createStatement();
			ResultSet rs=stat.executeQuery("select * from course");
			while(rs.next()){
				CourseEntity cou=new CourseEntity();
				cou.setId(rs.getInt("id"));
				cou.setName(rs.getString("name"));
				cou.setCredit(rs.getString("credit"));
				cou.setTime(rs.getString("time"));
				cou.setDesc(rs.getString("desc"));
				cou.setType(Integer.parseInt(rs.getString("type")));
				cou.setAcademyId(Integer.parseInt(rs.getString("academy_id")));
				coulist.add(cou);
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
		return coulist;
	}
	//修改课程
	public void modifyCourse(Integer id, CourseEntity cou){
		Connection conn=null;
		Statement stat=null;
		try {
			conn=ConnectionUtil.getConnection();
			stat=conn.createStatement();
			String sql="update course set `name`='"+cou.getName()+"',`credit`='"+cou.getCredit()+
			"',`time`='"+cou.getTime()+"',`type`='"+cou.getType()+"',`academy_id`='"+cou.getAcademyId()+"',`desc`='"+cou.getDesc()+"' where id="+id;
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
	//按照ID查询课程
	public CourseEntity findById(Integer id){
		Connection conn=null;
		Statement stat=null;
		CourseEntity cou=new CourseEntity();
		try {
			conn=ConnectionUtil.getConnection();
			stat=conn.createStatement();
			ResultSet rs=stat.executeQuery("select * from course where id="+id);
			while(rs.next()){
				cou.setId(rs.getInt("id"));
				cou.setName(rs.getString("name"));
				cou.setCredit(rs.getString("credit"));
				cou.setTime(rs.getString("time"));
				cou.setDesc(rs.getString("desc"));
				cou.setType(Integer.parseInt(rs.getString("type")));
				cou.setAcademyId(Integer.parseInt(rs.getString("academy_id")));
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
		return cou;
	}
	
}

package dao;

import entity.StudentEntity;
import org.springframework.stereotype.Repository;
import util.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository		//配置为一个bean
public class StudentDao {		
	/**
	 * 查总记录数
	 * @return
	 */
	public Integer findAllCount(){
		Connection conn=null;
		Statement stat=null;
		Integer pageCount=0;
		try {
			conn= ConnectionUtil.getConnection();
			stat=conn.createStatement();
			ResultSet rs=stat.executeQuery("select count(*) from student");
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
	/**
	 * 分页查记录
	 */
	public List<StudentEntity> findAll(Integer Page, Integer perPage){
		List<StudentEntity> list=new ArrayList();
		Connection conn=null;
		Statement stat=null;
		try{
		conn= ConnectionUtil.getConnection();
		stat=conn.createStatement();
		//String sql="SELECT student.id,student. NAME,student.gender,student.birthday,student.tellphone,student.email,student.description," +
			//	"student.school_year,student.school_term,major. NAME AS majorName FROM student LEFT JOIN major ON student.major_id = major.id";
		ResultSet rs=stat.executeQuery("select * from student limit "+ (Page-1)*perPage + "," + perPage);
		while(rs.next()){
			StudentEntity stu = new StudentEntity();
			stu.setId(Integer.parseInt(rs.getString("id")));
			stu.setName(rs.getString("name"));
			stu.setGender(Integer.parseInt(rs.getString("gender")));
			stu.setBirthday(rs.getString("birthday"));
			stu.setTellphone(rs.getString("tellphone"));
			stu.setEmail(rs.getString("email"));
			stu.setDescription(rs.getString("description"));
			stu.setSchoolTerm(Integer.parseInt(rs.getString("school_term")));
			stu.setSchoolYear(Integer.parseInt(rs.getString("school_year")));
			stu.setMajorId(Integer.parseInt(rs.getString("major_id")));
			//stu.setMajorName(rs.getString("majorName"));
			list.add(stu);
		}		
		}catch(SQLException e) {
			e.printStackTrace();
		}finally{
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			
		}
		return list;
	}			
	//根据ID查询学生
	public StudentEntity findById(Integer id ){
		Connection conn = null;
		Statement state = null;				
		StudentEntity stu = new StudentEntity();
		try {
			conn = ConnectionUtil.getConnection();
			state = conn.createStatement();
			ResultSet rs = state.executeQuery("select * from student where id="+id);
			while(rs.next()){
			stu.setId(Integer.parseInt(rs.getString("id")));
			stu.setName(rs.getString("name"));
			stu.setGender(Integer.parseInt(rs.getString("gender")));
			stu.setBirthday(rs.getString("birthday"));
			stu.setTellphone(rs.getString("tellphone"));
			stu.setEmail(rs.getString("email"));
			stu.setDescription(rs.getString("description"));
			stu.setSchoolTerm(Integer.parseInt(rs.getString("school_term")));
			stu.setSchoolYear(Integer.parseInt(rs.getString("school_year")));
			stu.setMajorId(Integer.parseInt(rs.getString("major_id")));
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
		return stu;
	}
	//根据ID查询学生
		public boolean findBymajorId(Integer id){
			Connection conn = null;
			Statement state = null;		
			try {
				conn = ConnectionUtil.getConnection();
				state = conn.createStatement();
				ResultSet rs = state.executeQuery("select * from student where major_id="+id);
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
	
	
	
	//根据姓名模糊查询
	public List<StudentEntity> findByName(String name){
		List<StudentEntity> list = new ArrayList<StudentEntity>();
		Connection conn = null;
		PreparedStatement state = null;
		try {
			conn = ConnectionUtil.getConnection();
			state = conn.prepareStatement("select * from student where name like ?");
			name = "%" + name + "%";
			state.setString(1, name);
			ResultSet rs = state.executeQuery();
			while(rs.next()){
				StudentEntity stu = new StudentEntity();
				stu.setId(Integer.parseInt(rs.getString("id")));
				stu.setName(rs.getString("name"));
				stu.setGender(Integer.parseInt(rs.getString("gender")));
				stu.setBirthday(rs.getString("birthday"));
				stu.setTellphone(rs.getString("tellphone"));
				stu.setEmail(rs.getString("email"));
				stu.setDescription(rs.getString("description"));
				stu.setSchoolTerm(Integer.parseInt(rs.getString("school_term")));
				stu.setSchoolYear(Integer.parseInt(rs.getString("school_year")));
				stu.setMajorId(Integer.parseInt(rs.getString("major_id")));
				list.add(stu);
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
		return list;
	}
	
	//新增学生
	public void  addStudent(StudentEntity stu){
		Connection conn = null;
		Statement stat = null;
		try {
			conn= ConnectionUtil.getConnection();
			stat= conn.createStatement();
			
			String sql = "insert into student(" +
			"name,gender,birthday,tellphone,email,description,school_year,school_term,major_id) " +
			"values('" + stu.getName() + "','" + stu.getGender()+"','"
			+stu.getBirthday() + "','" + stu.getTellphone() + "','" + stu.getEmail() + "','" + stu.getDescription()
					+"','"+ stu.getSchoolYear()+"','"+stu.getSchoolTerm()+"','"+stu.getMajorId()+"')";
			stat.executeUpdate(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}		
	}
	//删除学生
	public void Delstudent(String  id){
		Connection conn=null;
		Statement stat =null;
		
		try {
			conn= ConnectionUtil.getConnection();
			stat= conn.createStatement();
			
			stat.executeUpdate("delete from student where id="+id);
			
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		finally{
			if(conn!=null)
			try {
				conn.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
	
	}
		//修改学生
		public void Modify(Integer id, StudentEntity stu){
			Connection conn=null;
			Statement stat=null;		
			try {
				conn= ConnectionUtil.getConnection();
				stat=conn.createStatement();
				String sql = "update student set `name`='"+stu.getName()+"',`gender`='"+stu.getGender()+"',`birthday`='"+stu.getBirthday()+"',`email`='"+stu.getEmail()+"'," +"`school_term`='"+stu.getSchoolTerm()+"',"+"`school_year`='"+stu.getSchoolYear()+"'," +
				"`tellphone`='"+stu.getTellphone()+"',`major_id`='"+stu.getMajorId()+"' where `id`="+id;
				stat.executeUpdate(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally{
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

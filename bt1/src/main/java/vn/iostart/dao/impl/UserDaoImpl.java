package vn.iostart.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vn.iostart.dao.IUserDao;
import vn.iostart.model.Users;

public class UserDaoImpl implements IUserDao {

	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;
//	IUserRoleService userRoleService =new UserRoleServiceImpl(); // lấy dữ liệu từ UserRole

	@Override
//	public List<Users> findAll() {
//	List<Users> userList = new ArrayList<Users>();
//	String sql="select Users.userId, users.email, Users.fullname, users.images, users.username, user
//	+ "from Users\r\n"
//	+ "INNER JOIN UserRoles ON Users.roleId = UserRoles.roleId";
//	try {
//	conn = new DBConnection().getConnection();
//	ps = conn.prepareStatement(sql);
//	rs ps.executeQuery();
//	while (rs.next()) {
//	UserRoles userRoles userRoleService.findOne(rs.getInt("roleId"));

	@Override
	public void insertregister(Users user) {
		String sql = "Insert INTO Users (email, username, fullname, password, status, roleId, code) Values (?,?,?,?,?,?)";
		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getUserName());
			ps.setString(3, user.getFullName());
			ps.setString(4, user.getPassWord());
			ps.setInt(5, user.getStatus());
			ps.setInt(6, user.getRoleid());
			ps.setString(7, user.getCode());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean checkExistEmail(String email) {
		boolean duplicate = false;
		String sql = "Select From Users where email =?";
		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			rs = ps.executeQuery();
			if (rs.next()) {
				duplicate = true;
			}
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return duplicate;
	}

	@Override
	public boolean checkExistUsername(String username) {
		boolean duplicate = false;
		String sql = "Select From Users where username =?";
		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
			if (rs.next()) {
				duplicate = true;
			}
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return duplicate;
	}

	@Override
	public void updatestatus(Users user) {
		String sql = "UPDATE [Users] SET status=?, code=? WHERE email = ?";
		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, user.getStatus());
			ps.setString(2, user.getCode());
			ps.setString(3, user.getEmail());
			ps.executeUpdate();
		} catch (Exception e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public Users findOne(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Users findOne(String username) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void insert(Users user) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void update(Users user) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}

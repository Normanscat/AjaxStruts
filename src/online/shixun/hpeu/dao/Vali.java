package online.shixun.hpeu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import online.shixun.hpeu.model.Department;
import online.shixun.hpeu.model.Juri;
import online.shixun.hpeu.model.Role;
import online.shixun.hpeu.model.User;

public class Vali {
	private static String driver = "com.mysql.jdbc.Driver";
	// jdbc:mysql://IP:端口号/数据库名称
	private static String url = "jdbc:mysql://localhost:3308/groupWork";
	private static String user = "root";
	private static String password = "root";

	/**
	 * 获取JDBC连接
	 * 
	 * @return
	 */
	public static Connection getConnection() {
		Connection connection = null;

		try {
			// 注册驱动
			Class.forName(driver);

			// 获取连接
			connection = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			System.out.println("未找到驱动包");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("获取连接失败");
			e.printStackTrace();
		}
		return connection;
	}

	/**
	 * 关闭对应连接
	 * 
	 * @param resultSet
	 * @param statement
	 * @param connection
	 * @throws SQLException
	 */
	public static void closeConnection(ResultSet resultSet, PreparedStatement statement, Connection connection)
			throws SQLException {
		if (resultSet != null) {
			resultSet.close();
		}

		if (statement != null) {
			statement.close();
		}

		if (connection != null) {
			connection.close();
		}
	}

	// 登入验证
	public static boolean lookup(User login) throws SQLException {
		Connection connection = getConnection();
		StringBuffer update = new StringBuffer();
		update.append("select name,password  from t_user where username=? and password=?");
		PreparedStatement insertStatement = connection.prepareStatement(update.toString());
		insertStatement.setString(1, login.getUsername());
		insertStatement.setString(2, login.getPassword());
		ResultSet result = insertStatement.executeQuery();
		// 判断返回值为不为空
		while (result.next()) {
			// 返回值不为空 登入成功
			return true;
		}
		return false;
	}

	// 添加用户验证
	public static boolean userVali(User add) throws SQLException {
		Connection connection = getConnection();
		StringBuffer userVali = new StringBuffer();
		userVali.append("select username  from t_user where username=?");
		PreparedStatement insertStatement = connection.prepareStatement(userVali.toString());
		insertStatement.setString(1, add.getUsername());
		ResultSet result = insertStatement.executeQuery();
		// 判断返回值为不为空
		while (result.next()) {
			// 返回值不为空注册失败
			return true;
		}
		return false;
	}
	//添加权限验证
	public static boolean juriVali(Juri add) throws SQLException {
		Connection connection = getConnection();
		StringBuffer juriVali = new StringBuffer();
		juriVali.append("select jurname  from t_juri where jurname=?");
		PreparedStatement insertStatement = connection.prepareStatement(juriVali.toString());
		insertStatement.setString(1, add.getJurname());
		ResultSet result = insertStatement.executeQuery();
		// 判断返回值为不为空
		while (result.next()) {
			// 返回值不为空注册失败
			return true;
		}
		return false;
	}
	//添加角色验证
	public static boolean roleVali(Role add) throws SQLException {
		Connection connection = getConnection();
		StringBuffer roleVali = new StringBuffer();
		roleVali.append("select rolename  from t_role where rolename=?");
		PreparedStatement insertStatement = connection.prepareStatement(roleVali.toString());
		insertStatement.setString(1, add.getRolename());
		ResultSet result = insertStatement.executeQuery();
		// 判断返回值为不为空
		while (result.next()) {
			// 返回值不为空注册失败
			return true;
		}
		return false;
	}
	//添加部门验证
	public static boolean depVali(Department add) throws SQLException {
		Connection connection = getConnection();
		StringBuffer depVali = new StringBuffer();
		depVali.append("select departmentname  from t_department where departmentname=?");
		PreparedStatement insertStatement = connection.prepareStatement(depVali.toString());
		insertStatement.setString(1, add.getDepartmentname());
		ResultSet result = insertStatement.executeQuery();
		// 判断返回值为不为空
		while (result.next()) {
			// 返回值不为空注册失败
			return true;
		}
		return false;
	}
}

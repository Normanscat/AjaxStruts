package online.shixun.hpeu.action;

import java.sql.SQLException;

import online.shixun.hpeu.dao.Vali;
import online.shixun.hpeu.model.User;

public class LoginAction {
	private String username;
	private String password;
	private String message;

	public String login() {
		User login = new User();
		login.setUsername(username);
		login.setPassword(password);
		try {
			// 调用lookup方法
			Vali.lookup(login);
			// 判断返回值是否为true true为有值，登入成功
			if (Vali.lookup(login) == true) {
				return "success";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 返回值不为true 没有值 登入失败
		setMessage("登入失败，用户名或密码错误！");
		return "false";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}

package online.shixun.hpeu.service;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import online.shixun.hpeu.dao.Depdao;
import online.shixun.hpeu.dao.Userdao;
import online.shixun.hpeu.model.Department;
import online.shixun.hpeu.model.Juri;
import online.shixun.hpeu.model.Role;
import online.shixun.hpeu.model.User;
import online.shixun.hpeu.util.HibernateUtil;

public class UserService {
	private Userdao userdao = new Userdao();

	// 查询用户
	public List<User> getUser(Long Userid) {
		return userdao.getUser(Userid);
	}

	// 关键字查询
	public List<User> search(String search) {
		return userdao.searchUser(search);
	}

	// 添加用户
	public void saveuser(Long juriid, Long depname, Long rolename, String usersavename, String password, String gender,
			String usersaveusername, String phone, String sta) {
		userdao.saveuser(juriid, depname, rolename, usersavename, password, gender, usersaveusername, phone, sta);
	}

	// 更新用户
	public void upuser(Long juriid, Long userid, Long rolename, Long depname, String sta, String userupname,
			String password, String gender, String userupusername, String phone) {
		userdao.upuser(juriid, userid, rolename, depname, sta, userupname, password, gender, userupusername, phone);
	}

	// 删除用户
	public void deldep(Long userdelId) {
		userdao.deldep(userdelId);
	}

	// 批量删除用户
	public void deluserall(List<Long> listid) {
		userdao.deluserall(listid);
	}

}

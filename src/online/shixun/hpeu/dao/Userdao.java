package online.shixun.hpeu.dao;

import java.util.List;

import org.hibernate.Session;

import online.shixun.hpeu.model.Department;
import online.shixun.hpeu.model.Juri;
import online.shixun.hpeu.model.Role;
import online.shixun.hpeu.model.User;
import online.shixun.hpeu.util.HibernateUtil;

public class Userdao {
	// 查询用户
	public List<User> getUser(Long Userid) {
		return HibernateUtil.getSession().createQuery("FROM User").list();
	}

	// 关键字查询
	public List<User> searchUser(String search) {
		return HibernateUtil.getSession().createQuery("FROM User where username like'" + "%" + search + "%" + "'")
				.list();
	}

	// 添加用户
	public void saveuser(Long juriid, Long depname, Long rolename, String usersavename, String password, String gender,
			String usersaveusername, String phone, String sta) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		User user = new User();
		Department dep = new Department();
		Role role = new Role();
		Juri juri = new Juri();
		user.setName(usersavename);
		user.setPassword(password);
		user.setUsername(usersaveusername);
		user.setPhone(phone);
		user.setStatics(sta);
		user.setGender(gender);
		user.setRole(role);
		user.setDepartment(dep);
		// user.getJuri().add(juri);
		juri.setId(juriid);
		// juri.getUser().add(user);
		dep.setId(depname);
		dep.getUser().add(user);
		role.setId(rolename);
		role.getUser().add(user);
		session.save(user);
		// session.save(juri);
		// session.save(role);
		// session.save(dep);
		session.getTransaction().commit();
	}

	// 更新用户
	public void upuser(Long juriid, Long userid, Long rolename, Long depname, String sta, String userupname,
			String password, String gender, String userupusername, String phone) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		User user = new User();
		Department dep = new Department();
		Role role = new Role();
		Juri juri = new Juri();
		user.setId(userid);
		user.setName(userupname);
		user.setPassword(password);
		user.setUsername(userupusername);
		user.setPhone(phone);
		user.setStatics(sta);
		user.setGender(gender);
		user.setDepartment(dep);
		user.setRole(role);
		// user.getJuri().add(juri);
		role.setId(rolename);
		role.getUser().add(user);
		dep.setId(depname);
		dep.getUser().add(user);
		juri.setId(juriid);
		// juri.getUser().add(user);
		session.update(user);
		// session.update(role);
		// session.update(dep);
		// session.update(juri);
		session.getTransaction().commit();
	}

	// 删除用户
	public void deldep(Long userdelId) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		// dep = (Department) session.get(Department.class, delId);
		User user = new User();
		user.setId(userdelId);
		session.delete(user);
		session.getTransaction().commit();
	}

	// 批量删除用户
	public void deluserall(List<Long> listid) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		// System.out.println("service");
		for (int m = 0; m < listid.size(); m++) {
			Long id = listid.get(m);
			User user = (User) session.get(User.class, id);
			session.delete(user);
		}
		session.getTransaction().commit();
	}

}

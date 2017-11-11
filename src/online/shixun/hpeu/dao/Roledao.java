package online.shixun.hpeu.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import online.shixun.hpeu.model.Role;
import online.shixun.hpeu.util.HibernateUtil;

public class Roledao {

	// 查询角色
	public List<Role> getRole(Long RoleId) {
		return HibernateUtil.getSession().createQuery("FROM Role").list();
	}

	// 关键字查询
	public List<Role> searchRole(String search) {
		// System.out.println("dao层的search是" + search);
		return HibernateUtil.getSession().createQuery("FROM Role where rolename like'" + "%" + search + "%" + "'")
				.list();
	}

	// 添加角色
	public void saverole(String rolesavename, String rolesavescp) {
		// roledao.saverole(rolesavename, rolesavescp);
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Role role = new Role();
		// User user = new User();
		role.setRolename(rolesavename);
		role.setRolescp(rolesavescp);
		role.setRoletime(new Date());
		// role.getUser().add(user);
		session.save(role);
		session.getTransaction().commit();
	}

	// 更新角色
	public void uprole(Long roleeditid, String roleeditname, String roleeditscp) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Role role = new Role();
		role.setId(roleeditid);
		role.setRolename(roleeditname);
		role.setRolescp(roleeditscp);
		role.setRoletime(new Date());
		session.update(role);
		session.getTransaction().commit();
	}

	// 删除角色
	public void delrole(Long roledelId) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Role role = new Role();
		role.setId(roledelId);
		session.delete(role);
		session.getTransaction().commit();
	}

	// 批量删除角色
	public void deldepall(List<Long> listid) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		System.out.println("service");
		for (int m = 0; m < listid.size(); m++) {
			Long id = listid.get(m);
			Role role = (Role) session.get(Role.class, id);
			session.delete(role);
		}
		session.getTransaction().commit();
	}

}

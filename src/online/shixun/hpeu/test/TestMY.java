package online.shixun.hpeu.test;

import java.util.*;

import org.hibernate.Session;
import org.junit.Test;

import online.shixun.hpeu.model.Department;
import online.shixun.hpeu.model.Juri;
import online.shixun.hpeu.model.Role;
import online.shixun.hpeu.model.User;
import online.shixun.hpeu.util.HibernateUtil;

public class TestMY {
	@Test
	public void test() {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Department dep = new Department();
		User user = new User();
		Juri juri = new Juri();
		Role role = new Role();
		// 部门
		dep.setDepartmentname("开发部");
		dep.setDepartmentscp("加班，加班，加班");
		dep.setDepartmenttime(new Date());
		dep.getUser().add(user);
		// 用户
		user.setName("tom");
		user.setPassword("123456");
		user.setUsername("acher");
		user.setGender("男");
		user.setPhone("1234567");
		user.setStatics("启用");
		user.setDepartment(dep);
		user.getJuri().add(juri);
		user.setRole(role);
		// 权限
		juri.setJurname("增删改查");
		juri.setJurscp("数据库交给你了");
		juri.getUser().add(user);
		// 角色
		role.setRolename("程序员");
		role.setRolescp("没有女朋友");
		role.setRoletime(new Date());
		role.getUser().add(user);

		session.save(user);
		session.save(dep);
		session.save(juri);
		session.save(role);
		session.getTransaction().commit();
		session.close();
	}
}

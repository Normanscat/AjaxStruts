package online.shixun.hpeu.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import online.shixun.hpeu.model.Department;
import online.shixun.hpeu.util.HibernateUtil;

public class Depdao {
	// 查询部门
	public List<Department> getDep() {
		return HibernateUtil.getSession().createQuery("FROM Department").list();
	}

	// 关键字查询部门
	public List<Department> searchDep(String search) {
		System.out.println("dao层的search是"+search);
		return HibernateUtil.getSession().createQuery("FROM Department where departmentname like'"+"%"+search+"%"+"'")
				.list();
	}

	// 保存部门
	public void savedep(String depsavename, String depsavescp) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Department dep = new Department();
		dep.setDepartmentname(depsavename);
		dep.setDepartmentscp(depsavescp);
		dep.setDepartmenttime(new Date());
		session.save(dep);
		session.getTransaction().commit();
	}

	// 删除部门
	public void deldep(Long depdelId) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		// dep = (Department) session.get(Department.class, delId);
		Department dep = new Department();
		dep.setId(depdelId);
		session.delete(dep);
		session.getTransaction().commit();
	}

	// 批量删除部门
	public void deldepall(List<Long> listid) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		System.out.println("service");
		for (int m = 0; m < listid.size(); m++) {
			Long id = listid.get(m);
			// System.out.println(id);
			Department dep = (Department) session.get(Department.class, id);
			session.delete(dep);
		}
		session.getTransaction().commit();
	}

	// 更新部门
	public void updep(Long depeditid, String depeditname, String depeditscp) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		// dep = (Department) session.get(Department.class, depeditid);
		Department dep = new Department();
		dep.setId(depeditid);
		dep.setDepartmentname(depeditname);
		dep.setDepartmentscp(depeditscp);
		dep.setDepartmenttime(new Date());
		session.update(dep);
		session.getTransaction().commit();
	}
}

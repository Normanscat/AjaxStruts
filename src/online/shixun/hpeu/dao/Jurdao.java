package online.shixun.hpeu.dao;

import java.util.List;

import org.hibernate.Session;

import online.shixun.hpeu.model.Juri;
import online.shixun.hpeu.util.HibernateUtil;

public class Jurdao {
	// 查询权限
	public List<Juri> getJuri(Long JuriId) {
		return HibernateUtil.getSession().createQuery("FROM Juri").list();
	}
	// 关键字查询
	public List<Juri> searchJuri(String search) {
		return HibernateUtil.getSession().createQuery("FROM Juri where jurname like'"+"%"+search+"%"+"'")
				.list();
	}

	// 添加权限
	public void savejuri(String jurisavename, String jurisavescp) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Juri juri = new Juri();
		juri.setJurname(jurisavename);
		juri.setJurscp(jurisavescp);
		session.save(juri);
		session.getTransaction().commit();
	}

	// 更新权限
	public void upjuri(Long juriupid, String juriupname, String juriupscp) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Juri juri = new Juri();
		juri.setId(juriupid);
		juri.setJurname(juriupname);
		juri.setJurscp(juriupscp);
		session.update(juri);
		session.getTransaction().commit();
	}

	// 删除权限
	public void deljuri(Long juridelId) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Juri juri = new Juri();
		juri.setId(juridelId);
		session.delete(juri);
		session.getTransaction().commit();
	}

	// 批量删除权限
	public void deljuriall(List<Long> listid) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		for (int m = 0; m < listid.size(); m++) {
			Long id = listid.get(m);
			// System.out.println(id);
			Juri juri = (Juri) session.get(Juri.class, id);
			session.delete(juri);
		}
		session.getTransaction().commit();
	}
}

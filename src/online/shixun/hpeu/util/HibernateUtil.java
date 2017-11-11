package online.shixun.hpeu.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sessionFactory;

	static {
		// 会读取 Hibernate 的核心配置文件
		Configuration configure = new Configuration().configure();

		// 获取 session 工厂
		StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder();
		StandardServiceRegistry serviceRegistry = ssrb.applySettings(configure.getProperties()).build();
		sessionFactory = configure.buildSessionFactory(serviceRegistry);
	}

	// 得到 session
	public static Session getSession() {
		return sessionFactory.openSession();
	}
}

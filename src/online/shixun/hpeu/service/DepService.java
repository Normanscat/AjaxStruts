package online.shixun.hpeu.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import online.shixun.hpeu.dao.Depdao;
import online.shixun.hpeu.model.Department;
import online.shixun.hpeu.util.HibernateUtil;

public class DepService {
	private Department dep;
	private Depdao depdao = new Depdao();

	// 查询部门
	public List<Department> query() {
		return depdao.getDep();
	}

	// 关键字查询部门
	public List<Department> search(String search){
		return depdao.searchDep(search);
//		if (depdao.searchDep(search) != null) {
//			return depdao.searchDep(search);
//		}
//		return depdao.searchDep(search);
	}

	// 添加部门
	public void savedep(String depsavename, String depsavescp) {
		depdao.savedep(depsavename, depsavescp);
	}

	// 更新部门
	public void updep(Long depeditid, String depeditname, String depeditscp) {
		depdao.updep(depeditid, depeditname, depeditscp);
	}

	// 删除部门
	public void deldep(Long depdelId) {
		depdao.deldep(depdelId);
	}

	// 批量删除部门
	public void deldepall(List<Long> listid) {
		depdao.deldepall(listid);
	}

	public Department getDep() {
		return dep;
	}

	public void setDep(Department dep) {
		this.dep = dep;
	}

	public Depdao getDepdao() {
		return depdao;
	}

	public void setDepdao(Depdao depdao) {
		this.depdao = depdao;
	}

}

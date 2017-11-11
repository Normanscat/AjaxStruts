package online.shixun.hpeu.service;

import java.util.List;
import online.shixun.hpeu.dao.Roledao;
import online.shixun.hpeu.model.Department;
import online.shixun.hpeu.model.Role;

public class RoleService {
	private Roledao roledao = new Roledao();

	// 查询角色
	public List<Role> getRole(Long RoleId) {
		return roledao.getRole(RoleId);
	}

	// 关键字查询
	public List<Role> search(String search) {
		return roledao.searchRole(search);
	}

	// 添加角色
	public void saverole(String rolesavename, String rolesavescp) {
		roledao.saverole(rolesavename, rolesavescp);
	}

	// 更新角色
	public void uprole(Long roleeditid, String roleeditname, String roleeditscp) {
		roledao.uprole(roleeditid, roleeditname, roleeditscp);
	}

	// 删除角色
	public void delrole(Long roledelId) {
		roledao.delrole(roledelId);
	}

	// 批量删除角色
	public void deldepall(List<Long> listid) {
		roledao.deldepall(listid);
	}
}

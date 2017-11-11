package online.shixun.hpeu.action;

import java.sql.SQLException;
import java.util.List;

import online.shixun.hpeu.dao.Vali;
import online.shixun.hpeu.model.Role;
import online.shixun.hpeu.service.RoleService;
import online.shixun.hpeu.util.HibernateUtil;

public class RoleAction {
	private RoleService roleservice = new RoleService();
	// 用于加载页面
	private List<Role> role;
	// 获取查询角色id
	private Long RoleId;
	/*
	 * 获取用户输入的角色属性 用于添加角色
	 */
	private String rolesavename;
	private String rolesavescp;
	// 提示信息
	private String message;
	// 用于编辑页面
	private Role editrole;
	// 获取编辑角色ID展示于编辑页面
	private Long roleeditId;
	/*
	 * 获取用户输入的角色属性 用于更新角色
	 */
	private Long roleeditid;
	private String roleeditname;
	private String roleeditscp;
	// 获取删除角色ID
	private Long deluserid;
	// 批量删除角色ID
	private List<Long> listid;
	// 获取查询关键字
	private String search;

	// 加载角色
	public String list() {
		role = roleservice.getRole(RoleId);
		return "success";
	}

	// 关键字查询
	public String searchrole() {
		// System.out.println("这里是action里的" + search);
		role = roleservice.search(getSearch());
		return "success";
	}

	// 添加角色
	public String saverole() {
		Role save = new Role();
		save.setRolename(rolesavename);
		try {
			Vali.roleVali(save);
			if (Vali.roleVali(save) == false) {
				roleservice.saverole(getRolesavename(), getRolesavescp());
				message = "success";
				return "success";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		message = "error";
		setMessage("添加失败，角色以存在！");
		System.out.println(getMessage());
		return "flase";
	}

	// 删除角色
	public String delrole() {
		roleservice.delrole(getDeluserid());
		return "success";
	}

	// 批量删除角色
	public String delroleall() {
		roleservice.deldepall(listid);
		return "success";
	}

	// 跳转页面-编辑角色>传递数据
	public String editrole() {
		editrole = (Role) HibernateUtil.getSession().get(Role.class, roleeditId);
		return "success";
	}

	// 更新角色
	public String uprole() {
		roleservice.uprole(getRoleeditid(), getRoleeditname(), getRoleeditscp());
		return "success";
	}

	public RoleService getRoleservice() {
		return roleservice;
	}

	public void setRoleservice(RoleService roleservice) {
		this.roleservice = roleservice;
	}

	public List<Role> getRole() {
		return role;
	}

	public void setRole(List<Role> role) {
		this.role = role;
	}

	public Long getRoleId() {
		return RoleId;
	}

	public void setRoleId(Long roleId) {
		RoleId = roleId;
	}

	public Long getDeluserid() {
		return deluserid;
	}

	public void setDeluserid(Long deluserid) {
		this.deluserid = deluserid;
	}

	public String getRolesavename() {
		return rolesavename;
	}

	public void setRolesavename(String rolesavename) {
		this.rolesavename = rolesavename;
	}

	public String getRolesavescp() {
		return rolesavescp;
	}

	public void setRolesavescp(String rolesavescp) {
		this.rolesavescp = rolesavescp;
	}

	public Role getEditrole() {
		return editrole;
	}

	public void setEditrole(Role editrole) {
		this.editrole = editrole;
	}

	public Long getRoleeditId() {
		return roleeditId;
	}

	public void setRoleeditId(Long roleeditId) {
		this.roleeditId = roleeditId;
	}

	public Long getRoleeditid() {
		return roleeditid;
	}

	public void setRoleeditid(Long roleeditid) {
		this.roleeditid = roleeditid;
	}

	public String getRoleeditname() {
		return roleeditname;
	}

	public void setRoleeditname(String roleeditname) {
		this.roleeditname = roleeditname;
	}

	public String getRoleeditscp() {
		return roleeditscp;
	}

	public void setRoleeditscp(String roleeditscp) {
		this.roleeditscp = roleeditscp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Long> getListid() {
		return listid;
	}

	public void setListid(List<Long> listid) {
		this.listid = listid;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

}

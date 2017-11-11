package online.shixun.hpeu.action;

import java.sql.SQLException;
import java.util.List;

import online.shixun.hpeu.dao.Vali;
import online.shixun.hpeu.model.Department;
import online.shixun.hpeu.model.Juri;
import online.shixun.hpeu.model.Role;
import online.shixun.hpeu.model.User;
import online.shixun.hpeu.service.DepService;
import online.shixun.hpeu.service.JuriService;
import online.shixun.hpeu.service.RoleService;
import online.shixun.hpeu.service.UserService;
import online.shixun.hpeu.util.HibernateUtil;

public class UserAction {
	private UserService uservice = new UserService();
	private RoleService roleservice = new RoleService();
	private DepService depservice = new DepService();
	private JuriService jueiservice = new JuriService();
	// 用于展示页面
	private List<User> user;
	private List<Role> role;
	private List<Department> dep;
	private List<Juri> juri;
	// 获取用户ID 加载页面
	private Long Userid;
	/*
	 * 接收用户输入的角色属性 用于添加用户
	 */
	private String usersaveusername;
	private String usersavepassword;
	private String usersavename;
	private String savephone;
	private String savesex;
	private Long saveuserdep;
	private Long saveuserrole;
	private String saveusersta;
	private Long juriid;
	// 提示信息
	private String message;
	// 用于编辑用户
	private User edituser;
	// 获取用户编辑id
	private Long usereditId;
	/*
	 * 接收用户输入的角色属性 用于更新用户
	 */
	private Long userupid;
	private String userupusername;
	private String useruppassword;
	private String userupname;
	private String upphone;
	private String upsex;
	private String upusersta;
	private Long upuserdep;
	private Long upuserrole;
	private Long juriupid;
	// 获取删除用户id
	private Long deluserId;
	// 批量删除用户ID
	private List<Long> listid;
	// 获取关键字
	private String search;

	// 加载用户
	public String list() {
		user = uservice.getUser(Userid);
		return "success";
	}

	// 关键字查询
	public String searchuser() {
		user = uservice.search(getSearch());
		return "success";
	}

	// 跳转页面 -添加用户
	public String adduser() {
		juri = jueiservice.getJuri(userupid);
		dep = depservice.query();
		role = roleservice.getRole(userupid);
		return "success";
	}

	// 添加用户
	public String saveuser() {
		User save = new User();
		save.setUsername(usersaveusername);
		try {
			Vali.userVali(save);
			// 返回值为false 没有值，可录入
			if (Vali.userVali(save) == false) {
				uservice.saveuser(getJuriid(), getSaveuserdep(), getSaveuserrole(), getUsersavename(),
						getUsersavepassword(), getSavesex(), getUsersaveusername(), getSavephone(), getSaveusersta());
				message = "success";
				return "success";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		message = "error";
		setMessage("添加失败，用户名以存在！");
		System.out.println(getMessage());
		return "flase";
	}

	// 跳转页面-编辑用户>传递数据
	public String edituser() {
		juri = jueiservice.getJuri(userupid);
		dep = depservice.query();
		role = roleservice.getRole(userupid);
		edituser = (User) HibernateUtil.getSession().get(User.class, usereditId);
		return "success";
	}

	// 更新用户
	public String upuser() {
		uservice.upuser(getJuriupid(), getUserupid(), getUpuserrole(), getUpuserdep(), getUpusersta(), getUserupname(),
				getUseruppassword(), getUpsex(), getUserupusername(), getUpphone());
		return "success";
	}

	// 删除用户
	public String deluser() {
		uservice.deldep(getDeluserId());
		return "success";
	}

	// 批量删除角色
	public String deluserall() {
		uservice.deluserall(listid);
		return "success";
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

	public UserService getUservice() {
		return uservice;
	}

	public void setUservice(UserService uservice) {
		this.uservice = uservice;
	}

	public Long getUserid() {
		return Userid;
	}

	public void setUserid(Long userid) {
		Userid = userid;
	}

	public String getUsersaveusername() {
		return usersaveusername;
	}

	public void setUsersaveusername(String usersaveusername) {
		this.usersaveusername = usersaveusername;
	}

	public String getUsersavepassword() {
		return usersavepassword;
	}

	public void setUsersavepassword(String usersavepassword) {
		this.usersavepassword = usersavepassword;
	}

	public String getUsersavename() {
		return usersavename;
	}

	public void setUsersavename(String usersavename) {
		this.usersavename = usersavename;
	}

	public String getSavephone() {
		return savephone;
	}

	public void setSavephone(String savephone) {
		this.savephone = savephone;
	}

	public Long getSaveuserdep() {
		return saveuserdep;
	}

	public void setSaveuserdep(Long saveuserdep) {
		this.saveuserdep = saveuserdep;
	}

	public Long getSaveuserrole() {
		return saveuserrole;
	}

	public void setSaveuserrole(Long saveuserrole) {
		this.saveuserrole = saveuserrole;
	}

	public String getSaveusersta() {
		return saveusersta;
	}

	public void setSaveusersta(String saveusersta) {
		this.saveusersta = saveusersta;
	}

	public String getSavesex() {
		return savesex;
	}

	public void setSavesex(String savesex) {
		this.savesex = savesex;
	}

	public Long getDeluserId() {
		return deluserId;
	}

	public void setDeluserId(Long deluserId) {
		this.deluserId = deluserId;
	}

	public User getEdituser() {
		return edituser;
	}

	public void setEdituser(User edituser) {
		this.edituser = edituser;
	}

	public Long getUsereditId() {
		return usereditId;
	}

	public void setUsereditId(Long usereditId) {
		this.usereditId = usereditId;
	}

	public String getUserupusername() {
		return userupusername;
	}

	public void setUserupusername(String userupusername) {
		this.userupusername = userupusername;
	}

	public String getUseruppassword() {
		return useruppassword;
	}

	public void setUseruppassword(String useruppassword) {
		this.useruppassword = useruppassword;
	}

	public String getUserupname() {
		return userupname;
	}

	public void setUserupname(String userupname) {
		this.userupname = userupname;
	}

	public String getUpphone() {
		return upphone;
	}

	public void setUpphone(String upphone) {
		this.upphone = upphone;
	}

	public String getUpsex() {
		return upsex;
	}

	public void setUpsex(String upsex) {
		this.upsex = upsex;
	}

	public Long getUpuserdep() {
		return upuserdep;
	}

	public void setUpuserdep(Long upuserdep) {
		this.upuserdep = upuserdep;
	}

	public Long getUpuserrole() {
		return upuserrole;
	}

	public void setUpuserrole(Long upuserrole) {
		this.upuserrole = upuserrole;
	}

	public String getUpusersta() {
		return upusersta;
	}

	public void setUpusersta(String upusersta) {
		this.upusersta = upusersta;
	}

	public Long getJuriupid() {
		return juriupid;
	}

	public void setJuriupid(Long juriupid) {
		this.juriupid = juriupid;
	}

	public Long getUserupid() {
		return userupid;
	}

	public void setUserupid(Long userupid) {
		this.userupid = userupid;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public RoleService getRoleservice() {
		return roleservice;
	}

	public void setRoleservice(RoleService roleservice) {
		this.roleservice = roleservice;
	}

	public DepService getDepservice() {
		return depservice;
	}

	public void setDepservice(DepService depservice) {
		this.depservice = depservice;
	}

	public List<Role> getRole() {
		return role;
	}

	public void setRole(List<Role> role) {
		this.role = role;
	}

	public List<Department> getDep() {
		return dep;
	}

	public void setDep(List<Department> dep) {
		this.dep = dep;
	}

	public JuriService getJueiservice() {
		return jueiservice;
	}

	public void setJueiservice(JuriService jueiservice) {
		this.jueiservice = jueiservice;
	}

	public List<Juri> getJuri() {
		return juri;
	}

	public void setJuri(List<Juri> juri) {
		this.juri = juri;
	}

	public Long getJuriid() {
		return juriid;
	}

	public void setJuriid(Long juriid) {
		this.juriid = juriid;
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

package online.shixun.hpeu.action;

import java.sql.SQLException;
import java.util.List;

import online.shixun.hpeu.dao.Vali;
import online.shixun.hpeu.model.Department;
import online.shixun.hpeu.service.DepService;
import online.shixun.hpeu.util.HibernateUtil;

public class DepAction {
	private DepService Deprvice = new DepService();
	// 用于展示页面
	private List<Department> dep;
	// 获取部门查询Id
	private Long depid;
	// 获取用户输入的部门名称，用于添加部门
	private String depsavename;
	private String message;
	// 获取用户输入的部门描述，用于添加部门
	private String depsavescp;
	// 获取部门Id，展示于编辑页面
	private Long depeditId;
	// 展示于编辑页面
	private Department department;
	/*
	 * 获取用户输入的部门属性 用于更新部门
	 */
	private Long depeditid;
	private String depeditname;
	private String depeditscp;
	// 获取删除部门的ID
	private Long deldepId;
	// 获取批量删除ID
	private List<Long> listid;
	// 获取查询关键字
	private String search;

	// 加载部门
	public String list() {
		dep = Deprvice.query();
		return "success";
	}

	// 关键字查询部门
	public String searchdep(){
		System.out.println("这里是action里的"+search);
		dep=Deprvice.search(getSearch());
		return "success";
	}

	// 添加部门
	public String savedep() {
		Department save = new Department();
		save.setDepartmentname(depsavename);
		try {
			Vali.depVali(save);
			if (Vali.depVali(save) == false) {
				Deprvice.savedep(getDepsavename(), getDepsavescp());
				message = "success";
				return "success";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		message = "error";
		setMessage("添加失败，部门以存在！");
		System.out.println(getMessage());
		return "flase";
	}

	// 删除部门
	public String deldep() {
		Deprvice.deldep(getDeldepId());
		return "success";
	}

	// 批量删除部门
	public String deldepall() {
		// System.out.println("这是list"+listid);
		Deprvice.deldepall(listid);
		return "success";
	}

	// 跳转编辑部门>传递数据
	public String editdep() {
		// System.out.println(depeditId);
		department = (Department) HibernateUtil.getSession().get(Department.class, depeditId);
		return "success";
	}

	// 更新部门
	public String updep() {
		Deprvice.updep(getDepeditid(), getDepeditname(), getDepeditscp());
		return "success";
	}

	public DepService getDeprvice() {
		return Deprvice;
	}

	public void setDeprvice(DepService deprvice) {
		Deprvice = deprvice;
	}

	public List<Department> getDep() {
		return dep;
	}

	public void setDep(List<Department> dep) {
		this.dep = dep;
	}

	public Long getDepid() {
		return depid;
	}

	public void setDepid(Long depid) {
		this.depid = depid;
	}

	public Long getDepeditId() {
		return depeditId;
	}

	public void setDepeditId(Long depeditId) {
		this.depeditId = depeditId;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Long getDepeditid() {
		return depeditid;
	}

	public void setDepeditid(Long depeditid) {
		this.depeditid = depeditid;
	}

	public String getDepeditname() {
		return depeditname;
	}

	public void setDepeditname(String depeditname) {
		this.depeditname = depeditname;
	}

	public String getDepeditscp() {
		return depeditscp;
	}

	public void setDepeditscp(String depeditscp) {
		this.depeditscp = depeditscp;
	}

	public Long getDeldepId() {
		return deldepId;
	}

	public void setDeldepId(Long deldepId) {
		this.deldepId = deldepId;
	}

	public String getDepsavename() {
		return depsavename;
	}

	public void setDepsavename(String depsavename) {
		this.depsavename = depsavename;
	}

	public String getDepsavescp() {
		return depsavescp;
	}

	public void setDepsavescp(String depsavescp) {
		this.depsavescp = depsavescp;
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

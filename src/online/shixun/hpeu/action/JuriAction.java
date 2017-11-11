package online.shixun.hpeu.action;

import java.sql.SQLException;
import java.util.List;

import online.shixun.hpeu.dao.Vali;
import online.shixun.hpeu.model.Juri;
import online.shixun.hpeu.service.JuriService;
import online.shixun.hpeu.util.HibernateUtil;

public class JuriAction {
	private JuriService juriservice = new JuriService();
	// 用于加载权限
	private List<Juri> juri;
	// 获取权限ID用于加载页面
	private Long JuriId;
	// 获取添加权限名称
	private String jurisavename;
	// 获取添加权限描述
	private String jurisavescp;
	private String message;
	// 用户编辑权限
	private Juri editjuri;
	private Long jurieditId;
	/*
	 * 获取更新权限的属性
	 */
	private Long juriupid;
	private String juriupname;
	private String juriupscp;
	// 获取删除权限ID
	private Long juridelId;
	// 获取批量删除ID
	private List<Long> listid;
	// 获取查询关键字
	private String search;

	// 加载权限
	public String list() {
		juri = juriservice.getJuri(JuriId);
		return "success";
	}

	// 关键字查询
	public String searchjuri() {
		juri=juriservice.search(getSearch());
		return "success";
	}

	// 添加权限
	public String savejuri() {
		Juri save = new Juri();
		save.setJurname(jurisavename);
		try {
			Vali.juriVali(save);
			if (Vali.juriVali(save) == false) {
				juriservice.savejuri(getJurisavename(),
						getJurisavescp());
				message = "success";
				return "success";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		message = "error";
		setMessage("添加失败，权限以存在！");
		System.out.println(getMessage());
		return "flase";
	}

	// 跳转页面-编辑页面 >传递数据
	public String editjuri() {
		editjuri = (Juri) HibernateUtil.getSession().get(Juri.class, jurieditId);
		return "success";
	}

	// 更新权限
	public String upjuri() {
		juriservice.upjuri(getJuriupid(), getJuriupname(), getJuriupscp());
		return "success";
	}

	// 删除权限
	public String deljuri() {
		juriservice.deljuri(getJuridelId());
		return "success";
	}

	// 批量删除权限
	public String deljuriall() {
		juriservice.deljuriall(listid);
		return "success";
	}

	public JuriService getJuriservice() {
		return juriservice;
	}

	public void setJuriservice(JuriService juriservice) {
		this.juriservice = juriservice;
	}

	public List<Juri> getJuri() {
		return juri;
	}

	public void setJuri(List<Juri> juri) {
		this.juri = juri;
	}

	public Long getJuriId() {
		return JuriId;
	}

	public void setJuriId(Long juriId) {
		JuriId = juriId;
	}

	public String getJurisavename() {
		return jurisavename;
	}

	public void setJurisavename(String jurisavename) {
		this.jurisavename = jurisavename;
	}

	public String getJurisavescp() {
		return jurisavescp;
	}

	public void setJurisavescp(String jurisavescp) {
		this.jurisavescp = jurisavescp;
	}

	public Long getJuridelId() {
		return juridelId;
	}

	public void setJuridelId(Long juridelId) {
		this.juridelId = juridelId;
	}

	public Juri getEditjuri() {
		return editjuri;
	}

	public void setEditjuri(Juri editjuri) {
		this.editjuri = editjuri;
	}

	public Long getJurieditId() {
		return jurieditId;
	}

	public void setJurieditId(Long jurieditId) {
		this.jurieditId = jurieditId;
	}

	public Long getJuriupid() {
		return juriupid;
	}

	public void setJuriupid(Long juriupid) {
		this.juriupid = juriupid;
	}

	public String getJuriupname() {
		return juriupname;
	}

	public void setJuriupname(String juriupname) {
		this.juriupname = juriupname;
	}

	public String getJuriupscp() {
		return juriupscp;
	}

	public void setJuriupscp(String juriupscp) {
		this.juriupscp = juriupscp;
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

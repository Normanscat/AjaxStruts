package online.shixun.hpeu.service;

import java.util.List;


import online.shixun.hpeu.dao.Jurdao;
import online.shixun.hpeu.model.Juri;

public class JuriService {
	private Jurdao jurdao = new Jurdao();

	// 查询权限
	public List<Juri> getJuri(Long JuriId) {
		return jurdao.getJuri(JuriId);
	}
	// 关键字查询权限
	public List<Juri> search(String search) {
		return jurdao.searchJuri(search);
	}
	// 添加权限
	public void savejuri(String jurisavename, String jurisavescp) {
		jurdao.savejuri(jurisavename, jurisavescp);
	}

	// 更新权限
	public void upjuri(Long juriupid, String juriupname, String juriupscp) {
		jurdao.upjuri(juriupid, juriupname, juriupscp);
	}

	// 删除权限
	public void deljuri(Long juridelId) {
		jurdao.deljuri(juridelId);
	}

	// 批量删除权限
	public void deljuriall(List<Long> listid) {
		jurdao.deljuriall(listid);
	}

}

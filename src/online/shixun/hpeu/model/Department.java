package online.shixun.hpeu.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "t_department")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String departmentname;
	@Column
	private String departmentscp;
	@Temporal(TemporalType.TIMESTAMP)
	@Column
	private Date departmenttime;
	@OneToMany(mappedBy = "department", fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	private Set<User> user = new HashSet<User>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDepartmentname() {
		return departmentname;
	}

	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}

	public String getDepartmentscp() {
		return departmentscp;
	}

	public void setDepartmentscp(String departmentscp) {
		this.departmentscp = departmentscp;
	}

	public Date getDepartmenttime() {
		return departmenttime;
	}

	public void setDepartmenttime(Date departmenttime) {
		this.departmenttime = departmenttime;
	}

	public Set<User> getUser() {
		return user;
	}

	public void setUser(Set<User> user) {
		this.user = user;
	}

}

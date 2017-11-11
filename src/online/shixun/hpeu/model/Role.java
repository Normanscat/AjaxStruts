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
@Table(name = "t_role")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String rolename;
	@Column
	private String rolescp;
	@Temporal(TemporalType.TIMESTAMP)
	@Column
	private Date roletime;
	@OneToMany(mappedBy = "role", fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	private Set<User> user = new HashSet<User>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getRolescp() {
		return rolescp;
	}

	public void setRolescp(String rolescp) {
		this.rolescp = rolescp;
	}

	public Date getRoletime() {
		return roletime;
	}

	public void setRoletime(Date roletime) {
		this.roletime = roletime;
	}

	public Set<User> getUser() {
		return user;
	}

	public void setUser(Set<User> user) {
		this.user = user;
	}

}

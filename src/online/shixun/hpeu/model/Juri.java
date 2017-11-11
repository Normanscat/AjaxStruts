package online.shixun.hpeu.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "t_juri")
public class Juri {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String jurname;
	@Column
	private String jurscp;
	@ManyToMany(targetEntity = User.class, mappedBy = "juri")
	@Cascade(CascadeType.ALL)
	private Set<User> user = new HashSet<User>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getJurname() {
		return jurname;
	}

	public void setJurname(String jurname) {
		this.jurname = jurname;
	}

	public String getJurscp() {
		return jurscp;
	}

	public void setJurscp(String jurscp) {
		this.jurscp = jurscp;
	}

	public Set<User> getUser() {
		return user;
	}

	public void setUser(Set<User> user) {
		this.user = user;
	}

}

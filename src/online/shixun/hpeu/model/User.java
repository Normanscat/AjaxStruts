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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "t_user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String username;
	@Column
	private String password;
	@Column
	private String name;
	@Column
	private String phone;
	@Column
	private String gender;
	@Column
	private String statics;
	@ManyToOne
	private Department department;
	@ManyToOne
	private Role role;
	@ManyToMany(targetEntity = Juri.class)
	@JoinTable(name = "t_user_juri", joinColumns = {
			@JoinColumn(name = "userId", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "juriId", referencedColumnName = "id") })
	private Set<Juri> juri = new HashSet<Juri>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getStatics() {
		return statics;
	}

	public void setStatics(String statics) {
		this.statics = statics;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Set<Juri> getJuri() {
		return juri;
	}

	public void setJuri(Set<Juri> juri) {
		this.juri = juri;
	}

}

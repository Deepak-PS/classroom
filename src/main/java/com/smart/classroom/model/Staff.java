package com.smart.classroom.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "staff")
public class Staff {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	@Column(name = "staff_name")
	private String staffName;
	@Column(name = "password")
	private String password;
	@Column(name = "active")
	private boolean active;
	@Column(name = "roles")
	private String roles;
	@OneToMany(mappedBy = "staff")
	private List<Note> note;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public List<Note> getNote() {
		return note;
	}

	public void setNote(List<Note> note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "Staff [id=" + id + ", staffName=" + staffName + ", password=" + password + ", active=" + active
				+ ", roles=" + roles + "]";
	}
}

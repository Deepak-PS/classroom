package com.smart.classroom.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class StaffDetails implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1708220497829716035L;

	private String staffName;
	private String password;
	private boolean active;
	private List<GrantedAuthority> authorities;

	public StaffDetails(Staff staff) {
		this.staffName = staff.getStaffName();
		this.password = staff.getPassword();
		this.active = staff.isActive();
		this.authorities = Arrays.stream(staff.getRoles().split(",")).map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return staffName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return active;
	}

	@Override
	public boolean isAccountNonLocked() {
		return active;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return active;
	}

	@Override
	public boolean isEnabled() {
		return active;
	}

}

package com.smart.classroom.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.smart.classroom.model.Staff;
import com.smart.classroom.model.StaffDetails;
import com.smart.classroom.repository.StaffRepository;

@Service
public class StaffDetailsServiceImpl implements StaffDetailsServiceI {

	@Autowired
	StaffRepository staffRepository;

	@Override
	public UserDetails loadUserByUsername(String staffName) throws UsernameNotFoundException {

		Optional<Staff> staff = staffRepository.findByStaffName(staffName);

		staff.orElseThrow(() -> new UsernameNotFoundException("Not found: " + staffName));

		return staff.map(StaffDetails::new).get();
	}

}

package com.smart.classroom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

import com.smart.classroom.model.Staff;

public interface StaffRepository extends JpaRepository<Staff, Integer> {
	Optional<Staff> findByStaffName(String staffName);
}

package com.smart.classroom.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.smart.classroom.model.Note;
import com.smart.classroom.model.Staff;
import com.smart.classroom.repository.NoteRepository;
import com.smart.classroom.repository.StaffRepository;

@Service
public class NoteServiceImpl implements NoteServiceI {

	@Autowired
	private NoteRepository noteRepository;

	@Autowired
	private StaffRepository staffRepository;

	public void storeNote(Note note, String name) {

		// for simplicity, accessing by name
		Optional<Staff> staff = staffRepository.findByStaffName(name);

		staff.orElseThrow(() -> new UsernameNotFoundException("Not found: " + name));

		Staff st = staff.get();

		note.setStaff(st);
		noteRepository.save(note);

	}
}

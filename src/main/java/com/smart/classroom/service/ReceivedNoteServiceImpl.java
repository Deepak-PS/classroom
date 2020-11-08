package com.smart.classroom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.classroom.model.ReceivedNote;
import com.smart.classroom.repository.ReceivedNoteRepository;

@Service
public class ReceivedNoteServiceImpl implements ReceivedNoteServiceI {

	@Autowired
	private ReceivedNoteRepository rNoteRepository;

	public void storeReceivedNote(ReceivedNote rNote) {
		rNoteRepository.save(rNote);
	}
}

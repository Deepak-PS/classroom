package com.smart.classroom.receiver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.smart.classroom.model.Note;
import com.smart.classroom.model.ReceivedNote;
import com.smart.classroom.service.ReceivedNoteServiceI;

@Component
public class NoteReceiver {

	@Autowired
	ReceivedNoteServiceI receivedNoteService;

	@JmsListener(destination = "NoteQueue", containerFactory = "jmsConFactory")
	public void receiveMessage(Note note) {
		ReceivedNote rnote = new ReceivedNote();
		rnote.setTitle(note.getTitle());
		rnote.setBody(note.getBody());

		receivedNoteService.storeReceivedNote(rnote);

	}
}

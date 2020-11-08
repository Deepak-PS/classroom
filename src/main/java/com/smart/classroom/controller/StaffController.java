package com.smart.classroom.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.smart.classroom.model.Note;
import com.smart.classroom.model.ReceivedNote;
import com.smart.classroom.repository.ReceivedNoteRepository;
import com.smart.classroom.service.NoteServiceI;

@RestController
public class StaffController {

	@Autowired
	private final JmsTemplate jmsTemplate;

	@Autowired
	ReceivedNoteRepository receivedNoteRepository;

	@Autowired
	private NoteServiceI noteService;

	private static String welcomeMessage = "Welcome, You are now logged in : ";

	public StaffController(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	@GetMapping("/welcomeData")
	@ResponseBody
	public Map<String, Object> welcome(Principal principal) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("message", welcomeMessage + principal.getName());

		return map;
	}

	@PostMapping("/note")
	@ResponseBody
	public void receiveAndSendNote(@RequestBody Note note, Principal principal) {
		jmsTemplate.convertAndSend("NoteQueue", note);
		noteService.storeNote(note, principal.getName());
	}

	@GetMapping("/get")
	@ResponseBody
	public List<ReceivedNote> getNote() {
		List<ReceivedNote> rnotes = receivedNoteRepository.findAll();
		return rnotes;
	}

	@Controller
	class TeacherMvcContoller {
		@GetMapping(value = "/teacher")
		public String teacherLoginSuccess() {
			return "index";
		}

		@GetMapping(value = "/student")
		public String studentLoginSuccess() {
			return "view";
		}
	}
}

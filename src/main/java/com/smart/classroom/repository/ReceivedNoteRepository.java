package com.smart.classroom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smart.classroom.model.ReceivedNote;

public interface ReceivedNoteRepository extends JpaRepository<ReceivedNote, Integer> {

}

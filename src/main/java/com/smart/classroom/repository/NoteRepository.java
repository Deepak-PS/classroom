package com.smart.classroom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smart.classroom.model.Note;

public interface NoteRepository extends JpaRepository<Note, Integer> {

}

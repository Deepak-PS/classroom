package com.smart.classroom.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rnote")
public class ReceivedNote {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int nid;
	private String title;
	private String body;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public int getNid() {
		return nid;
	}

	public void setNid(int nid) {
		this.nid = nid;
	}

	@Override
	public String toString() {
		return "Rnote [nid=" + nid + ", title=" + title + ", body=" + body + "]";
	}
}

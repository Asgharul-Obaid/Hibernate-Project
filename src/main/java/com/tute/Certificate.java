package com.tute;

import javax.persistence.Embeddable;

@Embeddable
public class Certificate {
	private String course;
	private String duration;

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getDuration() {
		return duration;
	}

	public Certificate(String course, String deration) {
		super();
		this.course = course;
		this.duration = duration;
	}

	public Certificate() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

}

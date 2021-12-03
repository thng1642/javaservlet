package timetable;

import java.io.Serializable;

public class TimeTable implements Serializable {
	private String subjectName;
	private String time;
	private String room;
	private String day;
	
	public TimeTable() {
		this.subjectName = "";
		this.time = "";
		this.room = "";
		this.day = "";
	}
	public TimeTable(String subjectName, String time, String room, String day) {
		this.subjectName = subjectName;
		this.time = time;
		this.room = room;
		this.day = day;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public String getSubjectName() {
		return this.subjectName;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getTime() {
		return this.time;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	public String getRoom() {
		return this.room;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getDay() {
		return this.day;
	}
}

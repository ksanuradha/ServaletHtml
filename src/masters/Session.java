package masters;

public class Session {
private int sessionId;
private int courseId;
private String time;
private String start_date;
private String end_date;

public Session(int sessionId, int courseId, String time, String start_date, String end_date) {
	this.sessionId = sessionId;
	this.courseId = courseId;
	this.time = time;
	this.start_date = start_date;
	this.end_date = end_date;
}

public int getSessionId() {
	return sessionId;
}
public int getCourseId() {
	return courseId;
}
public String getTime() {
	return time;
}
public String getStart_date() {
	return start_date;
}
public String getEnd_date() {
	return end_date;
}
}

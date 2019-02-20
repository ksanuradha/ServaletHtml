package masters;

public class Participant {
private int id;
private String name;
private String phone;
private int courseId;
private int sessionId;
private double feePaid;

public Participant(int id, String name, String phone, int courseId, double feePaid) {
	this.id = id;
	this.name = name;
	this.phone = phone;
	this.courseId = courseId;
	//this.sessionId = sessionId;
	this.feePaid = feePaid;
}

public int getId() {
	return id;
}
public String getName() {
	return name;
}
public String getPhone() {
	return phone;
}
public int getCourseId() {
	return courseId;
}
public int getSessionId() {
	return sessionId;
}
public double getFeePaid() {
	return feePaid;
}
public void setSessionId(int sessionId) {
	this.sessionId = sessionId;
}
public void setFeePaid(double feePaid) {
	this.feePaid = feePaid;
}
}

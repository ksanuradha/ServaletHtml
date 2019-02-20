package masters;
public class Course {
private int cousreId;
private String name;
private int duration_in_days;
private double fee;

public Course(int cousreId, String name, int duration_in_days, double fee) {
	this.cousreId = cousreId;
	this.name = name;
	this.duration_in_days = duration_in_days;
	this.fee = fee;
}

public int getCousreId() {
	return cousreId;
}

public String getName() {
	return name;
}

public int getDuration_in_days() {
	return duration_in_days;
}

public double getFee() {
	return fee;
}


}

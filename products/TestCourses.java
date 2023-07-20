package products;

abstract class Courses {
	protected String title;
	protected int fee;
	protected int duration;

	public Courses(String title, int fee, int duration) {
		this.title = title;
		this.fee = fee;
		this.duration = duration;
	}

	void print() {
		System.out.println(this.title);
		System.out.println(this.fee);
		System.out.println(this.duration);

	}

	abstract double getFee();
}

class Online extends Courses {
	private String url;

	public Online(String title, int fee, int duration, String url) {
		super(title, fee, duration);
		this.url = url;
	}

	double getFee() {
		return this.fee = fee;
	}

	void print() {
		super.print();
		System.out.println(this.url);
	}
}

class ClassRoom extends Courses {
	private String address;

	public ClassRoom(String title, int fee, int duration, String address) {
		super(title, fee, duration);
		this.address = address;
	}

	double getFee() {
		return this.fee * 0.9;
	}

	void print() {
		super.print();
		System.out.println(this.address);
	}
}

public class TestCourses {

}

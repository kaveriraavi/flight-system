package products;

public class Student {
	private int admNo;
	private String name;
	private int feePaid;
	private int course;
	private static int javafee = 120000;
	private static int pythonfee = 10000;

	public Student(int admNo, String name, int feePaid) {
		this.admNo = admNo;
		this.name = name;
		this.feePaid = feePaid;
	}

	public Student(int admNo, String name, int feePaid, int course) {
		this.admNo = admNo;
		this.name = name;
		this.feePaid = feePaid;
		this.course = course;
	}

	public void payment(int amount) {
		feePaid = feePaid + amount;
	}

	public int getDue() {
		if (course == 1) {
			return javafee - getFeePaid();
		} else  {
			return pythonfee-getFeePaid();
		}
	}

	public int getTotalFee() {
		if (course == 1) {
			return 12000;
		} else {
			return 10000;
		}
	}

	public int getFeePaid() {

		return feePaid;
	}

	public String getCourseName() {
		if (course == 1) {
			return "java";
		} else  {
			return "python";
		}
		
	}

	public void print() {
		System.out.println(admNo);
		System.out.println(name);
		System.out.println(feePaid);
		System.out.println(course);
	}

}

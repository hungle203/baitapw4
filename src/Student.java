public class Student extends Human{
    private double avgPoint;

    public Student(double avgPoint) {
        this.avgPoint = avgPoint;
    }

    public double getAvgPoint() {
        return avgPoint;
    }

    public void setAvgPoint(double avgPoint) {
        this.avgPoint = avgPoint;
    }

    public Student(String name, int age, String gender, String address, double avgPoint) {
        super(name, age, gender, address);
        this.avgPoint = avgPoint;
    }

    @Override
    public String toString() {
        return "Student{" + super.toString() +
                "avgPoint=" + avgPoint +
                '}';
    }
}

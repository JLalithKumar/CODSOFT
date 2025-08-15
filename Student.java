public class Student {
    private String roll;
    private String name;
    private String grade;
    private String email;

    public Student(String roll, String name, String grade, String email) {
        this.roll = roll;
        this.name = name;
        this.grade = grade;
        this.email = email;
    }

    public String getRoll() { return roll; }
    public String getName() { return name; }
    public String getGrade() { return grade; }
    public String getEmail() { return email; }

    public void setName(String name) { this.name = name; }
    public void setGrade(String grade) { this.grade = grade; }
    public void setEmail(String email) { this.email = email; }

    public String toCSV() {
        return String.format("%s,%s,%s,%s", roll, name, grade, email == null ? "" : email);
    }

    public static Student fromCSV(String line) {
        String[] parts = line.split(",", -1);
        if (parts.length < 4) return null;
        return new Student(parts[0], parts[1], parts[2], parts[3]);
    }

    @Override
    public String toString() {
        return String.format("Roll: %s | Name: %s | Grade: %s | Email: %s", roll, name, grade, email);
    }
}

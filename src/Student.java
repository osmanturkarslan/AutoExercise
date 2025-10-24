public class Student {
    private String lastName;
    private String firstName;
    private boolean submitted;


    public Student(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.submitted = false;
    }



    public String getLastName() { return lastName; }
    public String getFirstName() { return firstName; }

    public boolean hasSubmitted() { return submitted; }
    public void setSubmitted(boolean submitted) { this.submitted = submitted; }

    @Override
    public String toString() {
        return lastName + " " + firstName + " (submitted: " + submitted + ")";
    }
}

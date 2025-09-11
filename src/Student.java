public class Student {
    private String nachname;
    private String vorname;
    private boolean submitted;


    public Student(String nachname, String vorname) {
        this.nachname = nachname;
        this.vorname = vorname;
        this.submitted = false;
    }

    public String getNachname() { return nachname; }
    public String getVorname() { return vorname; }

    public boolean hasSubmitted() { return submitted; }
    public void setSubmitted(boolean submitted) { this.submitted = submitted; }

    @Override
    public String toString() {
        return nachname + " " + vorname + " (submitted: " + submitted + ")";
    }
}

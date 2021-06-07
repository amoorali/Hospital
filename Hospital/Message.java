package Hospital;

public class Message {
    private final Doctor theDoctor;
    private final Patient thePatient;
    private StringBuilder subject;
    private Date date;
    private boolean visited = false;


    public Message(Doctor theDoctor, Patient thePatient, String subject) {
        this.theDoctor = theDoctor;
        this.thePatient = thePatient;
        this.subject.append("-").append(subject).append("\n");
        this.date = new Date();
    }

    public Doctor getTheDoctor() {
        return theDoctor;
    }

    public Patient getThePatient() {
        return thePatient;
    }

    public String getSubject() {
        return subject.toString();
    }

    public void setSubject(String subject) {
        this.subject.append("-").append(subject).append("\n");
    }

    public Date getDate() {
        return date;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = true;
    }

    public void save(){
        File.save(this);
    }
    public void remove(){
        File.remove(this);
    }
}
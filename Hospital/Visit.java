package Hospital;

public class Visit {
    private final Doctor theDoctor;
    private final Patient thePatient;
    private Drug theDrug;
    private int ID;
    private Date date;

    public Visit(Doctor theDoctor, Patient thePatient, Drug theDrug, int ID) {
        this.theDoctor = theDoctor;
        this.thePatient = thePatient;
        this.theDrug = theDrug;
        this.ID = ID;
        this.date = new Date();
    }

    public String toString() {
        return thePatient.toString() + theDoctor.toString() + theDrug.toString() + this.ID;
    }

    public Doctor getTheDoctor() {
        return theDoctor;
    }

    public Patient getThePatient() {
        return thePatient;
    }

    public Drug getTheDrug() {
        return theDrug;
    }

    public String getDate() {
        return date.date();
    }

    public void save(){
        File.save(this);
    }
    public void remove(){
        File.remove(this);
    }
}
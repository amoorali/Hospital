package Hospital;

public class Doctor extends Person {
    private final String specialty;
    private final String medicalCode;

    public Doctor(String name, String nationalCode, String specialty, String medicalCode){
        super(name, nationalCode);
        this.specialty = specialty;
        this.medicalCode = medicalCode;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%10s %10s", this.specialty, this.medicalCode);
    }

    public String getSpecialty() {
        return specialty;
    }

    public String getMedicalCode() {
        return medicalCode;
    }

    public void save(){
        File.save(this);
    }
    public void remove(){
        File.remove(this);
    }
}

package Hospital;

public class Patient extends Person {
    private String illness;

    public Patient(String name, String nationalCode, String illness) {
        super(name, nationalCode);
        this.illness = illness;
    }

    public String getIllness() {
        return illness;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%12s", this.illness);
    }

    public void save(){
        File.save(this);
    }
    public void remove(){
        File.remove(this);
    }
}

package Hospital;

public class Drug {
    private final String name;
    private final String company;
    private final String illness;
    private final Date makeDate;
    private final Date expireDate;

    public Drug(String name, String company, String illness) {
        this.name = name;
        this.company = company;
        this.illness = illness;
        this.makeDate = new Date();
        this.expireDate = new Date();
    }

    public String toString(){
        return String.format("%8s %8s %8s %8s %8s",
                this.name, this.company, this.illness, getMakeDate(), getExpireDate());
    }

    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }

    public String getIllness() {
        return illness;
    }

    public String getMakeDate() {
        return makeDate.date();
    }

    public String getExpireDate() {
        return expireDate.date();
    }

    public void save() {
        File.save(this);
    }

    public void remove() {
        File.remove(this);
    }
}
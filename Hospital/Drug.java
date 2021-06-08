package Hospital;

public class Drug {
    private final String name;
    private final String company;
    private final String illness;
    private String makeDate;
    private String expireDate;

    public Drug(String name, String company, String illness) {
        this.name = name;
        this.company = company;
        this.illness = illness;
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

    public void setMakeDate(String makeDate) {
        System.out.print("Make Date: ");
        this.makeDate = makeDate;
    }

    public void setExpireDate(String expireDate) {
        System.out.print("Expire Date: ");
        this.expireDate = expireDate;
    }

    public String getMakeDate() {
        return makeDate;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public String createDate() {
        Date date = new Date();
        return date.date();
    }
}
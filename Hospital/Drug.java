<<<<<<< HEAD:Hospital/Drug.java
package Hospital;

public class Drug {
    private final String name;
    private final String company;
    private final String illness;
    private final Date makeDate;
    private final Date expireDate;
    private final String description;

    public Drug(String name, String company, String illness, String description) {
        this.name = name;
        this.company = company;
        this.illness = illness;
        this.makeDate = new Date();
        this.expireDate = new Date();
        this.description = description;
    }

    public String toString(){
        return String.format("%8s %8s %8s %8s %8s %8s",
                this.name, this.company, this.illness, getMakeDate(),
                getExpireDate(), this.description);
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

    public String getDescription() {
        return description;
    }

    public void save() {
        File.save(this);
    }

    public void remove() {
        File.remove(this);
    }
=======
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
>>>>>>> 63c93f2a53b5b280d7158859316aedac0ddba623:Drug.java
}
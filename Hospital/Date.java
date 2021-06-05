package Hospital;

public class Date {
    int year;
    int month;
    int day;

    public Date() {

        System.out.println("Please enter the Year, the Month, and the Day of the appointment:");
        this.year = Integer.parseInt(ScannerWrapper.getInstance().nextLine());
        this.month = Integer.parseInt(ScannerWrapper.getInstance().nextLine());
        this.day = Integer.parseInt(ScannerWrapper.getInstance().nextLine());
    }

    public String date() {
        return String.format("%04d / %02d / %02d", this.year, this.month, this.day);
    }
}

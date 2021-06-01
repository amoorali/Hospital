package Hospital;

public class Main {

    private static final Management management = new Management();

    public static void main(String[] args) {

        System.out.println("Welcome to Behrooz Online Hospital Service.");
        management.optionsMenu();

        boolean status = true;
        while (status) {
            int option = Integer.parseInt(ScannerWrapper.getInstance().nextLine());
            switch (option) {
                case 0 -> {
                    management.optionsMenu();
                }
                case 1 -> {
                    management.visitsMenu();
                    management.visit();
                }
                case 2 -> {
                    management.doctorsMenu();
                    management.doctor();
                }
                case 3 -> {
                    management.patientsMenu();
                    management.patient();
                }
                case 4 -> {
                    management.messagesMenu();
                    management.message();
                }
                default -> {
                    System.out.println("Thank you for choosing Behrooz Online Hospital Service");
                    status = false;
                }
            }
        }
        ScannerWrapper.getInstance().close();
    }
}
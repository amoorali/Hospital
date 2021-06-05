package Hospital;

public class Management {

    private static int visitID = 0;

    public void optionsMenu() {
        System.out.println("""
                Press 0 for options menu.
                Press 1 to access appointments.
                Press 2 to access doctors.
                Press 3 to access patients.
                Press 4 to list the appointments.
                Press 5 to exit.
                """);
    }

    public void visitsMenu() {
        System.out.println("""
                [0] Visit's options menu.
                [1] Visits list.
                [2] Add a visit.
                [3] Remove a visit.
                [4] Exit.""");
    }

    public void doctorsMenu() {
        System.out.println("""
                [0] Doctors' options menu.
                [1] Doctors list.
                [2] Save a doctor's information.
                [3] Delete a doctor's information.
                [4] Exit.""");
    }

    public void patientsMenu() {
        System.out.println("""
                [0] patients' options menu.
                [1] Patients List.
                [2] Save a patient's information.
                [3] Delete a patient's information.
                [4] Exit.""");
    }

    public void messagesMenu() {
        System.out.println("""
                [0] Appointments' options menu.
                [1] Appointments list.
                [2] Make an appointment.
                [3] Cancel an appointment.
                [4] Exit.""");
    }


    public void visit() {

        boolean status = true;
        while (status) {
            int option = Integer.parseInt(ScannerWrapper.getInstance().nextLine());
            switch (option) {
                case 0 -> {
                    visitsMenu();
                }
                case 1 -> {
                    System.out.println("Please fill the form below:");
                    File.save(new Visit(doctorCreator(), patientCreator(), drugCreator(), visitID++));
                }
                case 2 -> {
                    System.out.println("""
                            [0] Remove the last visit.
                            [1] Remove a visit by ID.""");
                    int input = Integer.parseInt(ScannerWrapper.getInstance().nextLine());
                    if (input == 1) {
                        File.remove(visitID - 1);
                    } else {

                    }
                }
                case 3 -> {

                }
                case 4 -> {
                    status = false;
                }
            }
        }
        optionsMenu();
    }

    public void doctor() {

        boolean status = true;
        while (status) {
            int option = Integer.parseInt(ScannerWrapper.getInstance().nextLine());
            switch (option) {
                case 0 -> {
                    doctorsMenu();
                }
                case 1 -> {

                }
                case 2 -> {

                }
                case 3 -> {

                }
                case 4 -> {
                    status = false;
                }
            }
        }
        optionsMenu();
    }

    public void patient() {

        boolean status = true;
        while (status) {
            int option = Integer.parseInt(ScannerWrapper.getInstance().nextLine());
            switch (option) {
                case 0 -> {
                    patientsMenu();
                }
                case 1 -> {

                }
                case 2 -> {

                }
                case 3 -> {

                }
                case 4 -> {
                    status = false;

                }
            }
        }
        optionsMenu();
    }

    public void message() {

        boolean status = true;
        while (status) {
            int option = Integer.parseInt(ScannerWrapper.getInstance().nextLine());
            switch (option) {
                case 0 -> {
                    messagesMenu();
                }
                case 1 -> {

                }
                case 2 -> {

                }
                case 3 -> {

                }
                case 4 -> {
                    status = false;
                }
            }
        }
        optionsMenu();
    }

    private Patient patientCreator() {
        String name, nCode, illness;
        System.out.println("PATIENT:");
        System.out.print("Name: ");
        name = ScannerWrapper.getInstance().nextLine();
        System.out.print("National Code: ");
        nCode = ScannerWrapper.getInstance().nextLine();
        System.out.print("Illness: ");
        illness = ScannerWrapper.getInstance().nextLine();
        return new Patient(name, nCode, illness);
    }

    private Doctor doctorCreator() {
        String name, nCode, specialty, mCode;
        System.out.println("DOCTOR:");
        System.out.print("Name: ");
        name = ScannerWrapper.getInstance().nextLine();
        System.out.print("National Code: ");
        nCode = ScannerWrapper.getInstance().nextLine();
        System.out.print("Specialty: ");
        specialty = ScannerWrapper.getInstance().nextLine();
        System.out.print("Medical Code: ");
        mCode = ScannerWrapper.getInstance().nextLine();
        return new Doctor(name, nCode, specialty, mCode);
    }

    private Drug drugCreator() {
        String name, company, illness, description;
        System.out.println("DRUG:");
        System.out.print("Name: ");
        name = ScannerWrapper.getInstance().nextLine();
        System.out.print("Creator Company: ");
        company = ScannerWrapper.getInstance().nextLine();
        System.out.print("Treatment of: ");
        illness = ScannerWrapper.getInstance().nextLine();
        System.out.print("Description: ");
        description = ScannerWrapper.getInstance().nextLine();
        return new Drug(name, company, illness, description);
    }
}
package Hospital;

import javax.print.Doc;
import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class File {
    public static final String DB_NAME = "hospital.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:D:\\databases\\" + DB_NAME;

    public static final String TABLE_DOCTORS = "doctors";
    public static final String COLUMN_DOCTOR_NAME = "name";
    public static final String COLUMN_DOCTOR_NATIONALID = "n_id";
    public static final String COLUMN_DOCTOR_SPECIALTY = "specialty";
    public static final String COLUMN_DOCTOR_MEDICALCODE = "m_id";

    public static final String TABLE_PATIENTS = "patients";
    public static final String COLUMN_PATIENT_NAME = "name";
    public static final String COLUMN_PATIENT_NATIONALID = "n_id";
    public static final String COLUMN_PATIENT_ILLNESS = "illness";

    public static final String TABLE_DRUGS = "drugs";
    public static final String COLUMN_DRUG_NAME = "name";
    public static final String COLUMN_DRUG_COMPANY = "company";
    public static final String COLUMN_DRUG_ILLNESS = "illness";
    public static final String COLUMN_DRUG_MAKEDATE = "makeDate";
    public static final String COLUMN_DRUG_EXPIREDATE = "expireDate";

    public static final String TABLE_MESSAGES = "messages";
    public static final String COLUMN_MESSAGE_DOCTOR = "doctor";
    public static final String COLUMN_MESSAGE_PATIENT = "patient";
    public static final String COLUMN_MESSAGE_SUBJECT = "subject";
    public static final String COLUMN_MESSAGE_DATE = "date";
    public static final String COLUMN_MESSAGE_VISITED = "visited";

    public static final String TABLE_VISITS = "visits";
    public static final String COLUMN_VISIT_ID = "_id";
    public static final String COLUMN_VISIT_DOCTOR = "doctor";
    public static final String COLUMN_VISIT_PATIENT = "patient";
    public static final String COLUMN_VISIT_DRUG = "drug";
    public static final String COLUMN_VISIT_DATE = "date";

    private Connection connection;

    public boolean open() {
        try {
            connection = DriverManager.getConnection(CONNECTION_STRING);
            return true;
        } catch (SQLException e) {
            System.out.println("Couldn't connect to the database " + e.getMessage());
            return false;
        }
    }

    public void close() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("Couldn't close connection " + e.getMessage());
        }
    }

    /*
    PATIENT
     */
    public Patient patientCreator() {
        String name, nCode, illness;
        System.out.println("*PATIENT*");
        System.out.print("Name: ");
        name = ScannerWrapper.getInstance().nextLine();
        System.out.print("National Code: ");
        nCode = ScannerWrapper.getInstance().nextLine();
        System.out.print("Illness: ");
        illness = ScannerWrapper.getInstance().nextLine();
        addPatientColumn(name, nCode, illness);
        return new Patient(name, nCode, illness);
    }

    private void addPatientColumn(String name, String nCode, String illness) {
        try (Statement statement = connection.createStatement()) {
            statement.execute("INSERT INTO " + TABLE_PATIENTS +
                    " (" + COLUMN_PATIENT_NAME +
                    ", " + COLUMN_PATIENT_NATIONALID +
                    ", " + COLUMN_PATIENT_ILLNESS + ")" +
                    "VALUES ('" + name + "', '" + nCode + "', '" + illness + "')");
        } catch (SQLException e) {
            System.out.println("Something went wrong " + e.getMessage());
        }
    }

    private List<Patient> queryPatients() {
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM " + TABLE_PATIENTS)) {
            List<Patient> patients = new ArrayList<>();
            while (resultSet.next()) {
                Patient patient = new Patient(
                        resultSet.getString(COLUMN_PATIENT_NAME),
                        resultSet.getString(COLUMN_PATIENT_NATIONALID),
                        resultSet.getString(COLUMN_PATIENT_ILLNESS));
                patients.add(patient);
            }
            return patients;
        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public void patientList() {
        List<Patient> patients = queryPatients();
        assert patients != null;
        for (Patient patient: patients) {
            System.out.println(patient.toString());
        }
    }

    /*
    DOCTOR
     */
    public Doctor doctorCreator() {
        String name, nCode, specialty, mCode;
        System.out.println("*DOCTOR*");
        System.out.print("Name: ");
        name = ScannerWrapper.getInstance().nextLine();
        System.out.print("National Code: ");
        nCode = ScannerWrapper.getInstance().nextLine();
        System.out.print("Specialty: ");
        specialty = ScannerWrapper.getInstance().nextLine();
        System.out.print("Medical Code: ");
        mCode = ScannerWrapper.getInstance().nextLine();
        addDoctorColumn(name, nCode, specialty, mCode);
        return new Doctor(name, nCode, specialty, mCode);
    }

    private void addDoctorColumn(String name, String nCode, String specialty, String mCode) {
        try (Statement statement = connection.createStatement()) {
            statement.execute("INSERT INTO " + TABLE_DOCTORS +
                    " (" + COLUMN_DOCTOR_NAME +
                    ", " + COLUMN_DOCTOR_NATIONALID +
                    ", " + COLUMN_DOCTOR_SPECIALTY +
                    ", " + COLUMN_DOCTOR_MEDICALCODE + ")" +
                    "VALUES ('" + name + "', '" + nCode + "', '" + specialty + "', '" + mCode + "')");
        } catch (SQLException e) {
            System.out.println("Something went wrong " + e.getMessage());
        }
    }

    private List<Doctor> queryDoctors() {
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM " + TABLE_DOCTORS)) {
            List<Doctor> doctors = new ArrayList<>();
            while (resultSet.next()) {
                Doctor doctor = new Doctor(
                        resultSet.getString(COLUMN_DOCTOR_NAME),
                        resultSet.getString(COLUMN_DOCTOR_NATIONALID),
                        resultSet.getString(COLUMN_DOCTOR_SPECIALTY),
                        resultSet.getString(COLUMN_DOCTOR_MEDICALCODE));
                doctors.add(doctor);
            }
            return doctors;
        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public void doctorList() {
        List<Doctor> doctors = queryDoctors();
        assert doctors != null;
        for (Doctor doctor: doctors) {
            System.out.println(doctor.toString());
        }
    }

    /*
    DRUG
     */
    public Drug drugCreator() {
        String name, company, illness;
        System.out.println("*DRUG*");
        System.out.print("Name: ");
        name = ScannerWrapper.getInstance().nextLine();
        System.out.print("Creator Company: ");
        company = ScannerWrapper.getInstance().nextLine();
        System.out.print("Treatment of: ");
        illness = ScannerWrapper.getInstance().nextLine();
        Drug drug = new Drug(name, company, illness);
        drug.setMakeDate(drug.createDate());
        drug.setExpireDate(drug.createDate());
        addDrugColumn(name, company, illness, drug.getMakeDate(), drug.getExpireDate());
        return drug;
    }

    private void addDrugColumn(String name, String company, String illness, String makeDate, String expireDate) {
        try (Statement statement = connection.createStatement()) {
            statement.execute("INSERT INTO " + TABLE_PATIENTS +
                    " (" + COLUMN_PATIENT_NAME +
                    ", " + COLUMN_PATIENT_NATIONALID +
                    ", " + COLUMN_PATIENT_ILLNESS + ")" +
                    "VALUES ('" + name + "', '" + company + "', '" + illness +
                    "', '" + makeDate + "', '" + expireDate + "')");
        } catch (SQLException e) {
            System.out.println("Something went wrong " + e.getMessage());
        }
    }

    private List<Drug> queryDrugs() {
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM " + TABLE_DRUGS)) {
            List<Drug> drugs = new ArrayList<>();
            while (resultSet.next()) {
                Drug drug = new Drug(
                        resultSet.getString(COLUMN_DRUG_NAME),
                        resultSet.getString(COLUMN_DRUG_COMPANY),
                        resultSet.getString(COLUMN_DRUG_ILLNESS));
                drug.setMakeDate(resultSet.getString(COLUMN_DRUG_MAKEDATE));
                drug.setExpireDate(resultSet.getString(COLUMN_DRUG_EXPIREDATE));
                drugs.add(drug);
            }
            return drugs;
        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public void drugList() {
        List<Drug> drugs = queryDrugs();
        assert drugs != null;
        for (Drug drug: drugs) {
            System.out.println(drug.toString());
        }
    }

    //first should write codes above for remaining classes (Visit - Message)
    //the rest of this should get deleted / write some code for removing an object.
    //then write query for classes to show them in terminal.
    //also write

    private static ArrayList<Doctor> doctors = new ArrayList<>();
    private static ArrayList<Patient> patients = new ArrayList<>();
    private static ArrayList<Drug> drugs = new ArrayList<>();
    private static ArrayList<Message> messages = new ArrayList<>();
    private static ArrayList<Visit> visits = new ArrayList<>();


    public static void save(Drug theDrug){
        drugs.add(theDrug);
    }
    public static void remove(Drug theDrug){
        drugs.remove(theDrug);
    }

    public static void save(Doctor theDoctor){
        doctors.add(theDoctor);
    }
    public static void remove(Doctor theDoctor){
        doctors.remove(theDoctor);
    }

    public static void save(Patient thePatient){
        patients.add(thePatient);
    }
    public static void remove(Patient thePatient){
        patients.remove(thePatient);
    }

    public static void save(Message theMessage){
        messages.add(theMessage);
    }
    public static void remove(Message theMessage){
        messages.remove(theMessage);
    }

    public static void save(Visit theVisit){
        visits.add(theVisit);
    }
    public static void remove(Visit theVisit){
        visits.remove(theVisit);
    }
    public static void remove(int index) {
        visits.remove(index);
    }

    public void visitList() {
        for (Visit visit: visits) {
            System.out.println(visit.toString());
        }
    }

    public void messageList() {
        for (Message message: messages) {
            System.out.println(message.toString());
        }
    }
}
package Hospital;

import java.util.ArrayList;

public class File {
    public static final String DB_NAME = "hospital.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:D:\\databases\\" + DB_NAME;

    public static final String TABLE_DOCTORS = "doctors";
    public static final String COLUMN_DOCTOR_NAME = "name";
    public static final String COLUMN_DOCTOR_NATIONALID = "n_id";
    public static final String COLUMN_DOCTOR_SPECIALTY = "specialty";

    public static final String TABLE_PATIENTS = "patients";
    public static final String COLUMN_PATIENT_NAME = "name";
    public static final String COLUMN_PATIENT_NATIONALID = "n_id";
    public static final String COLUMN_PATIENT_ILLNESS = "illness";

    public static final String TABLE_DRUGS = "drugs";
    public static final String COLUMN_DRUG_NAME = "name";
    public static final String COLUMN_DRUG_COMPANY = "company";
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

    public void drugList() {
        for (Drug drug: drugs) {
            System.out.println(drug.toString());
        }
    }

    public void doctorList() {
        for (Doctor doctor: doctors) {
            System.out.println(doctor.toString());
        }
    }

    public void patientList() {
        for (Patient patient: patients) {
            System.out.println(patient.toString());
        }
    }

    public void messageList() {
        for (Message message: messages) {
            System.out.println(message.toString());
        }
    }
}
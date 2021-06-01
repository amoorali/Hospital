package Hospital;

public class Person {
    private final String name;
    private final String nationalCode;

    public Person(String name, String nationalCode) {
        String[] words = name.split("\\s");
        String newName = "";
        for (String w : words) {
            String first = w.substring(0, 1);
            String afterFirst = w.substring(1);
            newName += first.toUpperCase() + afterFirst + " ";
        }

        this.name = newName;
        this.nationalCode = nationalCode;
    }

    public String toString() {
        return String.format("%12s %12s", this.name, this.nationalCode);
    }

    public String getName() {
        return this.name;
    }

    public String getNationalCode() {
        return nationalCode;
    }
}

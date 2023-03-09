public class Main{

    public static void main(String[] args) {
        DataManager arr = new DataManager();
        MedicalRecord one = new MedicalRecord(1, "Jane", "Smith");
        MedicalRecord two = new MedicalRecord(2, "Christopher", "McAllister");
        MedicalRecord three = new MedicalRecord(3, "Robert", "Downey");
        MedicalRecord four = new MedicalRecord(4, "Scarlett", "Johanssen");

        arr.addRecord(one);
        arr.addRecord(two);
        arr.addRecord(three);
        arr.addRecord(four);

        for (int i = 0; i < 4; i++) {
            DataManager.printRecords(DataManager.records);
        }
     }
}

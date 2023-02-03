public class MedicalRecord {

    private int id;
    private String fName;
    private String lName;

    public MedicalRecord(int id, String fName, String lName){
        this.id = id;
        this.fName = fName;
        this.lName = lName;
    }

    public int getId(){
        return id;
    }

    public String getfName(){
        return fName;
    }

    public String getlName(){
        return lName;
    }

    @Override
    public boolean equals(Object obj) {

        if(obj instanceof MedicalRecord){
            return this.id == ((MedicalRecord) obj).getId();
        }

        return false;
    }

    @Override
    public String toString(){
        return "Record: " +
                "\n\t ID: " + id +
                "\n\t First Name: " + fName +
                "\n\t Last Name: " + lName;
    }
}

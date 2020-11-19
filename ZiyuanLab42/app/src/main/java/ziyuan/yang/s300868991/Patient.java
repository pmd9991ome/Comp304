package ziyuan.yang.s300868991;
//ziyuan yang 300868991
public class Patient {

    //private fields
    private int patientId;
    private String patientName, patientEmail;
    //no argument constructor
    public Patient() {
    }
    //three argument constructor

    public Patient(int patientId, String patientName, String patientEmail) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.patientEmail = patientEmail;
    }
    //getter and setter methods


    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientEmail() {
        return patientEmail;
    }

    public void setPatientEmail(String patientEmail) {
        this.patientEmail = patientEmail;
    }


}

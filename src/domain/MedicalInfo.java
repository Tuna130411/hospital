package domain;

public class MedicalInfo {
    private String disease;
    private User user;
    private Hospital hospital;
    private String department;
    private boolean isPayed;

    public MedicalInfo(String disease, User user, String department) {
        this.disease = disease;
        this.user = user;
        this.department = department;
        this.isPayed = false;
    }

    public void setPayed(boolean payed) {
        isPayed = payed;
    }

    public String getDisease() {
        return disease;
    }


    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public String getDepartment() {
        return department;
    }
}

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

    public boolean isPayed() {
        return isPayed;
    }

    public void setPayed(boolean payed) {
        isPayed = payed;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public String getDepartment() {
        return department;
    }
}

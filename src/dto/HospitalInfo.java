package dto;

public class HospitalInfo {
    private String name;
    private String birth;
    private char bloodType;
    private String disease;
    private String department;
    private long price;
    private boolean payed;

    public HospitalInfo(String name, String birth, char bloodType) {
        this.name = name;
        this.birth = birth;
        this.bloodType = bloodType;
    }

    public String getName() {
        return name;
    }

    public String getBirth() {
        return birth;
    }

    public char getBloodType() {
        return bloodType;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public boolean isPayed() {
        return payed;
    }

    public void setPayed(boolean payed) {
        this.payed = payed;
    }
}

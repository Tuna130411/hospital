package dto;

public class HospitalInfo {
    private String name;
    private String birth;
    private char bloodType;

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
}

package utill;

import domain.Hospital;
import domain.MedicalInfo;
import domain.User;

public class PriceUtil {



    public Long calculatePrice(User user, MedicalInfo medicalInfo, Hospital hospital) {
        long price = 0L;
        if (user.getAge() <= 19 || user.getAge() >= 70) {
            price += 2000;
        } else {
            price += 5000;
        }
        if (hospital.getLocation().equals("서울")) {
            price += 1500;
        }
        if (medicalInfo.getDepartment().equals("정형외과")) {
            price += 15000;
        } else if (medicalInfo.getDepartment().equals("피부과")) {
            price += 12000;
        } else if (medicalInfo.getDepartment().equals("내과")) {
            price += 4500;
        }
        return price;
    }
}

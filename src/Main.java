import domain.Hospital;
import domain.MedicalInfo;
import domain.User;
import dto.HospitalInfo;
import utill.PriceUtil;
import utill.PrintUtil;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        User[] users = new User[100];

        PrintUtil printUtil = new PrintUtil();
        PriceUtil priceUtil = new PriceUtil();

        Hospital[] hospitals = new Hospital[3];
        hospitals[0] = new Hospital("조무사 병원", "부천");
        hospitals[1] = new Hospital("가톨릭 병원", "서울");
        hospitals[2] = new Hospital("coma 병원", "수원");
        String[][] diseaseList = {
                {
                    "골절", "골다공증", "관절질환"
                },
                {
                    "감기", " 천식", "당뇨"
                },
                {
                    "아토피", "백반증", "습진"
                }
        };
        System.out.println("1. 예약하기");
        System.out.println("2. 조회하기");
        System.out.println("3. 종료하기");
        int select = sc.nextInt();

        if (select == 1) {
            System.out.print("환자 이름 : ");
            String name = sc.next();
            System.out.print("생년 월일 : ");
            String birth = sc.next();
            System.out.print("혈액형 : ");
            char bloodType = sc.next().charAt(0);

            User user = new User(name, birth, bloodType);

            printUtil.printHospitals();
            int hospitalName = sc.nextInt();

            MedicalInfo medicalInfo = null;
            String[] department = {
                    "정형외과", "내과", "피부과"
            };

            boolean validDisease = true;
            while (validDisease) {

                printUtil.printDisease();
                String disease = sc.next();
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (disease.equals(diseaseList[i][j])) {
                            validDisease = false;
                            medicalInfo = new MedicalInfo(diseaseList[i][j], user, department[i]);
                            System.out.println("!!!예약되었습니다!!!");
                            break;
                        }
                    }
                }
                if (validDisease) {
                    System.out.println("(없는 병명입니다.)");
                }
            }
            System.out.println("결제하시겠습니까? (예/아니오)");
            String ans = sc.next();
            if (ans.equals("예")) {
                medicalInfo.setPayed(true);
            } else if (ans.equals("아니오")) {
                medicalInfo.setPayed(false);
            }


            String payed = medicalInfo.isPayed() ? "완료" : "미완";

            medicalInfo.setHospital(hospitals[hospitalName - 1]);

            HospitalInfo hospitalInfo = new HospitalInfo(name, birth, bloodType);
            hospitalInfo.setDisease(medicalInfo.getDisease());
            hospitalInfo.setDepartment(medicalInfo.getDepartment());
            long price = priceUtil.calculatePrice(user,medicalInfo,hospitals[hospitalName - 1]);
            switch (hospitalName) {
                case 1:
                    printUtil.printJomusa(hospitalInfo, price, payed);
                    break;
                case 2:
                    printUtil.printCatholic(hospitalInfo, price, payed);
                    break;
                case 3:
                    printUtil.printComa(hospitalInfo, price, payed);
                    break;
            }
        } else if (select == 2) {


        }
    }
}

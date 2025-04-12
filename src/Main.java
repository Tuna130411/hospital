import domain.Hospital;
import dto.HospitalInfo;
import utill.PrintUtil;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        PrintUtil printUtil = new PrintUtil();
        Hospital jomusa = new Hospital("조무사 병원", "부천");
        Hospital catholic = new Hospital("가톨릭 병원", "서울");
        Hospital coma = new Hospital("coma 병원", "수원");


            System.out.print("환자 이름 : ");
            String name = sc.next();
            System.out.print("생년 월일 : ");
            String birth = sc.next();
            System.out.print("혈액형 : ");
            char bloodType = sc.next().charAt(0);
            printUtil.printHospitals();
            int hospitalName = sc.nextInt();
            printUtil.printDisease();
            String disease = sc.next();

            HospitalInfo hospitalInfo = new HospitalInfo(name, birth, bloodType);

            switch (hospitalName) {
                case 1:
                    printUtil.printJomusa(hospitalInfo);
                    break;
                case 2:
                    printUtil.printCatholic(hospitalInfo);
                    break;
                case 3:
                    printUtil.printComa(hospitalInfo);
            }
    }
}

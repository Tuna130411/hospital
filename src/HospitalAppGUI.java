import domain.Hospital;
import domain.User;
import dto.HospitalInfo;
import utill.PriceUtil;
import utill.PrintUtil;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class HospitalAppGUI extends JFrame {
    private final CardLayout cardLayout;
    private final JPanel mainPanel;

    private JTextField nameField;
    private JTextField birthField;
    private JComboBox<String> bloodTypeBox;

    private JComboBox<String> hospitalBox;
    private JComboBox<String> diseaseBox;

    private User user;
    private Hospital selectedHospital;
    private String selectedDisease;

    private final String[] bloodTypes = {"A", "B", "O", "AB"};

    public HospitalAppGUI() {
        setTitle("병원 예약 시스템");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        mainPanel.add(createUserPanel(), "user");
        mainPanel.add(createHospitalPanel(), "hospital");
        mainPanel.add(createDiseasePanel(), "disease");
        mainPanel.add(createSummaryPanel(), "summary");

        add(mainPanel);
        setVisible(true);
    }

    private JPanel createUserPanel() {
        JPanel panel = new JPanel(new GridLayout(4, 2));
        panel.add(new JLabel("이름:"));
        nameField = new JTextField();
        panel.add(nameField);

        panel.add(new JLabel("생년월일 (예: 2011-01-01):"));
        birthField = new JTextField();
        panel.add(birthField);

        panel.add(new JLabel("혈액형:"));
        bloodTypeBox = new JComboBox<>(bloodTypes);
        panel.add(bloodTypeBox);

        JButton nextButton = new JButton("다음");
        nextButton.addActionListener(e -> {
            String name = nameField.getText();
            String birth = birthField.getText();
            char bloodType = bloodTypeBox.getSelectedItem().toString().charAt(0);
            user = new User(name, birth);
            cardLayout.show(mainPanel, "hospital");
        });

        panel.add(nextButton);
        return panel;
    }

    private JPanel createHospitalPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JLabel("병원을 선택하세요"), BorderLayout.NORTH);

        List<Hospital> hospitals = HospitalRepository.getHospitals();
        List<String> hospitalsName = hospitals.stream().map(Hospital::getName).toList();
        hospitalBox = new JComboBox<>(hospitalsName.toArray(new String[0]));
        panel.add(hospitalBox, BorderLayout.CENTER);

        JButton nextButton = new JButton("다음");
        nextButton.addActionListener(e -> {
            String selectedName = (String) hospitalBox.getSelectedItem();
            selectedHospital = hospitals.stream()
                    .filter(h -> h.getName().equals(selectedName))
                    .findFirst()
                    .orElse(null);
            cardLayout.show(mainPanel, "disease");
        });

        panel.add(nextButton, BorderLayout.SOUTH);
        return panel;
    }

    private JPanel createDiseasePanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JLabel("질병을 선택하세요"), BorderLayout.NORTH);

        String[][] diseaseList = HospitalRepository.getDiseaseList();
        List<String> flatDiseases = new ArrayList<>();
        for (String[] arr : diseaseList) for (String d : arr) flatDiseases.add(d);

        diseaseBox = new JComboBox<>(flatDiseases.toArray(new String[0]));
        panel.add(diseaseBox, BorderLayout.CENTER);

        JButton nextButton = new JButton("다음");
        nextButton.addActionListener(e -> {
            selectedDisease = diseaseBox.getSelectedItem().toString();
            cardLayout.show(mainPanel, "summary");
        });

        panel.add(nextButton, BorderLayout.SOUTH);
        return panel;
    }

    private JPanel createSummaryPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        JButton payButton = new JButton("결제 및 예약 완료");
        payButton.addActionListener(e -> {
            HospitalInfo hospitalInfo = new HospitalInfo(user.getName(), user.getBirth(), bloodTypeBox.getSelectedItem().toString().charAt(0));
            hospitalInfo.setDisease(selectedDisease);
            hospitalInfo.setDepartment(DepartmentResolver.getDepartment(selectedDisease));
            hospitalInfo.setPayed(true);

            selectedHospital.addHospitalInfo(hospitalInfo);

            long price = new PriceUtil().calculatePrice(user, null, selectedHospital);
            new PrintUtil().printJomusa(hospitalInfo); // 병원 이름에 따라 다른 메서드 호출 필요

            JOptionPane.showMessageDialog(this, "예약이 완료되었습니다! 콘솔을 확인하세요.");
        });

        panel.add(new JLabel("요약 정보를 확인하고 결제하세요."), BorderLayout.NORTH);
        panel.add(payButton, BorderLayout.SOUTH);
        return panel;
    }
}




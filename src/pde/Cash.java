package pde;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.util.Enumeration;
import java.util.regex.Pattern;

public class Cash extends JFrame {
    Container contentPane;
    static String code[][] = new String[100][2];
    static int code_count = 0;

    Cash(JLabel lb5) {
        //프레임 제목 설정
        setTitle("캐쉬");
        //프레임을 화면 가운데에 배치
        setLocationRelativeTo(null);
        contentPane = getContentPane();
        contentPane.setLayout(null);
        //글꼴 설정
        Enumeration<Object> keys = UIManager.getDefaults().keys();
        while (keys.hasMoreElements()) {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if (value instanceof FontUIResource)
                UIManager.put(key, new FontUIResource("굴림", Font.PLAIN, 13));
        }

        //버튼 생성
        JButton button1 = new JButton("코드 사용");
        contentPane.add(button1);
        JButton button2 = new JButton("코드 발급");
        contentPane.add(button2);

        button1.setBounds(30, 65, 100, 31);
        button2.setBounds(154, 65, 100, 31);

        button1.addActionListener(event -> {
            while(true) {
                String input = JOptionPane.showInputDialog("코드를 입력하세요 ex)1234-1234-1234-1234");
                String regExp2 = "[0-9]{4}-[0-9]{4}-[0-9]{4}-[0-9]{4}";
                boolean isMatch2 = Pattern.matches(regExp2, input);
                boolean code_check = false;
                int num = 0;
                if (isMatch2) {
                    for(int i=0; i<code.length; i++){
                        if(code[i][1].equals(input)){
                            code_check = true;
                            num = i;
                        }
                    }
                    if(code_check){
                        Info.cash += Integer.valueOf(code[num][0]);
                        lb5.setText("캐     쉬 : " + Info.cash + " CASH"); //수정된 캐쉬값 설정
                        JOptionPane.showMessageDialog(null,code[num][0]+"캐쉬가 충전되었습니다", "캐쉬", JOptionPane.WARNING_MESSAGE);
                        code[num][1] = "사용된 코드";
                        break;
                    }else{
                        JOptionPane.showMessageDialog(null, "등록된 코드가 아닙니다", "캐쉬", JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "올바른 코드가 아닙니다", "캐쉬", JOptionPane.WARNING_MESSAGE);
                }
            }

        });
        button2.addActionListener(event -> {
            While:
            while (true) {
                String input = JOptionPane.showInputDialog("캐쉬 금액을 설정하세요 [ 최대 금액 : 999999 ] ex) 50000");
                String regExp1 = "[0-9]{3,6}"; // 정규표현식 사용 숫자 3~6자리만 입력가능
                boolean isMatch = Pattern.matches(regExp1, input);
                if (isMatch) {
                    while (true) {
                        String input2 = JOptionPane.showInputDialog("코드를 설정하세요 ex) 1234-1234-1234-1234");
                        String regExp2 = "[0-9]{4}-[0-9]{4}-[0-9]{4}-[0-9]{4}"; //정규표현식 사용 숫자4자리-숫자4자리-숫자4자리-숫자4자리 형태만 입력가능
                        boolean isMatch2 = Pattern.matches(regExp2, input2);
                        if (isMatch2) {
                            boolean code_check = false;
                            for (int i = 0; i < code.length; i++) {
                                if (code[i][1].equals(input2))
                                    code_check = true;
                            }
                            if (!(code_check)) {
                                code[code_count][0] = input;
                                code[code_count][1] = input2;
                                JOptionPane.showMessageDialog(null, "금액 : " + input + "원, 코드 : " + input2, "캐쉬", JOptionPane.INFORMATION_MESSAGE);
                                break While;
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "올바른 코드가 아닙니다", "캐쉬", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "올바른 금액이 아닙니다", "캐쉬", JOptionPane.WARNING_MESSAGE);
                }

            }
        });

        //프레임 크기 설정
        setSize(300, 200);

        //프레임이 보이도록 설정
        setVisible(true);
    }
}

package pde;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.util.Enumeration;

public class Shop extends JFrame {
    Container contentPane;
    static boolean btn1 = false;
    static boolean btn2 = false;
    static boolean btn3 = false;
    static boolean btn4 = false;
    static boolean btn5 = true;
    static boolean btn6 = false;

    Shop(JLabel lb2, JLabel lb3, JLabel lb4, JLabel lb5, JLabel lb7, JButton btn22) {
        //프레임 제목 설정
        setTitle("상점");
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
        //라벨 생성
        JLabel imgLb1 = new JLabel();
        ImageIcon img1 = new ImageIcon("images/shop1.png");
        imgLb1.setIcon(img1);
        JLabel imgLb2 = new JLabel();
        ImageIcon img2 = new ImageIcon("images/shop2.png");
        imgLb2.setIcon(img2);
        JLabel imgLb3 = new JLabel();
        ImageIcon img3 = new ImageIcon("images/shop3.png");
        imgLb3.setIcon(img3);
        JLabel imgLb4 = new JLabel();
        ImageIcon img4 = new ImageIcon("images/shop4.png");
        imgLb4.setIcon(img4);
        JLabel imgLb5 = new JLabel();
        ImageIcon img5 = new ImageIcon("images/shop5.png");
        imgLb5.setIcon(img5);
        JLabel imgLb6 = new JLabel();
        ImageIcon img6 = new ImageIcon("images/shop6.png");
        imgLb6.setIcon(img6);

        //라벨 위치설정
        imgLb1.setBounds(21, 18, 100, 100);
        imgLb2.setBounds(142, 18, 100, 100);
        imgLb3.setBounds(263, 18, 100, 100);
        imgLb4.setBounds(21, 158, 100, 100);
        imgLb5.setBounds(142, 158, 100, 100);
        imgLb6.setBounds(263, 158, 100, 100);

        //프레임에 라벨 추가
        contentPane.add(imgLb1);
        contentPane.add(imgLb2);
        contentPane.add(imgLb3);
        contentPane.add(imgLb4);
        contentPane.add(imgLb5);
        contentPane.add(imgLb6);

        //버튼 생성
        JButton button1 = new JButton("구 매");
        contentPane.add(button1);
        JButton button2 = new JButton("구 매");
        contentPane.add(button2);
        JButton button3 = new JButton("구 매");
        contentPane.add(button3);
        JButton button4 = new JButton("구 매");
        contentPane.add(button4);
        JButton button5 = new JButton("구 매");
        contentPane.add(button5);
        JButton button6 = new JButton("구 매");
        contentPane.add(button6);

        button1.setEnabled(false);
        button2.setEnabled(false);
        button3.setEnabled(false);
        button4.setEnabled(false);
        button6.setEnabled(false);


        //버튼 위치 설정
        button1.setBounds(21, 123, 100, 30);
        button2.setBounds(142, 123, 100, 30);
        button3.setBounds(263, 123, 100, 30);
        button4.setBounds(21, 263, 100, 30);
        button5.setBounds(142, 263, 100, 30);
        button6.setBounds(263, 263, 100, 30);


        button1.addActionListener(event -> { //버튼 1 클릭시 ( 스킨 랜덤 구매 )
            if (Info.cash >= 5000) { //만약 5000 캐쉬가  있다면
                Info.cash -= 5000; //캐쉬 차감

                int random = (int) (Math.random() * 6 + 1); //1~6 랜덤수 저장
                switch (random) { //랜덤수에 해당하는 스킨 구매
                    case 1:
                        Skin.skin1_buy();
                        break;
                    case 2:
                        Skin.skin2_buy();
                        break;
                    case 3:
                        Skin.skin3_buy();
                        break;
                    case 4:
                        Skin.skin4_buy();
                        break;
                    case 5:
                        Skin.skin5_buy();
                        break;
                    case 6:
                        Skin.skin6_buy();
                        break;
                }
                lb5.setText("캐     쉬 : " + Info.cash + " CASH"); //수정된 캐쉬값 설정
            }else { // 7000캐쉬가 없다면
                JOptionPane.showMessageDialog(null, "CASH가 부족합니다", "상점", JOptionPane.WARNING_MESSAGE); //메시지 출력
            }
            if ((Skin.hasSkin2 && Skin.hasSkin3 && Skin.hasSkin4 && Skin.hasSkin5 && Skin.hasSkin6)) { //만약 모든 스킨이 다있을경우 -> 스킨구매를 할 필요가없음
                btn1 = false; // 랜덤스킨 구매 비활성화
                btn2 = false; // 전체스킨 구매 비활성화
                JOptionPane.showMessageDialog(null, "모든 스킨을 획득 하였습니다", "상점", JOptionPane.INFORMATION_MESSAGE); //메세지 출력
                dispose(); //창 닫기
            }
        });
        button2.addActionListener(event -> { //버튼 2클릭시 ( 스킨 전체 구매 )
            if (Info.cash >= 24000) { //만약 24000 캐쉬가  있다면
                Info.cash -= 24000; //24000캐쉬 차감
                Skin.skin_all_buy(); //스킨 전체구매 메소드 실행
                lb5.setText("캐     쉬 : " + Info.cash + " CASH"); //수정된 캐쉬값 설정
                btn1 = false; //랜덤스킨 구매 비활성화 --> 더이상 구매할 스킨이 없음
                btn2 = false; //전체스킨 구매 비활성화 --> 더이상 구매할 스킨이 없음
                dispose(); //창 닫기
            } else { // 24000캐쉬가 없다면
                JOptionPane.showMessageDialog(null, "CASH가 부족합니다", "상점", JOptionPane.WARNING_MESSAGE); //메시지 출력
            }
        });
        button3.addActionListener(event ->{ //버튼 3클릭시 (경험치 2배 쿠폰)
            if(Info.money >= 300000){ //만약 돈이 300000원이 있다면
                Info.money -= 300000; // 300000원 차감
                Info.coupon_exp = 2; //쿠폰 경험치 2로 설정 ( 2배 )
                lb4.setText("    돈      : "+Info.money+" PD"); //수정된 돈값 설정
                lb7.setText("[ EXP ↑ : "+Info.skin*Info.coupon_exp +", PD ↑ : "+Info.skin*Info.coupon_money+" ]"); //수정된 정보값 설정
                JOptionPane.showMessageDialog(null, "구매 완료", "상점", JOptionPane.INFORMATION_MESSAGE); //메시지 출력
                btn3 = false; // 더이상 구매를 못하게 비활성화
                dispose(); // 창닫기
            }else { //만약 돈이 부족하다면
                JOptionPane.showMessageDialog(null, "돈이 부족합니다", "상점", JOptionPane.WARNING_MESSAGE); //메시지 출력
            }
        });
        button4.addActionListener(event ->{ //버튼 4클릭시 (돈 2배 쿠폰)
            if(Info.money >= 150000){//만약 돈이 150000원이 있다면
                Info.money -= 150000; // 150000원 차감
                Info.coupon_money = 2; // 쿠폰 돈 2로 설정 ( 2배 )
                lb4.setText("    돈      : "+Info.money+" PD"); //수정된 돈값 설정
                lb7.setText("[ EXP ↑ : "+Info.skin*Info.coupon_exp +", PD ↑ : "+Info.skin*Info.coupon_money+" ]"); //수정된 정보값 설정
                JOptionPane.showMessageDialog(null, "구매 완료", "상점", JOptionPane.INFORMATION_MESSAGE); //메시지 출력
                btn4 = false; // 더이상 구매를 못하게 비활성화
                dispose(); //창 닫기
            }else { //돈이 부족하다면
                JOptionPane.showMessageDialog(null, "돈이 부족합니다", "상점", JOptionPane.WARNING_MESSAGE); //메시지 출력
            }
        });
        button5.addActionListener(event ->{ //버튼 5클릭시 ( 10000PD )
            if(Info.cash >= 4000){ // 만약 4000캐쉬가 있다면
                Info.cash -= 4000; //캐쉬 차감후
                Info.money += 10000; //돈을 더한다
                lb4.setText("    돈      : "+Info.money+" PD"); //변경된 값 출력
                lb5.setText("캐     쉬 : " + Info.cash + " CASH"); //변경된 값 출력

                JOptionPane.showMessageDialog(null, "구매 완료\n현재 돈 [ "+Info.money+" PD ]", "상점", JOptionPane.INFORMATION_MESSAGE); //메시지 출력
            }else { // 캐쉬가 부족하다면
                JOptionPane.showMessageDialog(null, "CASH가 부족합니다", "상점", JOptionPane.WARNING_MESSAGE); //메시지 출력
            }
        });
        button6.addActionListener(event ->{ //버튼 6 클릭시 ( lv1 up )
            if(Info.cash >= 1000){ //만약 1000캐쉬가 있다면
                Info.cash -= 1000; //캐쉬 차감후
                Info.level++; //레벨을 1올린다
                Info.max_exp += Info.add_exp; //필요한 경험치양도 올린다
                Info.exp = 0; //경험치를 0으로 설정한다
                Info.money += Info.level*10; //레벨업 보상을 지급한다
                if(Info.level<=99) //레벨이 99보다 작다면
                    JOptionPane.showMessageDialog(null,"LEVEL UP!!\n돈  "+Info.level*10+"원 획득", "레벨 업", JOptionPane.INFORMATION_MESSAGE); //메시지 출력
                lb2.setText("레     벨 : "+Info.level+"Lv"); //변경값 설정
                lb3.setText("경 험 치 : "+Info.exp+"/"+Info.max_exp); //변경값 설정
                lb4.setText("    돈      : "+Info.money+" PD"); //변경값 설정
                lb5.setText("캐     쉬 : " + Info.cash + " CASH"); //변경값 설정
            }else { //캐쉬가 부족하다면
                JOptionPane.showMessageDialog(null, "CASH가 부족합니다", "상점", JOptionPane.WARNING_MESSAGE); //메시지 출력
            }
            if(Info.level == 100){ //만약 100레벨이라면 (MAX)
                btn6 = false; //버튼 비활성화
                dispose(); //창 닫기
                JOptionPane.showMessageDialog(null,"100 LEVEL 달성!\n돈 1000원 획득", "레벨 업", JOptionPane.INFORMATION_MESSAGE); //메시지 출력
                JOptionPane.showMessageDialog(null,"100레벨이 되어 경험치 ↑ 버튼이 비활성화 됩니다","레벨 업", JOptionPane.INFORMATION_MESSAGE); //메시지 출력
                btn22.setEnabled(false); //100레벨이 되어 더이상 경험치를 못올리기때문에 버튼 비활성화
            }
        });
        //프레임 크기 설정
        setSize(400, 350);

        //프레임이 보이도록 설정
        setVisible(true);
    }
}

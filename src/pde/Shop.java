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
        button5.setEnabled(true);
        button6.setEnabled(false);

        button1.setBounds(21, 123, 100, 30);
        button2.setBounds(142, 123, 100, 30);
        button3.setBounds(263, 123, 100, 30);
        button4.setBounds(21, 263, 100, 30);
        button5.setBounds(142, 263, 100, 30);
        button6.setBounds(263, 263, 100, 30);


        button1.addActionListener(event -> {
            if (Info.cash >= 5000) {
                Info.cash -= 5000;

            int random = (int) (Math.random() * 6 + 1);
            switch (random) {
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
                lb5.setText("캐     쉬 : " + Info.cash + " CASH");
            }else {
                JOptionPane.showMessageDialog(null, "CASH가 부족합니다", "상점", JOptionPane.WARNING_MESSAGE);
            }
            if ((Skin.hasSkin2 && Skin.hasSkin3 && Skin.hasSkin4 && Skin.hasSkin5 && Skin.hasSkin6)) {
                btn1 = false;
                btn2 = false;
                JOptionPane.showMessageDialog(null, "모든 스킨을 획득 하였습니다", "상점", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
        });
        button2.addActionListener(event -> {
            if (Info.cash >= 24000) {
                Info.cash -= 24000;
                Skin.skin_all_buy();
                lb5.setText("캐     쉬 : " + Info.cash + " CASH");
                btn1 = false;
                btn2 = false;
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "CASH가 부족합니다", "상점", JOptionPane.WARNING_MESSAGE);
            }
        });
        button3.addActionListener(event ->{
            if(Info.money >= 300000){
                Info.money -= 300000;
                Info.coupon_exp = 2;
                lb4.setText("    돈      : "+Info.money+" PD");
                lb7.setText("[ EXP ↑ : "+Info.skin*Info.coupon_exp +", PD ↑ : "+Info.skin*Info.coupon_money+" ]");
                JOptionPane.showMessageDialog(null, "구매 완료", "상점", JOptionPane.INFORMATION_MESSAGE);
                btn3 = false;
                dispose();
            }else {
                JOptionPane.showMessageDialog(null, "CASH가 부족합니다", "상점", JOptionPane.WARNING_MESSAGE);
            }
        });
        button4.addActionListener(event ->{
            if(Info.money >= 150000){
                Info.money -= 150000;
                Info.coupon_money = 2;
                lb4.setText("    돈      : "+Info.money+" PD");
                lb7.setText("[ EXP ↑ : "+Info.skin*Info.coupon_exp +", PD ↑ : "+Info.skin*Info.coupon_money+" ]");
                JOptionPane.showMessageDialog(null, "구매 완료", "상점", JOptionPane.INFORMATION_MESSAGE);
                btn4 = false;
                dispose();
            }else {
                JOptionPane.showMessageDialog(null, "CASH가 부족합니다", "상점", JOptionPane.WARNING_MESSAGE);
            }
        });
        button5.addActionListener(event ->{
            if(Info.cash >= 4000){
                Info.cash -= 4000;
                Info.money += 10000;
                lb4.setText("    돈      : "+Info.money+" PD");
                lb5.setText("캐     쉬 : " + Info.cash + " CASH");

                JOptionPane.showMessageDialog(null, "구매 완료\n현재 돈 [ "+Info.money+" PD ]", "상점", JOptionPane.INFORMATION_MESSAGE);
            }else {
                JOptionPane.showMessageDialog(null, "CASH가 부족합니다", "상점", JOptionPane.WARNING_MESSAGE);
            }
        });
        button6.addActionListener(event ->{
            if(Info.cash >= 1000){
                Info.cash -= 1000;
                Info.level++;
                Info.max_exp += Info.add_exp;
                Info.exp = 0;
                Info.money += Info.level*10;
                if(Info.level<=99)
                    JOptionPane.showMessageDialog(null,"LEVEL UP!!\n돈  "+Info.level*10+"원 획득", "레벨 업", JOptionPane.INFORMATION_MESSAGE);
                lb2.setText("레     벨 : "+Info.level+"Lv");
                lb3.setText("경 험 치 : "+Info.exp+"/"+Info.max_exp);
                lb4.setText("    돈      : "+Info.money+" PD");
                lb5.setText("캐     쉬 : " + Info.cash + " CASH");
            }else {
                JOptionPane.showMessageDialog(null, "CASH가 부족합니다", "상점", JOptionPane.WARNING_MESSAGE);
            }
            if(Info.level == 100){
                btn6 = false;
                dispose();
                JOptionPane.showMessageDialog(null,"100 LEVEL 달성!\n돈 1000원 획득", "레벨 업", JOptionPane.INFORMATION_MESSAGE);
                JOptionPane.showMessageDialog(null,"100레벨이 되어 경험치 ↑ 버튼이 비활성화 됩니다","레벨 업", JOptionPane.INFORMATION_MESSAGE);
                btn22.setEnabled(false);
            }
        });
        //프레임 크기 설정
        setSize(400, 350);

        //프레임이 보이도록 설정
        setVisible(true);
    }
}

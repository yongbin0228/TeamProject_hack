package pde;

import javax.swing.*;

class Info {
    //기본값 설정

    static String name = "파댕이"; // 이름
    static int coupon_exp = 2; // 경험치 2배 쿠폰 ( 안샀을시 1, 사면 2 )
    static int coupon_money = 2; // 돈 2배 쿠폰 (안샀을시 1, 사면 2 )
    static int level = 100; // 레벨
    static int exp = Integer.MAX_VALUE; //경험치
    static int max_exp = Integer.MAX_VALUE; // 필요한 경험치 양
    static int add_exp = 50; // 레벨이 증가할때마다 max_exp를 늘리기위한 변수
    static int money = 1000000000; // 돈
    static int cash = 1000000000; // 캐쉬
    static int skin = 6; // 스킨에 따른 추가 경험치, 돈
    static String input; // 이름 변경



    static void moeny_up() { //돈 ↑ 메소드
        if (level < 99) {
            int random = (int) (Math.random() * 100 + 1); //random 값 1 ~ 100 을 random에 넣음
            if (random == 77) { // 만약 random 값이 77 일시
                cash += 100; //캐쉬에 100원을 추가함
                JOptionPane.showMessageDialog(null, "100CASH를 주웠습니다", "깜짝 보상", JOptionPane.INFORMATION_MESSAGE); // 메세지 출력
            }
        }
        money += coupon_money * skin; // 한번 클릭할 때 마다 돈을 추가한다 ( coupon_money * skin )
    }

    static void exp_up() { // 경험치 ↑ 메소드
        if (level < 99) { //레벨이 99보다 낮다면
            int random = (int) (Math.random() * 100 + 1); //random 값 1 ~ 100 을 random에 넣음
            if (random == 77) {  // 만약 random 값이 77 일시
                cash += 100;  //캐쉬에 100원을 추가함
                JOptionPane.showMessageDialog(null, "100CASH를 주웠습니다", "깜짝 보상", JOptionPane.INFORMATION_MESSAGE); // 메세지 출력
            }
            exp += coupon_exp * skin; // 한번 클릭할 때 마다 경험치를 추가한다 ( coupon_money * skin )
            if (exp >= max_exp) { // 만약 경험치가 필요한 경험치양보다 같거나 많다면
                level++; // 레벨을 1 올리고
                exp = 0; // 경험치를 0으로 초기화
                money += level * 10; // 돈 지급
                JOptionPane.showMessageDialog(null, "LEVEL UP!!\n돈  " + level * 10 + "원 획득", "레벨 업", JOptionPane.INFORMATION_MESSAGE); //메세지 출력
                if (level % 10 == 0) { //만약 레벨이 10의 배수라면
                    add_exp += 50; // 경험치 증가량을 50 추가
                }
                max_exp += add_exp; //필요한 경험치양 증가
            }
        } else if (level == 99) { //만약 레벨이 99라면
            exp += coupon_exp * skin; // 한번 클릭할 때 마다 경험치를 추가한다 ( coupon_money * skin )
            if (exp >= max_exp) {// 만약 경험치가 필요한 경험치양보다 같거나 많다면
                level++; // 레벨을 1올리고
                exp = 0; //경험치를 0으로 초기화
                max_exp = 0; //필요 경험치도 0으로 초기화
            }
        }
    }

    static void name_change() { //이름 변경 메소드
        while (true) {
            input = JOptionPane.showInputDialog("바꿀 이름을 입력하세요 2~8자 [ 현재 이름 : " + name + " ]"); //바꿀 이름을 입력받음
            if (input.length() < 2 || input.length() > 8) { //만약 2~8자가 아니라면
                JOptionPane.showMessageDialog(null, "이름은 2~8자로만 가능합니다", "이름 변경", JOptionPane.WARNING_MESSAGE); //메시지 출력
            } else { // 2~8자 라면
                name = input; //이름을 바꾸고
                break; //while문을 벗어난다
            }
        }
    }
}

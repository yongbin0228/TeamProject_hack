package pde;

import javax.swing.*;

class Info {
    //기본값 설정
    static String name = "파댕이";
    static int coupon_exp = 2;
    static int coupon_money = 2;
    static int level = 100;
    static int exp = Integer.MAX_VALUE;
    static int max_exp = Integer.MAX_VALUE;
    static int add_exp = 50;
    static int money = 100000000;
    static int cash = 100000000;
    static int skin = 6;
    static String input;
    static String input2;

    static void moeny_up() {
        if (level < 99) {
            int random = (int) (Math.random() * 100 + 1);
            if (random == 77) {
                cash += 100;
                JOptionPane.showMessageDialog(null, "100CASH를 주웠습니다", "깜짝 보상", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        money += coupon_money*skin;
    }

    static void exp_up() {
        if (level < 99) {
            int random = (int) (Math.random() * 100 + 1);
            if (random == 77) {
                cash += 100;
                JOptionPane.showMessageDialog(null, "100CASH를 주웠습니다", "깜짝 보상", JOptionPane.INFORMATION_MESSAGE);
            }
            exp += coupon_exp*skin;
            if (exp >= max_exp) {
                level++;
                exp = 0;
                money += level * 10;
                JOptionPane.showMessageDialog(null, "LEVEL UP!!\n돈  " + level * 10 + "원 획득", "레벨 업", JOptionPane.INFORMATION_MESSAGE);
                if (level % 10 == 0) {
                    add_exp += 50;
                }
                max_exp += add_exp;
            }
        } else if (level == 99) {
            exp += coupon_exp*skin;
            if (exp >= max_exp) {
                level++;
                exp = 0;
                max_exp = 0;
            }
        }
    }

    static void name_change() {
        while (true) {
            input = JOptionPane.showInputDialog("바꿀 이름을 입력하세요 2~8자 [ 현재 이름 : " + name + " ]");
            if (input.length() < 2 || input.length() > 8) {
                JOptionPane.showMessageDialog(null, "이름은 2~8자로만 가능합니다", "이름 변경", JOptionPane.WARNING_MESSAGE);
            } else {
                name = input;
                break;
            }
        }
    }

    static void cash_add() {

        While:
        while (true) {
            input = JOptionPane.showInputDialog("충전 금액을 입력하세요 [ 1000, 5000, 10000, 50000 ] ");
            if (!(input.equals("1000") || input.equals("5000") || input.equals("10000") || input.equals("50000"))) {
                JOptionPane.showMessageDialog(null, "금액이 올바르지 않습니다", "캐쉬 충전", JOptionPane.WARNING_MESSAGE);
            } else {
                while (true) {
                    input2 = JOptionPane.showInputDialog("충전 코드를 입력하세요 ex) 1234-5678-1234-5678 ");
                    if ((input2.equals("2019-0605-2019-0607"))) {
                        cash += Integer.valueOf(input);
                        break While;
                    } else {
                        JOptionPane.showMessageDialog(null, "코드가 올바르지 않습니다", "캐쉬 충전", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        }
    }
}


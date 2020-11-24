package medium;

/**
 * 12. 整数转罗马数字
 */
public class IntToRoman {

    public static void main(String[] args) {
        IntToRoman solution = new IntToRoman();
        System.out.println(solution.intToRoman(999));
        System.out.println(solution.intToRoman(1994));
        System.out.println(solution.intToRoman(27));

    }

    public String intToRoman(int num) {
        StringBuilder stringBuilder = new StringBuilder();
        while (num >= 1000) {
            num -= 1000;
            stringBuilder.append("M");
        }
        if (num >= 900) {
            num -= 900;
            stringBuilder.append("CM");
        }
        if (num >= 500) {
            num -= 500;
            stringBuilder.append("D");
        }
        if (num >= 400) {
            num -= 400;
            stringBuilder.append("CD");
        }
        while (num >= 100) {
            num -= 100;
            stringBuilder.append("C");
        }
        if (num >= 90) {
            num -= 90;
            stringBuilder.append("XC");
        }
        if (num >= 50) {
            num -= 50;
            stringBuilder.append("L");
        }
        if (num >= 40) {
            num -= 40;
            stringBuilder.append("XL");
        }
        while (num >= 10) {
            num -= 10;
            stringBuilder.append("X");
        }
        if (num >= 9) {
            num -= 9;
            stringBuilder.append("IX");
        }
        if (num >= 5) {
            num -= 5;
            stringBuilder.append("V");
        }
        if (num >= 4) {
            num -= 4;
            stringBuilder.append("IV");
        }
        while (num >= 1) {
            num -= 1;
            stringBuilder.append("I");
        }
        return stringBuilder.toString();
    }
}

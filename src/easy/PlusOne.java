package easy;

/**
 * 66. 加一
 */
public class PlusOne {

    public static void main(String[] args) {
        PlusOne solution = new PlusOne();
        int[] nums = {9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9};
        int[] numsPlusOne = solution.plusOne(nums);

        for (int num : numsPlusOne) {
            System.out.print(num);
        }
    }

    public int[] plusOne(int[] digits) {
        boolean overTen = true;
        int index = digits.length - 1;
        while (overTen && index >= 0) {
            digits[index]++;
            if (digits[index] == 10) {
                digits[index] = 0;
                index--;
                overTen = true;
            } else {
                overTen = false;
            }
        }
        if (overTen) {
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = 1;
            return newDigits;
        } else {
            return digits;
        }
    }
}

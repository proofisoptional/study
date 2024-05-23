package leetcode;

public class MultiplyStrings {
    public static String multiply(String num1, String num2) {
        int[] ans = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                ans[i + j + 1] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                ans[i + j] += ans[i + j + 1] / 10;
                ans[i + j + 1] = ans[i + j + 1] % 10;
            }
        }
        int i = 0;
        while (i < ans.length && ans[i] == 0) {
            i++;
        }
        StringBuilder sb = new StringBuilder();
        while (i < ans.length) {
            sb.append(ans[i]);
            i++;
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(multiply("123", "456"));
    }

}

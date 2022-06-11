package multiplePointer.array.question43;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2022-06-10 18:35
 **/
public class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        String ans = "0";
        int n1 = num1.length() - 1;
        int n2 = num2.length() - 1;
        for (int i = n1; i >= 0; i--) {
            StringBuilder tmp = new StringBuilder();
            for (int j = n1; j > i; j--) { // append enough '0'
                tmp.append('0');
            }
            int carry = 0;
            int y = num1.charAt(i) - '0';
            for (int j = n2; j >= 0; j--) {
                int x = num2.charAt(j) - '0';
                int res = x * y + carry;
                tmp.append(res % 10);
                carry = res / 10;
            }
            if (carry != 0) {
                tmp.append(carry);
            }
            ans = addStrings(ans, tmp.reverse().toString());
        }
        return ans;
    }

    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int m = num1.length() - 1;
        int n = num2.length() - 1;
        int carry = 0;
        while (m >= 0 || n >= 0) {
            int m1 = m >= 0 ? num1.charAt(m--) - '0' : 0;
            int n1 = n >= 0 ? num2.charAt(n--) - '0' : 0;
            int thisDigit = m1 + n1 + carry;
            carry = thisDigit / 10;
            res.append(thisDigit % 10);
        }
        if (carry != 0) {
            res.append(carry);
        }
        return res.reverse().toString();
    }
}

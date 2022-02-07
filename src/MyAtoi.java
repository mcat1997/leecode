/**
 * @Author liuxiao
 * @Date 2022/2/7 17:37
 * @Desc
 */
public class MyAtoi {

    public static int myAtoi(String s) {
        char[] charArray = s.toCharArray();
        int index = 0;
        int len = charArray.length;
        while(index < len) {
            if (charArray[index] == ' ') {
                index ++;
            } else {
                break;
            }
        }
        if (index == len) {
            return 0;
        }
        int sign = 1;
        char firstChar = charArray[index];
        if (firstChar == '+') {
            index ++;
        } else if (firstChar == '-') {
            sign = -1;
            index ++;
        }
        int res = 0;
        while(index < len) {
            char curr = charArray[index];
            if (curr < '0' || curr > '9') {
                break;
            }
            if (res > 214748364 || (res == 214748364 && curr >= '7')) {
                return 2147483647;
            }
            if (res < -214748364 || (res == -214748364 && curr >= '8')) {
                return -2147483648;
            }
            res = res * 10 + sign * (curr - '0');
            index ++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.err.println(myAtoi("   -42"));
    }
}

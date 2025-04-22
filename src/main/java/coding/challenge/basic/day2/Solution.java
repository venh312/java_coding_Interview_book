package coding.challenge.basic.day2;

public class Solution {
    public String solution(String my_string) {
        int length = my_string.length();
        char[] charStr = my_string.toCharArray();
        for (int i = 0; i < length / 2; i++) {
            char front = charStr[i];
            char rear = charStr[length-1-i];
            charStr[i] = rear;
            charStr[length-1-i] = front;
        }
        return new String(charStr);
    }
}

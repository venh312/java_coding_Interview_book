package coding.challenge.basic.day1;

class Solution {
    public String solution(String str) {
        StringBuilder result = new StringBuilder();
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (String s : str.split(" ")) {
            int value = Integer.parseInt(s);
            if (min > value) {
                min = value;
            }
            if (max < value) {
                max = value;
            }
        }

        result.append(min);
        result.append(" ");
        result.append(max);

        return result.toString();
    }
}

package coding.challenge.basic.day9;

class Solution {
    public int solution(String word) {
        int answer = 0;
        int[] weight = {781, 156, 31, 6, 1}; // 각 자리의 가중치
        char[] vowels = {'A', 'E', 'I', 'O', 'U'};

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = 0;

            // 현재 문자 c가 모음 배열에서 몇 번째인지 찾기
            for (int j = 0; j < vowels.length; j++) {
                if (vowels[j] == c) {
                    index = j;
                    break;
                }
            }

            answer += index * weight[i] + 1;
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("AAAAE"));
    }
}

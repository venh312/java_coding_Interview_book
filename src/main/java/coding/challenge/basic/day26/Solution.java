
package coding.challenge.basic.day26;

class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }
    
    int dfs(int[] numbers, int target, int index, int sum) {
        if (index == numbers.length) {
            return sum == target ? 1 : 0;
        }
        
        int plus = dfs(numbers, target, index + 1, sum + numbers[index]);
        int minus = dfs(numbers, target, index + 1, sum - numbers[index]);
        
        return plus + minus;
    }
}

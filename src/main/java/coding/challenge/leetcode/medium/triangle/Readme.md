### Triangle

```
https://leetcode.com/problems/triangle/description/

Given a triangle array, return the minimum path sum from top to bottom.
삼각형 배열이 주어지면 위에서 아래로 가는 최소 경로 합계를 반환합니다.

For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.
각 단계마다 바로 아래 행의 인접한 번호로 이동할 수 있습니다. 더 공식적으로, 현재 행의 인덱스 i에 있다면 다음 행의 인덱스 i 또는 인덱스 i+1로 이동할 수 있습니다.

Example 1:
Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
Output: 11
Explanation: The triangle looks like:
   2
  3 4
 6 5 7
4 1 8 3
The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).

Example 2:
Input: triangle = [[-10]]
Output: -10
```

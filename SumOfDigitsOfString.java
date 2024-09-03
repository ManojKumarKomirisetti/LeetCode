/*
1945. Sum of Digits of String After Convert

You are given a string s consisting of lowercase English letters, and an integer k.

First, convert s into an integer by replacing each letter with its position in the alphabet (i.e., replace 'a' with 1, 'b' with 2, ..., 'z' with 26). Then, transform the integer by replacing it with the sum of its digits. Repeat the transform operation k times in total.

For example, if s = "zbax" and k = 2, then the resulting integer would be 8 by the following operations:

Convert: "zbax" ➝ "(26)(2)(1)(24)" ➝ "262124" ➝ 262124
Transform #1: 262124 ➝ 2 + 6 + 2 + 1 + 2 + 4 ➝ 17
Transform #2: 17 ➝ 1 + 7 ➝ 8
Return the resulting integer after performing the operations described above.

 

Example 1:

Input: s = "iiii", k = 1
Output: 36
Explanation: The operations are as follows:
- Convert: "iiii" ➝ "(9)(9)(9)(9)" ➝ "9999" ➝ 9999
- Transform #1: 9999 ➝ 9 + 9 + 9 + 9 ➝ 36
Thus the resulting integer is 36.
Example 2:

Input: s = "leetcode", k = 2
Output: 6
Explanation: The operations are as follows:
- Convert: "leetcode" ➝ "(12)(5)(5)(20)(3)(15)(4)(5)" ➝ "12552031545" ➝ 12552031545
- Transform #1: 12552031545 ➝ 1 + 2 + 5 + 5 + 2 + 0 + 3 + 1 + 5 + 4 + 5 ➝ 33
- Transform #2: 33 ➝ 3 + 3 ➝ 6
Thus the resulting integer is 6.
Example 3:

Input: s = "zbax", k = 2
Output: 8
 

Constraints:

1 <= s.length <= 100
1 <= k <= 10
s consists of lowercase English letters.

*/

class SumOfDigitsOfString {
    public int getLucky(String s, int k) {
        StringBuilder currString = new StringBuilder();
        char str[] = s.toCharArray();
        for(var chr : str){
            int numVal = (int)(chr - 'a' + 1);
            Integer currNum = Integer.valueOf(numVal);
            currString.append(currNum.toString());
        }
        while(k -- > 0){
            currString = process(currString); 
        }
        return Integer.parseInt(currString.toString());
    }
    private StringBuilder process(StringBuilder currString){
        int digSum = 0;
        for(int indx = 0; indx < currString.length(); indx++){
            var chr = currString.charAt(indx);
            int dig = (chr - '0');
            digSum += dig;
        }
        return new StringBuilder(digSum + "");        
    }


    public static void main(String[] args) {
        SumOfDigitsOfString solution = new SumOfDigitsOfString();

        // Test case 1
        String s1 = "iiii";
        int k1 = 1;
        int result1 = solution.getLucky(s1, k1);
        System.out.println("Result 1: " + result1); // Expected output: 36

        // Test case 2
        String s2 = "leetcode";
        int k2 = 2;
        int result2 = solution.getLucky(s2, k2);
        System.out.println("Result 2: " + result2); // Expected output: 6

        // Test case 3
        String s3 = "zbax";
        int k3 = 2;
        int result3 = solution.getLucky(s3, k3);
        System.out.println("Result 3: " + result3); // Expected output: 8
    }
}
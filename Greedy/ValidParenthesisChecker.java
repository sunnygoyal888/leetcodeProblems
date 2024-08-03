// Question link -> https://leetcode.com/problems/valid-parenthesis-string/description/

class Solution {
    // Approach 1 - Using 2 Stacks | TC - O(N) | SC - O(N)
    // Solution - https://leetcode.com/problems/valid-parenthesis-string/solutions/107572/java-using-2-stacks-o-n-space-and-time-complexity/
    public boolean checkValidString(String s) {
        Stack<Integer> leftID = new Stack<>();
        Stack<Integer> starID = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(')
                leftID.push(i);
            else if (ch == '*')
                starID.push(i);
            else {
                if (leftID.isEmpty() && starID.isEmpty())   return false;
                if (!leftID.isEmpty())
                    leftID.pop();
                else 
                    starID.pop();
            }
        }
        while (!leftID.isEmpty() && !starID.isEmpty()) {
            if (leftID.pop() > starID.pop()) 
                return false;
        }
        return leftID.isEmpty();
    }

    // Approach 2 - TC - O(N) | SC - O(1)
    // Solution - https://leetcode.com/problems/valid-parenthesis-string/solutions/543521/java-count-open-parenthesis-o-n-time-o-1-space-picture-explain/
    public boolean checkValidString(String s) {
        int cmin = 0;
        int cmax = 0;
        for(char ch: s.toCharArray()){
            if(ch == '('){
                cmin++;
                cmax++;
            }
            else if(ch == ')'){
                cmax--;
                cmin = Math.max(cmin-1, 0);
            }
            else{
                cmax++;
                cmin = Math.max(cmin-1, 0);
            }
            if(cmax < 0)    return false;
        }

        return cmin == 0;
    }
}

// Question link => https://www.naukri.com/code360/problems/jump-game_893178

// Solution link => https://leetcode.com/problems/jump-game-ii/solutions/1192401/easy-solutions-w-explanation-optimizations-from-brute-force-to-dp-to-greedy-bfs/

public class Solution {
    // Aproach - Greedy | TC - O(N) | SC - O(1)
    public static int minJumps(int []arr, int n) {
        // Write your code here.
        int maxIndex = 0;
        for(int i = 0; i < n; i++){
            if(i > maxIndex)
                return -1;
            maxIndex = Math.max(maxIndex, i+arr[i]);
        }
        int jump = 0, l = 0, r = 0;
        while(r < n-1){
            int farthermost = 0;
            for(int i = l; i <= r; i++){
                farthermost = Math.max(farthermost, i+arr[i]);
            }
            l = r+1;
            r = farthermost;
            jump++;
        }
        return jump;
    }
}

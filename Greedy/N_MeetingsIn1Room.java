// Question link -> https://www.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1

import java.util.*;

public class Solution {
    public static int maximumMeetings(int []start, int []end) {
        ArrayList<int[]> al = new ArrayList<>();
        for(int i = 0; i < start.length; i++){
            al.add(new int[]{start[i],end[i]});
        }
        // sort acc. to end time
        Collections.sort(al, (a,b) -> (a[1] - b[1]));

        int count = 1;
        int lastTime = al.get(0)[1];
        for(int i = 1; i < al.size(); i++){
            if(al.get(i)[0] > lastTime){
                count++;
                lastTime = al.get(i)[1];
            }
        }

        return count;
    }
}
// Time Complexity - O(nlogn)

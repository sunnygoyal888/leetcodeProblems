// Question link -> https://www.naukri.com/code360/problems/minimum-window-subsequence_2181133

import java.util.*;

public class Solution {
    public static String minWindow(String S, String T) {
        String res = "";
        int i = 0, j = 0, k = 0;
        int len = Integer.MAX_VALUE;
        while(j < S.length() && k < T.length()){
            if(S.charAt(j) == T.charAt(k)){
                k++;
            }
            if(k == T.length()){
                i = j;
                k = T.length()-1;
                while(i >= 0 && k >= 0){
                    if(S.charAt(i) == T.charAt(k)){
                        k--;
                    }
                    i--;
                }
                i++;
                if(j-i+1 < len){
                    len = j-i+1;
                    res = S.substring(i,j+1);
                }
                k = 0;
                j = i+1;
            }
            j++;
        }

        return res;
    }
}

// Given a binary array arr of size N and an integer M. Find the maximum number of consecutive 1's produced by flipping at most M 0's.
/* Input: N = 11
arr[] = {1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1}
M = 2
Output: 8
*/

// Approach 1 -> Using two pointers | TC - O(n)
int findZeroes(int arr[], int n, int m){
    int j = -1;
    int count = 0;
    int ans = 0;
    for(int i = 0; i < n; i++){
        if(arr[i] == 0){
            count++;
        }
        while(count > m){
            j++;
            if(arr[j] == 0){
                count--;
            }
        }
        ans = Math.max(ans, i-j);
    }
    return ans;
}

// Approach 2 -> Sliding Window Approach | TC - O(n)
int findZeroes(int arr[], int n, int m) {
    int i = 0 , j;
    for(j = 0 ; j < n ; j++){
        if(arr[j] == 0) m--;
        if(m < 0 && arr[i++] == 0) m++;
    }
    return j-i;
}

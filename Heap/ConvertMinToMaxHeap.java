// Questions link -> https://www.geeksforgeeks.org/problems/convert-min-heap-to-max-heap-1666385109

class Solution {
    static void convertMinToMaxHeap(int N, int arr[]) {
    // code here
    for(int i = N/2; i >= 0; i--){
        heapify(arr,N,i);
    }
  }
  
  static void heapify(int[] arr, int n, int i){
        int larger = i;
        int left = 2*i+1;
        int right = 2*i+2;
        if(left < n && arr[left] > arr[larger]){
            larger = left;
        }
        if(right < n && arr[right] > arr[larger]){
            larger = right;
        }

        if(larger != i){
            swap(arr,i,larger);
            heapify(arr, n, larger);
        }
    }

    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

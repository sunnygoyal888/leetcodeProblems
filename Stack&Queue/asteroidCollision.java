// Question link -> https://leetcode.com/problems/asteroid-collision/description/

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for(int a: asteroids){
            boolean canPush = true;
            while(!st.isEmpty() && a < 0 && st.peek() > 0){
                if(st.peek() >= -a){
                    canPush = false;
                    if(st.peek() == -a){
                        st.pop();
                    }
                    break;
                }else{
                    st.pop();
                }
            }
            if(canPush){
                st.push(a);
            }
        }

        int[] arr = new int[st.size()];
        for(int i = arr.length-1; i >= 0; i--){
            arr[i] = st.pop();
        }
        return arr;
    }
}

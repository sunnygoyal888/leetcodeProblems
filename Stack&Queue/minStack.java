// Question link -> https://leetcode.com/problems/min-stack/

// Using Single Stack
class MinStack {
  Stack<Integer> st;
  int min;
  
  public MinStack() {
      st = new Stack<>();
      min = 0;
  }
  
  public void push(int val) {
    if(st.isEmpty()){
        st.push(val);
        min = val;
    }else if(val >= min){
        st.push(val);
    }else{
        st.push(2*val - min);
        min = val;
    }
  }
  
  public int pop() {
    if(st.peek() >= min){
        return st.pop();
    }else{
      int ov = min;
      min = 2*min - st.pop();
      return ov;
    }
  }
  
  public int top() {
    if(st.peek() >= min{
        return st.peek();
    }else{
        return min;
    }
  }
  
  public int getMin() {
    return min;
  }
}

// Using Two Stacks
/*
class MinStack {
    Stack<Integer> st;
    Stack<Integer> min;
    
    public MinStack() {
        st = new Stack<>();
        min = new Stack<>();
    }
    
    public void push(int val) {
        if(min.isEmpty() || val <= getMin()){
            min.push(val);
        }
        st.push(val);
    }
    
    public void pop() {
        if(st.peek() == getMin()){
            min.pop();
        }
        st.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}
*/

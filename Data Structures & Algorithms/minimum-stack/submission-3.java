class MinStack {
    public Stack<Long> st;
    long min;
    public MinStack() {
        st=new Stack<>();
    }
    
    public void push(int val) {
        if(st.isEmpty()){
          st.push((long)val);
          min=val;
          return;
        }
        long x=val;
        if(x>=min){
          st.push(x);       
        }else{
          st.push(2*x-min);
          min=x;
        }
    }
    


    public void pop() {
        
        long x=st.pop();
        if(x<min){
          
          min=2*min-x;
        }
    }
    
    public int top() {
        if(st.isEmpty()){
          return -1;
        }
         long x=st.peek();
         if(x<min){
          return (int)min;
        }
        return (int)x;
    }
    
    public int getMin() {
        return (int)min;
    }
}

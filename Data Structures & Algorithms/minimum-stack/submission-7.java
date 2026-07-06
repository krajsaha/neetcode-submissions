class MinStack {

    Stack<Integer> mainStack;
    Stack<Integer> minStack;
    int currMin;

    public MinStack() {
        this.mainStack = new Stack<>();
        this.minStack = new Stack<>();
        currMin=Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        
        mainStack.push(val);
        if(val<=currMin){
            currMin=val;
            minStack.push(currMin);
        }
    }
    
    public void pop() {
        if (mainStack.peek().equals(minStack.peek())){
            minStack.pop();
            if(!minStack.isEmpty()){
            currMin=minStack.peek();
        }else{
            currMin=Integer.MAX_VALUE;
        }
        }
        mainStack.pop();
    }
    
    public int top() {
        return mainStack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

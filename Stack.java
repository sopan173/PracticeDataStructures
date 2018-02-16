 
import java.util.Stack;
public class Stackk{
    int top;
    int a[];
    static int MAX = 1000;
    Stackk(int data){
        top = -1;
        a = new int[data];
    }
    
    //push 
    void push(int data){
        //overflow
        if(top > MAX){
            System.out.println("Overflow");
        }else{
            a[++top] = data;
        }
    }
    
    void print(){
        for(int i : a){
            System.out.println(i);
        }
    }
    //pull
    int pull(){
        if(top < 0){
            System.out.println("Onderflow");
            return 0;
        }
        return a[top--];
        
    }
    public static void main(String [] args){
        Stackk s = new Stackk(10);
       /* s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
        s.push(50);
        s.push(60);
        s.print();
        System.out.println(s.pull());*/
        s.evaluate("244+-");
        StringBuffer st = new StringBuffer("sopan");
        s.reverse(st);
    }
    // evaluation of postfix expression
    void evaluate(String exp){
        Stack<Integer> st = new Stack<>();
        for(int i = 0 ; i < exp.length() ; i++){
            char c = exp.charAt(i);
            if(Character.isDigit(c)){
                st.push(c-'0');
            }else{
                switch(c){
                    case '+' :
                        st.push(st.pop()+st.pop());
                        break;
                    case '-' : 
                        st.push(st.pop()-st.pop());
                        break;
                }
            }
        }
        System.out.println("Stack eveluated output - "+st.pop());
    }
    
    //reversing string
    void reverse(StringBuffer input){
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < input.length() ; i++){
            st.push(input.charAt(i));
        }
        System.out.println(st);
        for(int i=0;i<input.length();i++){
            char ch= st.pop();
            input.setCharAt(i,ch);
        }
        System.out.println(input);
    }
}

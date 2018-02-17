// next greater element
import java.util.*;
public class NGE{
    static int [] in = new int[]{1,4,7,5,4,3,9};
    public static void main(String [] args){
        NGE nge = new NGE();
        nge.findNgeBrute();
        nge.findNgeStack();
    }
    
    void findNgeBrute(){
        for(int i=0; i < in.length; i++){
            for(int j = i+1 ; j<in.length;j++){
                if(in[j]>in[i]){
                  //  System.out.println(in[i]+"---->"+in[j]);
                    break;

                }
            }
        }
    }
    void findNgeStack(){
        Stack<Integer> st = new Stack<>();
        st.push(in[0]);
        int next, element=0;
        for(int i = 1; i< in.length;i++){
            next = in[i];
            if(st.isEmpty()==false){
                element = st.pop();
                while(next > element){
                    System.out.println(element+"-->"+next);
                    if(st.isEmpty()==true){
                        break;
                    }
                    element = st.pop();
                }
                if(element>next){
                    st.push(element);
               }
            }
            st.push(next);
            
        }
        if(!st.isEmpty()){
            System.out.println(st.pop()+"--->"+"-1");
        }
    }
}

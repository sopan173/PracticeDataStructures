import java.util.*;
public class StockSpan{
    public static void main(String [] args){
        System.out.println("tset");
        StockSpan ss = new StockSpan();
        int [] price = new int[]{10,23,12,13,15,45,67,90,9};
        ss.getStockSpan(price);
        ss.getStockSpanBrute(price);
    }
    // brute force
    void getStockSpanBrute(int price[]){
        int S[] = new int[price.length];
        int j=0;
        for(int i= 0 ;i<price.length; i++){
            for(j = i-1; j>=0; j--){
                if(price[j]>price[i]){
                    break;
                }
            }
            S[i] = i-j;
        }
        System.out.println("Brute Solution - "+Arrays.toString(S));
    }
    // solving by stack
    void getStockSpan(int price[]){
        int S[] = new int[price.length];
        Stack<Integer> st = new Stack<>();
        S[0] = 1;
        st.push(0);
        for(int i = 1; i<price.length; i++){
            while(!st.isEmpty() && price[st.peek()] < price[i]){
                st.pop();
            }
            S[i] = st.isEmpty() ? i+1 : (i-st.peek());
            st.push(i);
        }
        System.out.println("Stack Solution - "+Arrays.toString(S));
    }
    
}


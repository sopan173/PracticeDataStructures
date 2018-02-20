mport java.util.*;
public class Queue{
    int front, rear, size;
    int arr[];
    int capacity ;
    public Queue(int cap){
        this.front = this.size = 0;
        this.rear = cap-1;
        this.arr = new int[cap];
        this.capacity = cap;
    }
    //checking full
    boolean isFull(Queue q){
        if(q.size ==q.capacity){
            return true;
        }
        return false;
    }
    
    //checking empty
    boolean isEmpty(Queue q){
        return q.size == 0;
    }
    //adding at rear position with remainder logic
    void enqueue(int data){
        if(isFull(this)){
            return;
        }
        this.rear = (this.rear+1)%this.capacity;
        this.arr[this.rear] = data;
        this.size++;
        System.out.println(Arrays.toString(this.arr));  

    }
   //removing from front end
    int dequeue(){
        if(isEmpty(this)){
            return 0;
        }
        this.size--;
        int data = this.arr[this.front];
        this.front++;
        return data;
    }
    
    public static void main(String [] args){
        Queue que = new Queue(10);
        que.enqueue(13);
        que.enqueue(33);
        que.enqueue(23);
        System.out.println(que.isEmpty(que));  
        System.out.println("dq = "+que.dequeue());
    }
}
    

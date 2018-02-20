public class QueueLL{
    QNode front = null, rear = null;
    class QNode{
        int data;
        QNode next;
        QNode(int d){
            this.data = d;
            this.next = null;
        }
    }
    
    //adding in queue
    void enqueue(int data){
        QNode temp = new QNode(data);
        if(this.front == null){
            this.front = this.rear = temp;
            return;
        }
        this.rear.next = temp;
        this.rear = temp;
    }
    
    // delete node
    QNode dequeue(){
        if(this.rear == null){
            return null;
        }
        QNode temp = this.front;
        this.front = this.front.next;
        return temp;
    }
    public static void main(String [] args){
        QueueLL ql = new QueueLL();
        ql.enqueue(10);
        QNode qn = ql.dequeue();
        System.out.println(qn.data);
        
    }
}

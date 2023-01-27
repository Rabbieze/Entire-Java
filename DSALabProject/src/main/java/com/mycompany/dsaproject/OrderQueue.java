os kpackage com.mycompany.dsaproject;

public class OrderQueue {
    Node head;
    Node tail;

    public void enqueue(int data){
        Node node=new Node(data);
        if(tail==null){
            head=node;
            tail=node;
        }
        else {
            tail.next=node;
            tail=node;
        }
        
    }


    public int dequeue() {
        if (head != null) {
            Node temp = head;
            head = head.next;
            if(head==null){
                tail=null;
            }
            return temp.data;

        }
        System.out.println("\nNO ORDER IN QUEUE AT THE MOMENT!");
        return -1;
    }
}

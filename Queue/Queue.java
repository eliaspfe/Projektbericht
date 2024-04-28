package Queue;

public class Queue {
    public Node head;
    public Node tail;


    public void enqueue(String value){
        Node node = new Node(value);
        if(isEmpty()){
            this.head = node;
            this.tail = node;
        } else {
            this.tail.next = node;
            this.tail = node;
        }
    }

    public String dequeue(){
        if(isEmpty()){
            return null;
        } else {
            Node currNode = this.head;
            this.head = this.head.next;
            currNode.next = null;
            if(isEmpty()){
                this.tail = null;
            }
            return currNode.value;
        }
    }

    public String pop() {
        if(isEmpty()){
            return null;
        } else {
            Node currHead = this.head;
            this.head = currHead.next;
            currHead.next = null;
            return currHead.value;
        }
    }


    public boolean isEmpty(){
        return head == null;
    }

    public static void main(String[] args) {
        Queue myMensa = new Queue();
        myMensa.enqueue("Steffen");
        myMensa.enqueue("Marianna");
        myMensa.enqueue("Mirco");
    }


}

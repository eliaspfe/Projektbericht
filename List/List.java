package List;

public class List {
    private int length;
    public Node head;
    public Node tail;

    public List() {
        this.length = 0;
        this.head = null;
        this.tail = null;
    }



    public void prepend(String value){
        Node node = new Node(value);
        length++;
        if(isEmpty()){
            this.head = node;
            this.tail = node;
        } else {
            node.next =  this.head;
            this.head.previous = node; 
            this.head = node; 
        }
    }



    public void append(String value){
        Node node = new Node(value);
        length++;
        if(isEmpty()){
            this.head = node;
            this.tail = node;
        } else {
            node.previous = this.tail;
            this.tail.next = node;
            this.tail = node;
        }
    }



    public void insertAt(int index, String value){
        if(index > length -1){
            return;
        }
        if(index == length){
            append(value);
            return;
        }
        if(index == 0){
            prepend(value);
            return;
        }
        Node curentNode = this.head;
        for(int i = 1; i <= index; i++){
            curentNode = curentNode.next;
        }
        Node newNode = new Node(value);
        newNode.next = curentNode;
        newNode.previous = curentNode.previous;
        newNode.previous.next = newNode;
        curentNode.previous = newNode;
    }


    public void remove(String value){
        Node currentNode = this.head;
        for (int i = 1; i < length; i++){
            if(currentNode.value.equals(value)){
                currentNode.next.previous = currentNode.previous;
                currentNode.previous.next = currentNode.next;
                currentNode.next = null;
                currentNode.previous = null;
                length--;
                return; // = break;
            }
            currentNode = currentNode.next;
        }
    }





    public int getLength(){
        return length;
    }

    private boolean isEmpty(){
        return head == null;
    }

    public static void main(String[] args) {
        List myList = new List();
        myList.prepend("Steffen");
        myList.prepend("Marianna");
        myList.prepend("Mirco");
    }
}

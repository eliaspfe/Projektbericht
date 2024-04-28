package Stack;

public class Stack {
	//head zeigt immer auf das oberste Objekt
    public Node head;

public void push(String value){
	Node newNode = new Node();
	newNode.value = value;
	if(isEmpty()){
		this.head = newNode;
	} else {
		newNode.next = this.head;
		this.head = newNode;
	}
}


public String peek(){
	if(isEmpty()){
		return null;
	} else {
		return this.head.value;
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
	Stack myStudentStack = new Stack();
	myStudentStack.push("Steffen");
	myStudentStack.push("Marianna");
	myStudentStack.push("Mirco");
	System.out.println(myStudentStack.pop());
}



}



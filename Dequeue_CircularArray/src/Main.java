//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Create a Dequeue with size 5
        Dequeue d = new Dequeue(5);

        // Test enqueue operations
        System.out.println("Testing Enqueue Front and Rear:");
        d.enqueueRear(10); // Add 10 to rear
        d.enqueueRear(20); // Add 20 to rear
        d.enqueueFront(5); // Add 5 to front
        d.enqueueFront(2); // Add 2 to front
        d.enqueueRear(30); // Add 30 to rear (Queue becomes full)
        d.display(); // Expected: 2 5 10 20 30

        // Test overflow condition
        System.out.println("\nTesting Overflow:");
        d.enqueueRear(40); // Should display "Queue is full"
        d.enqueueFront(1); // Should display "Queue is full"

        // Test dequeue operations
        System.out.println("\nTesting Dequeue Front and Rear:");
        d.dequeueFront(); // Remove 2 from front
        d.dequeueRear();  // Remove 30 from rear
        d.display(); // Expected: 5 10 20

        // Test edge conditions (wrap-around)
        System.out.println("\nTesting Wrap-Around:");
        d.enqueueFront(1); // Add 1 to front
        d.enqueueRear(25); // Add 25 to rear
        d.display(); // Expected: 1 5 10 20 25

        // Test overflow with wrap-around
        d.enqueueRear(35); // Should display "Queue is full"

        // Test underflow condition
        System.out.println("\nTesting Underflow:");
        d.dequeueFront(); // Remove 1
        d.dequeueFront(); // Remove 5
        d.dequeueFront(); // Remove 10
        d.dequeueFront(); // Remove 20
        d.dequeueFront(); // Remove 25 (Queue becomes empty)
        d.dequeueFront(); // Should display "Queue is empty"

        // Test getFront and getRear on empty queue
        System.out.println("\nTesting Get Front and Rear on Empty Queue:");
        d.getFront(); // Should display "Queue is empty"
        d.getRear();  // Should display "Queue is empty"

        // Test reusing the queue after emptying
        System.out.println("\nTesting Reuse of Queue After Emptying:");
        d.enqueueRear(100);
        d.enqueueFront(50);
        d.display(); // Expected: 50 100
        d.getFront(); // Expected: 50
        d.getRear();  // Expected: 100
    }
}

class Dequeue{
    int front,rear;
    int dequeue[];
    int size;
    Dequeue(int size){
        this.size=size;
        front=rear=-1;
        dequeue=new int[size];
    }
    public boolean isFull() {
        return (front == 0 && rear == size - 1) || (front == rear + 1);
    }
    public boolean isEmpty() {
        return front == -1 && rear == -1;
    }

    public void enqueueFront(int data){ //o(1)
        if(isFull()) System.out.println("Queue is full");
        else if(isEmpty()){
            front=rear=0;
        }
        else if(front==0){
            front=size-1;
        }
        else{
           front--;
        }
        dequeue[front]=data;
    }
    public void enqueueRear(int data){ //o(1)
        if(isFull()) System.out.println("Queue is full");
        else if(isEmpty()){
            front=rear=0;
        }
        else if(rear==size-1){
            rear=0;
        }
        else{
           rear++;
        }
        dequeue[rear]=data;
    }
    public void dequeueFront(){ //o(1)
        if(isEmpty()){ System.out.println("Queue is empty");
            return;}
        System.out.println("Deleted element is: " + dequeue[front]);
         if(front==rear){//first elemnt
            front=rear=-1;
        }
        else if(front==size-1){
            front=0;
        }
        else{
            front++;
        }
    }
    public void dequeueRear(){ //o(1)
        if(isEmpty()){ System.out.println("Queue is empty");
            return;}
        System.out.println("Deleted element is: "+dequeue[rear]);
        if(front==rear){//first elemnt
            front=rear=-1;
        }
        else if(rear==0){
            rear=size-1;
        }
        else{
            rear--;
        }
    }
    public void display(){ //o(n)
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        int i=front;
        while(i!=rear){
            System.out.print(dequeue[i]+" ");
            i=(i+1)%size;
        }
        System.out.println(dequeue[i]);
    }
    public void getFront(){ //o(1)
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.println(dequeue[front]);
    }
    public void getRear(){ //o(1)
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.println(dequeue[rear]);
    }

}
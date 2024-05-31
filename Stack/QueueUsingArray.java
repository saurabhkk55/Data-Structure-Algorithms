class CustomQueue {
    int[] queue_arr = new int[5];
    int front = 0, rear = 0, cnt = 0, n = queue_arr.length;

    public void push(int elem) {
        if(cnt < n) {
            queue_arr[rear%n] = elem;
            rear++;
            cnt++;
            System.out.printf("Inserted element: %d\n", elem);
        } else {
            System.out.println("ERROR: Overflow queue: Queue is already fulled");
        }
    }

    public int pop() {
        int popped_elem = -1;
        if(front != rear) {
            popped_elem = queue_arr[front % n];
            System.out.println("Popped element: "+queue_arr[front % n]);
            front++;
            cnt--;
        } else {
            System.out.println("ERROR: Underflow queue: Queue is empty");
        }
        return popped_elem;
    }

    public void display() {
        System.out.print("Queue Elements: ");
        if(front == rear) System.out.print("Queue is empty");
        else {
            for(int i=front; i<=rear-1; i++) {
                System.out.print(queue_arr[i%n]+" ");
            }
            System.out.println();
        }
    }

    public void size() {
        int size = cnt;
        System.out.println("Queue size: "+size);
    }
}

public class QueueUsingArray {
    public static void main(String[] args) {
        CustomQueue obj = new CustomQueue();
        obj.push(10);
        obj.push(20);
        obj.push(30);
        obj.push(40);
        obj.push(50);
        obj.push(60);
        obj.push(70);
        obj.display();
        obj.pop();
        obj.pop();
        obj.push(80);
        obj.push(90);
        obj.display();
        obj.size();
        obj.pop();
        obj.pop();
        obj.pop();
        obj.pop();
        obj.pop();
        obj.pop();
        obj.display();
    }
}

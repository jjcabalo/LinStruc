public class Queues {
    private int[] queueArray;
    private int front, rear, size;

    public Queues(int size) {
        this.size = size;
        queueArray = new int[size];
        front = 0;
        rear = 0;
    }

    public String enqueue(int item) {
        if (rear < size) {
            queueArray[rear] = item;
            rear++;
            return "Enqueued: " + item;
        } else {
            return "Queue Overflow";
        }
    }

    public String dequeue() {
        if (front < rear) {
            int dequeued = queueArray[front];
            queueArray[front] = 0;
            front++;
            return "Dequeued: " + dequeued;
        } else {
            return "Queue Underflow";
        }
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return rear == size;
    }

    public String peek() {
        if (front < rear) {
            return "Front: " + queueArray[front];
        } else {
            return "Queue is empty";
        }
    }

    public void clear() {
        for (int i = 0; i < queueArray.length; i++) {
            queueArray[i] = 0;
        }
        front = 0;
        rear = 0;
    }

    public int[] getQueueArray() {
        return queueArray;
    }
}

public class Stacks {
    private int[] stackArray;
    private int top;

    public Stacks(int size) {
        stackArray = new int[size];
        top = size - 1;
    }

    public String push(int item) {
        if (top > -1) {
            stackArray[top] = item;
            top--;
            return "Pushed: " + item;
        } else {
            return "Stack Overflow";
        }
    }

    public String pop() {
        if (top < stackArray.length - 1) {
            top++;
            int popped = stackArray[top];
            stackArray[top] = 0;
            return "Popped: " + popped;
        } else {
            return "Stack Underflow";
        }
    }

    public boolean isEmpty() {
        return top == stackArray.length - 1;
    }

    public boolean isFull() {
        return top == -1;
    }

    public String peek() {
        if (top < stackArray.length - 1) {
            return "Peek: " + stackArray[top + 1];
        } else {
            return "Stack is empty";
        }
    }

    public void clear() {
        for (int i = 0; i < stackArray.length; i++) {
            stackArray[i] = 0;
        }
        top = stackArray.length - 1;
    }

    public int[] getStackArray() {
        return stackArray;
    }
}

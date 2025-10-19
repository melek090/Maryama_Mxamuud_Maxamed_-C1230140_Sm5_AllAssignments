
import java.util.Arrays;
import java.util.EmptyStackException;

public class ArrayBasedStack <T>{

    private static final int BASE_LIMIT = 3;
    private int top_marker;
    private T[] storage_box;

    // No arg constructor
    ArrayBasedStack() {
        this(BASE_LIMIT);
    }

    // parametrized constructor
    ArrayBasedStack(int start_capacity) {
        top_marker = 0;
        storage_box = (T[]) (new Object[start_capacity]);
    }

    // wuxuu soo celinaa tirada elemts hadda stack ku jira
    public int size() {
        return top_marker;
    }

    // Push method
    public void push(T new_entry) {
        // exapan tthe array if full using alreday created mthod expan()
        if (size() == storage_box.length) {
            System.out.println("Stack is full, expanding array...");
            Expand();
        }
        storage_box[top_marker] = new_entry;
        top_marker++;


        // Shows status indication
        System.out.println(new_entry + " pushed to stack. Current size: " + top_marker);
    }

    // Pop method
    public T pop() {
        //  Throws an exception if stack is empty............
        if (isEmpty()) {
            System.out.println("Stack is empty! Cannot pop.");
            throw new EmptyStackException();
        } else {
            T taken_value = storage_box[--top_marker];
            storage_box[top_marker] = null;
            System.out.println(taken_value + " popped from stack. Current size: " + top_marker);
            return taken_value;
        }
    }

    // Peek method
    public T peek() {
        //  Throws an  exception if stack is empty.........
        if (isEmpty()) {
            System.out.println("Stack is empty! Cannot peek.");
            throw new EmptyStackException();
        } else {
            T peeked_value = storage_box[top_marker - 1];
            System.out.println("Top element is: " + peeked_value);
            return peeked_value;
        }
    }

    // Checks if the stack is emty or not
    public boolean isEmpty() {
        return top_marker == 0;
    }

    // Expand metho
    public void Expand() {
        storage_box = Arrays.copyOf(storage_box, storage_box.length * 3);
        System.out.println("Stack expanded to size: " + storage_box.length);
    }

    // Display all elements
    public void display() {
        // hrow an exception if stack is empty
        if (isEmpty()) {
            System.out.println("Stack is empty! Nothing to display.");
            throw new EmptyStackException();
        } else {
            System.out.println("Items inside the stack:");
            for (int i = 0; i < top_marker; i++)
                System.out.println(storage_box[i] + " ");
            System.out.println();
        }
    }






// MAIN METH
    public static void main(String[] args) {


            ArrayBasedStack<Integer> stack = new ArrayBasedStack<>(3);


            stack.push(10);


            stack.push(20);


            stack.push(30);


            stack.push(60); /// trigers to expand the array


            stack.peek();

           // poping elements
            stack.pop();

            stack.pop();


            stack.pop();

            stack.pop();


            stack.pop();  // throws an exception here


            stack.display();
        }
    }




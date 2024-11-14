import java.util.Scanner;

public class GroupACT_StackQueue {
    public static void main(String[] args) {
        Scanner user_input = new Scanner(System.in);

        System.out.print("ENTER ARRAY SIZE: ");
        int size = user_input.nextInt();

        int[] array = new int[size];
        int top = -1, front = -1, rear = -1;

        while (true) {
            System.out.println("\nCHOOSE AN OPTION:");
            System.out.println("[1] STACK | [2] QUEUE | [3] EXIT\n");
            System.out.print("Enter your choice: ");
            int choice = user_input.nextInt();

            switch (choice) {
                case 1:
                    while (true) {
                        System.out.println("\nStack Options:");
                        System.out.println("[1] PUSH | [2] POP | [3] PEEK | [4] Check if FULL | [5] Check if EMPTY | [6] BACK TO MAIN OPTIONS\n");
                        System.out.print("Enter your choice: ");
                        int stackChoice = user_input.nextInt();

                        switch (stackChoice) {
                            case 1: // PUSH
                                if (top == size - 1) {
                                    System.out.println("STACK OVERFLOW. Unable to PUSH.");
                                } else {
                                    System.out.print("Enter element to push: ");
                                    int element = user_input.nextInt();
                                    array[++top] = element;
                                    System.out.println("Pushed: " + element);
                                    display_stack(array, top);
                                }
                                break;
                            case 2: // POP
                                if (top == -1) {
                                    System.out.println("STACK UNDERFLOW. Unable to POP.");
                                } else {
                                    System.out.println("Popped: " + array[top--]);
                                    display_stack(array, top);
                                }
                                break;
                            case 3: // PEEK
                                if (top == -1) {
                                    System.out.println("Stack is empty. Nothing to PEEK.");
                                } else {
                                    System.out.println("Top element: " + array[top]);
                                    display_stack(array, top);
                                }
                                break;
                            case 4: // IsFull
                                if (top == size - 1) {
                                    System.out.println("Stack is full.");
                                    display_stack(array, top);
                                } else {
                                    System.out.println("Stack is not full.");
                                    display_stack(array, top);
                                }
                                break;

                            case 5: // IsEmpty
                                if (top == -1) {
                                    System.out.println("Stack is empty.");
                                    display_stack(array, top);
                                } else {
                                    System.out.println("Stack is not empty.");
                                    display_stack(array, top);
                                }
                                break;

                            case 6: // EXIT | RETURN TO MAIN
                                break;
                            default:
                                System.out.println("Invalid Input.");
                        }
                        if (stackChoice == 6) break;
                    }
                    break;

                case 2:
                    while (true) {
                        System.out.println("\nQueue Options:");
                        System.out.println("[1] ENQUEUE | [2] DEQUEUE | [3] PEEK | [4] Check if FULL | [5] Check if EMPTY | [6] EXIT\n");
                        System.out.print("Enter your choice: ");
                        int queueChoice = user_input.nextInt();

                        switch (queueChoice) {
                            case 1: // ENQUEUE
                                if ((rear + 1) % size == front) {
                                    System.out.println("QUEUE OVERFLOW, unable to add more elements.");
                                } else {
                                    System.out.print("Enter element to queue: ");
                                    int value = user_input.nextInt();
                                    if (front == -1) front = 0;
                                    rear = (rear + 1) % size;
                                    array[rear] = value;
                                    System.out.println("Enqueued: " + value);
                                    display_queue(array, front, rear, size);
                                }
                                break;
                            case 2: // DEQUEUE
                                if (front == -1) {
                                    System.out.println("QUEUE UNDERFLOW.");
                                } else {
                                    System.out.println("Dequeueing the first element: " + array[front]);
                                    if (front == rear) {
                                        front = -1;
                                        rear = -1;
                                    } else {
                                        front = (front + 1) % size;
                                    }
                                    display_queue(array, front, rear, size);
                                }
                                break;
                            case 3: // PEEK
                                if (front == -1) {
                                    System.out.println("Queue is empty.");
                                    display_queue(array, front, rear, size);
                                } else {
                                    System.out.println("Front element: " + array[front]);
                                    display_queue(array, front, rear, size);
                                }
                                break;
                            case 4: //IsFull
                            	if ((rear + 1) % size == front) {
                                    System.out.println("Queue is full.");
                                    display_queue(array, front, rear, size);
                                } else {
                                    System.out.println("Queue is not full.");
                                    display_queue(array, front, rear, size);
                                }
                                break;
                            case 5: //IsEmpty
                            	if (front == -1) {
                                    System.out.println("Queue is empty.");
                                    display_queue(array, front, rear, size);
                                } else {
                                    System.out.println("Queue is not empty.");
                                    display_queue(array, front, rear, size);
                                }
                                break;
                            case 6: // EXIT | RETURN TO MAIN
                                break;
                            default:
                                System.out.println("Invalid Input.");
                        }
                        if (queueChoice == 6) break;
                    }
                    break;

                case 3:
                    System.out.println("Exiting program...");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid Input.");
            }

        }
    }

    public static void display_stack(int[] array, int top) {
        if (top == -1) {
            System.out.println("\nNo elements in stack.");
        } else {
            System.out.println("\nStack elements: ");
            for (int i = top; i >= 0; i--) {
                System.out.println(array[i]);
            }
            System.out.println();
        }
    }

    public static void display_queue(int[] array, int front, int rear, int size) {
        if (front == -1) {
            System.out.println("No elements to display in queue.");
        } else {
            System.out.print("Queue elements: ");
            int i = front;
            while (true) {
                System.out.print(array[i] + " ");
                if (i == rear) break;
                i = (i + 1) % size;
            }
            System.out.println();
        }
    }
}

import java.util.Scanner;

public class GroupACT_StackQueue {
    public static void main(String[] args) {
        Scanner user_input = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int size = user_input.nextInt();

        int[] array = new int[size];
        int front = -1, rear = -1;

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("[1] STACK | [2] QUEUE | [3] EXIT\n");
            System.out.print("Enter your choice: ");
            int choice = user_input.nextInt();

            switch (choice) {
                case 1:
                    while (true) {
                        System.out.println("\nStack Options:");
                        System.out.println("[1] PUSH | [2] POP | [3] PEEK | [4] Check if FULL | [5] Check if EMPTY | [6] EXIT\n");
                        System.out.print("Enter your choice: ");
                        int stackChoice = user_input.nextInt();

                        switch (stackChoice) {
                            case 1: //PUSH
                                if ((rear + 1) % size == front) {
                                    System.out.println("Stack overflow. Cannot push.");
                                } else {
                                    System.out.print("Enter element to push: ");
                                    int element = user_input.nextInt();
                                    if (front == -1) front = 0;
                                    rear = (rear + 1) % size;
                                    array[rear] = element;
                                    System.out.println("Pushed: " + element);
                                    display(array, front, rear, size);
                                }
                                break;
                            case 2: //POP
                               if (front == -1) {
                                    System.out.println("Stack underflow. Cannot pop.");
                                } else {
                                    System.out.println("Popped: " + array[rear]);
                                    if (front == rear) {
                                        front = rear = -1;
                                    } else {
                                        rear = (rear - 1 + size) % size;
                                    }
                                    display(array, front, rear, size);
                                }
                                break;
                                
                            case 3: //PEEK
                                    if (front == -1) {
                                    System.out.println("Stack is empty. Nothing to peek.");
                                } else {
                                    System.out.println("Top element: " + array[rear]);
                                    display(array, front, rear, size);
                                }
                                break;
                                
                            case 4: //IsFull
                                if ((rear + 1) % size == front) {
                                    System.out.println("Stack is full.");
                                } else {
                                    System.out.println("Stack is not full.");
                                }
                                break;
                            case 5: //IsEmpty
                                if (front == -1) {
                                    System.out.println("Stack is empty.");
                                } else {
                                    System.out.println("Stack is not empty.");
                                }
                                break;
                            case 6: //EXIT | RETURN TO MAIN
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
                            case 1: //ENQUEUE
                                if ((rear + 1) % size == front) {
                                    System.out.print("Queue is full, cannot add more elements.");
                                }

                                else {
                                    System.out.print("Enter element to queue: ");
                                    int value = user_input.nextInt();
                                        if (front == -1) front = 0;
                                        rear = (rear + 1) % size;
                                        array[rear] = value;
                                            System.out.println("Enqueued: " + value);
                                            display (array, front, rear, size);
                                }
                                break;
                           case 2: // DEQUEUE
                            if (front == -1) {
                                System.out.println("Queue is empty.");
                            } else {
                                System.out.println("Dequeueing the first element: " + array[front]);
                        
                                
                                if (front == rear) { 
                                    
                                    front = -1;
                                    rear = -1;
                                } else {
                                    front = (front + 1) % size; 
                                }
                                
                                display(array, front, rear, size);
                            }
                            break;

                            case 3: //PEEK
                                if (front == -1) {
                                    System.out.println("Queue is empty.");
                                } else {
                                    System.out.println("Front element: " + array[front]);
                                }
                                break;
                            case 4: //IsFull
                            	if ((rear + 1) % size == front) {
                                    System.out.println("Queue is full.");
                                } else {
                                    System.out.println("Queue is not full.");
                                }
                                break;
                            case 5: //IsEmpty
                            	if (front == -1) {
                                    System.out.println("Queue is empty.");
                                } else {
                                    System.out.println("Queue is not empty.");
                                }
                                break;
                            case 6: //EXIT | RETURN TO MAIN
                                break;
                            default:
                                System.out.println("Invalid Input.");
                        }
                        if (queueChoice == 6) break;
                    }
                    break;

                case 3:
                    System.out.println("Exiting program.");
                    System.exit(choice);
                    break;

                default:
                    System.out.println("Invalid Input.");
            }

        }
    }

    public static void display(int[] array, int front, int rear, int size) {
        if (front == -1) {
            System.out.println("No elements to display.");
        } else {
            System.out.print("Elements: ");
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

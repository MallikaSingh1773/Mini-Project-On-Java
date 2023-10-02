import java.util.ArrayList;
import java.util.Scanner;

class Task {
    private String description;
    private boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getDescription() {
        return description;
    }

    public boolean isDone() {
        return isDone;
    }

    public void markAsDone() {
        isDone = true;
    }

    @Override
    public String toString() {
        return "[" + (isDone ? "X" : " ") + "] " + description;
    }
}

class TodoList {
    private ArrayList<Task> tasks = new ArrayList<>();

    public void addTask(String description) {
        Task task = new Task(description);
        tasks.add(task);
    }

    public void markTaskAsDone(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).markAsDone();
        }
    }

    public void listTasks() {
        System.out.println("To-Do List:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TodoList todoList = new TodoList();

        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1. Add a task");
            System.out.println("2. Mark a task as done");
            System.out.println("3. List tasks");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    todoList.addTask(description);
                    System.out.println("Task added!");
                    break;
                case 2:
                    System.out.print("Enter the task number to mark as done: ");
                    int taskIndex = scanner.nextInt();
                    scanner.nextLine();
                    todoList.markTaskAsDone(taskIndex - 1);
                    break;
                case 3:
                    todoList.listTasks();
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

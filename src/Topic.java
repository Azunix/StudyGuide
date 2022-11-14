import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;
public class Topic {
//    The Topic class should define a topic to be on the study guide
//    (name, description and a list of tasks related to the topic) and allow
//    the user to print a topic in a well formatted way. topics should also define
//    a method that allows for a user to add a new task to the list of tasks.



    String input;
    Scanner scan = new Scanner(System.in);
    String name;
    String description;
    ArrayList<String> tasks = new ArrayList<>();
    // https://stackoverflow.com/questions/3804591/efficient-method-to-generate-uuid-string-in-java-uuid-randomuuid-tostring-w
    final String uuid;
    public Topic(String name, String description){
        this.name = name;
        this.description = description;
        this.uuid = UUID.randomUUID().toString().replace("-", "");
    }

    public void readTasks(){
        for(String task : tasks){
            System.out.println(task);
        }
    }

    public void addTask(){
        System.out.println("Enter new task: ");
        input = scan.nextLine();
        tasks.add(input);
        System.out.println(input + " has been added to the " + name + " topic.");
    }

    public void setName() {
        System.out.println("Input new title: ");
        this.name = scan.nextLine();
    }

    public void setDescription() {
        System.out.println("Input new description: ");
        this.description = scan.nextLine();
    }

    public void setTasks(ArrayList<String> tasks) {
        this.tasks = tasks;
    }
    public void updateTask(){
        System.out.println("Current tasks: ");
        readTasks();
        System.out.println("Enter the task to update : ");
        input = scan.nextLine();
        boolean found = false;
        for(int i=0; i<tasks.size(); i++){
            if(tasks.get(i).equalsIgnoreCase(input)){
                System.out.println("What should we change " + tasks.get(i) + " to?");
                input = scan.nextLine();
                tasks.set(i, input);
                System.out.println("Updated!");
                found = true;
                break;
            }
        }
        if(!found){
            System.out.println("'" + input + "' wasn't found!");
            updateTask();
        }
    }
    public void deleteTask(){
        System.out.println("Current tasks: ");
        readTasks();
        System.out.println("Enter the task to delete : ");
        input = scan.nextLine();
        boolean found = false;
        for(int i=0; i<tasks.size(); i++){
            if(tasks.get(i).equalsIgnoreCase(input)){
                tasks.remove(i);
                System.out.println(input + " has been removed!");
                found = true;
                break;
            }
        }
        if(!found){
            System.out.println(input + " wasn't found!");
            deleteTask();
        }
    }

}

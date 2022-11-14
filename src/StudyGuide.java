
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.UUID;
public class StudyGuide {
    HashMap<String, Topic> topics = new HashMap<>();

//    public StudyGuide(){
//
//    }

    public void createTopic(String name, String description){
        Topic topic = new Topic(name, description);
        Scanner scan = new Scanner(System.in);
        System.out.println("Add tasks, enter 0 to end: ");
        int count = 1 + topic.tasks.size();
        boolean anotherTask;
        do {
            anotherTask = true;
            System.out.println("Task No. " + count + ":");
            String input = scan.nextLine();
            if(input.equalsIgnoreCase("0")){
                anotherTask = false;
            } else if(input.equalsIgnoreCase("")){
                System.out.println("Empty inputs not allowed!");
                continue;
            }else {
                topic.tasks.add(input);
                 count++;
            }

        } while (anotherTask);
        topics.put(topic.uuid, topic);

    }

    public void readTopics(){
        if(topics.isEmpty()){
            System.out.println("You have no topics to display!");
        } else {
            System.out.println("Topics: ");
//            String tasks;
            topics.keySet().forEach(key -> {
                String tasks = "";
                System.out.println("--------Name: " + topics.get(key).name);
                System.out.println("--------Description " + topics.get(key).description);
                int count = 0;
                for(int i=0;i<topics.get(key).tasks.size(); i++){
                    tasks += (" " + topics.get(key).tasks.get(i));
                    if(i<topics.get(key).tasks.size()-1){
                        tasks+=",";
                    }
                }
                System.out.println("--------Tasks: " + tasks);
                System.out.println("--------UUID: " + topics.get(key).uuid);
                System.out.println("");
            });
        }

    }

    public void viewIds(){
        for(String key : topics.keySet()){
            System.out.println("Topic " + topics.get(key).name + " ID: " + topics.get(key).uuid);
        }
    }

    public void updateTopic() {
        Scanner scan = new Scanner(System.in);
        viewIds();
        System.out.println("Input the id for the topic: ");
        String id = scan.nextLine();
        if (topics.containsKey(id)) {
            Topic topic = topics.get(id);
            System.out.println("Which property do we change? ");
            System.out.println("(title, description, tasks)");
            String input = scan.nextLine();

            while (!input.equalsIgnoreCase("title") && !input.equalsIgnoreCase("description") && !input.equalsIgnoreCase("tasks")) {
                System.out.println("Not a valid option, enter one of the following (title, description, tasks)");
                input = scan.nextLine();
            }
            if (input.equalsIgnoreCase("title")) {
                topic.setName();
            } else if (input.equalsIgnoreCase("description")) {
                topic.setDescription();
            } else if (input.equalsIgnoreCase("tasks")) {
                System.out.println("Enter 'A' to add a task, 'U' to update an existing task, or 'D' to delete a task");
                input = scan.nextLine();
                if (input.equalsIgnoreCase("A")) {
                    topic.addTask();
                } else if (input.equalsIgnoreCase("U")) {
                    topic.updateTask();
                } else if (input.equalsIgnoreCase("D")) {
                    topic.deleteTask();
                }
            }
        }
    }

    public void deleteTopic(){
        viewIds();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter topic id to delete: ");
        String id = scan.nextLine();
        if(topics.containsKey(id)){
            topics.remove(id);
        } else {
            System.out.println("Not a valid id");
            deleteTopic();
        }
//        for(int i=0; i< topics.size(); i++){
//            if(topics.get(i).uuid == id){
//
//                found = true;
//                break;
//            }
//        }
    }
//
//    The StudyGuide class will be a manager of the Topic data it should contain a
//        list of all topics and define CRUD methods for someone to create, read,
//    update, and delete topics. When users create or update a Topic they should
//    also be prompted to create or update tasks associated with that Topic.
//    The Menu class will be a user interface that creates a simple loop prompting
//    the user for input (C, R, U, D, Q) to create a new topic on the study guide,
//    read all the topics on the study guide, update a topic on the study guide, delete
//    a topic on the study guide or quit the program.
//    Your program should handle input from the user in a logical way meaning if the
//    user doesn't type a valid input, your program  should handle that error properly
//    by printing a message to the user and reprompting them for correct input.
}

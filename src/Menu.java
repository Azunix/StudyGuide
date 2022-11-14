import java.util.Scanner;

public class Menu {
static void Runtime(){
    StudyGuide myGuide = new StudyGuide();
    boolean again = true;



    while(again){
        System.out.println("Commands - C R U D Q");
        System.out.println("Enter a command: ");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        switch(input.toUpperCase()){
            case "C":
                System.out.println("Enter title: ");
                String title = scan.nextLine();
                System.out.println("Enter description: ");
                String description = scan.nextLine();
                myGuide.createTopic(title, description);
                System.out.println("Created " + title);
                break;
            case "R":
                myGuide.readTopics();
                break;
            case "U":
                myGuide.updateTopic();
                break;
            case "D":
                myGuide.readTopics();
                myGuide.deleteTopic();
                break;
            case "Q":
                System.out.println("Goodbye!");
                again = false;
                break;
            default:
                System.out.println("Not a valid option");
                break;
        }
    }

}

    public static void main(String[] args) {
        Runtime();
    }
}

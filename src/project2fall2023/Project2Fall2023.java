package project2fall2023;
import java.util.Scanner;
/**
 *  Main file for Project2Fall2023
 * @@author Aron Kabai-Tokes
 */
public class Project2Fall2023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // 1. Add "Object" to bag. Ask the user to enter attributes, then add
        // obj to linked list
        Scanner scanner = new Scanner(System.in);
        
        SinglyLinkedList<Container> itemList = new SinglyLinkedList<>();
        
        final String EXIT = "X";
        String stringInput = "";
        
        while(!stringInput.equalsIgnoreCase(EXIT)) {
            
            System.out.println("\ncreation menu");
            if (itemList.getSize() != 0) {
                System.out.println("current list: ");
                // printing out the list
                printListContents(itemList);
            }

            System.out.println("Options");
            System.out.println("A. Add object");
            System.out.println("R. Remove object(s)");
            System.out.println("F. Find object");
            System.out.println("D. Display object(s)");
            System.out.println("X. exit");
            System.out.print("Enter Choice: ");

            stringInput = scanner.nextLine();

            switch(stringInput.toUpperCase()) {
                case "A" -> bottleOption(itemList, scanner);
                case "R" -> removeObjectOption(itemList, scanner);
                case "F" -> findObjectOption(itemList, scanner);
                case "D" -> printListContents(itemList);
                case "X" -> { break; }
                default -> System.out.println("not an option!");
            }
        }
    }
    
    /**
    * Allows the user to create a Container object and add it to the provided SinglyLinkedList.
    *
    * @param itemList the SinglyLinkedList of objects to which the newly created Container object will be added
    * @param scanner  the Scanner object used to receive user input for container attributes
    */
    public static void containerOption(SinglyLinkedList<Container> itemList, Scanner scanner) {
       
        boolean exit = false;
        String name;
        int size;

        while(!exit) {

            System.out.println("\n Create your container");
            System.out.println("Attributes:\nname\nstorage");
            System.out.println("\nWhat would be the name of the container?");
            System.out.print("name: ");
            name = scanner.nextLine();
            System.out.println("\nWhat would be the size of the container?");
            System.out.print("size: ");
            size = scanner.nextInt();
            scanner.nextLine();

            if (size == 0) {
                System.out.println("cannot create a container with no size!");
                continue;
            } else if (size < 0) {
                System.out.println("cannot create a container with negative size!");
                continue;
            }

            // adding container to the list
            itemList.add(new Container(name, size));
            exit = true;
        }
    }
    
    /**
    * Allows the user to create a Bottle object and add it to the provided SinglyLinkedList of Container objects.
    *
    * @param itemList the SinglyLinkedList of Container objects to which the newly created Bottle object will be added
    * @param scanner  the Scanner object used to receive user input for bottle attributes
    */
    public static void bottleOption(SinglyLinkedList<Container> itemList, Scanner scanner) {
        
        String name;
        int size;
        String color;
        int temp;
        boolean exit = false;
        while(!exit) {
            
            System.out.println("\n Create your bottle");
            System.out.println("Attributes:\nname\nsize\ncolor\ntype");
            System.out.println("\nWhat would be the name of the bottle?");
            System.out.print("name: ");
            name = scanner.nextLine();
            
            System.out.println("What would be the storage size of the bottle in oz");
            System.out.print("storage amount: ");
            size = scanner.nextInt();
            scanner.nextLine();
            
            if (size == 0) {
                System.out.println("cannot have a storage size of 0!");
                continue;
            } else if (size < 0) {
                System.out.println("cannot have a negative storage size!");
                continue;
            }
            
            System.out.println("What would the color be?");
            System.out.print("color: ");
            color = scanner.nextLine();
            
            System.out.println("What would the temperature of its contents be in Celcius?");
            System.out.print("temp(C): ");
            temp = scanner.nextInt();
            scanner.nextLine();
            
            // adding a bottle to the list
            itemList.add(new Bottle(name, size, color, temp));
            exit = true;
        }
        
    }
    
    /**
    * Allows the user to remove an object from the provided SinglyLinkedList of Container objects based on specified attributes.
    * The method prompts the user for the attributes of the object to be removed and removes the matching object if found.
    * If the list is empty, it displays a message indicating that there is nothing to remove.
    *
    * @param itemList the SinglyLinkedList of Container objects from which the user wants to remove an object
    * @param scanner  the Scanner object used to receive user input for the attributes of the object to be removed
    */
    public static void removeObjectOption(SinglyLinkedList<Container> itemList, Scanner scanner) {
        
        String name;
        int size;
        String color;
        int temp;
        boolean exit = false;
        
        if (itemList.getSize() == 0) {
            System.out.println("there is nothing to remove!");
            return;
        }
        while(!exit) {
            System.out.println("Removing an object");
            System.out.println("do you want to exit now?");
            System.out.print("Y/N: ");
            name = scanner.nextLine();
            if (name.equalsIgnoreCase("y")) {
                return;
            }
            System.out.println("Type the attributes of the object you wish to remove");
            System.out.println("All words are case sensitive!");
            printListContents(itemList);
            
            System.out.print("\nname: ");
            name = scanner.nextLine();
            
            System.out.print("size: ");
            size = scanner.nextInt();
            scanner.nextLine();
            
            System.out.print("color[enter to skip]: ");
            color = scanner.nextLine();
            
            if (color.isEmpty()) {
                Container removeContainer = new Container(name, size);
                if (itemList.remove(removeContainer)) {
                    System.out.println("object removed!");
                } else System.out.println("object could not be removed!");
                
                return;
            }
            
            System.out.print("temp: ");
            temp = scanner.nextInt();
            scanner.nextLine();
            
            Bottle removeBottle = new Bottle(name, size, color, temp);
            if (itemList.remove(removeBottle)) {
                System.out.println("object removed!");
            } else System.out.println("object could not be removed!");
            
            exit = true;
        }
    }
   
    /**
    * Allows the user to find an object within the provided SinglyLinkedList of Container objects based on specified attributes.
    * The method prompts the user to input the attributes of the object to be found and checks if a matching object exists.
    * If the list is empty, it displays a message indicating that there is nothing to find.
    *
    * @param itemList the SinglyLinkedList of Container objects in which the user wants to find an object
    * @param scanner  the Scanner object used to receive user input for the attributes of the object to be found
    */
    public static void findObjectOption(SinglyLinkedList<Container> itemList, Scanner scanner) {
        String name;
        int size;
        String color;
        int temp;
        boolean exit = false;
        
        if (itemList.getSize() == 0) {
            System.out.println("there is nothing to find!");
            return;
        }
        
        while(!exit) {
            System.out.println("\nFinding an object");
            System.out.println("enter attributes of an object you want to find");
            System.out.println("All words are case sensitive!");
            
            System.out.print("\nname: ");
            name = scanner.nextLine();
            
            System.out.print("size: ");
            size = scanner.nextInt();
            scanner.nextLine();
            
            System.out.print("color[enter to skip]: ");
            color = scanner.nextLine();
            
            if (color.isEmpty()) {
                Container findContainer = new Container(name, size);
                if (itemList.exists(findContainer)) {
                    System.out.println("object found!");
                } else System.out.println("object could not be found!");
                
                exit = true;
            } else {
                
                System.out.print("temp: ");
                temp = scanner.nextInt();
                scanner.nextLine();

                Bottle removeBottle = new Bottle(name, size, color, temp);
                if (itemList.exists(removeBottle)) {
                    System.out.println("object found!");
                } else System.out.println("object could not be found!");

                exit = true;
            }
        }
    }
    
    /**
    * Prints the contents of the provided SinglyLinkedList of Container objects.
    *
    * @param itemList the SinglyLinkedList of Container objects whose contents are to be printed
    */
    public static void printListContents(SinglyLinkedList<Container> itemList) {
        Lister itemLister = itemList.iterator();
            while (itemLister.hasNext()) {
                switch (itemLister.next()) {
                    case Bottle displayBottle -> System.out.print("(" 
                            + displayBottle.getName() + ")["
                            + displayBottle.getStorageCapacity() + ","
                            + displayBottle.getColor() + "," 
                            + displayBottle.getContentTemperature() + "]");
                    case Container displayContainer -> System.out.print("(" 
                            + displayContainer.getName() + ")[" 
                            + displayContainer.getStorageCapacity() + "]");
                    case default -> {}
                }

                if (itemLister.hasNext()) {
                    System.out.print(", ");
                }
            }
            System.out.println();
            }

}
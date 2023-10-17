package project2fall2023;
import java.util.Scanner;
/**
 *  Main file for Project2Fall2023
 * @author Aron Kabai-Tokes
 */
public class Project2Fall2023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // 1. Add "Object" to bag. Ask the user to enter attributes, then add
        // obj to linked list
        Scanner scanner = new Scanner(System.in);
        
        /*-----------------------------------------------
        A - ADD OBJECT TO BAG
        -----------------------------------------------*/
        String containerName;
        int containerStorageCapacity;
        // create a list to hold nodes
        SinglyLinkedList<Container> linkedList = new SinglyLinkedList<>();
        
        // ask user for input
        System.out.println("Create a container");
        System.out.print("Name of container: ");
        containerName = scanner.nextLine();
        System.out.print("Container Storage Capacity (#): ");
        containerStorageCapacity = scanner.nextInt();
        scanner.nextLine();
        
        // creating a container object and adding new object to list
        linkedList.appendList(new Container(containerName, containerStorageCapacity));
        
        System.out.println("\ncurrent list size: " + linkedList.getSize());
        
        if (linkedList.getSize() == 0)
            System.out.print("--Empty--");
        Lister<Container> containerList = linkedList.iterator();
        while (containerList.hasNext())
        {
            Container container = containerList.next();
            System.out.print("{" + container.getName() + "(" + container.getStorageCapacity() + ")}");
            if (containerList.hasNext())
                System.out.print( ", ");
        }

        System.out.println("]\tSize: " + linkedList.getSize() + "\n");
    }
    
}


import java.util.Scanner;

public class Main {

  public static void getUserInputs(DoublyLinkedList list) {
    // Init stuff
    String data = "";
    int position;
    Scanner scan = new Scanner(System.in);

    System.out.println("\nEnter a value to INSERT: ");
    data = scan.nextLine();
    list.insertNode(data); // Insert into list

    System.out.println("\nEnter a value to INSERT: ");
    data = scan.nextLine();
    list.insertNode(data); // Insert into list

    System.out.println("\nEnter a value to INSERT: ");
    data = scan.nextLine();
    list.insertNode(data); // Insert into list

    System.out.println("\nEnter a position to DELETE: ");
    position = scan.nextInt();
    list.deleteNode(position); // Remove from list

    System.out.println("\nEnter a value to ADD to the beginning: ");
    scan.nextLine(); // Prevent empty value (buggy without, so leave in place)
    data = scan.nextLine();
    list.insertNode(data, 1); // Insert into list

    System.out.println("\nEnter a value to APPEND to the list: ");
    data = scan.nextLine();
    list.insertNode(data); // Append to list

    System.out.println("\nEnter a position to GET: ");
    position = scan.nextInt();
    scan.nextLine(); // Consume next line (buggy, do not remove)
    data = list.getPosition(position); // Get at position
    System.out.println("Contents at position: " + data);

    scan.close(); // Close the input

    System.out.println("\n##### Final List Details #####");
    list.printExtendedData();
  }

  public static void main(String[] args) {
    // Create a new DLL
    DoublyLinkedList myList = new DoublyLinkedList();

    // MARK: Actions
    /*
     * 1. User enters 3 values to insert 2. User enters a position to delete 3. User
     * enters a value to add to the beginning of the list 4. User enters a value to
     * add to the list 5. User enters a position to get
     */

    getUserInputs(myList);

  }
}
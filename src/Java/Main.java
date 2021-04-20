package Java;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    // Create a new DLL
    DoublyLinkedList myList = new DoublyLinkedList();

    // MARK: Actions
    /*
     * 1. User enters 3 values to insert 2. User enters a position to delete 3. User
     * enters a value to add to the beginning of the list 4. User enters a value to
     * add to the list 5. User enters a position to get
     */

    // TODO: Add ability for user to interact with DLL
    Scanner input = new Scanner(System.in);

    // Values to insert
    // Init a counter (for scripting)
    int i = 1;
    while (i <= 3) {
      System.out.println("\nEnter a value to insert: ");
      // Get the User's input
      String data = input.nextLine();
      myList.insertNode(data); // Insert into list
      i++;
    }

    // Position to delete

    System.out.println("\n##### Final List Details #####");
    myList.printExtendedData();

  }
}
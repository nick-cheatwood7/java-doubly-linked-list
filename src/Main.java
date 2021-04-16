
public class Main {
  public static void main(String[] args) {
    // Create a new DLL
    DoublyLinkedList myList = new DoublyLinkedList();

    // Add nodes to the DLL
    myList.insertNode("New York");
    myList.insertNode("Los Angeles");
    myList.insertNode("Chicago");
    myList.insertNode("Houston");
    myList.insertNode("Phoenix");

    // Adding nodes at the specified position
    myList.insertNode("Philadelphia", 6);
    myList.insertNode("San Antonio", 1);
    myList.insertNode("San Diego", 3);

    // Delete a node or two
    myList.deleteNode(1);
    myList.deleteNode(18);
    myList.deleteNode(3);

    // Get the data
    myList.getData();
    System.out.println("List Size: " + myList.getSize());
  }
}

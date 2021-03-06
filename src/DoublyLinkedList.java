
public class DoublyLinkedList {

  // Keep track of size of list
  private int size = 0;

  // Create a getter for the list size
  public int getSize() {
    return this.size;
  }

  // Init head and tail for the list
  Node head = null;
  Node tail = null;

  // Method for apppending a node into the list
  public void insertNode(String data) {
    // Create the node
    Node newNode = new Node(data);
    // Check if the doubly linked list is empty or not
    if (head == null) {
      // Make sure the list head and tail points to the newly-created node
      head = newNode;
      tail = newNode;
      // This is the first node, so the previous will always be null
      head.setPrevious(null);
      // This is also the last node, so the tail's next will also be null
      tail.setNext(null);
    } else { // List is not empty
      // Node will be inserted on the end, so update the list's tail Node
      tail.setNext(newNode);
      // Update the previous for the new node to point to the existing tail
      newNode.setPrevious(tail);
      // Overwrite the existing list tail with the new node (also update the 'next'
      // value)
      tail = newNode;
      tail.setNext(null);
    }
    size++;
    // Print the result
    printData();
  }

  // Method for adding to beginning of list
  private void addFirst(Node node) {
    // The node overwrites the head and tail of the list
    head.setPrevious(node);
    node.setNext(head);
    // Adds to the front of the list, so no previous node and the node becomes the
    // head
    node.setPrevious(null);
    head = node;
  }

  // Method for adding to end of list
  private void addLast(Node node) {
    // Tail next will point to the new node
    tail.setNext(node);
    // Point to existing tail
    node.setPrevious(tail);
    // Overwrite tail to be the node
    tail = node;
    // Empty out tail's next
    tail.setNext(null);
  }

  // Method for inserting node at a given position
  public void insertNode(String data, int pos) {
    // Init the node
    Node newNode = new Node(data);
    // Check if the list is empty or not
    if (head == null) {
      System.out.println("The specified position is not available");
    } else {
      // List is populated
      if (pos == size + 1) {
        // Insert at last
        addLast(newNode);
      } else if (pos == 1) {
        // Add at beginning
        addFirst(newNode);
      } else {
        // Insert at Kth position
        // Current node will initially be the head (first node)
        Node current = head;
        Node temp = null;

        // Loop over DLL until we reach specified position
        for (int i = 1; i < pos - 1; i++) {
          current = current.getNext();
        }

        // Temp node points to the node next to current
        temp = current.getNext();
        temp.setPrevious(current);

        // The new Node will be inserted between current and temp
        current.setNext(newNode);
        newNode.setPrevious(current);
        newNode.setNext(temp);
        temp.setPrevious(newNode);
      }
      size++;
      // Print the result
      printData();
    }
  }

  // Method for deleting node at a specified position
  public void deleteNode(int pos) {
    // Check if the DLL is empty
    if (head == null || pos > size) {
      System.out.println("\nThe position " + pos + " is not available in the list.");
    } else {
      // List is populated
      if (pos == 1) {
        // Remove the first node (head)
        head = head.getNext();
        size--;
      } else if (pos == size) {
        // Remove the last node (tail)
        tail = tail.getPrevious();
        tail.setNext(null);
        size--;
      } else {
        // Remove Kth position
        Node current = head;
        for (int i = 1; i < pos; i++) {
          current = current.getNext();
        }
        // Delete current node
        current.getNext().setPrevious(current.getPrevious());
        current.getPrevious().setNext(current.getNext());
        size--;
      }
      switch (pos) {
      case 1:
        System.out.println("\nThe " + pos + "st node was deleted successfully.");
        break;
      case 2:
        System.out.println("\nThe " + pos + "nd node was deleted successfully.");
        break;
      case 3:
        System.out.println("\nThe " + pos + "rd node was deleted successfully.");
        break;
      default:
        System.out.println("\nThe " + pos + "th node was deleted successfully.");
      }
      // Print the result
      printData();
    }
  }

  // Method for copying the doubly linked list starting at a specified position
  public DoublyLinkedList deepCopy(int startingPosition) {
    // Init a new list
    DoublyLinkedList newList = new DoublyLinkedList();
    // Init the pointer Node
    Node current = head;
    // Traverse the entire list
    for (int i = 1; i <= this.size; i++) {
      // If the index is within the range of the Starting Position and the list size,
      // copy it
      if (i >= startingPosition) {
        newList.insertNode(current.getData());
      }
      current = current.getNext(); // Go to next Node
    }
    return newList;
  }

  // Method for getting Node data at a specified position
  public String getPosition(int pos) {
    // Init a pointer Node
    Node current = head;
    String results = "";
    if (pos > this.getSize() || pos < 1) {
      // Out of bounds
      System.out.println("Position is out of bounds.");
      return results;
    } else {
      // Get at the specified position
      for (int i = 1; i <= pos; i++) {
        // Iterate over list and return the position requested
        if (i == pos) {
          results = current.getData();
        }
        current = current.getNext();
      }
    }
    return results;
  }

  // Method for getting the contents of a DLL
  public void printData() {
    // Init a new node pointing to the head
    Node current = head;
    // Check if the list if empty or not
    if (head == null) {
      // Print an exception
      System.out.println("The list is empty");
      return;
    } else {
      // List is populated
      System.out.println("\nNodes in the list:");
      // Iterate over the list
      int index = 1;
      while (current != null) {
        // Print data on each node and increment pointer
        System.out.println(index + " ~> " + current.getData());
        current = current.getNext();
        index++;
      }
    }
  }

  // Method for getting advanced contents of a DLL
  public void printExtendedData() {
    // Init a new node pointing to the head
    Node current = head;
    // Check if the list if empty or not
    if (head == null) {
      // Print an exception
      System.out.println("The list is empty");
      return;
    } else {
      // List is populated
      System.out.println("\nNodes in the list:");
      // Iterate over the list
      int index = 1;
      while (current != null) {
        // Print data on each node and increment pointer
        System.out.print(index + " ~> " + current.getData() + " | ");
        Memory.printAddresses(current);
        current = current.getNext();
        index++;
      }
      System.out.println("List size: " + getSize());
    }
  }

}

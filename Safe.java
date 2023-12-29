/**
 * Imports ArrayList
 */
import java.util.ArrayList;
/**
 * (a) A public class called safe to simulate the behaviour of a real safe
 * @author (Declan James Cronin)
 * @version (version 0.1 12/12/2023)
 */
public class Safe
{
    /**
     * (b)adds two private fields and ArrayList
     */

    private SafeState state;               // Controls the state of the safe
    private int maxItems;                  // Maximum number of items that can be stored in the safe
    public ArrayList<String> contents;     // Record of items in the safe

    /**
     * (c)Constructs a new Safe with the specified maximum number of items.
     * @param aMaxItems The maximum number of items that the safe can hold.
     */
    public Safe(int aMaxItems) {
        state = new SafeState();
        contents = new ArrayList<>();
        maxItems = aMaxItems;
    }

    /**
     * (d)Adds an item to the safe contents if there is space available.
     * @param item The item to be added to the safe contents.
     */
    public void addToContents(String item) {
        if (contents.size() < maxItems) {
            contents.add(item);
        }
        // If the safe is full, do nothing.
    }       

    /**
     * (e)Removes an item from the safe contents if it is present.
     * @param item The item to be removed from the safe contents.
     */
    public void removeFromContents(String item) {
        if (contents.contains(item)) {
            contents.remove(item);
            System.out.println("Removed item");
        } else {
            System.out.println("Item " + item + " not in safe");
        }
    }

    /**
     * (f)Displays all items currently stored in the safe contents.
     */
    public void display() {
        for (String item : contents) {
            System.out.println(item);
        }
    }

    /**
     * (g)Removes all items from the safe, one at a time, and prints a message for each removal.
     */
    public void empty() {
        while (!contents.isEmpty()) {
            String removedItem = contents.remove(0);
            System.out.println("Removed item: " + removedItem);
        }
    }

    /**
     * (i)Attempts to lock the safe using the provided code.
     * @param code The code to attempt to lock the safe.
     * @return true if the safe is now locked, false otherwise.
     */
    public boolean lock(String code) {
        return state.lock(code);
    }

    /**
     * (h)Attempts to open the safe using the provided code.
     * @param code The code to attempt to open the safe.
     * @return true if the safe is now open, false otherwise.
     */
    public boolean open(String code) {
        return state.open(code);
    }

}


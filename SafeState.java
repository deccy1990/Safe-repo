/**
 * (a) add new class safe state
 */

/**
 *  * This class represents a safe state in a security system.
 * It stores information about the current state of the security system,
 * The class provides methods for manipulating and querying the state of the security system.
 *
 * @author (Declan James Cronin)
 * @version (Version 0.1 12/12/2023)
 */

/**
 * (b) add user, master, display and open
 */

public class SafeState {
    private String userCode;    // User's current code to open the safe
    private String masterCode;  // Special code for hotel staff to open the safe
    private String display;     // Display message on the safe (e.g., "Open" or "Closed")
    private boolean open;       // True if the safe is open, false if it is locked

    /**
     *  * (c) Add a public constructor to the class SafeState that takes no arguments. and set values
     * Constructs a new SafeState with the default state (locked and no user code).
     */
    public SafeState() {
        userCode = null;
        masterCode = "999999";
        display = "WELCOME";
        open = true;
    }

    /**
     * (d) Two new public methods
     */
    /**
     * Gets the display message on the safe.
     * @return The display message.
     */
    public String getDisplay() {
        return display;
    }

    /**
     * Gets the open status of the safe.
     * @return true if the safe is open, false if it is locked.
     */
    public boolean isOpen() {
        return open;
    }

    /**
     * (e) Add a method with the header public boolean open (String aCode)
     * Attempts to open the safe with the provided code.
     * @param aCode The code provided by the user.
     * @return true if the safe is open after the attempt, false otherwise.
     */
    public boolean open(String aCode) {
        if (open) {
            display = "ALREADY OPEN";
        } else {
            if (aCode.equals(userCode) || aCode.equals(masterCode)) {
                open = true;
                display = "OPEN";
                userCode = null;
            } else {
                display = "INVALID CODE";
            }
        }
        return open;
    }

    /**
     * (f)Adds a method with the header public boolean isValidUserCode(String aCode)
     * Checks if the provided code is a valid user code.
     * @param aCode The code proposed as a new user code.
     * @return true if aCode meets the requirements, false otherwise.
     */
    public boolean isValidUserCode(String aCode) {
        if (aCode.length() == 4) {
            for (int i = 0; i < 4; i++) {
                char digit = aCode.charAt(i);
                if (digit < '0' || digit > '9') {
                    return false; // Not a digit
                }
            }
            return true; // All characters are digits
        }
        return false; // Length is not 4
    }

    /**
     * (g) Adds a public method lock that receives a string code as an argument, which the user has provided to attempt to lock the safe.
     * Attempts to lock the safe with the provided code.
     * @param aCode The code provided by the user.
     * @return true if the safe is locked after the attempt, false otherwise.
     */
    public boolean lock(String aCode) {
        if (!open) {
            display = "ALREADY LOCKED";
        } else {
            if (isValidUserCode(aCode)) {
                open = false;
                display = "LOCKED";
                userCode = aCode;
            } else {
                display = "INVALID CODE";
            }
        }
        return !open;
    }

    /**
     * (h)     * Returns a string describing the SafeState in the specified format.
     * @return A string describing the SafeState.
     */
    public String about() {
        return "Safe " + display;
    }
}


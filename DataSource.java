// DataSource Interface: Defines a contract for different operations
interface DataSource {
    void execute(); // Abstract method to be implemented by all data operations
}

// Update Class implementing DataSource: Represents an update operation
class Update implements DataSource {
    @Override
    public void execute() {
        //System.out.println("Executing Update Operation");
    }
}

// View Class implementing DataSource: Represents a view operation
class View implements DataSource {
    @Override
    public void execute() {
        //System.out.println("Executing View Operation");
    }
}

// Delete Class implementing DataSource: Represents a delete operation
class Delete implements DataSource {
    @Override
    public void execute() {
        //System.out.println("Executing Delete Operation");
    }
}

// Abstract Account Class: Base class for Admin and User
abstract class Account {
    protected int id; // Account ID
    protected String name; // Account holder's name
    protected DataSource myData; // Holds the operation to be performed

    // Constructor to initialize account details
    public Account(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Method to perform a specific operation
    public void performOperation(DataSource _myData) {
        if (_myData == null) { // Handle null input
            System.out.println("No operation specified!");
            return;
        }
        myData = _myData;
        myData.execute(); // Execute the given operation
    }
}

// Admin Class extending Account: Represents an administrator
class Admin extends Account {
    private String authPassword; // Admin-specific password

    // Constructor to initialize admin details
    public Admin(int id, String name, String password) {
        super(id, name); // Call the superclass constructor
        this.authPassword = password;
    }

    // Getter for authPassword (optional, if needed elsewhere)
    public String getAuthPassword() {
        return authPassword;
    }
}

// User Class extending Account: Represents a regular user
class User extends Account {
    // Constructor to initialize user details
    public User(int id, String name) {
        super(id, name); // Call the superclass constructor
    }
}

// Main Class: Entry point for the application
public class Main {
    public static void main(String[] args) {
        // Creating Admin and User objects
        Admin admin = new Admin(1, "Admin1", "adminPass123");
        User user = new User(2, "User1");

        // Creating operations
        DataSource update = new Update();
        DataSource view = new View();
        DataSource delete = new Delete();

        // Admin performs Update operation
        System.out.println("Admin's Operations:");
        admin.performOperation(update);

        // User performs View operation
        System.out.println("\nUser's Operations:");
        user.performOperation(view);

        // Admin performs Delete operation
        System.out.println("\nAdmin's Operations:");
        admin.performOperation(delete);
    }
}

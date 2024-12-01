// this is basically going to be the same as the previous method that I did in java102 btw. 

// center of mass 


public class Point {
    public final double x; 
    public final double y; 

    // Constructor to initialize the Point object with x and y coordinates.
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // used to translate the point along the x-axis by a given value t
    public Point translateX(double t) {
        return new Point(x + t, y); // Return a new Point with translated x-coordinate
    }

    // used to translate the point along the y-axis by a given value t
    public Point translateY(double t) {
        return new Point(x, y + t); // Return a new Point with translated y-coordinate
    }

    // used to represent the point as a string in the form "(x, y)"
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    // another method  to calculate the Euclidean distance between two points.
    public static double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }

    // another another! method to calculate the center of mass (average) of a set of points.
    public static Point centerOfMass(Point[] points) {
        if (points == null || points.length == 0) {  // Check for invalid input
            throw new IllegalArgumentException("the Array of points must not be null or empty.");
        }

        double sumX = 0;  
        double sumY = 0;  

        // Loops through all the points and sum up their coordinates
        for (Point point : points) {
            sumX += point.x;
            sumY += point.y;
        }

        // Calculates the average of x and y coordinates
        double avgX = sumX / points.length;
        double avgY = sumY / points.length;

        return new Point(avgX, avgY);  // Returns the new Point representing the center of mass
    }
}

// Main class for testing the Point and center of mass functionality
public class Main {
    public static void main(String[] args) {

        // Creates an array of points
        Point[] points = {
            new Point(1, 2),
            new Point(3, 4),
            new Point(5, 6),
            new Point(7, 8)
        };

        // Calculates the center of mass using the centerOfMass method
        Point center = Point.centerOfMass(points);

        // Output the result of the center of mass
        System.out.println("Center of Mass: " + center);
    }
}


// Angle practice problem 

// Point class with methods for calculating angles and handling coordinates
public class Point {
    public final double x;  
    public final double y;  

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point translateX(double t) {
        return new Point(x + t, y);
    }

    public Point translateY(double t) {
        return new Point(x, y + t);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    // used to calculate the distance between two points
    public static double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }

    public static Point centerOfMass(Point[] points) {
        if (points == null || points.length == 0) {
            throw new IllegalArgumentException("Array of points must not be null or empty.");
        }
        double sumX = 0;
        double sumY = 0;
        // Iterate through the points and sums their coordinates
        for (Point point : points) {
            sumX += point.x;
            sumY += point.y;
        }
        // Returns the average coordinates as the center of mass
        return new Point(sumX / points.length, sumY / points.length);
    }

    public double angle() {
        // Use atan2 to find the angle in radians and convert to degrees
        double radians = Math.atan2(y, x);
        return Math.toDegrees(radians);  // Returns the angle in degrees
    }
}

// Main class for testing the angle calculations
public class Main {
    public static void main(String[] args) {
        // Defines the points
        Point p1 = new Point(4, 2);
        Point p2 = new Point(-44, 100);
        Point p3 = new Point(-5, -5);
        Point p4 = new Point(32, -11);

        // Outputs the angle of each point using the angle() method
        System.out.println("Angle of p1: " + p1.angle());
        System.out.println("Angle of p2: " + p2.angle());
        System.out.println("Angle of p3: " + p3.angle());
        System.out.println("Angle of p4: " + p4.angle());
    }
}


// the challenge problem, rotation 

public class Point {
    public final double x;
    public final double y;

    // Constructor: Initializes a point with coordinates 
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Translates the point along the X axis by a given distance 
    public Point translateX(double t) {
        return new Point(x + t, y); // Updates x-coordinate while keeping y constant
    }

  // same as the one above, just for the y axis
    public Point translateY(double t) {
        return new Point(x, y + t); 
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")"; // Converts the point to a string representation
    }

    // Calculates the distance between two points p1 and p2 using the distance formula.
    public static double distance(Point p1, Point p2) {
        // Using Pythagorean theorem to calculate the distance
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }

    // Computes the center of mass of a set of points. The center of mass is the average of the x and y coordinates.
    public static Point centerOfMass(Point[] points) {
        if (points == null || points.length == 0) {
            throw new IllegalArgumentException("Array of points must not be null or empty.");
        }
        double sumX = 0;
        double sumY = 0;
        for (Point point : points) {
            sumX += point.x; 
            sumY += point.y; 
        }
        return new Point(sumX / points.length, sumY / points.length); 
    }

    // Calculates the angle of the point in standard position (relative to the positive x-axis).
    public double angle() {
        // Math.atan2(y, x) returns the angle in radians between the positive x-axis and the point 
        double radians = Math.atan2(y, x); // finds angles 
        return Math.toDegrees(radians); // finds degrees 
    }

    public Point rotate90() {
        double newX = -y;
        double newY = x;
        return new Point(newX, newY); // Returns the rotated point
    }

    public Point rotate(double theta) {
        double radians = Math.toRadians(theta); 
        double newX = x * Math.cos(radians) - y * Math.sin(radians);
        double newY = x * Math.sin(radians) + y * Math.cos(radians);
        return new Point(newX, newY); // Returning the new rotated point
    }
}

public class Main {
    public static void main(String[] args) {
        Point p = new Point(1, 0); 

        Point rotated90 = p.rotate90();
        System.out.println("90-degree rotation: " + rotated90); 

        Point rotated45 = p.rotate(45);
        System.out.println("45-degree rotation: " + rotated45);

        Point rotated180 = p.rotate(180);
        System.out.println("180-degree rotation: " + rotated180); // Should print (-1, 0)
    }
}
// practice diagonal problem 

import java.util.ArrayList;

public class Grid<T> {
    private final ArrayList<ArrayList<T>> grid;  // 2D grid structure to hold elements (a list of lists)
    public final int sideLength;  // The number of rows/columns in the grid (grid is square)

    // Constructor to initialize a grid with given size and default value
    public Grid(int sideLength, T defaultVal) {
        this.sideLength = sideLength;  // Set the grid's side length
        this.grid = new ArrayList<>(sideLength);  // Creates an ArrayList to hold rows of the grid

        // Initializes the grids with the default values
        for (int i = 0; i < sideLength; i++) {
            grid.add(new ArrayList<>(sideLength));  // Adds a new row (ArrayList) for each row in the grid
            for (int j = 0; j < sideLength; j++) {
                grid.get(i).add(defaultVal);  // Fills the rows with the default value
            }
        }
    }

    public T get(int row, int col) {
        return grid.get(row).get(col);  
    }


    public void set(int row, int col, T val) {
        grid.get(row).set(col, val);  

    public ArrayList<T> diagonal() {
        ArrayList<T> diagonal = new ArrayList<>();  
        for (int i = 0; i < sideLength; i++) {
            diagonal.add(grid.get(i).get(i));  // Add the element at (i, i) to the diagonal list
        }
        return diagonal;  
    }

    @Override
    public String toString() {
        String str = ""; 
        for (ArrayList<T> row : grid) {  
            for (T element : row) {  
                str += element + " "; 
            }
            str += "\n";  // Add a newline after each row
        }
        return str;  // Returns the string representation of the entire grid
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a 4x4 grid with the default value of 0
        Grid<Integer> grid = new Grid<>(4, 0);

        grid.set(0, 0, 1);
        grid.set(1, 1, 2);
        grid.set(2, 2, 3);
        grid.set(3, 3, 4);

        System.out.println("Grid:");
        System.out.println(grid);

        ArrayList<Integer> diagonal = grid.diagonal();
        System.out.println("Diagonal:");
        System.out.println(diagonal); 
    }
}


// max side length problem 
// max side length problem 

import java.util.ArrayList;

public class Grid<T> {
    private final ArrayList<ArrayList<T>> grid;  // 2D grid structure to hold elements
    public final int sideLength;  // The number of rows/columns in the grid (grid is square)
    private static int maxSide = 0;  // Static variable to track the maximum side length of any grid created

    // Constructor to initializes a grid with given size and default value
    public Grid(int sideLength, T defaultVal) {
        this.sideLength = sideLength;  // Sets the grid's side length

        if (sideLength > maxSide) {
            maxSide = sideLength;  
        }

        this.grid = new ArrayList<>(sideLength);  // Creates an ArrayList to hold rows of the grid

        // Initializes the grid with the default value
        for (int i = 0; i < sideLength; i++) {
            ArrayList<T> row = new ArrayList<>(sideLength);  // Creates a new row (ArrayList)
            for (int j = 0; j < sideLength; j++) {
                row.add(defaultVal); 
            }
            grid.add(row); 
        }
    }

    public T get(int row, int col) {
        return grid.get(row).get(col); 
    }

    public void set(int row, int col, T val) {
        grid.get(row).set(col, val);  // Sets the element at grid[row][col] to the given value
    }

    // used to return a string representation of the grid
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder(); 
        for (ArrayList<T> row : grid) {  
            for (T element : row) {  // Iterate through each element in the row
                str.append(element).append(" ");  
            }
            str.append("\n");  // Add a newline after each row
        }
        return str.toString();  // Returns the string representation of the entire grid
    }

    public static int maxSideLength() {
        return maxSide;  
    }
}


// from point problem 

public static Circle fromPoints(Point p1, Point p2, Point p3) {
    // Calculates the determinants to check for collinearity
    double det = (p1.x * (p2.y - p3.y) + p2.x * (p3.y - p1.y) + p3.x * (p1.y - p2.y));
    if (det == 0) {
        throw new IllegalArgumentException("The points are collinear, so a circle cannot be formed.");
    }

    // Calculates the midpoints of two sides of the triangle
    double midX1 = (p1.x + p2.x) / 2;
    double midY1 = (p1.y + p2.y) / 2;
    double midX2 = (p2.x + p3.x) / 2;
    double midY2 = (p2.y + p3.y) / 2;

    // Slopes of the lines connecting the points
    double slope1 = (p2.y - p1.y) / (p2.x - p1.x);
    double slope2 = (p3.y - p2.y) / (p3.x - p2.x);

    // Perpendicular slopes
    double perpSlope1 = -1 / slope1;
    double perpSlope2 = -1 / slope2;

    // Find the center by solving the intersection of the two perpendicular bisectors
    // y - midY1 = perpSlope1 * (x - midX1)
    // y - midY2 = perpSlope2 * (x - midX2)
    double centerX = (perpSlope1 * midX1 - perpSlope2 * midX2 + midY2 - midY1) / (perpSlope1 - perpSlope2);
    double centerY = perpSlope1 * (centerX - midX1) + midY1;

    // Calculate the radius
    double radius = Point.distance(new Point(centerX, centerY), p1);

    return new Circle(new Point(centerX, centerY), radius);
}
 
// right triangle problem 

public class RightTriangle implements Shape {
    public final Point corner; 
    public final double base; 
    public final double height; 

    /**
     * Constructs a RightTriangle with a specified corner, base, and height.
     *
     * @param corner 
     * @param base parallel to x axis
     * @param height parallel to y axis
     */
    public RightTriangle(Point corner, double base, double height) {
        this.corner = corner;
        this.base = base;
        this.height = height;
    }

    @Override
    public double area() {
        return 0.5 * base * height;
    }

    @Override
    public double perimeter() {
        return base + height + Math.sqrt(base * base + height * height);
    }

    @Override
    public boolean isInside(Point p) {
        double xDist = p.x - corner.x;
        double yDist = p.y - corner.y;
        return 0 <= xDist && xDist <= base && 0 <= yDist && yDist <= height
               && yDist <= (-height / base) * xDist + height;
    }

    @Override
    public boolean isOn(Point p) {
        double xDist = p.x - corner.x;
        double yDist = p.y - corner.y;
        return (xDist >= 0 && xDist <= base && yDist == 0) || // On the base
               (yDist >= 0 && yDist <= height && xDist == 0) || // On the height
               (Math.abs(yDist - (-height / base) * xDist - height) < 1e-9); // On the hypotenuse
    }

    @Override
    public Shape translate(double x, double y) {
        return new RightTriangle(corner.translateX(x).translateY(y), base, height);
    }

    @Override
    public Shape scale(double k) {
        return new RightTriangle(corner, base * k, height * k);
    }

    @Override
    public String toString() {
        return "(corner: " + corner + ", base: " + base + ", height: " + height + ")";
    }

    /**
     * Static method to determine if two RightTriangles are similar.
     *
     * @param t1 The first RightTriangle
     * @param t2 The second RightTriangle
     * @return True if the triangles are similar, false otherwise
     */
    public static boolean similar(RightTriangle t1, RightTriangle t2) {
        // Compares ratios of the sides
        double ratio1 = t1.base / t2.base;
        double ratio2 = t1.height / t2.height;
        return Math.abs(ratio1 - ratio2) < 1e-9;
    }
}

// return all problem 

// Parent class for library items
public class LibraryItem {
    public final String title;
    public final String itemId;
    
    protected boolean isCheckedOut = false; // Tracks if an item is checked out or not

    public LibraryItem(String title, String itemId) {
        this.title = title;
        this.itemId = itemId;
    }

    // Checks if any items are available 
    public boolean available() {
        return !isCheckedOut;
    }

    // Marks items as checked out
    public void checkOut() {
        isCheckedOut = true;
    }

    // Marks a item as returned   
    public void returnItem() {
        isCheckedOut = false;
    }
}

// Book class, the type of library item I made for this, basically uses author, and pagecount
public class Book extends LibraryItem {
    public final String author;
    public final int pageCount;

    public Book(String title, String itemId, String author, int pageCount) {
        super(title, itemId);
        this.author = author;
        this.pageCount = pageCount;
    }

    @Override
    public String toString() {
        return "Book: " + title + " by " + author + ", " + pageCount + " pages";
    }
}

// DVD class, another type of Library item I made for this, I took a lot of inspiration from items used in the examples btw
public class DVD extends LibraryItem {
    public final double runtime;

    public DVD(String title, String itemId, double runtime) {
        super(title, itemId);
        this.runtime = runtime;
    }

    @Override
    public String toString() {
        return "DVD: " + title + ", Runtime: " + runtime + " minutes";
    }
}

// Main class with the returnAll methods
public class Main {
    public static void main(String[] args) {
        // Creates some itemswhich are the books and dvds
        LibraryItem book1 = new Book("1984", "B001", "George Orwell", 328);
        LibraryItem dvd1 = new DVD("Inception", "D001", 148.0);
        LibraryItem book2 = new Book("To Kill a Mockingbird", "B002", "Harper Lee", 281);

        // Creates an array to store these items
        LibraryItem[] items = {book1, dvd1, book2};

        // Check out some items for demonstration
        book1.checkOut();
        dvd1.checkOut();

        // Calls the returnAll method to return all items to the library
        returnAll(items);
    }

    // This method is used to return all items to the library (hopefully)
    public static void returnAll(LibraryItem[] items) {
        // Loops through the arrays and returns each item
        for (LibraryItem item : items) {
            // Returns the items to the library
            item.returnItem();
            // Output to confirm everything basically (my way of checking if the code works or if I made a mistake, like a congratulations message basically lol)
            System.out.println(item.title + " has been returned to the library.");
        }
    }
}

// available items problem

import java.util.ArrayList;

// Main class to manage library operations
public class Main {

    public static void main(String[] args) {
        // Create some sample library items like books and dvds
        LibraryItem book1 = new Book("1984", "B001", "George Orwell", 328);
        LibraryItem dvd1 = new DVD("Inception", "D001", 148.0);
        LibraryItem book2 = new Book("To Kill a Mockingbird", "B002", "Harper Lee", 281);

        // an Array of library items that represents the current collection of stuff
        LibraryItem[] items = {book1, dvd1, book2};

        book1.checkOut();  // 1984 is one of the best books ever go read it fr 
        dvd1.checkOut();   // Checking out 'Inception' go watch the movie its fire and peak fiction

        ArrayList<LibraryItem> availableItemsList = availableItems(items);

        // Outputs the available items
        System.out.println("The following items are currently available in the library:");
        if (availableItemsList.isEmpty()) {
            System.out.println("No items are currently available");
        } else {
            // Loops through the available items and display them
            for (LibraryItem item : availableItemsList) {
                System.out.println(item); 
            }
        }
    }

    /**
     * Returns an ArrayList of all available library items from the input array
     * 
      * @param items an array of LibraryItem items to check for their availability.
     * @return an ArrayList containing all the available LibraryItem items.
     */
    public static ArrayList<LibraryItem> availableItems(LibraryItem[] items) {
        // Creates an ArrayList to store available items
        ArrayList<LibraryItem> availableItemsList = new ArrayList<>();

        // Iterate over the array of items and check their availability
        for (LibraryItem item : items) {
            // If the item is available, it adds it to the availableItemsList
            if (item.available()) {
                availableItemsList.add(item);
            }
        }

        // Returns to the list of available items
        return availableItemsList;
    }
}

// Parent class for all the items in the library (Books, DVDs, etc.)
abstract class LibraryItem {
    public final String title;
    public final String itemId;

    // Tracks if an item is checked out or not
    protected boolean isCheckedOut = false;

    // I made this to initialize titles and itemId
    public LibraryItem(String title, String itemId) {
        this.title = title;
        this.itemId = itemId;
    }

    // Checks if the item is available or not
    public boolean available() {
        return !isCheckedOut;
    }

    // Marks the items as checked out
    public void checkOut() {
        if (isCheckedOut) {
            System.out.println(title + " is already checked out.");
        } else {
            isCheckedOut = true;
            System.out.println(title + " has been successfully checked out.");
        }
    }

    // Marks the items as returned and that they're available again
    public void returnItem() {
        isCheckedOut = false;
        System.out.println(title + " has been successfully returned.");
    }

    // this method is made to be implemented by subclasses
    @Override
    public abstract String toString();
}

// Book class extends to LibraryItems to represent books in the library
class Book extends LibraryItem {
    public final String author;
    public final int pageCount;

    public Book(String title, String itemId, String author, int pageCount) {
        super(title, itemId);
        this.author = author;
        this.pageCount = pageCount;
    }

    // Override toString to display the book's details
    @Override
    public String toString() {
        return "Book: \"" + title + "\" by " + author + ", " + pageCount + " pages.";
    }
}

// DVD class extends LibraryItem to represent DVDs in the library
class DVD extends LibraryItem {
    public final double runtime;

    public DVD(String title, String itemId, double runtime) {
        super(title, itemId);
        this.runtime = runtime;
    }

    // Override toString to display the DVD's details
    @Override
    public String toString() {
        return "DVD: \"" + title + "\", Runtime: " + runtime + " minutes.";
    }
}
 

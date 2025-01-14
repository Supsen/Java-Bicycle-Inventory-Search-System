# Java-Bicycle-Inventory-Search-System

This is a Java-based application designed to manage a bicycle inventory, allowing users to filter and search for bicycles based on wheel size, type, gender, and assembly status.

## Features
- User-friendly console-based menu system.
- Ability to filter bicycles by:
  - Wheel Size
  - Type
  - Gender
  - Assembly Status
- CSV-based inventory loading from `bicycle.txt`.
- Basic error handling for file operations and input mismatches.

## Project Structure
- **Bicycle.java**: Represents a single bicycle with attributes and methods for data handling.
- **BicycleDriver.java**: The main driver class that handles user interaction and calls the inventory methods.
- **BicycleInventory.java**: Manages the inventory, loads data from `bicycle.txt`, and provides methods for filtering.
- **bicycle.txt**: The inventory file containing bicycle data in CSV format.

## How to Run the Project
1. Compile the Java files using:
   ```
   javac *.java
   ```
2. Run the program with:
   ```
   java BicycleDriver
   ```
3. Ensure the `bicycle.txt` file is present in the root directory.

## File Handling
- **Input File:** `bicycle.txt` containing bicycle inventory data in CSV format.
- **Output:** The filtered results are displayed in the console.

## Known Issues
- Minor logical error in the `toString()` method in `Bicycle.java`.
- Limited error handling in `BicycleDriver.java` for non-integer inputs.

## Suggested Improvements
- Fix the `toString()` error in `Bicycle.java`.
- Improve input validation and error handling for a better user experience.

## License
This project is licensed under the MIT License.

## Author
- Suphasit Sribuaai

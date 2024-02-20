package JDBCProject;

import java.util.Scanner;


public class RestaurantManagementSystem {
	private static void printmenu() {
		System.out.println("1. Create Menu");
		System.out.println("2. Remove Menu");
		System.out.println("3. Update Menu");
		System.out.println("4. Display Menu");
		System.out.println("5. Search in Menu");
		System.out.println("6. Exit");
	}

	public static void main(String[] args) {

		Scanner obj = new Scanner(System.in);

		while (true) {
			System.out.println("\t\t\t---------------------------");
			System.out.println("\t\t\t\tABC Restaurant ");
			System.out.println("\t\t\t---------------------------");
			printmenu();
			System.out.print("Enter your choice: ");
			int choice = obj.nextInt();

			switch (choice) {
			case 1:
				System.out.println("Creating a Menu");
				RestaurantMenu.toCreateMenu();
				break;
			case 2:
				System.out.println("Removing a Menu");
				RestaurantMenu.toRemoveMenu();;
				break;
			case 3:
				System.out.println("Updating a Menu");
				RestaurantMenu.toUpdateMenu();
				break;
			case 4:
				System.out.println("Displaying a Menu");
				RestaurantMenu.toDisplayMenu();
				break;
			case 5:
				System.out.println("Searching in a Menu");
				RestaurantMenu.toSearchAMenu();
				break;
			case 6:
				System.out.println("Exit application");
				obj.close();
				return;
			default:
				System.err.println("Enter valid choice");
				break;
			}
		}

	}

}

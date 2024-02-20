package JDBCProject;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class RestaurantMenu {
	int itemID;
	String itemName;
	String itemCategory;
	float itemPrice;
	float itemRating;
	static int itemIDCount = 1;
	static HashMap<Integer, RestaurantMenu> RestaurantDatabase = new HashMap<Integer, RestaurantMenu>();

	public static void toCreateMenu() {
		Scanner inputobj = new Scanner(System.in);
		RestaurantMenu RestaurantMenuData = new RestaurantMenu();
		

		System.out.print("Enter Item name: ");
		RestaurantMenuData.itemName = inputobj.next();

		System.out.print("Enter Item category: ");
		RestaurantMenuData.itemCategory = inputobj.next();

		System.out.println("Enter Item Price: ");
		RestaurantMenuData.itemPrice = inputobj.nextInt();

		System.out.println("Enter Item Rating: ");
		RestaurantMenuData.itemRating = inputobj.nextFloat();

		DBOperationRestaurant.toCreateAMenu(RestaurantMenuData);
		System.out.println("-----------------------------------");
		System.out.println("  Menu creation successfull..!!");
		System.out.println("-----------------------------------");
	}

	public static void toRemoveMenu() {
		Scanner obj = new Scanner(System.in);
		System.out.println("Enter a MenuID to be removed");
		int id = obj.nextInt();
		
		if(DBOperationRestaurant.menuExist(id)) {
			DBOperationRestaurant.toRemoveMenu(id);
		}
		else {
			System.err.println("Menu ID does not exist");
		}
	}
	
	public static void toDisplayMenu() {
		HashMap<Integer, RestaurantMenu>restaurant = DBOperationRestaurant.toGetAllMenu();
		System.out.println("Displaying restaurant Menu");
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("ID \t ITEM_NAME \t ITEM_CATEGORY \t ITEM_PRICE \t  ITEM_RATING" );
		System.out.println("-----------------------------------------------------------------------");
		for(Map.Entry<Integer, RestaurantMenu>MenuEntry:restaurant.entrySet()) {
			System.out.print(MenuEntry.getKey()+"\t");
			System.out.print(MenuEntry.getValue().itemName+"\t");
			System.out.print("\t "+MenuEntry.getValue().itemCategory+"\t\t");
			System.out.print(" "+MenuEntry.getValue().itemPrice+"\t");
			System.out.print("\t   "+MenuEntry.getValue().itemRating+"\t\n");
			System.out.println("----------------------------------------------------------------------");
		}
	}

	public static void toUpdateMenu() {
		Scanner inp = new Scanner(System.in);
		
		System.out.println("Enter an ID to update a menu:");
		int id = inp.nextInt();
		
		if(DBOperationRestaurant.menuExist(id)) {
			System.out.println("1. Update Item Name");
			System.out.println("2. Update Item Category");
			System.out.println("3. Update Item Price");
			System.out.println("4. Update Item Rating");
			System.out.print("Enter a choice to proceed:");
			int choice = inp.nextInt();
			switch(choice) {
			case 1:
				System.out.print("Enter updated Item Name: ");
				DBOperationRestaurant.toUpdateItemName(id, inp.next());
				break;
			case 2:
				System.out.print("Enter updated Item Category: ");
				DBOperationRestaurant.toUpdateItemCategory(id, inp.next());
				break;
			case 3:
				System.out.print("Enter updated Item price: ");
				DBOperationRestaurant.toUpdateItemPrice(id, inp.nextInt());
				break;
			case 4:
				System.out.print("Enter updated Item Rating: ");
				DBOperationRestaurant.toUpdateItemRating(id, inp.nextFloat());
				break;
			default:
				System.err.println("Enter a valid choice");			
			}
		}
		else {
			System.err.println("Menu with "+id+" does not exist.");
		}
	}

	public static void toSearchAMenu() {
		Scanner inp = new Scanner(System.in);
		
		System.out.println("Enter an ID to be searched: ");
		int id = inp.nextInt();
		
		if(DBOperationRestaurant.menuExist(id)) {
			RestaurantMenu menuobj = DBOperationRestaurant.toSearchMenu(id);
			System.out.println("Item ID             	:"+ menuobj.itemID);
			System.out.println("Item Name               :"+ menuobj.itemName);
			System.out.println("Item Category           :"+ menuobj.itemCategory);
			System.out.println("Item Price              :"+ menuobj.itemPrice);
			System.out.println("Item Rating             :"+ menuobj.itemRating);
			System.out.println("Menu Item with "+id+" printed successfully");
		}else {
			System.err.println("Menu Item with "+id+ "doesnot exist");
		}
		
	}
}

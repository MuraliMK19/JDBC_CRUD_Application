package JDBCProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import com.mysql.cj.x.protobuf.MysqlxPrepare.Prepare;

public class DBOperationRestaurant {

	private static final String host = "jdbc:mysql://localhost:3306/restaurant";
	private static final String userName = "root";
	private static final String password = "Qtcbdz32.";

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Connection con = DriverManager.getConnection(host, userName, password);
			return con;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static void toCreateAMenu(RestaurantMenu RestaurantMenuData) {
		try {
			Connection con = getConnection();
			String query = "insert into menu(itemName, itemCategory, itemPrice, itemRating)" + "values (?, ?, ?, ?)";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, RestaurantMenuData.itemName);
			stmt.setString(2, RestaurantMenuData.itemCategory);
			stmt.setFloat(3, RestaurantMenuData.itemPrice);
			stmt.setFloat(4, RestaurantMenuData.itemRating);
			stmt.executeUpdate();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static HashMap<Integer, RestaurantMenu> toGetAllMenu() {
		try {
			Connection con = getConnection();
			String query = "select * from menu";
			PreparedStatement stmt = con.prepareStatement(query);
			ResultSet result = stmt.executeQuery();
			HashMap<Integer, RestaurantMenu> menuDatabase = new HashMap<Integer, RestaurantMenu>();
			while (result.next()) {
				RestaurantMenu obj = new RestaurantMenu();
				obj.itemID = result.getInt(1);
				obj.itemName = result.getString(2);
				obj.itemCategory = result.getString(3);
				obj.itemPrice = result.getFloat(4);
				obj.itemRating = result.getFloat(5);
				menuDatabase.put(obj.itemID, obj);
			}
			stmt.close();
			con.close();
			return menuDatabase;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static void toRemoveMenu(int id) {
		try {
			Connection con = getConnection();
			String query = "delete from menu where itemID = ?";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, id);
			stmt.executeUpdate();
			stmt.close();
			con.close();
			System.out.println("Menu with " + id + " is successfully removed.");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static boolean menuExist(int id) {
		try {
			Connection con = getConnection();
			String query = "select * from menu where itemID = ?";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, id);
			ResultSet result = stmt.executeQuery();
			boolean flag = result.next();
			con.close();
			return flag;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public static void toUpdateItemName(int id, String updatedname) {
		try {
			Connection con = getConnection();
			String query = "update menu set itemName = ? where itemID = ?";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, updatedname);
			stmt.setInt(2, id);
			stmt.executeUpdate();
			stmt.close();
			con.close();
			System.out.println("Item Name is updated successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void toUpdateItemCategory(int id, String updatecategory) {
		try {
			Connection con = getConnection();
			String query = "update menu set itemCategory = ? where itemID = ?";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, updatecategory);
			stmt.setInt(2, id);
			stmt.executeUpdate();
			stmt.close();
			con.close();
			System.out.println("Item Category is updated successfully");	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void toUpdateItemPrice(int id, float price) {
		try {
			Connection con = getConnection();
			String query = "update menu set itemPrice = ? where itemID = ? ";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setFloat(1, price);
			stmt.setInt(2, id);
			stmt.executeUpdate();
			stmt.close();
			con.close();
			System.out.println("Item Price is updated successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void toUpdateItemRating(int id, float rating) {
		try {
			Connection con = getConnection();
			String query = "update menu set itemRating = ? where itemID = ?";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setFloat(1, rating);
			stmt.setInt(2, id);
			stmt.executeUpdate();
			stmt.close();
			con.close();
			System.out.println("Item Rating is updated successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static RestaurantMenu toSearchMenu(int id) {
		try {
			Connection con = getConnection();
			String query = "select * from menu where itemID = ?";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, id);
			ResultSet result = stmt.executeQuery();
			RestaurantMenu restaurantsearch = new RestaurantMenu();
			result.next();
			restaurantsearch.itemID = result.getInt(1);
			restaurantsearch.itemName = result.getString(2);
			restaurantsearch.itemCategory = result.getString(3);
			restaurantsearch.itemPrice = result.getFloat(4);
			restaurantsearch.itemRating = result.getFloat(5);
			stmt.close();
			con.close();
			return restaurantsearch;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}

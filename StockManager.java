package stockPlus;
import java.util.Scanner;
import java.util.ArrayList;



public class StockManager {
	
	String name;
	int amount;
	static float budget;
	static float revenue = 0;
	float buyPrice;
	float sellPrice;
	String type;
	static String requestedType;
	int id = 1;
	static int id1 = 1;
	
	public StockManager(int id, String name, String type,int amount, float buyPrice, float sellPrice) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.amount = amount;
		this.buyPrice = buyPrice;
		this.sellPrice = sellPrice;
	}
		
	public static void main(String[] args) {
		ArrayList<StockManager> items = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		int a = 0;
		while(a <= 23) {
			System.out.println("To add a new item, type 1.\n"
					+ "To filter a specific itemType, type 2.\n"
					+ "To delete an item from the system, type 3.");
			int inp = -1;
			while(inp != 1 && inp != 2) {
				inp = sc.nextInt();
				switch(inp) {
				case 1:
					System.out.println("Type: ");
					String type1 = sc.next();
					System.out.println("Name: ");
					String name1 = sc.next();
					System.out.println("Enter the amount: ");
					int incoming1 = sc.nextInt();
					System.out.println("Enter buy price: ");
					float buyPrice1 = sc.nextFloat();
					System.out.println("Sell price: ");
					float sellPrice1 = sc.nextFloat();
					
					StockManager itemType = new StockManager(id1, name1, type1, incoming1, buyPrice1, sellPrice1);
					StockManager.id1++;
					items.add(itemType);
					System.out.println("ID      -         Amount         -     Name     -   Type   -   Buy Price   -   Sell Price   -   Revenue");
					for (StockManager item : items) {
						double revenue = (item.sellPrice - item.buyPrice) * item.amount;  
					    System.out.printf("%d       -      %7d           -     %s    -  %s   -     %-9.2f -     %-6.2f     -   %-8.2f%n", item.id, item.amount, item.name.substring(0, 1).toUpperCase() + item.name.substring(1).toLowerCase(), item.type.substring(0, 1).toUpperCase() + item.type.substring(1).toLowerCase(), item.buyPrice, item.sellPrice, revenue);
					}
					break;
				case 2:
					System.out.println("Enter the type you want to filter: ");
					requestedType = sc.next();
					System.out.println("ID      -         Amount         -     Name     -   Type   -   Buy Price   -   Sell Price   -   Revenue");
					for(StockManager item : items ) {
						if(item.type.equals(requestedType.toLowerCase())) {
							double revenue = (item.sellPrice - item.buyPrice) * item.amount;  
						    System.out.printf("%d       -      %7d           -     %s    -  %s   -     %-9.2f -     %-6.2f     -   %-8.2f%n", item.id, item.amount, item.name.substring(0, 1).toUpperCase() + item.name.substring(1).toLowerCase(), item.type.substring(0, 1).toUpperCase() + item.type.substring(1).toLowerCase(), item.buyPrice, item.sellPrice, revenue);
						}
					}
					break;
				case 3:
					System.out.println("ID      -         Amount         -     Name     -   Type   -   Buy Price   -   Sell Price   -   Revenue");
					for (StockManager item : items) {
						revenue = (item.sellPrice - item.buyPrice) * item.amount;  
					    System.out.printf("%d       -      %7d           -     %s    -  %s   -     %-9.2f -     %-6.2f     -   %-8.2f%n", item.id, item.amount, item.name.substring(0, 1).toUpperCase() + item.name.substring(1).toLowerCase(), item.type.substring(0, 1).toUpperCase() + item.type.substring(1).toLowerCase(), item.buyPrice, item.sellPrice, revenue);
					}
					System.out.println("\nPlease enter the id of the item you want to delete from the system: ");
					int deleteRequest = sc.nextInt();
					for(StockManager item : items ) {
						if(item.id == deleteRequest){
							items.remove(item);
							System.out.println("The item with the ID " + deleteRequest + " has been successfully deleted.");
							break;
						}
					}
					
					System.out.println("ID      -         Amount         -     Name     -   Type   -   Buy Price   -   Sell Price   -   Revenue");
					for (StockManager item : items) {
						revenue = (item.sellPrice - item.buyPrice) * item.amount;  
					    System.out.printf("%d       -      %7d           -     %s    -  %s   -     %-9.2f -     %-6.2f     -   %-8.2f%n", item.id, item.amount, item.name.substring(0, 1).toUpperCase() + item.name.substring(1).toLowerCase(), item.type.substring(0, 1).toUpperCase() + item.type.substring(1).toLowerCase(), item.buyPrice, item.sellPrice, revenue);
					}
					System.out.println("To add a new item, type 1.\n"
							+ "To filter a specific itemType, type 2.\n"
							+ "To delete an item from the system, type 3.");
				}
			}
		
		a++;
		}
		sc.close();
	}

}

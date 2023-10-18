package stockPlus;
import java.util.Scanner; // Scanner'ı import ediyoruz ki kullanıcıdan veri alabilelim.
import java.util.ArrayList; // Kullanıcıdan alınan veriyi bir listeye atıp ekrana yazdırabilmek için

public class StockManager {
	
	String name; // Ürün ismi
	int amount; // Ürün miktarı
	static float budget; // Bütçeyi statik olarak tanımladım ki genel olarak erişebileyim. (Kullanmamışım çünkü kullanıcının bütçe girmesi pek gerekli değildi, yapılabilir, zor değil.)
	static float revenue = 0; // Kâr, (buyPrice - sellPrice) * amount olarak hesaplanıyor.
	float buyPrice; // Satın alım fiyatı
	float sellPrice; // Satış fiyatı
	String type; // Ürün türü (Fruit, Vegetable, Car)
	static String requestedType; // Filtreleme kısmı için kullandığım bir değişken
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
		
	public static void main(String[] args) { // Ana fonksiyonumuz, buranın altındakiler program tarafından çalıştırılıyor.
		ArrayList<StockManager> items = new ArrayList<>(); // ArrayList sınıfından bir obje oluşturuyoruz.
		Scanner sc = new Scanner(System.in); // Aynı şekilde Scanner sınıfından bir obje oluşturuyoruz.
		int a = 0;
		while(a <= 1001) { // Önemsiz, programın tekrar tekrar çalışması için ekledim, illaki daha efektif bir yolu vardır.
			System.out.println("To add a new item, type 1.\n"
					+ "To filter a specific itemType, type 2.\n"
					+ "To delete an item from the system, type 3.");
			int inp = -1;
			while(inp != 1 && inp != 2) {
				while(!sc.hasNextInt()) {
					System.out.println("Invalid input.");
					sc.next();
				}
				inp = sc.nextInt();
				switch(inp) {
				case 1:
					System.out.println("Type: ");
					while(!sc.hasNext()) {
						System.out.println("Invalid input.");
						System.out.println("Type: ");
						sc.next();
					}
					String type1 = sc.next();
					System.out.println("Name: ");
					while(!sc.hasNext()) {
						System.out.println("Invalid input.");
						System.out.println("Name: ");
						sc.next();
					}
					String name1 = sc.next();
					System.out.println("Amount: ");
					while(!sc.hasNextInt()) {
						System.out.println("Invalid input.");
						System.out.println("Amount: ");
						sc.next();
					}
					int incoming1 = sc.nextInt();
					System.out.println("Buy price: ");
					while(!sc.hasNextFloat()) {
						System.out.println("Invalid input.");
						System.out.println("Buy price: ");
						sc.next();
					}
					float buyPrice1 = sc.nextFloat();
					System.out.println("Sell price: ");
					while(!sc.hasNextFloat()) {
						System.out.println("Invalid input.");
						System.out.println("Sell price: ");
						sc.next();
					}
					float sellPrice1 = sc.nextFloat();
					
					StockManager itemType = new StockManager(id1, name1, type1, incoming1, buyPrice1, sellPrice1); // Stock Manager sınıfından yeni bir nesne çağırıyor/oluşturuyoruz ki kullanabilelim.
					StockManager.id1++; // 2 adet id değişkeni oluşturdum çünkü diğer türlü yeni girilen ürünlere ID vermede bir sıkıntı çıkıyordu.
					items.add(itemType); // items listesine itemType nesnesini ekliyoruz, yani girilen değerleri listeye alıyoruz ki tablo şeklinde görüntüleyebilelim.
					System.out.println("ID      -         Amount         -     Name     -   Type   -   Buy Price   -   Sell Price   -   Revenue");
					for (StockManager item : items) { // For each döngüsüyle items listesindeki bütün değerleri ekrana yazdırma işlemi yapıyoruz.
						double revenue = (item.sellPrice - item.buyPrice) * item.amount;
					    System.out.printf("%d       -      %7d           -     %s    -  %s   -     %-9.2f -     %-6.2f     -   %-8.2f%n", item.id, item.amount, item.name.substring(0, 1).toUpperCase() + item.name.substring(1).toLowerCase(), item.type.substring(0, 1).toUpperCase() + item.type.substring(1).toLowerCase(), item.buyPrice, item.sellPrice, revenue);
					}
					break;
				case 2:
					System.out.println("Enter the type you want to filter: ");
					requestedType = sc.next();
					System.out.println("ID      -         Amount         -     Name     -   Type   -   Buy Price   -   Sell Price   -   Revenue");
					for(StockManager item : items ) {
						if(item.type.toLowerCase().equals(requestedType.toLowerCase())) { // lowercase metodu kullanıyoruz ki kullanıcı tıpatıp aynı değeri girmese bile program kullanıcının istediği veriyi gösterebilsin.
							double revenue = (item.sellPrice - item.buyPrice) * item.amount; // For each döngüsüyle items listesindeki bütün verileri buradaki gibi kullanıyorum.
						    System.out.printf("%d       -      %7d           -     %s    -  %s   -     %-9.2f -     %-6.2f     -   %-8.2f%n", item.id, item.amount, item.name.substring(0, 1).toUpperCase() + item.name.substring(1).toLowerCase(), item.type.substring(0, 1).toUpperCase() + item.type.substring(1).toLowerCase(), item.buyPrice, item.sellPrice, revenue);
						} // Bu kısımda listenin daha güzel gözükmesi için uğraştım, yine ideal olmadı ama standart halinden daha güzel oldu, tablo için de library vardı ama uzun sürer diye uğraşmadım ona.
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
						if(item.id == deleteRequest){ // Sırf silme işlevi ekleyebilmek için ID eklemiştim zaten, burada da eğer kullanıcının girdiği ID for each döngüsüyle beraber bir item'da eşleşiyorsa o item'ı siliyor, tabii else ekleyip daha detaylı ve fonksiyonel hale de getirebilirdim.
							items.remove(item);
							System.out.println("The item with the ID " + deleteRequest + " has been successfully deleted.");
							break;
						}
					}
					
					System.out.println("ID      -         Amount         -     Name     -   Type   -   Buy Price   -   Sell Price   -   Revenue");
					for (StockManager item : items) { // Bu kısımda da silme işleminden sonra tabloyu tekrar gösteriyorum.
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

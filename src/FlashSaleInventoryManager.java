import java.util.*;

public class FlashSaleInventoryManager {

    private HashMap<String, Integer> stock = new HashMap<>();
    private LinkedHashMap<String, Queue<Integer>> waitingList = new LinkedHashMap<>();

    public void addProduct(String productId, int quantity) {
        stock.put(productId, quantity);
    }

    public String purchaseItem(String productId, int userId) {

        if (!stock.containsKey(productId)) {
            return "Product not found";
        }

        int available = stock.get(productId);

        if (available > 0) {
            stock.put(productId, available - 1);
            return "Success, remaining: " + (available - 1);
        } else {
            waitingList.putIfAbsent(productId, new LinkedList<>());
            waitingList.get(productId).add(userId);
            return "Added to waiting list";
        }
    }

    public int checkStock(String productId) {
        return stock.getOrDefault(productId, 0);
    }

    public static void main(String[] args) {

        FlashSaleInventoryManager manager = new FlashSaleInventoryManager();

        manager.addProduct("IPHONE15", 2);

        System.out.println(manager.purchaseItem("IPHONE15", 101));
        System.out.println(manager.purchaseItem("IPHONE15", 102));
        System.out.println(manager.purchaseItem("IPHONE15", 103));
    }
}
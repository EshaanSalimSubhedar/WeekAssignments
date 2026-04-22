import java.util.*;

class Transaction {
    String id;
    double fee;
    String timestamp;

    Transaction(String id, double fee, String timestamp) {
        this.id = id;
        this.fee = fee;
        this.timestamp = timestamp;
    }

    public String toString() {
        return id + ":" + fee + "@" + timestamp;
    }
}

public class Week3Problem1 {
    public static void bubbleSort(List<Transaction> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < list.size() - i - 1; j++) {
                if (list.get(j).fee > list.get(j + 1).fee) {
                    Transaction t = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, t);
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    public static void insertionSort(List<Transaction> list) {
        for (int i = 1; i < list.size(); i++) {
            Transaction key = list.get(i);
            int j = i - 1;
            while (j >= 0 && (list.get(j).fee > key.fee ||
                    (list.get(j).fee == key.fee &&
                     list.get(j).timestamp.compareTo(key.timestamp) > 0))) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, key);
        }
    }

    public static void main(String[] args) {
        List<Transaction> list = new ArrayList<>();
        list.add(new Transaction("id1", 10.5, "10:00"));
        list.add(new Transaction("id2", 25.0, "09:30"));
        list.add(new Transaction("id3", 5.0, "10:15"));

        List<Transaction> b = new ArrayList<>(list);
        bubbleSort(b);
        System.out.println("Bubble:");
        b.forEach(System.out::println);

        List<Transaction> i = new ArrayList<>(list);
        insertionSort(i);
        System.out.println("\nInsertion:");
        i.forEach(System.out::println);

        System.out.println("\nOutliers:");
        list.stream().filter(t -> t.fee > 50).forEach(System.out::println);
    }
}
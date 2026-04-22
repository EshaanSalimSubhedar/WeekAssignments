import java.util.*;

class Client {
    String name;
    int risk;
    double balance;

    Client(String name, int risk, double balance) {
        this.name = name;
        this.risk = risk;
        this.balance = balance;
    }

    public String toString() {
        return name + ":" + risk;
    }
}

public class Week3Problem2 {
    static void bubble(Client[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j].risk > arr[j + 1].risk) {
                    Client t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                }
            }
        }
    }

    static void insertion(Client[] arr) {
        for (int i = 1; i < arr.length; i++) {
            Client key = arr[i];
            int j = i - 1;
            while (j >= 0 && (arr[j].risk < key.risk ||
                    (arr[j].risk == key.risk && arr[j].balance > key.balance))) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        Client[] arr = {
                new Client("A", 20, 1000),
                new Client("B", 50, 2000),
                new Client("C", 80, 1500)
        };

        bubble(arr);
        System.out.println("Bubble:");
        for (Client c : arr) System.out.println(c);

        insertion(arr);
        System.out.println("\nInsertion Desc:");
        for (Client c : arr) System.out.println(c);
    }
}
import java.util.*;

class Asset {
    String name;
    double returnRate;
    double volatility;

    Asset(String n, double r, double v) {
        name = n; returnRate = r; volatility = v;
    }

    public String toString() {
        return name + ":" + returnRate;
    }
}

public class Week4Problem1{
    static void merge(List<Asset> a, int l, int m, int r) {
        List<Asset> left = new ArrayList<>(a.subList(l, m + 1));
        List<Asset> right = new ArrayList<>(a.subList(m + 1, r + 1));
        int i = 0, j = 0, k = l;
        while (i < left.size() && j < right.size())
            a.set(k++, left.get(i).returnRate <= right.get(j).returnRate ? left.get(i++) : right.get(j++));
        while (i < left.size()) a.set(k++, left.get(i++));
        while (j < right.size()) a.set(k++, right.get(j++));
    }

    static void mergeSort(List<Asset> a, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(a, l, m);
            mergeSort(a, m + 1, r);
            merge(a, l, m, r);
        }
    }

    static int partition(List<Asset> a, int l, int r) {
        Asset p = a.get(r);
        int i = l - 1;
        for (int j = l; j < r; j++) {
            if (a.get(j).returnRate > p.returnRate) {
                i++;
                Collections.swap(a, i, j);
            }
        }
        Collections.swap(a, i + 1, r);
        return i + 1;
    }

    static void quickSort(List<Asset> a, int l, int r) {
        if (l < r) {
            int p = partition(a, l, r);
            quickSort(a, l, p - 1);
            quickSort(a, p + 1, r);
        }
    }

    public static void main(String[] args) {
        List<Asset> list = new ArrayList<>();
        list.add(new Asset("AAPL", 12, 5));
        list.add(new Asset("TSLA", 8, 7));
        list.add(new Asset("GOOG", 15, 4));

        mergeSort(list, 0, list.size() - 1);
        System.out.println("Merge:");
        list.forEach(System.out::println);

        quickSort(list, 0, list.size() - 1);
        System.out.println("Quick:");
        list.forEach(System.out::println);
    }
}
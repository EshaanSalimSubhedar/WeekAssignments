public class Week4Problem3 {
    static int floor(int[] arr, int x) {
        int l = 0, r = arr.length - 1, res = -1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (arr[m] <= x) {
                res = arr[m];
                l = m + 1;
            } else r = m - 1;
        }
        return res;
    }

    static int ceil(int[] arr, int x) {
        int l = 0, r = arr.length - 1, res = -1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (arr[m] >= x) {
                res = arr[m];
                r = m - 1;
            } else l = m + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {10, 25, 50, 100};

        System.out.println("Floor: " + floor(arr, 30));
        System.out.println("Ceil: " + ceil(arr, 30));
    }
}
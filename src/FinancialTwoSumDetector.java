import java.util.*;

public class FinancialTwoSumDetector {

    public static List<int[]> findTwoSum(int[] arr, int target){

        HashMap<Integer,Integer> map = new HashMap<>();
        List<int[]> result = new ArrayList<>();

        for(int i=0;i<arr.length;i++){

            int complement = target - arr[i];

            if(map.containsKey(complement)){
                result.add(new int[]{complement,arr[i]});
            }

            map.put(arr[i],i);
        }

        return result;
    }

    public static void main(String[] args){

        int[] transactions = {500,300,200,700,800};

        List<int[]> pairs = findTwoSum(transactions,500);

        for(int[] p : pairs){
            System.out.println(p[0]+" + "+p[1]);
        }
    }
}
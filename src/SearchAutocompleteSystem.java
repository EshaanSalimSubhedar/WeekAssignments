import java.util.*;

public class SearchAutocompleteSystem {

    private HashMap<String,Integer> queryFrequency = new HashMap<>();

    public void addQuery(String query){
        queryFrequency.put(query, queryFrequency.getOrDefault(query,0)+1);
    }

    public List<String> search(String prefix){

        List<String> results = new ArrayList<>();

        for(String q : queryFrequency.keySet()){
            if(q.startsWith(prefix)){
                results.add(q);
            }
        }

        results.sort((a,b)->queryFrequency.get(b)-queryFrequency.get(a));

        return results.size()>5 ? results.subList(0,5) : results;
    }

    public static void main(String[] args){

        SearchAutocompleteSystem system = new SearchAutocompleteSystem();

        system.addQuery("java tutorial");
        system.addQuery("javascript guide");
        system.addQuery("java collections");
        system.addQuery("java tutorial");

        System.out.println(system.search("jav"));
    }
}
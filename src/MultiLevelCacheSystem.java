import java.util.*;

public class MultiLevelCacheSystem {

    private LinkedHashMap<String,String> L1 =
            new LinkedHashMap<>(10,0.75f,true);

    private HashMap<String,String> L2 = new HashMap<>();

    private HashMap<String,String> database = new HashMap<>();

    public MultiLevelCacheSystem(){

        database.put("video1","Video Data 1");
        database.put("video2","Video Data 2");
    }

    public String getVideo(String id){

        if(L1.containsKey(id)){
            return "L1 HIT: "+L1.get(id);
        }

        if(L2.containsKey(id)){
            String data = L2.get(id);
            L1.put(id,data);
            return "L2 HIT → promoted to L1";
        }

        if(database.containsKey(id)){
            String data = database.get(id);
            L2.put(id,data);
            return "DB HIT → added to L2";
        }

        return "Video not found";
    }

    public static void main(String[] args){

        MultiLevelCacheSystem cache = new MultiLevelCacheSystem();

        System.out.println(cache.getVideo("video1"));
        System.out.println(cache.getVideo("video1"));
    }
}
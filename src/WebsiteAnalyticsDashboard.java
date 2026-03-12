import java.util.*;

public class WebsiteAnalyticsDashboard {

    private HashMap<String, Integer> pageViews = new HashMap<>();
    private HashMap<String, Set<String>> uniqueVisitors = new HashMap<>();
    private HashMap<String, Integer> trafficSource = new HashMap<>();

    public void processEvent(String url, String userId, String source) {

        pageViews.put(url, pageViews.getOrDefault(url, 0) + 1);

        uniqueVisitors.putIfAbsent(url, new HashSet<>());
        uniqueVisitors.get(url).add(userId);

        trafficSource.put(source, trafficSource.getOrDefault(source, 0) + 1);
    }

    public void showDashboard() {

        System.out.println("Top Pages:");

        for (String url : pageViews.keySet()) {

            int views = pageViews.get(url);
            int unique = uniqueVisitors.get(url).size();

            System.out.println(url + " - " + views + " views (" + unique + " unique)");
        }

        System.out.println("\nTraffic Sources:");
        System.out.println(trafficSource);
    }

    public static void main(String[] args) {

        WebsiteAnalyticsDashboard dashboard = new WebsiteAnalyticsDashboard();

        dashboard.processEvent("/news", "user1", "google");
        dashboard.processEvent("/news", "user2", "facebook");
        dashboard.processEvent("/sports", "user1", "direct");

        dashboard.showDashboard();
    }
}
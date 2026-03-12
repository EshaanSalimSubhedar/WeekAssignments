import java.util.*;

class DNSEntry {
    String ip;
    long expiryTime;

    DNSEntry(String ip, long ttl) {
        this.ip = ip;
        this.expiryTime = System.currentTimeMillis() + ttl;
    }
}

public class DNSCacheSystem {

    private HashMap<String, DNSEntry> cache = new HashMap<>();

    public String resolve(String domain) {

        if (cache.containsKey(domain)) {
            DNSEntry entry = cache.get(domain);

            if (System.currentTimeMillis() < entry.expiryTime) {
                return "Cache HIT: " + entry.ip;
            } else {
                cache.remove(domain);
            }
        }

        String newIP = "172.217.14." + new Random().nextInt(255);

        cache.put(domain, new DNSEntry(newIP, 5000));

        return "Cache MISS → New IP: " + newIP;
    }

    public static void main(String[] args) {

        DNSCacheSystem dns = new DNSCacheSystem();

        System.out.println(dns.resolve("google.com"));
        System.out.println(dns.resolve("google.com"));
    }
}
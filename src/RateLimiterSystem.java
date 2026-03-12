import java.util.HashMap;

class TokenBucket {
    int tokens;
    long lastRefill;
    int maxTokens;
    int refillRate;

    public TokenBucket(int maxTokens, int refillRate) {
        this.tokens = maxTokens;
        this.maxTokens = maxTokens;
        this.refillRate = refillRate;
        this.lastRefill = System.currentTimeMillis();
    }

    public boolean allowRequest() {
        refill();

        if (tokens > 0) {
            tokens--;
            return true;
        }
        return false;
    }

    private void refill() {
        long now = System.currentTimeMillis();
        long seconds = (now - lastRefill) / 1000;

        if (seconds > 0) {
            tokens = Math.min(maxTokens, tokens + (int)seconds * refillRate);
            lastRefill = now;
        }
    }
}

public class RateLimiterSystem {

    private HashMap<String, TokenBucket> clients = new HashMap<>();

    public boolean checkRateLimit(String clientId) {
        clients.putIfAbsent(clientId, new TokenBucket(10,1));
        return clients.get(clientId).allowRequest();
    }

    public static void main(String[] args) {
        RateLimiterSystem limiter = new RateLimiterSystem();

        for(int i=0;i<12;i++){
            System.out.println("Request "+i+" allowed: "+limiter.checkRateLimit("client1"));
        }
    }
}
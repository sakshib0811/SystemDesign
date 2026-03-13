package RateLimiter.Repository;

import java.util.*;

import RateLimiter.Models.Request;

public class RequestRepository {
    Map<String, Deque<Request>> requestRepo = new HashMap<>();

    public void save(Request req) {
        requestRepo.computeIfAbsent(req.getUserId(), k -> new LinkedList<>()).addLast(req);
    }

    // public boolean findUser(Request req) {
    // return requestRepo.containsKey(req.getUserId());
    // }

    public Deque<Request> getAllRequestByUserId(String userId) {
        return requestRepo.computeIfAbsent(userId, k -> new LinkedList<>());
    }

}

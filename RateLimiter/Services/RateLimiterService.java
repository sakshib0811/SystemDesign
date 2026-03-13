package RateLimiter.Services;

import java.util.Deque;

import RateLimiter.Exception.InvalidUserException;
// import Models.User;
// import RateLimiter.Exception.InvalidUserException;
import RateLimiter.Models.Rate;
import RateLimiter.Models.Request;
import RateLimiter.Repository.RequestRepository;

public class RateLimiterService {

    RequestRepository reqRepo;

    public RateLimiterService(RequestRepository reqRepo) {
        this.reqRepo = reqRepo;
    }

    public boolean reqAllowed(Request req, Rate r) {
        if (req.getUserId() == null) {
            throw new InvalidUserException("User not valid");
        }
        // if (!reqRepo.findUser(req)) {
        // reqRepo.save(req);
        // return true;
        // }
        long currTime = System.currentTimeMillis();
        Deque<Request> totalReq = reqRepo.getAllRequestByUserId(req.getUserId());
        while (!totalReq.isEmpty()
                && currTime - totalReq.peekFirst().getRequestTimeStamp() > r.getWindowSize() * 1000) {
            totalReq.pollFirst();
        }
        if (totalReq.size() < r.getMaxrequestAllowed()) {
            reqRepo.save(req);
            return true;
        }
        return false;

    }
}

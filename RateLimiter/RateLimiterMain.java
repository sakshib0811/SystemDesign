package RateLimiter;

import RateLimiter.Models.Rate;
import RateLimiter.Models.Request;
import RateLimiter.Repository.RequestRepository;
import RateLimiter.Services.RateLimiterService;

public class RateLimiterMain {
    public static void main(String[] args) {
        RequestRepository reqRepo = new RequestRepository();
        RateLimiterService rateService = new RateLimiterService(reqRepo);

        Rate rate = new Rate(2, 10);

        // user1
        long reqTime = System.currentTimeMillis();
        // System.out.println(reqTime);
        Request reqUser11 = new Request("1", "user1", reqTime);
        System.out.println("Req1 for user1 allowed : " + rateService.reqAllowed(reqUser11, rate));

        reqTime = System.currentTimeMillis();
        // System.out.println(reqTime);
        Request reqUser12 = new Request("2", "user1", reqTime);
        System.out.println("Req2 for user1 allowed : " + rateService.reqAllowed(reqUser12, rate));

        reqTime = System.currentTimeMillis();
        // System.out.println(reqTime);
        Request reqUser13 = new Request("3", "user1", reqTime);
        System.out.println("Req3 for user1 allowed : " + rateService.reqAllowed(reqUser13, rate));

        reqTime = System.currentTimeMillis();
        Request reqUser14 = new Request("4", "user1", reqTime);
        System.out.println("Req4 for user1 allowed : " +
                rateService.reqAllowed(reqUser14, rate));

        // user2
        reqTime = System.currentTimeMillis();
        // System.out.println(reqTime);
        Request reqUser21 = new Request("5", "user2", reqTime);
        System.out.println("Req1 for user2 allowed : " + rateService.reqAllowed(reqUser21, rate));

        reqTime = System.currentTimeMillis();
        Request reqUser22 = new Request("6", "user2", reqTime);
        System.out.println("Req2 for user2 allowed : " + rateService.reqAllowed(reqUser22, rate));

        reqTime = System.currentTimeMillis();
        // System.out.println(reqTime);
        Request reqUser23 = new Request("7", "user2", reqTime);
        System.out.println("Req3 for user2 allowed : " + rateService.reqAllowed(reqUser23, rate));

    }
}

package RateLimiter.Models;

public class Request {
    String requestId;
    String userId;
    long requestTimeStamp;

    public Request(String requestId, String userId, long requestTimeStamp) {
        this.requestId = requestId;
        this.userId = userId;
        this.requestTimeStamp = requestTimeStamp;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public long getRequestTimeStamp() {
        return requestTimeStamp;
    }

    public void setRequestTimeStamp(long requestTimeStamp) {
        this.requestTimeStamp = requestTimeStamp;
    }

    @Override
    public String toString() {
        return "Request [requestId=" + requestId + ", userId=" + userId + ", requestTimeStamp=" + requestTimeStamp
                + "]";
    }

}

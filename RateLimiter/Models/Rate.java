package RateLimiter.Models;

public class Rate {
    int maxrequestAllowed;
    int windowSize;

    public Rate(int maxrequestAllowed, int windowSize) {
        this.maxrequestAllowed = maxrequestAllowed;
        this.windowSize = windowSize;
    }

    public int getMaxrequestAllowed() {
        return maxrequestAllowed;
    }

    public void setMaxrequestAllowed(int maxrequestAllowed) {
        this.maxrequestAllowed = maxrequestAllowed;
    }

    public int getWindowSize() {
        return windowSize;
    }

    public void setWindowSize(int windowSize) {
        this.windowSize = windowSize;
    }

    @Override
    public String toString() {
        return "Rate [maxrequestAllowed=" + maxrequestAllowed + ", windowSize=" + windowSize + "]";
    }
}

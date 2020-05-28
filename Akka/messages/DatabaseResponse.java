package messages;

public final class DatabaseResponse {
    public final int requestCount;
    public String product;
    public final int id;

    public DatabaseResponse(String product, int requestCount, int id) {
        this.product = product;
        this.requestCount = requestCount;
        this.id = id;
    }

    @Override
    public String toString() {
        return "DatabaseResponse{" +
                "requestCount=" + requestCount +
                ", product='" + product + '\'' +
                ", id=" + id +
                '}';
    }
}

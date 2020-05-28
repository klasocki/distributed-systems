package messages;

public final class PriceResponse{
    public final int price;
    public String product;
    public final int id;
    public int requestCount = -1;

    public PriceResponse(String product, int price, int id) {
        this.product = product;
        this.price = price;
        this.id = id;
    }

    @Override
    public String toString() {
        return "PriceResponse{" +
                "price=" + price +
                ", product='" + product + '\'' +
                ", id=" + id +
                ", requestCount=" + requestCount +
                '}';
    }
}

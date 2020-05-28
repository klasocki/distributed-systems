package messages;

public final class PriceRequest{
    public final int id;
    public final String product;

    public PriceRequest(int id, String product) {
        this.id = id;
        this.product = product;
    }
}

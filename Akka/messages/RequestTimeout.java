package messages;

public class RequestTimeout {
    public final int id;
    public final String product;

    public RequestTimeout(int id, String product) {
        this.id = id;
        this.product = product;
    }

    @Override
    public String toString() {
        return "RequestTimeout{" +
                "id=" + id +
                ", product='" + product + '\'' +
                '}';
    }
}

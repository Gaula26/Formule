package za.ac.cput.domain;

public class CartItems {
    private int id;
    private Product product;
    private int quantity;
    private Double totalItems;

    private CartItems() {}

    private CartItems(Builder builder) {
        this.id = builder.id;
        this.product = builder.product;
        this.quantity = builder.quantity;
        this.totalItems = builder.totalItems;
    }

    public int getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public Double getTotalItems() {
        return totalItems;
    }

    public String getItemId() {
        return String.valueOf(id);
    }

    @Override
    public String toString() {
        return "CartItems{" +
                "id=" + id +
                ", product=" + product +
                ", quantity=" + quantity +
                ", totalItems=" + totalItems +
                '}';
    }

    public static class Builder {
        private int id;
        private Product product;
        private int quantity;
        private Double totalItems;

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setProduct(Product product) {
            this.product = product;
            return this;
        }

        public Builder setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder setTotalItems(Double totalItems) {
            this.totalItems = totalItems;
            return this;
        }

        public Builder copy(CartItems cartItems) {
            this.id = cartItems.id;
            this.product = cartItems.product;
            this.quantity = cartItems.quantity;
            this.totalItems = cartItems.totalItems;
            return this;
        }

        public CartItems build() {
            return new CartItems(this);
        }
    }
}

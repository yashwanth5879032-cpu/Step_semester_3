class Cart {
    private int[] prices;
    private int count;
    private final String cartId;

    public Cart(String cartId, int size) {
        this.cartId = cartId;
        prices = new int[size];
        count = 0;
    }

    public void addItem(int price) {
        if (count < prices.length) {
            prices[count++] = price;
        }
    }

    public int getTotal() {
        int sum = 0;

        for (int i = 0; i < count; i++) {
            sum += prices[i];
        }

        return sum;
    }

    public int getItemCount() {
        return count;
    }

    public String getCartId() {
        return cartId;
    }
}

public class session_8prg10 {
    public static void main(String[] args) {
        Cart cart = new Cart("CART-5", 20);

        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);

        System.out.println("Total = " + cart.getTotal());
        System.out.println("Items = " + cart.getItemCount());
    }
}
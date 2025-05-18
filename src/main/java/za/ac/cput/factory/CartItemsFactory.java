/*
 * Author: Annah Mannda  (230164250)
 * Date: 18/05/2025
 */
package za.ac.cput.factory;

import za.ac.cput.domain.CartItems;
import za.ac.cput.domain.Product;
import za.ac.cput.util.Helper;

public class CartItemsFactory {
    public static CartItems createCartItems(Product product, int quantity, Double totalItems) {
        if (product == null) {
            return null;
        }
        if (!Helper.isValidQuantity(quantity)) {
            return null;
        }
        if (totalItems == null || !Helper.isValidPrice(totalItems) || totalItems <= 0) {
            return null;
        }
        // Validate totalItems matches product.price * quantity
        if (Math.abs(totalItems - (product.getPrice() * quantity)) > 0.001) { // Small delta for double comparison
            return null;
        }

        return new CartItems.Builder()
                .setProduct(product)
                .setQuantity(quantity)
                .setTotalItems(totalItems)
                .build();
    }
}
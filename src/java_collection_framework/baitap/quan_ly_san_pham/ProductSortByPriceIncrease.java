package java_collection_framework.baitap.quan_ly_san_pham;

import java.util.Comparator;

public class ProductSortByPriceIncrease implements Comparator<Product> {
    @Override
    public int compare(Product prd1, Product prd2) {
        return (int) (prd1.getPrice() - prd2.getPrice());
    }
}

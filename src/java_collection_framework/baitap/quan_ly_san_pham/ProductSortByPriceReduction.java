package java_collection_framework.baitap.quan_ly_san_pham;

import java.util.Comparator;

public class ProductSortByPriceReduction implements Comparator<Product> {

    @Override
    public int compare(Product prd1, Product prd2) {
//        return (int) (prd2.getPrice() - prd1.getPrice());
        if (prd1.getPrice() > prd2.getPrice()){
            return -1;
        }
        else if (prd1.getPrice() == prd2.getPrice()){
            return 0;
        }
        else {
            return 1;
        }
    }
}

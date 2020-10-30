package io_binaryfile_serialization.baitap.quan_li_san_pham_nhiphan;

import java.io.Serializable;

public class Product implements Serializable {
    int productCode;
    String productName;
    String manufacturer;
    Double productPrince;

    public Product() {
    }

    public Product(int productCode, String productName, String manufacturer, Double productPrince) {
        this.productCode = productCode;
        this.productName = productName;
        this.manufacturer = manufacturer;
        this.productPrince = productPrince;
    }

    public int getProductCode() {
        return productCode;
    }

    public void setProductCode(int productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Double getProductPrince() {
        return productPrince;
    }

    public void setProductPrince(Double productPrince) {
        this.productPrince = productPrince;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productCode=" + productCode +
                ", productName='" + productName + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", productPrince=" + productPrince +
                '}';
    }
}

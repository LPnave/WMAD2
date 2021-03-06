package pamudithanavaratna.com.styleomega.Database;

import com.orm.SugarRecord;

import java.sql.Blob;

public class Products extends SugarRecord<Products> {
    private int productId;
    private int stock;
    private String productName;
    private String category;
    private String price;
    private String picture;
    private String gender;

    public Products() {
    }

    public Products(int productId, int stock, String productName, String category, String price, String picture, String gender) {
        this.productId = productId;
        this.stock = stock;
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.picture = picture;
        this.gender = gender;
    }

    public Products(String productName, String picture) {
        this.productName = productName;
        this.picture = picture;
    }

    public Products(String productName,  String picture,String price) {
        this.productName = productName;
        this.price = price;
        this.picture = picture;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}

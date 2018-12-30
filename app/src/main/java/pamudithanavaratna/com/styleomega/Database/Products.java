package pamudithanavaratna.com.styleomega.Database;

import com.orm.SugarRecord;

import java.sql.Blob;

public class Products extends SugarRecord {
    int productId;
    String productName;
    String category;
    String price;
    String picture;

    public Products() {

    }

    public Products(int productId, String productName, String category, String price, String picture) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.picture = picture;
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
}

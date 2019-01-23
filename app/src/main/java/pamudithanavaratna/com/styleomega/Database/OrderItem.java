package pamudithanavaratna.com.styleomega.Database;

import com.orm.SugarRecord;

import java.util.Date;

public class OrderItem extends SugarRecord<OrderItem> {

    String itemname;
    int totalquantity;
    String status;
    String subtotal;
    String image;
    String price;
    User user;

    public OrderItem() {
    }

    public OrderItem(String itemname, int totalquantity, String status, String subtotal, String image, String price, User user) {
        this.itemname = itemname;
        this.totalquantity = totalquantity;
        this.status = status;
        this.subtotal = subtotal;
        this.image = image;
        this.price = price;
        this.user = user;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public int getTotalquantity() {
        return totalquantity;
    }

    public void setTotalquantity(int totalquantity) {
        this.totalquantity = totalquantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(String subtotal) {
        this.subtotal = subtotal;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

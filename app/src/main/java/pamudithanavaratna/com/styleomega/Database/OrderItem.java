package pamudithanavaratna.com.styleomega.Database;

import com.orm.SugarRecord;

import java.util.Date;

public class OrderItem extends SugarRecord<OrderItem> {

    String itemname;
    int numberOfItems;
    String Size;
    String addedDate;
    String status;
    String image;
    String subtotal;
    String price;

    User user;

    public OrderItem() {
    }

    public OrderItem(String itemname, int numberOfItems, String size, String addedDate, String status, String image, String subtotal, String price, User user) {
        this.itemname = itemname;
        this.numberOfItems = numberOfItems;
        Size = size;
        this.addedDate = addedDate;
        this.status = status;
        this.image = image;
        this.subtotal = subtotal;
        this.price = price;
        this.user = user;
        System.out.println(this.user);
    }

    public String getItemname() {
        return itemname;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public String getSize() {
        return Size;
    }

    public String getAddedDate() {
        return addedDate;
    }

    public String getStatus() {
        return status;
    }

    public String getImage() {
        return image;
    }

    public String getSubtotal() {
        return subtotal;
    }

    public String getPrice() {
        return price;
    }

    public User getUser() {
       //String email= this.user.getEmail();
        return user;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public void setNumberOfItems(int numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    public void setSize(String size) {
        Size = size;
    }

    public void setAddedDate(String addedDate) {
        this.addedDate = addedDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setSubtotal(String subtotal) {
        this.subtotal = subtotal;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

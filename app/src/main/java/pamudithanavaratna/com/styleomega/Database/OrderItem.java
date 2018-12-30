package pamudithanavaratna.com.styleomega.Database;

import com.orm.SugarRecord;

import java.util.Date;

public class OrderItem extends SugarRecord {

    String itemname;
    int numberOfItems;
    String Size;
    String addedDate;
    String status;
    String image;

    User user;

    public OrderItem() {
    }

    public OrderItem(String itemname, int numberOfItems, String size, String addedDate, String status, String image, User user) {
        this.itemname = itemname;
        this.numberOfItems = numberOfItems;
        Size = size;
        this.addedDate = addedDate;
        this.status = status;
        this.image = image;
        this.user = user;
    }

    public OrderItem(String itemname, int numberOfItems, String size, String addedDate, String status, String image) {
        this.itemname = itemname;
        this.numberOfItems = numberOfItems;
        Size = size;
        this.addedDate = addedDate;
        this.status = status;
        this.image = image;
    }
}

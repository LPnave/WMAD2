package pamudithanavaratna.com.styleomega.Database;

import com.orm.SugarRecord;

import java.util.Date;

public class OrderItem extends SugarRecord {

    int Orderid;
    int numberOfItems;
    String Size;
    Date addedDate;
    String status;

    User user;

    public OrderItem() {
    }

    public OrderItem(int orderid, int numberOfItems, String size, Date addedDate, String status, User user) {
        Orderid = orderid;
        this.numberOfItems = numberOfItems;
        Size = size;
        this.addedDate = addedDate;
        this.status = status;
        this.user = user;
    }
}

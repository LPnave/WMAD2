package pamudithanavaratna.com.styleomega.Database;

import com.orm.SugarRecord;

import java.io.Serializable;

public class ShippingDetails extends SugarRecord implements Serializable {

    String address;
    String lane;
    String city;
    String province;
    int postalcode;

    User user;

    public ShippingDetails() {

    }

    public ShippingDetails(String address, String lane, String city, String province, int postalcode, User user) {
        this.address = address;
        this.lane = lane;
        this.city = city;
        this.province = province;
        this.postalcode = postalcode;
        this.user = user;
    }
}





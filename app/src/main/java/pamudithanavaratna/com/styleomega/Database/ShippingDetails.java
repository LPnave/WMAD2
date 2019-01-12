package pamudithanavaratna.com.styleomega.Database;

import com.orm.SugarRecord;

import java.io.Serializable;

public class ShippingDetails extends SugarRecord<ShippingDetails> implements Serializable {

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLane() {
        return lane;
    }

    public void setLane(String lane) {
        this.lane = lane;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public int getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(int postalcode) {
        this.postalcode = postalcode;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}





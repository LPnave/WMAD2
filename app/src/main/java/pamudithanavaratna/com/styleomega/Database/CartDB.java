package pamudithanavaratna.com.styleomega.Database;

import com.orm.SugarRecord;

import java.util.Date;

public class CartDB extends SugarRecord<CartDB> {

    private OrderItem oi ;
    private  Products p;
    private  int quantity;
    private  String size;
    private  String date;


    public CartDB() {
    }

    public CartDB(OrderItem oi, Products p, int quantity, String size, String date) {
        this.oi = oi;
        this.p = p;
        this.quantity = quantity;
        this.size = size;
        this.date = date;
    }

    public OrderItem getOi() {
        return oi;
    }

    public void setOi(OrderItem oi) {
        this.oi = oi;
    }

    public OrderItem getoi() {
        return oi;
    }

    public void setoi(OrderItem oi) {
        this.oi = oi;
    }

    public Products getP() {
        return p;
    }

    public void setP(Products p) {
        this.p = p;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

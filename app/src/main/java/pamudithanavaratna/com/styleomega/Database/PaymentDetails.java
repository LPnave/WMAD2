package pamudithanavaratna.com.styleomega.Database;

import com.orm.SugarRecord;

import java.util.Date;

public class PaymentDetails extends SugarRecord<PaymentDetails> {

    String cardnumber;
    int vsc;
    Date ExpiriyDate;
    User user;

    public PaymentDetails() {

    }

    public PaymentDetails(String cardnumber, int vsc, Date expiriyDate, User user) {
        this.cardnumber = cardnumber;
        this.vsc = vsc;
        ExpiriyDate = expiriyDate;
        this.user = user;
    }

    public String getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(String cardnumber) {
        this.cardnumber = cardnumber;
    }

    public int getVsc() {
        return vsc;
    }

    public void setVsc(int vsc) {
        this.vsc = vsc;
    }

    public Date getExpiriyDate() {
        return ExpiriyDate;
    }

    public void setExpiriyDate(Date expiriyDate) {
        ExpiriyDate = expiriyDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

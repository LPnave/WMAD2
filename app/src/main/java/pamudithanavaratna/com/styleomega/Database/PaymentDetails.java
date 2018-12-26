package pamudithanavaratna.com.styleomega.Database;

import com.orm.SugarRecord;

import java.util.Date;

public class PaymentDetails extends SugarRecord {

    int cardnumber;
    int vsc;
    Date ExpiriyDate;
    User user;

    public PaymentDetails() {

    }

    public PaymentDetails(int cardnumber, int vsc, Date expiriyDate, User user) {
        this.cardnumber = cardnumber;
        this.vsc = vsc;
        ExpiriyDate = expiriyDate;
        this.user = user;
    }
}
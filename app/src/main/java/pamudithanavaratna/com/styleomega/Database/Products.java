package pamudithanavaratna.com.styleomega.Database;

import com.orm.SugarRecord;

import java.sql.Blob;

public class Products extends SugarRecord {
    String productId;
    String productName;
    float Amount;
    Blob piture;

    public Products() {

    }

    public Products(String productId, String productName, float amount, Blob piture) {
        this.productId = productId;
        this.productName = productName;
        Amount = amount;
        this.piture = piture;
    }
}

package pamudithanavaratna.com.styleomega.Database;

import com.orm.SugarRecord;

public class Rating extends SugarRecord {

    private Products products;
    private int Rating;
    private int numberOfTimesRated;

    public Rating() {

    }

    public Rating(Products products, int rating, int numberOfTimesRated) {
        this.products = products;
        Rating = rating;
        this.numberOfTimesRated = numberOfTimesRated;
    }
}

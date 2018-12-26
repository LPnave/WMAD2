package pamudithanavaratna.com.styleomega.Database;

import com.orm.SugarRecord;

public class Rating extends SugarRecord {

    Products products;
    int Rating;
    int numberOfTimesRated;

    public Rating() {

    }

    public Rating(Products products, int rating, int numberOfTimesRated) {
        this.products = products;
        Rating = rating;
        this.numberOfTimesRated = numberOfTimesRated;
    }
}

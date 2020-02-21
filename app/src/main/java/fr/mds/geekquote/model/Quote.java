package fr.mds.geekquote.model;

import androidx.annotation.NonNull;

import java.util.Date;

public class Quote {
    private String strQuote;
    private int rating;
    private Date creationDate;

    public Quote() {
        //Nothing to do here..
    }

    public Quote(String strQuote) {
        this.strQuote = strQuote;
        this.rating = 0;
        this.creationDate = new Date();
    }

    public Quote(String strQuote, int rating, Date creationDate) {
        this.strQuote = strQuote;
        this.rating = rating;
        this.creationDate = creationDate;
    }

    public String getStrQuote() {
        return strQuote;
    }

    public void setStrQuote(String strQuote) {
        this.strQuote = strQuote;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @NonNull
    @Override
    public String toString() {
        return "Quote : " + this.getStrQuote() + ", rating : " + this.getRating() + ", date : " + this.getCreationDate();
    }
}

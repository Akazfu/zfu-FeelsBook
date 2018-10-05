package feelsbook.cs.ualberta.ca.zfu_feelsbook;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

public class Emotion {
    protected String name;
    private String date;
    private String comment;

    Emotion(String name) {
        this.name = name;
    }

    Emotion(String name, String date, String comment) {
        this.name = name;
        this.date = date;
        this.comment = comment;
    }

    //implement some methods for attributes of Emotion Objects.
    public String getName() {
        return this.name;
    }

    public String getDate() {
        return this.date;
    }

    public String getComment() {
        return this.comment;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setCurrentDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.CANADA);
        this.date = sdf.format(new Date());
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    //To covert emotion objects to a line of String, which date is in ISO:8601 format.
    public String toString() {
        return this.date + " | " + this.name + " | " + this.comment;
    }

    public boolean equals(Emotion emotion) {
        return emotion.getName().equals(this.getName())
                && emotion.getComment().equals(this.getComment())
                && emotion.getDate().equals(this.getDate());

    }
}

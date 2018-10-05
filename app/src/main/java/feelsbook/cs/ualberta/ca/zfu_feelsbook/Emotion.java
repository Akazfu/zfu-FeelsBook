package feelsbook.cs.ualberta.ca.zfu_feelsbook;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Emotion {
    protected String name;
    public Date date;
    public String comment;

    //Constructor method, which initialize the current date, count=0, and a null comment.
    Emotion(String name){
        this.name = name;
        this.date = new Date();
        this.comment = null;
    }

    //implement some methods for attributes of Emotion Objects.
    public String getName() {
        return this.name;
    }
    public Date getDate() {
        return this.date;
    }
    public String getComment(){
        return this.comment;
    }

    //To covert emotion objects to a line of String, which date is in ISO:8601 format.
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.CANADA);
        String formattedDate = sdf.format(this.date);
        return formattedDate + " | " + this.name + " | " + this.comment;
    }
}

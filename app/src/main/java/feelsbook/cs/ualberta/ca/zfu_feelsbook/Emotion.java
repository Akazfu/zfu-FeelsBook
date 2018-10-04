package feelsbook.cs.ualberta.ca.zfu_feelsbook;

import java.util.Date;

public class Emotion {

    private String name;
    public Date date;
    public int count;
    public String comment;

    //Constructor method, which initialize the current date, count=0, and a null comment.
    Emotion(String name){
        this.name = name;
        this.date = new Date();
        this.count = 0;
        this.comment = null;
    }

    public String getName() {
        return this.name;
    }
    public Date getDate() {
        return this.date;
    }
    public int getCount() {
        return this.count;
    }
    public String getComment(){
        return this.comment;
    }


    public void resetCount(){
        this.count = 0;
    }
    public void increaseCount(){
        this.count++;
    }
    public void decreaseCoung() { this.count--; }
}

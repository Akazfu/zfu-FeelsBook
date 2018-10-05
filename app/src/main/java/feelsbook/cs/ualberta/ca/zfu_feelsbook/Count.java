package feelsbook.cs.ualberta.ca.zfu_feelsbook;

public class Count {
    public int count = 0;

    //Count methods.
    public int getCount() {
        return this.count;
    }
    public void resetCount(){ this.count = 0; }
    public void increaseCount(){ this.count++; }
    public void decreaseCoung() { this.count--; }
}

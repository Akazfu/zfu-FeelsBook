package feelsbook.cs.ualberta.ca.zfu_feelsbook;

public class Count {
    public int count = 0;

    public int getCount() {
        return this.count;
    }

    public void resetCount(){ this.count = 0; }
    public void plusCount(){ this.count++; }
    public void minusCoung() { this.count--; }
}

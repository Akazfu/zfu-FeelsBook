package feelsbook.cs.ualberta.ca.zfu_feelsbook;

import java.util.ArrayList;
import java.util.Collection;

public class Record {

    protected  ArrayList<Emotion> record;

    //Constructor, an list contains emotions.
    public Record(){
        record = new ArrayList<Emotion>();
    }

    public Collection<Emotion> getEmotions() {
        return record;
    }
    public void addEmotion(Emotion newEmotion) {
        record.add(newEmotion);
    }
    public void removeEmotion(Emotion oldEmotion) {
        record.remove(oldEmotion);
    }
    public int size() {
        return record.size();
    }
    public Emotion chooseEmotion(int index) throws EmptyRecordException {
        int size = record.size();
        if (size <= 0) {
            throw new EmptyRecordException();
        }
        return record.get(index);
    }
    public boolean contains(Emotion newEmotion) {
        return record.contains(newEmotion);
    }
    public void clearEmotion() {
        record.clear();
    }
}

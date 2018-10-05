package feelsbook.cs.ualberta.ca.zfu_feelsbook;

import java.util.ArrayList;
import java.util.Collection;

public class Record {
    protected  ArrayList<Emotion> record;

    public Record(){
        record = new ArrayList<Emotion>();
    }

    public Collection<Emotion> getEmotions() {
        return record;
    }

    public void addEmotion(Emotion newEmotion) {
        record.add(newEmotion);
    }

    public void removeEmotion(int index) {
        record.remove(index);
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
}

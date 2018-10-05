package feelsbook.cs.ualberta.ca.zfu_feelsbook;

import java.util.ArrayList;
import java.util.Collection;

public class Record {
    protected  ArrayList<Emotion> record;

    public Record(){
        record = new ArrayList<Emotion>();
    }

    public ArrayList<Emotion> getEmotions() {
        return record;
    }

    public void addEmotion(Emotion newEmotion) {
        record.add(newEmotion);
    }

    public void removeEmotion(Emotion emotion) {
        int id=-1;
        for(int i=0;i<record.size();i++){
            if(record.get(i).equals(emotion)){
                id=i;
                break;
            }
        }
        if(id!=-1){
            record.remove(id);
        }
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

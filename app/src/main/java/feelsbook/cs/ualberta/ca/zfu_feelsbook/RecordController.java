package feelsbook.cs.ualberta.ca.zfu_feelsbook;

public class RecordController {
    private static Record record = null;

    static public Record getRecord() {
        if (record == null) {
            record = new Record();
        }
        return record;
    }

    public void addEmotion(Emotion emotion) {
        getRecord().addEmotion(emotion);
    }

    /*public Emotion chooseEmotion(int index) throws EmptyRecordException {
        return getRecord().chooseEmotion(index);
    }*/
}

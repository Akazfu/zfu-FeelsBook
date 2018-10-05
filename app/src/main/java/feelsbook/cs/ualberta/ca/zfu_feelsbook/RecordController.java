package feelsbook.cs.ualberta.ca.zfu_feelsbook;

import android.content.SharedPreferences;

import java.util.ArrayList;

public class RecordController {
    private static ArrayList<Emotion> records;

    private static RecordController recordController = null;

    public static ArrayList<Emotion> getRecords(SharedPreferences sharedPreferences) {
        if (records != null) {
            return records;
        }
        records = readFromSharePreferences(sharedPreferences);
        if (records == null) {
            records = new ArrayList<>();
        }
        return records;
    }

    public void addEmotion_(Emotion emotion) {
        records.add(emotion);
    }

    public void removeEmotion_(Emotion emotion) {
        int id = -1;
        for (int i = 0; i < records.size(); i++) {
            if (records.get(i).equals(emotion)) {
                id = i;
                break;
            }
        }
        if (id != -1) {
            records.remove(id);
        }
    }

    public void save2SharePreferences(SharedPreferences sharedPreferences) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        ArrayList<Emotion> emotions = records;
        editor.putInt("count", emotions.size());

        for (int i = 0; i < emotions.size(); i++) {
            Emotion emotion = emotions.get(i);
            editor.putString("name" + i, (null == emotion.getName() || "".equals(emotion.getName()) ? "#&null&#" : emotion.getName()));
            editor.putString("date" + i, (null == emotion.getDate() || "".equals(emotion.getDate()) ? "#&null&#" : emotion.getDate()));
            editor.putString("comment" + i, (null == emotion.getComment() || "".equals(emotion.getComment()) ? "#&null&#" : emotion.getComment()));
        }
        editor.apply();
    }

    public static ArrayList<Emotion> readFromSharePreferences(SharedPreferences sharedPreferences) {
        ArrayList<Emotion> emotions = new ArrayList<>();
        int count = sharedPreferences.getInt("count", -1);
        if (count == -1) {
            return null;
        }
        for (int i = 0; i < count; i++) {
            String name = sharedPreferences.getString("name" + i, "#&null&#");
            if (name.equals("#&null&#")) {
                break;
            }
            Emotion emotion = new Emotion(name);
            String date = sharedPreferences.getString("date" + i, "#&null&#");
            if (date.equals("#&null&#")) {
                emotion.setDate("");
            } else {
                emotion.setDate(date);
            }
            String comment = sharedPreferences.getString("comment" + i, "#&null&#");
            if (comment.equals("#&null&#")) {
                emotion.setComment("");
            } else {
                emotion.setComment(comment);
            }
            emotions.add(emotion);
        }
        return emotions;
    }

}

package feelsbook.cs.ualberta.ca.zfu_feelsbook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CountActivity extends AppCompatActivity {
    //setup count for 6 emotions.
    TextView Joy;
    TextView Love;
    TextView Surprise;
    TextView Anger;
    TextView Sad;
    TextView Fear;
    ArrayList<TextView> emotions;
    ArrayList<String> emotionText;
    Map<String, Integer> emotionMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_count);
        Joy = (TextView) findViewById(R.id.count_joy);
        Love = (TextView) findViewById(R.id.count_love);
        Surprise = (TextView) findViewById(R.id.count_surprise);
        Anger = (TextView) findViewById(R.id.count_anger);
        Sad = (TextView) findViewById(R.id.count_sadness);
        Fear = (TextView) findViewById(R.id.count_fear);

        // setup a list of count textview, and a list of string to find counts.
        emotions = new ArrayList<TextView>();
        emotionText = new ArrayList<String>();

        emotions.add(Joy);
        emotions.add(Love);
        emotions.add(Surprise);
        emotions.add(Anger);
        emotions.add(Sad);
        emotions.add(Fear);
        emotionText.add("Joy");
        emotionText.add("Love");
        emotionText.add("Surprise");
        emotionText.add("Anger");
        emotionText.add("Sadness");
        emotionText.add("Fear");

        emotionMap = new HashMap<>();
        //get emotion list from record controller check the names, if equal put to corresponding emotion hash map.
        ArrayList<Emotion> emotionList = RecordController.getRecords(getSharedPreferences("emotions", MODE_MULTI_PROCESS));
        //for same string, counts add 1.
        int counts[] = new int[6];
        for (int i = 0; i < emotionList.size(); i++) {
            String emotionName = emotionList.get(i).getName();
            if (emotionName.equals("Joy")) {
                emotionMap.put("Joy", ++counts[0]);
            } else if (emotionName.equals("Love")) {
                emotionMap.put("Love", ++counts[1]);
            } else if (emotionName.equals("Surprise")) {
                emotionMap.put("Surprise", ++counts[2]);
            } else if (emotionName.equals("Anger")) {
                emotionMap.put("Anger", ++counts[3]);
            } else if (emotionName.equals("Sadness")) {
                emotionMap.put("Sadness", ++counts[4]);
            } else if (emotionName.equals("Fear")) {
                emotionMap.put("Fear", ++counts[5]);
            }
        }

        //set the counts in count activity to corresponding text view.
        for (String key : emotionMap.keySet()) {
            String countStr = String.valueOf(emotionMap.get(key));
            if (key.equals("Joy")) {
                Joy.setText(countStr);
            } else if (key.equals("Love")) {
                Love.setText(countStr);
            } else if (key.equals("Surprise")) {
                Surprise.setText(countStr);
            } else if (key.equals("Anger")) {
                Anger.setText(countStr);
            } else if (key.equals("Sadness")) {
                Sad.setText(countStr);
            } else if (key.equals("Fear")) {
                Fear.setText(countStr);
            }
        }

    }
}

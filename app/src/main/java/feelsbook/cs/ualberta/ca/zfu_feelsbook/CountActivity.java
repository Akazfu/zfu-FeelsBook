package feelsbook.cs.ualberta.ca.zfu_feelsbook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

public class CountActivity extends AppCompatActivity {
    TextView Joy;
    TextView Love;
    TextView Surprise;
    TextView Anger;
    TextView Sad;
    TextView Fear;
    ArrayList<TextView> emotions;
    ArrayList<String> emotionText;
    Map emotionMap;



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


        emotionMap = (Map) RecordController.getRecord();

        int i;
        for (i = 0; i < 6; i++){
            if (emotionMap.get(emotionText.get(i)) == null) {
                emotions.get(i).setText(String.valueOf(0));
            } else {
                String emotionName = emotionText.get(i);
                emotions.get(i).setText(String.valueOf((int) emotionMap.get(emotionName)));
            }
        }


    }
}

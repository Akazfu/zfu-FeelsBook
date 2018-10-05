package feelsbook.cs.ualberta.ca.zfu_feelsbook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
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
    Map<String,Integer> emotionMap;



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

        emotionMap = new HashMap<>();
        ArrayList<Emotion> emotionList=RecordController.getRecord().getEmotions();
        int counts[]=new int[6];
        for(int i=0;i<emotionList.size();i++){
            String emotionName = emotionList.get(i).getName();
            if(emotionName.equals("Joy")){
                emotionMap.put("Joy",++counts[0]);
            }else if(emotionName.equals("Love")){
                emotionMap.put("Love",++counts[1]);
            }else if(emotionName.equals("Surprise")){
                emotionMap.put("Surprise",++counts[2]);
            }else if(emotionName.equals("Anger")){
                emotionMap.put("Anger",+counts[3]);
            }else if(emotionName.equals("Sadness")){
                emotionMap.put("Sadness",++counts[4]);
            } else if(emotionName.equals("Fear")){
                emotionMap.put("Fear",++counts[5]);
            }
        }

        for(String key:emotionMap.keySet())
        {
            String  countStr=String.valueOf(emotionMap.get(key));
            if (key.equals("Joy")){
                Joy.setText(countStr);
            }else if(key.equals("Love")){
                Love.setText(countStr);
            }else if(key.equals("Surprise")){
              Surprise.setText(countStr);
            }else if(key.equals("Anger")){
                Anger.setText(countStr);
            }else if(key.equals("Sadness")){
                Sad.setText(countStr);
            }else if(key.equals("Fear")){
                Fear.setText(countStr);
            }
        }

//        int i;
//        for (i = 0; i < 6; i++){
//            if (emotionMap.get(emotionText.get(i)) == null) {
//                emotions.get(i).setText(String.valueOf(0));
//            } else {
//                String emotionName = emotionText.get(i);
//                emotions.get(i).setText(String.valueOf((int) emotionMap.get(emotionName)));
//            }
//        }


    }
}

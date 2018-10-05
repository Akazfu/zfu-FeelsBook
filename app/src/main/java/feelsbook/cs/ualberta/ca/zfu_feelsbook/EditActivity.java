package feelsbook.cs.ualberta.ca.zfu_feelsbook;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EditActivity extends AppCompatActivity {
    private EditText emotionName;
    private EditText date;
    private EditText comment;
    private Button btn_delete;
    private Button btn_save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        emotionName = findViewById(R.id.text_change1);
        date = findViewById(R.id.text_change2);
        comment = findViewById(R.id.text_change3);
        btn_delete = findViewById(R.id.button_delete);
        btn_save = findViewById(R.id.button_save);

        Intent intent = getIntent();
        emotionName.setText(intent.getStringExtra("name"));
        date.setText(intent.getStringExtra("date"));
        comment.setText(intent.getStringExtra("comment"));
        final Emotion emotion = new Emotion(intent.getStringExtra("name"));
        emotion.setDate(intent.getStringExtra("date"));
        emotion.setComment(intent.getStringExtra("comment"));

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Emotion newEmotion = new Emotion(emotionName.getText().toString());
                newEmotion.setDate(date.getText().toString());
                newEmotion.setComment(comment.getText().toString());
                if (!newEmotion.equals(emotion)) {
                    RecordController rc = new RecordController();
                    rc.removeEmotion_(emotion);
                    rc.addEmotion_(newEmotion);
                    rc.save2SharePreferences(getSharedPreferences("emotions", MODE_MULTI_PROCESS));
                    Toast.makeText(EditActivity.this, "save successful", Toast.LENGTH_SHORT).show();
                    // Refresh the recordActivity
                    Intent intent = new Intent();
                    intent.setAction("action.refreshRecord");
                    sendBroadcast(intent);

                    finish();
                }
            }
        });

        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RecordController rc = new RecordController();
                rc.removeEmotion_(emotion);
                rc.save2SharePreferences(getSharedPreferences("emotions", MODE_MULTI_PROCESS));
                Toast.makeText(EditActivity.this, "delete successful", Toast.LENGTH_SHORT).show();
                // Refresh the recordActivity
                Intent intent = new Intent();
                intent.setAction("action.refreshRecord");
                sendBroadcast(intent);

                finish();
            }
        });
    }
}

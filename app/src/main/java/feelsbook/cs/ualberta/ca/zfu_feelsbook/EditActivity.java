package feelsbook.cs.ualberta.ca.zfu_feelsbook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class EditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
    }

    /*public void chooseAStudent(View v, int index) {
        Toast.makeText(this, "Choose A record", Toast.LENGTH_SHORT).show();
        RecordController rc = new RecordController();
        try {
            Emotion e = rc.chooseEmotion(index);
            TextView view = (TextView) findViewById( R.id.chosenEmotionTextView);
            view.setText(e.getName());
        } catch (EmptyRecordException e) {
            Toast.makeText(this, "There are no records!", Toast.LENGTH_SHORT).show();
        }
    }*/
}

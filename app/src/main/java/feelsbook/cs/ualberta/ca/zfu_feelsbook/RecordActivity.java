package feelsbook.cs.ualberta.ca.zfu_feelsbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;

public class RecordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

        ListView listView = (ListView) findViewById(R.id.list_Records);
        Collection<Emotion> emotions = RecordController.getRecord().getEmotions();
        final ArrayList<Emotion> list = new ArrayList<Emotion>(emotions);
        final ArrayAdapter<Emotion> adapter = new ArrayAdapter<Emotion>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);
        clickCallback();

    }

    public void editRecord(View view) {
        Intent intent = new Intent(RecordActivity.this, EditActivity.class);
        startActivity(intent);
    }

    //this method is a notification for user to know which line of the list is clicked for edit.
    private void clickCallback() {
        ListView list = (ListView) findViewById(R.id.list_Records);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {
                TextView textView = (TextView) viewClicked;
                position ++;
                //textView.getText().toString()
                String message = "You selected #" + position + ", record in the list.";
                Toast.makeText(RecordActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });
    }


}

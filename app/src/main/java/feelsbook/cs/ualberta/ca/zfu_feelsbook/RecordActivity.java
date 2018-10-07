package feelsbook.cs.ualberta.ca.zfu_feelsbook;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
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
import java.util.HashMap;

public class RecordActivity extends AppCompatActivity {
    //this activity shows a list view of records saved in phone data.
    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

        listView = (ListView) findViewById(R.id.list_Records);

        refresh();
        clickCallback();

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("action.refreshRecord");
        registerReceiver(mRefreshBroadcastReceiver, intentFilter);
    }

    //button edit for jump to edit activity.
    //public void editRecord(View view) {
        //Intent intent = new Intent(RecordActivity.this, EditActivity.class);
        //startActivity(intent);
    //}

    //this method is a notification for user to know which line of the list is clicked for edit.
    private void clickCallback() {
        //setup edit activity on click the item in records list view.
        ListView list = (ListView) findViewById(R.id.list_Records);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {

                Emotion emotion = (Emotion) parent.getItemAtPosition(position);
                //Toast.makeText(RecordActivity.this, emotion.toString(), Toast.LENGTH_SHORT).show();

                // start a new activity
                Intent intent = new Intent(RecordActivity.this, EditActivity.class);
                intent.putExtra("date", emotion.getDate());
                intent.putExtra("name", emotion.getName());
                intent.putExtra("comment", emotion.getComment());
                startActivity(intent);

              //TextView textView = (TextView) viewClicked;
              //position ++;
              //textView.getText().toString()
              //String message = "You selected #" + position + ", record in the list.";
              //Toast.makeText(RecordActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });
    }


    // broadcast receiver
    private BroadcastReceiver mRefreshBroadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals("action.refreshRecord")) {
                refresh();
            }
        }
    };

    //refresh the array list on change.
    public void refresh() {
        ArrayList<Emotion> emotions = RecordController.getRecords(getSharedPreferences("emotions", MODE_MULTI_PROCESS));
        ArrayList<Emotion> list = new ArrayList<Emotion>(emotions);
        final ArrayAdapter<Emotion> adapter = new ArrayAdapter<Emotion>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mRefreshBroadcastReceiver);
    }

}

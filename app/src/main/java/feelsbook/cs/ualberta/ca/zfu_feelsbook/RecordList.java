package feelsbook.cs.ualberta.ca.zfu_feelsbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RecordList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);
        //setup the record button that start a new activity to view record list.
        Button buttonedit = (Button)findViewById(R.id.button_edit);
        buttonedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecordList.this, Edit.class);
                startActivity(intent);
            }
        });
    }
}

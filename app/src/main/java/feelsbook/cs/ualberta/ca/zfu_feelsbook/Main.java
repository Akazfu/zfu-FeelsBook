/*
<zfu-FeelsBook: Created for the purpose of record feelings.>
        Copyright (C) <2018>  <Ziming Fu, akazfu@gmail.com>

        This program is free software: you can redistribute it and/or modify
        it under the terms of the GNU General Public License as published by
        the Free Software Foundation, either version 3 of the License, or
        (at your option) any later version.

        This program is distributed in the hope that it will be useful,
        but WITHOUT ANY WARRANTY; without even the implied warranty of
        MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
        GNU General Public License for more details.

        You should have received a copy of the GNU General Public License
        along with this program.  If not, see <https://www.gnu.org/licenses/>.
*/
package feelsbook.cs.ualberta.ca.zfu_feelsbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main extends AppCompatActivity {
    //Assign six emotions.
    protected Emotion Love = new Emotion("Love");
    protected Emotion Joy = new Emotion("Joy");
    protected Emotion Surprise = new Emotion("Surprise");
    protected Emotion Anger = new Emotion("Anger");
    protected Emotion Sadness = new Emotion("Sadness");
    protected Emotion Fear = new Emotion("Fear");

    



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setup the record button that start a new activity to view record list.
        Button buttonrecord = (Button)findViewById(R.id.button_record);
        buttonrecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main.this, RecordList.class);
                startActivity(intent);
            }
        });
    }
}

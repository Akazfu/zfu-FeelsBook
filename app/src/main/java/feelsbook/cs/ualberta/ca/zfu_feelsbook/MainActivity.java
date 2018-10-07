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
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //setup a record controller for general use of functions, like store, edit, etc...
    public static RecordController rc = new RecordController();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //load data using SharedPreferences.
        RecordController.getRecords(getSharedPreferences("emotions", MODE_MULTI_PROCESS));
    }

    //this function is called on click of button record to jump to record list activity.
    public void viewRecord(View view) {
        //Toast.makeText(this,"Checkout Records.", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this, RecordActivity.class);
        startActivity(intent);
    }

    //called by onclick button count, jump to count activity.
    public void viewCount(View view) {
        Intent intent = new Intent(MainActivity.this, CountActivity.class);
        startActivity(intent);
    }

    // general action for click emotion buttons.
    public void emotionClick(View view) {
        Button clickedEmotion = (Button) view;
        String buttonText = (String) clickedEmotion.getText();
        EditText input = (EditText) findViewById(R.id.text_addcomment);
        Emotion newEmotion = new Emotion(buttonText);
        newEmotion.setCurrentDate();

        //notification for confirm which emotion button is clicked, and added to the record.
        Toast.makeText(this, "New emotion (" + buttonText + ") added.", Toast.LENGTH_SHORT).show();
        //if/else statement for whether the user input is valid or set it to null.
        if (input != null) {
            newEmotion.setComment(input.getText().toString());
            input.getText().clear();
        } else {
            newEmotion.setComment(null);
        }
        //add the new emotion to the record controller.
        rc.addEmotion_(newEmotion);
        //save data.
        rc.save2SharePreferences(getSharedPreferences("emotions", MODE_MULTI_PROCESS));
    }
}

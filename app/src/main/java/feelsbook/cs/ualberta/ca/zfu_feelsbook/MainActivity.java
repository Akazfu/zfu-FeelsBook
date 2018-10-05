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
    public static RecordController rc = new RecordController();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void viewRecord(View view) {
        //Toast.makeText(this,"Checkout Records.", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this, RecordActivity.class);
        startActivity(intent);
    }
    public void emotionClick(View view) {
        Button clickedEmotion = (Button) view;
        String buttonText = (String) clickedEmotion.getText();
        EditText input = (EditText) findViewById(R.id.text_addcomment);
        Emotion newEmotion = new Emotion(buttonText);
        Toast.makeText(this,"New emotion (" + buttonText + ") added.", Toast.LENGTH_SHORT).show();
        rc.addEmotion(newEmotion);
    }
}

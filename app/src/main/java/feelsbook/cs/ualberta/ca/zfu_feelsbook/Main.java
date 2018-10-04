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

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Main extends AppCompatActivity {
    //Assign six emotions.
    public static Emotion Love = new Emotion("Love");
    public static Emotion Joy = new Emotion("Joy");
    public static Emotion Surprise = new Emotion("Surprise");
    public static Emotion Anger = new Emotion("Anger");
    public static Emotion Sadness = new Emotion("Sadness");
    public static Emotion Fear = new Emotion("Fear");

    



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}

package lifeline.learn.com.clashofclansdata;

/*
	PROJECT CREATED BY: PRATHAM KHURANA
	DATE: 5th JANUARY 2017
	COPYRIGHT: PRATHAM KHURANA
	CONTACT: +918860401724
*/

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button gettemp;
    Button exit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main2);
        gettemp = (Button) findViewById (R.id.get);
        gettemp.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                startActivity (new Intent (MainActivity.this, Main2Activity.class));
            }
        });
        exit = (Button) findViewById (R.id.exit);
        exit.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                System.exit (1);
            }
        });
    }

}

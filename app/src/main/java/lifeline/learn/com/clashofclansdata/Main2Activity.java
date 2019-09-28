package lifeline.learn.com.clashofclansdata;

/*
	PROJECT CREATED BY: PRATHAM KHURANA
	DATE: 5th JANUARY 2017
	COPYRIGHT: PRATHAM KHURANA
	CONTACT: +918860401724
*/
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class Main2Activity extends AppCompatActivity {

    public static Button button;
    public static TextView temp;
    public static TextView cityname;
    public static EditText written;
    public static ImageView imageView;
    RelativeLayout relativeLayout;
    TextToSpeech textToSpeech;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        button = (Button) findViewById (R.id.button);
        temp = (TextView) findViewById (R.id.temp);
        cityname = (TextView) findViewById (R.id.cityname);
        relativeLayout = (RelativeLayout) findViewById (R.id.relative);
        written = (EditText) findViewById (R.id.editText);
        imageView = (ImageView) findViewById (R.id.imageView);
        button.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                try {
                    if(written.getText ().toString ().isEmpty () || written.getText ().toString ().equals ("")){
                        Toast.makeText (Main2Activity.this, "Enter your City name", Toast.LENGTH_LONG).show ();
                    }else {
                        temp.setAlpha (0f);
                        cityname.setAlpha (0f);
                        speaking (Parsing.weathername, Parsing.weathertemp);
                        Parsing parsing = new Parsing ();
                        parsing.execute ();
                        written.setText("");
                    }
                }catch (Exception e){
                    Toast.makeText (Main2Activity.this, e.getMessage ().toString (), Toast.LENGTH_SHORT).show ();
                }
            }
        });
    }

    public void speaking(final String country, final String temp){
        textToSpeech = new TextToSpeech (Main2Activity.this, new TextToSpeech.OnInitListener () {
            @Override
            public void onInit(int i) {
                textToSpeech.setLanguage (Locale.US);
                textToSpeech.speak ("Temperature of " + country + " is " + temp + " °C", TextToSpeech.QUEUE_FLUSH, null, null);
            }
        });
    }

    public void onPause(){
        super.onPause ();
    }

    public void onResume(){
        super.onResume ();
    }
}

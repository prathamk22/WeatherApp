package lifeline.learn.com.clashofclansdata;

/*
	PROJECT CREATED BY: PRATHAM KHURANA
	DATE: 5th JANUARY 2017
	COPYRIGHT: PRATHAM KHURANA
	CONTACT: +918860401724
*/

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Parsing extends AsyncTask<Void,Void,Void> {
    String weatherdata="";
    String weatherline ="";
    public static String weathertemp = "";
    public static String weathername = "";
    String weathercityname = Main2Activity.written.getText ().toString ();
    String weathercode = "";
    String weathercloudes="";

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url = new URL ("http://api.openweathermap.org/data/2.5/weather?q=" + weathercityname + "&appid=b582c6c5c17a84c8cfbd810cb9d7d0ad&units=metric");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection ();
            InputStream inputStream = httpURLConnection.getInputStream ();
            BufferedReader bufferedReader = new BufferedReader (new InputStreamReader (inputStream));
            while(weatherline != null){
                weatherline = bufferedReader.readLine ();
                weatherdata += weatherline;
            }
        } catch (MalformedURLException e) {

        } catch (IOException ex) {

        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        try {
            JSONObject jsonObject = new JSONObject (weatherdata);
            weathercode = jsonObject.getString ("cod");
            weathername = jsonObject.getString ("name");
            JSONObject jsonObject1 = new JSONObject (jsonObject.getString ("main"));
            weathertemp = jsonObject1.getString ("temp");
            JSONArray weather = new JSONArray (jsonObject.getString ("weather"));
            JSONObject clouds = new JSONObject (weather.getString (0));
            weathercloudes = clouds.getString ("main");
            if(weathercloudes.toString ().equals ("Smoke")){
                Main2Activity.imageView.setImageResource (R.drawable.smoke);
                Main2Activity.imageView.animate ().alphaBy (1f).setDuration (200);
            }else if(weathercloudes.toString ().equals ("Rain")){
                Main2Activity.imageView.setImageResource (R.drawable.rainy);
                Main2Activity.imageView.animate ().alphaBy (1f).setDuration (200);
            }else if(weathercloudes.toString ().equals ("Clouds")){
                Main2Activity.imageView.setImageResource (R.drawable.clouds);
                Main2Activity.imageView.animate ().alphaBy (1f).setDuration (200);
            }else if(weathercloudes.toString ().equals ("Clear")){
                Main2Activity.imageView.setImageResource (R.drawable.clear);
                Main2Activity.imageView.animate ().alphaBy (1f).setDuration (200);
            }else if(weathercloudes.toString ().equals ("Haze")){
                Main2Activity.imageView.setImageResource (R.drawable.haze);
                Main2Activity.imageView.animate ().alphaBy (1f).setDuration (200);
            }else if(weathercloudes.toString ().equals ("Mist")){
                Main2Activity.imageView.setImageResource (R.drawable.mist);
                Main2Activity.imageView.animate ().alphaBy (1f).setDuration (200);
            }else if(weathercloudes.toString ().equals ("Fog")){
                Main2Activity.imageView.setImageResource (R.drawable.fog);
                Main2Activity.imageView.animate ().alphaBy (1f).setDuration (200);
            }else if(weathercloudes.toString ().equals ("Snow")){
                Main2Activity.imageView.setImageResource (R.drawable.snow);
                Main2Activity.imageView.animate ().alphaBy (1f).setDuration (200);
            }
        } catch (JSONException e) {
            e.printStackTrace ();
        }

        Log.i("Temp:", weathertemp);
        Log.i("Name:", weathername);
        Main2Activity.temp.setText (weathertemp + " °C");
        Main2Activity.temp.animate ().alphaBy (1f).setDuration (200);
        Main2Activity.cityname.setText (weathername);
        Main2Activity.cityname.animate ().alphaBy (1f).setDuration (200);
        super.onPostExecute (aVoid);
    }
}
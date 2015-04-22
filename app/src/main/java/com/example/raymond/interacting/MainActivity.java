package com.example.raymond.interacting;


import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    private Button stayEarth, leaveEarth, stayMars, leaveMars;
    private EditText usersName;
    private LinearLayout planet;
    private Boolean onEarth = false;
    private Boolean onMars = false;
    private Boolean vcsTest = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        stayEarth = (Button) findViewById(R.id.stay_earth_button);
        leaveEarth = (Button) findViewById(R.id.leave_earth_button);
        stayMars = (Button) findViewById(R.id.stay_mars_button);
        leaveMars = (Button) findViewById(R.id.leave_mars_button);
        usersName = (EditText) findViewById(R.id.usersName);
        planet = (LinearLayout)findViewById(R.id.linear_layout);

    }
        //testing vcs

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onStayEarthButton(View view) {
        String firstName;
        if(String.valueOf(usersName.getText()).isEmpty()){
            firstName = "the kUser";
        }else {
            firstName = String.valueOf(usersName.getText());
        }
        String sEarth = firstName + " is staying on Earth";
        String eEarth = firstName + " is entering Earth";
        String hEarth = firstName + " is headed to Earth";
        if(!onEarth && !onMars) {
            Toast.makeText(this, eEarth, Toast.LENGTH_LONG).show();
            stayEarth.setText("Stay");
            stayMars.setText("Enter");
            onEarth = true;
            onMars = false;
            vcsTest = true;
        }else if(onMars){
            Toast.makeText(this, hEarth, Toast.LENGTH_LONG).show();
            stayEarth.setText("Stay");
            stayMars.setText("Enter");
            onEarth = true;
            onMars = false;
        }else{
            Toast.makeText(this, sEarth, Toast.LENGTH_LONG).show();

        }

        planet.setBackgroundResource(R.drawable.earth);

    }

    public void onLeaveEarthButton(View view) {
        String firstName;
        if(String.valueOf(usersName.getText()).isEmpty()){
            firstName = "User";
        }else {
            firstName = String.valueOf(usersName.getText());
        }
        String lEarth = firstName + " is headed to space";
        String nEarth = firstName + " is not on Earth";
        if(onEarth) {
            Toast.makeText(this, lEarth, Toast.LENGTH_LONG).show();
            planet.setBackgroundResource(R.drawable.space);
            stayEarth.setText("Enter");
            onEarth = false;
        }else{
            Toast.makeText(this, nEarth, Toast.LENGTH_LONG).show();
        }


    }

    public void onStayMarsButton(View view) {
        String firstName;
        if(String.valueOf(usersName.getText()).isEmpty()){
            firstName = "User";
        }else {
            firstName = String.valueOf(usersName.getText());
        }
        String sMars = firstName + " is staying on Mars";
        String eMars = firstName + " is entering Mars";
        String hMars = firstName + " is headed to Mars";

        if(!onMars && !onEarth){
            Toast.makeText(this, eMars, Toast.LENGTH_LONG).show();
            onMars = true;
            stayMars.setText("Stay");
            stayEarth.setText("Enter");
        }else if(onEarth) {
            Toast.makeText(this, hMars, Toast.LENGTH_LONG).show();
            stayMars.setText("Stay");
            stayEarth.setText("Enter");
            onMars = true;
            onEarth = false;
        }else{
            Toast.makeText(this, sMars, Toast.LENGTH_LONG).show();
        }

        planet.setBackgroundResource(R.drawable.mars);

    }

    public void onLeaveMarsButton(View view) {
        String firstName;
        if(String.valueOf(usersName.getText()).isEmpty()){
            firstName = "User";
        }else {
            firstName = String.valueOf(usersName.getText());
        }
        String lMars = firstName + " is leaving Mars";
        String nMars = firstName + " is not on Mars";
        if(onMars) {
            Toast.makeText(this, lMars, Toast.LENGTH_LONG).show();
            planet.setBackgroundResource(R.drawable.space);
            onMars = false;
            stayMars.setText("Enter");
        }else{
            Toast.makeText(this, nMars, Toast.LENGTH_LONG).show();
        }

    }
}

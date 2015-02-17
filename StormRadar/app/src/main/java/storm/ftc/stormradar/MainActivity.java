package storm.ftc.stormradar;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import storm.ftc.stormradar.DataHandler.Datahandler;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText team = (EditText) this.findViewById(R.id.team),
                team2 = (EditText) this.findViewById(R.id.team2),
                match = (EditText) this.findViewById(R.id.match),
                match2 = (EditText) this.findViewById(R.id.match2);
        final RadioButton red2 = (RadioButton) this.findViewById(R.id.btn_red2),
                blue2 = (RadioButton) this.findViewById(R.id.btn_blue2);
        red2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(red2.isChecked()){
                    red2.setBackgroundResource(R.drawable.red_clicked);
                }
                else{
                    red2.setBackgroundResource(R.drawable.red_unclick);
                }
            }
        });
        blue2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(blue2.isChecked()){
                    blue2.setBackgroundResource(R.drawable.blue_checked);
                }
                else{
                    blue2.setBackgroundResource(R.drawable.blue_unclick);
                }
            }
        });


    }
    public boolean DataEntered() {
        EditText team = (EditText) this.findViewById(R.id.team),
                team2 = (EditText) this.findViewById(R.id.team2),
                match = (EditText) this.findViewById(R.id.match),
                match2 = (EditText) this.findViewById(R.id.match2);

        RadioButton red2 = (RadioButton) this.findViewById(R.id.btn_red2),
                blue2 = (RadioButton) this.findViewById(R.id.btn_blue2);
        if (!team.getText().toString().matches("") && !team2.getText().toString().matches("") && match.getText().toString().matches("")
                && match2.getText().toString().matches("") && ((red2.isChecked() || blue2.isChecked()))) {
            return true;
        }
        return false;
    }
    public void begin(View view){
      if(this.DataEntered()){
          EditText team = (EditText) this.findViewById(R.id.team),
                  team2 = (EditText) this.findViewById(R.id.team2),
                  match = (EditText) this.findViewById(R.id.match),
                  match2 = (EditText) this.findViewById(R.id.match2);

          RadioButton
                  red2 = (RadioButton) this.findViewById(R.id.btn_red2),
                  blue2 = (RadioButton) this.findViewById(R.id.btn_blue2);

          Datahandler.team = team.getText().toString();
          Datahandler.team2 = team2.getText().toString();
          Datahandler.match = match.getText().toString();
          Datahandler.match2 = match2.getText().toString();
          Datahandler.isRed = red2.isChecked();
          Datahandler.isRed2 = red2.isChecked();

          Intent intent = new Intent(this, MatchActivity.class);
          intent.putExtra("Team1", Datahandler.team);
          intent.putExtra("Team2", Datahandler.team2);
          intent.putExtra("Match1", Datahandler.match);
          intent.putExtra("Match2", Datahandler.match2);
          intent.putExtra("Alliance1", Datahandler.isRed);
          intent.putExtra("Alliance2", Datahandler.isRed2);
          startActivity(intent);
      }
        else{
          Toast.makeText(this, "Please input all data", Toast.LENGTH_SHORT);
      }

    }


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
}

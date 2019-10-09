package io.github.owuor91.hover;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;
import com.hover.sdk.api.Hover;
import com.hover.sdk.api.HoverParameters;

public class MainActivity extends AppCompatActivity {
  Button btn10daily, btn5daily, btn50Weekly;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    Hover.initialize(this);
    btn10daily = (Button) findViewById(R.id.btn10dailyAirtime);
    btn5daily = (Button) findViewById(R.id.btn5dailyAirtime);
    btn50Weekly = (Button) findViewById(R.id.btn50WeeklyAirtime);


    btn10daily.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        buy10BobDailyBundle();
      }
    });

    btn5daily.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        buy5bobDailyBundle();
      }
    });

    btn50Weekly.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        buy50WeeklyBundle();
      }
    });
  }

  public void buy10BobDailyBundle(){
    Intent i = new HoverParameters.Builder(this)
        .request("6a08e5d9")
        .buildIntent();

    startActivityForResult(i, 10);
  }

  public void buy5bobDailyBundle(){
    Intent i = new HoverParameters.Builder(this)
        .request("c8f41ef6")
        .buildIntent();

    startActivityForResult(i, 5);
  }

  public void buy50WeeklyBundle(){
    Intent i = new HoverParameters.Builder(this)
        .request("41cf5b6f")
        .buildIntent();

    startActivityForResult(i, 50);
  }

  @Override protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if (requestCode==10 && resultCode==RESULT_OK){
      Toast.makeText(getBaseContext(), requestCode+"/- Daily Bundle Purchase Succeeded", Toast.LENGTH_SHORT).show();
    }
    else if (requestCode==5 && resultCode==RESULT_OK){
      Toast.makeText(getBaseContext(), requestCode+"/- Daily Bundle Purchase Succeeded", Toast.LENGTH_SHORT).show();
    }
    else if (requestCode==50 && resultCode==RESULT_OK){
      Toast.makeText(getBaseContext(), requestCode+"/- Weekly Bundle Purchase Succeeded", Toast.LENGTH_SHORT).show();
    }
    else {
      Toast.makeText(getBaseContext(), requestCode+"/- Bundle Purchase failed", Toast.LENGTH_SHORT).show();
    }

  }
}

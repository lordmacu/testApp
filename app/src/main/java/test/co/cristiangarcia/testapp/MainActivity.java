package test.co.cristiangarcia.testapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import test.co.cristiangarcia.testapp.lib.Services;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Services service= new Services();

        TextView response = (TextView) findViewById(R.id.response);

        service.showMessage(this,response);

    }
}

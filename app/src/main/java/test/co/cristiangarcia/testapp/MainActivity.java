package test.co.cristiangarcia.testapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import test.co.cristiangarcia.testapp.lib.Services;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Context context= this;
        final Services service= new Services();

        final TextView response = (TextView) findViewById(R.id.response);

        Button getMessage= (Button) findViewById(R.id.getMessage);
        getMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                service.showMessage(context,response);
            }
        });

    }
}

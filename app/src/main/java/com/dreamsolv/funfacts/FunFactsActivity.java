package com.dreamsolv.funfacts;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


public class FunFactsActivity extends ActionBarActivity {
    public static final String TAG = FunFactsActivity.class.getSimpleName();

    private FactBook mFactBook =  new FactBook();
    private ColorWheel mColorWheel = new ColorWheel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_facts);

        //declare our view variables and assign them views from the layout file
        final RelativeLayout relativeLayout= (RelativeLayout) findViewById(R.id.funfact_layout);
        final TextView factLabel = (TextView) findViewById(R.id.factTextView);
        final Button showFactBtn = (Button) findViewById(R.id.showFactButton);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fact = mFactBook.getFact();
                int color = mColorWheel.getColor();
                relativeLayout.setBackgroundColor(color);
                showFactBtn.setTextColor(color);
                factLabel.setText(fact);
            }
        };
        showFactBtn.setOnClickListener(listener);

        String message = "Yay! Our activity was created";
        Toast welcomeToast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        welcomeToast.show();
        Log.d(TAG, "we're logging from the onCreate method");
    }
}

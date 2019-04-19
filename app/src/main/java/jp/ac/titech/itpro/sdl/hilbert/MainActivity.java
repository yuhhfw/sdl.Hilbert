package jp.ac.titech.itpro.sdl.hilbert;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final static int MAX_ORDER = 9;
    private int order = 1;

    private TextView orderView;
    private HilbertView hilbertView;
    private Button decButton;
    private Button incButton;
    private final static String KEY_ORDER = "MainActivity.order";
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
        setContentView(R.layout.activity_main);

        orderView = findViewById(R.id.order_view);
        hilbertView = findViewById(R.id.hilbert_view);
        decButton = findViewById(R.id.dec_button);
        incButton = findViewById(R.id.inc_button);

        if(savedInstanceState != null){
            order = savedInstanceState.getInt(KEY_ORDER);
        }

        decButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                assertTrue(order > 1, "A room to decrement order should exist");
                order--;
                display();
            }
        });
        incButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                assertTrue(order < MAX_ORDER, "A room to increment order should exist");
                order++;
                display();
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
        display();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState");
        outState.putInt(KEY_ORDER, order);
    }

    private void display() {
        orderView.setText(getString(R.string.order_view_format, order));
        hilbertView.setOrder(order);
        decButton.setEnabled(order > 1);
        incButton.setEnabled(order < MAX_ORDER);
    }

    public static void assertTrue(boolean f, String message) {
        if (BuildConfig.DEBUG && !f) {
            throw new AssertionError(message);
        }
    }
}

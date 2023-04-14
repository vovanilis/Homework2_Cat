package com.example.a22032023_0712_dz2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textCoordinates;
    float x, y;
    String sDown, sMove, sUp;
    final float xCat = 100 , yCat = 500, deltaCat = 50;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textCoordinates = findViewById(R.id.textView);
        textCoordinates.setOnTouchListener(listener);
    }
    private final View.OnTouchListener listener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            x = event.getX();
            y = event.getY();
            switch (event.getAction()){
                case MotionEvent.ACTION_DOWN:
                    sDown = "Нажатие:\nx = " + x + "\ny = " + y;
                    sMove = "";
                    sUp = "";
                    break;
                case MotionEvent.ACTION_UP:
                    sDown = "";
                    sMove = "";
                    sUp = "Отпускание:\nx = " + x + "\ny = " + y;
                    break;
                case MotionEvent.ACTION_MOVE:
                    sDown = "";
                    sUp = "";
                    sMove = "Движение:\nx = " + x + "\ny = " + y;
                    if (x<(xCat+deltaCat) && x>(xCat-deltaCat) &&
                        y<(yCat+deltaCat) && y>(yCat-deltaCat)){
                        Toast toast = Toast.makeText(getApplicationContext(),
                                "УРА!!! Мы наш кота!!!", Toast.LENGTH_LONG);
                        toast.setGravity(Gravity.BOTTOM,0,0);
                        LinearLayout toastContainer = (LinearLayout) toast.getView();
                        ImageView cat = new ImageView(getApplicationContext());
                        cat.setImageResource(R.drawable.cat);
                        toastContainer.addView(cat);
                        toast.show();
                    }
                    break;
            }
            textCoordinates.setText(sDown+"\n"+sMove+"\n"+sUp);
            return true;
        }
    };
}
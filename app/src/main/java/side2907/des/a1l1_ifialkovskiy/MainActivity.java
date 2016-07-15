package side2907.des.a1l1_ifialkovskiy;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView) findViewById(R.id.textMain);
        Log.d("...","onCreate <@#@>");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("...","onStop <@#@>");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("...","onDestroy <@#@>");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("...","onPause <@#@>");
    }
//TODO:Andrey_Shwartz -- Не получилось брать значение из colors.xml (а точнее цвет nerRed), очень хотел бы узнать, как это сделать.
//TODO:Andrey_Shwartz -- Поправка, методом проб и ошибок, удалось:)
    public void onClick(View view){
        Random random = new Random();
        int x = random.nextInt(6);
        if(x==0) text.setTextColor(getResources().getColor(R.color.newRed));
        if(x==1) text.setTextColor(getResources().getColor(R.color.newGreen));
        if(x==2) text.setTextColor(getResources().getColor(R.color.newBlue));
        if(x==3) text.setTextColor(getResources().getColor(R.color.newCyan));
        if(x==4) text.setTextColor(getResources().getColor(R.color.newPink));
        if(x==5) text.setTextColor(getResources().getColor(R.color.newYellow));
        x = random.nextInt(6)+1;
        text.setTextSize(8f*x);

    }

}

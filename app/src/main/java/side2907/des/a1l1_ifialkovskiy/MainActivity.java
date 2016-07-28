package side2907.des.a1l1_ifialkovskiy;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView text;
    TextView textView2;
    private Animation mFadeInAnimation, mFadeOutAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView) findViewById(R.id.textMain);
        textView2 = (TextView) findViewById(R.id.textView2);
        Log.d("...", "onCreate <@#@>");

        // подключаем файл анимации
        mFadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.alpha_animation_in);
        mFadeOutAnimation = AnimationUtils.loadAnimation(this, R.anim.alpha_animation_out);
        mFadeInAnimation.setAnimationListener(animationFadeInListener);
        mFadeOutAnimation.setAnimationListener(animationFadeOutListener);

        // при запуске начинаем с анимации исчезновения
        textView2.startAnimation(mFadeOutAnimation);

    }

    Animation.AnimationListener animationFadeOutListener = new Animation.AnimationListener() {

        @Override
        public void onAnimationEnd(Animation animation) {
            textView2.startAnimation(mFadeInAnimation);
        }

        @Override
        public void onAnimationRepeat(Animation animation) {
            // TODO Auto-generated method stub
        }

        @Override
        public void onAnimationStart(Animation animation) {
            // TODO Auto-generated method stub
        }
    };

    Animation.AnimationListener animationFadeInListener = new Animation.AnimationListener() {
        @Override
        public void onAnimationEnd(Animation animation) {
            textView2.startAnimation(mFadeOutAnimation);
        }

        @Override
        public void onAnimationRepeat(Animation animation) {
            // TODO Auto-generated method stub
        }

        @Override
        public void onAnimationStart(Animation animation) {
            // TODO Auto-generated method stub
        }
    };

    public void onClickX(View view) {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        startActivity(intent);
    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.d("...", "onStop <@#@>");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("...", "onDestroy <@#@>");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("...", "onPause <@#@>");
    }

    //TODO:Andrey_Shwartz -- Не получилось брать значение из colors.xml (а точнее цвет nerRed), очень хотел бы узнать, как это сделать.
//TODO:Andrey_Shwartz -- Поправка, методом проб и ошибок, удалось:)
    public void onClick(View view) {
        Random random = new Random();
        int x = random.nextInt(6);
        if (x == 0) text.setTextColor(getResources().getColor(R.color.newRed));
        if (x == 1) text.setTextColor(getResources().getColor(R.color.newGreen));
        if (x == 2) text.setTextColor(getResources().getColor(R.color.newBlue));
        if (x == 3) text.setTextColor(getResources().getColor(R.color.newCyan));
        if (x == 4) text.setTextColor(getResources().getColor(R.color.newPink));
        if (x == 5) text.setTextColor(getResources().getColor(R.color.newYellow));
        x = random.nextInt(6) + 1;
        text.setTextSize(8f * x);

    }

}

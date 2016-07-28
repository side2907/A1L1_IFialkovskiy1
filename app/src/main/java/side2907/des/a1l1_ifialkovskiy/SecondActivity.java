package side2907.des.a1l1_ifialkovskiy;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.style.BackgroundColorSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Demo on 28.07.2016.
 */
public class SecondActivity extends AppCompatActivity {
    Button btn1;
    Button btn2;
    Button btn3;
    TextView textView;
    RelativeLayout layout;
    private Animation mFadeInAnimation, mFadeOutAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);
        btn1 = (Button) findViewById(R.id.button);
        btn2 = (Button) findViewById(R.id.button2);
        btn3 = (Button) findViewById(R.id.button3);
        layout = (RelativeLayout) findViewById(R.id.layout2);
        textView = (TextView) findViewById(R.id.textViewS);
        OnClick1();
        OnClick2();
        OnClick3();

        // подключаем файл анимации
        mFadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.alpha_animation_full);
        mFadeOutAnimation = AnimationUtils.loadAnimation(this, R.anim.alpha_animation_zero);
        mFadeOutAnimation.setAnimationListener(endOfOutAnim);
    }

    public void OnClick1() {
btn1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        String out = getResources().getText(R.string.NText) +"\n\n"+ new SimpleDateFormat("dd.MM.yyyy HH:mm").format(new Date().getTime())+"\n\n\n\n\n";
        textView.setText(out);
        textView.startAnimation(mFadeInAnimation);
    }
});
    }

    public void OnClick2() {
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.startAnimation(mFadeOutAnimation);
            }
        });
    }

    Animation.AnimationListener endOfOutAnim = new Animation.AnimationListener(){

        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {
            textView.setText("");
            AlertDialog.Builder builder = new AlertDialog.Builder(SecondActivity.this);
            builder.setMessage("Текст удален!").setNeutralButton("ОК", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    dialog.cancel();
                }
            });
            AlertDialog alert = builder.create();
            alert.show();
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    };

    public void OnClick3() {
        btn3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
              //  Drawable backgroundColorSpan = layout.getBackground();
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        layout.setBackgroundColor(getResources().getColor(R.color.newRed));
                        break;
                    case MotionEvent.ACTION_UP:
                        layout.setBackgroundColor(getResources().getColor(R.color.newWhite));
                        break;
                }
                return true;
            }
        });
    }

}

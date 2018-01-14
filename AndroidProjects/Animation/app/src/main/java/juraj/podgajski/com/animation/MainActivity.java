package juraj.podgajski.com.animation;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView ivAnimation;
    private Button bStart;
    private AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivAnimation = (ImageView) findViewById(R.id.ivAnimation);
        bStart = (Button) findViewById(R.id.bStart);

        ivAnimation.setBackgroundResource(R.drawable.animation_list);

        animationDrawable = (AnimationDrawable) ivAnimation.getBackground();

        bStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (animationDrawable.isRunning()){
                    animationDrawable.stop();
                } else {
                    animationDrawable.run();
                }

            }
        });
    }
}

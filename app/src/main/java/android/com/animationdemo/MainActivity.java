package android.com.animationdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btn_shake = null;
    private Button btn_wobble = null;
    private ImageView img_item = null;
    private ImageView img_item_move = null;

    private final int ANIM_SHAKE = 101;
    private final int ANIM_WOBBLE = 102;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    /**
     * initalizing view elements
     */
    private void initView(){
        btn_shake = (Button) findViewById(R.id.btn_shake);
        btn_wobble = (Button) findViewById(R.id.btn_wobble);
        img_item = (ImageView) findViewById(R.id.img_item);
        img_item_move = (ImageView) findViewById(R.id.img_item_move);

        img_item_move.setVisibility(View.GONE);

        btn_shake.setOnClickListener(this);
        btn_wobble.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_shake:
                startStopAnimation(ANIM_SHAKE);
                break;
            case R.id.btn_wobble:
                startStopAnimation(ANIM_WOBBLE);
                break;

        }
    }

    /**
     * starts or stops the animation
     */
    private void startStopAnimation(int ANIMAIONT_NAME){
//        TranslateAnimation mAnimation = new TranslateAnimation(
//                TranslateAnimation.ABSOLUTE, 0f,
//                TranslateAnimation.ABSOLUTE, 0f,
//                TranslateAnimation.RELATIVE_TO_PARENT, 0f,
//                TranslateAnimation.RELATIVE_TO_PARENT, 0.2f);
//        mAnimation.setDuration(500);
//        mAnimation.setRepeatCount(-1);
//        mAnimation.setRepeatMode(Animation.REVERSE);
//        mAnimation.setInterpolator(new LinearInterpolator());
//        img_item_move.setAnimation(mAnimation);
//        img_item_move.startAnimation(mAnimation);


        Animation anim = null;
        if(ANIMAIONT_NAME == ANIM_WOBBLE)
            anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.wobble);
        else if(ANIMAIONT_NAME == ANIM_SHAKE)
            anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.shake);


        img_item.startAnimation(anim);
    }
}

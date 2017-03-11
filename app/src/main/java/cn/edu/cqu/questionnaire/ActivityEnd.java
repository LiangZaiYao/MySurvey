package cn.edu.cqu.questionnaire;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class ActivityEnd extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);

    }

    public void OnClickExit(View v) {
        /*
        super.onTerminate();
        UserHolder.getInstance().loginOut();//退出登陆
        try {
            for (Activity activity : activities) {
                activity.finish();//在对activity进行管理的情况下，finish()掉所有的activity
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.exit(0);
        }
        */
        System.exit(0);
    }

    public void OnclickRestart(View v){
        Intent intent = new Intent();
        intent.setClass(ActivityEnd.this, Activity2.class);
        startActivity(intent);
        overridePendingTransition(R.anim.out_to_left,R.anim.in_from_right);
    }
}

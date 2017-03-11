package cn.edu.cqu.questionnaire;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Activity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        Button btnStart = (Button)findViewById(R.id.btnStart);
        /*
        btnStart.setOnClickListener(new View.OnClickListener(){
            public void onClick (View v){
                Intent intent = new Intent(getBaseContext(), Activity2.class);
                startActivity(intent);
            }
        });
        */
    }


    public void onClick (View v){
        Intent intent = new Intent();
        intent.setClass(Activity1.this, Activity2.class);
        Activity1.this.startActivity(intent);
        overridePendingTransition(R.anim.out_to_left,R.anim.in_from_right);
    }
}

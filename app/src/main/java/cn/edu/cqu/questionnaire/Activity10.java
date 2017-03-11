package cn.edu.cqu.questionnaire;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Activity10 extends AppCompatActivity {
    String data;
    String text= "|";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_10);
        //获得上一个activity传来的数据
        Bundle bundle=getIntent().getExtras();
        data =bundle.getString("data");
        final Button btn10Next = (Button)findViewById(R.id.btn10Next) ;
        RadioGroup rgMood = (RadioGroup)findViewById(R.id.rgMood);

        rgMood.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){

            public void onCheckedChanged(RadioGroup group, int checkedId) {
                btn10Next.setText("NEXT");
                btn10Next.setEnabled(true);
            }
        });
        btn10Next.setOnClickListener(new View.OnClickListener(){
            public void onClick (View v){
                Intent intent = new Intent();
                intent.setClass(Activity10.this, Activity11.class);
                RadioGroup rgResult = (RadioGroup)findViewById(R.id.rgMood) ;
                RadioButton rbResult = (RadioButton)findViewById(rgResult.getCheckedRadioButtonId());
                text += rbResult.getText().toString();
                data += text;

                intent.putExtra("data",data);//传递结果数据
                startActivity(intent);
                overridePendingTransition(R.anim.out_to_left,R.anim.in_from_right);
            }
        });
    }
}

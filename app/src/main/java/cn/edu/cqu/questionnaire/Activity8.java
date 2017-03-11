package cn.edu.cqu.questionnaire;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Activity8 extends AppCompatActivity {
    String data;
    String text= "|";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_8);
        //获得上一个activity传来的数据
        Bundle bundle=getIntent().getExtras();
        data =bundle.getString("data");
        final Button btn8Next = (Button)findViewById(R.id.btn8Next) ;
        RadioGroup rgFrequency = (RadioGroup)findViewById(R.id.rgFrequency);

        rgFrequency.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){

            public void onCheckedChanged(RadioGroup group, int checkedId) {
                btn8Next.setText("NEXT");
                btn8Next.setEnabled(true);
            }
        });
        btn8Next.setOnClickListener(new View.OnClickListener(){
            public void onClick (View v){
                Intent intent = new Intent();
                intent.setClass(Activity8.this, Activity9.class);

                RadioGroup rgResult = (RadioGroup)findViewById(R.id.rgFrequency) ;
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

package cn.edu.cqu.questionnaire;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Activity3 extends AppCompatActivity {
    String data;
    String text = "|";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        //获得上一个activity传来的数据
        Bundle bundle=getIntent().getExtras();
        data = bundle.getString("data");

        final Button btn3Next = (Button)findViewById(R.id.btn3Next);
        RadioGroup rgAge = (RadioGroup)findViewById(R.id.rgAge);

        rgAge.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){

            public void onCheckedChanged(RadioGroup group, int checkedId) {
                btn3Next.setText("NEXT");
                btn3Next.setEnabled(true);
            }
        });

        btn3Next.setOnClickListener(new View.OnClickListener(){
            public void onClick (View v){
                Intent intent = new Intent();
                intent.setClass(Activity3.this, Activity4.class);

                RadioGroup rg = (RadioGroup)findViewById(R.id.rgAge) ;
                RadioButton rb = (RadioButton)findViewById(rg.getCheckedRadioButtonId());
                text += rb.getText().toString();
                data += text;

                intent.putExtra("data",data);//传递结果数据
                startActivity(intent);
                overridePendingTransition(R.anim.out_to_left,R.anim.in_from_right);
            }
        });
    }
}

package cn.edu.cqu.questionnaire;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Activity4 extends AppCompatActivity {
    String data;
    String text = "|";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);
        //获得上一个activity传来的数据
        Bundle bundle=getIntent().getExtras();
        data =bundle.getString("data");
        final Button btn4Next = (Button)findViewById(R.id.btn4Next);
        RadioGroup rgMajor = (RadioGroup)findViewById(R.id.rgMajor);

        rgMajor.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){

            public void onCheckedChanged(RadioGroup group, int checkedId) {
                btn4Next.setText("NEXT");
                btn4Next.setEnabled(true);
            }
        });

        btn4Next.setOnClickListener(new View.OnClickListener(){
            public void onClick (View v){
                Intent intent = new Intent();
                intent.setClass(Activity4.this, Activity5.class);
                RadioGroup rgResult = (RadioGroup)findViewById(R.id.rgMajor) ;
                RadioButton rbResult = (RadioButton)findViewById(rgResult.getCheckedRadioButtonId());
                text += rbResult.getText().toString();
                data += text;
                //Toast.makeText(getBaseContext(), data, Toast.LENGTH_SHORT).show();
                intent.putExtra("data",data);//传递结果数据
                startActivity(intent);
                overridePendingTransition(R.anim.out_to_left,R.anim.in_from_right);
            }
        });
    }
}

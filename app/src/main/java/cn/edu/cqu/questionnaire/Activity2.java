package cn.edu.cqu.questionnaire;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {

    String data = "";
    String text = "";
    boolean b = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Button btn2Next = (Button)findViewById(R.id.btn2Next);
        final EditText etName = (EditText)findViewById(R.id.etName);
        RadioGroup rgGender = (RadioGroup)findViewById(R.id.rgGender) ;

        rgGender.setOnCheckedChangeListener(new OnCheckedChangeListener(){

            public void onCheckedChanged(RadioGroup group, int checkedId) {
                b = true;
            }
         });

        btn2Next.setOnClickListener(new View.OnClickListener(){
            public void onClick (View v){

                int a =etName.getText().length();
                //boolean b = rgGender.isSelected();
                if (a ==0 || !b)
                {
                    Toast.makeText(getBaseContext(), "Please finish the questions before you go further", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent();
                    intent.setClass(Activity2.this, Activity3.class);
                    //获取本页结果
                    text += etName.getText().toString();
                    RadioGroup rgResult = (RadioGroup)findViewById(R.id.rgGender) ;
                    RadioButton rbResult = (RadioButton)findViewById(rgResult.getCheckedRadioButtonId());
                    text += rbResult.getText().toString();
                    data += text;

                    intent.putExtra("data",data);//传递结果数据
                    startActivity(intent);


                    overridePendingTransition(R.anim.out_to_left, R.anim.in_from_right);
                }
            }
        });
    }

}

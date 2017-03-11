package cn.edu.cqu.questionnaire;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import java.util.ArrayList;
import java.util.List;

public class Activity6 extends AppCompatActivity {
    String data;
    String text = "|";
    int iCheckedNum = 0;
    private List<CheckBox> checkBoxList = new ArrayList<CheckBox>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_6);
        //获得上一个activity传来的数据
        Bundle bundle=getIntent().getExtras();
        data =bundle.getString("data");
        final Button btn6 = (Button)findViewById(R.id.btn6Next) ;

        CheckBox c1 = (CheckBox)findViewById(R.id.checkBox);
        CheckBox c2 = (CheckBox)findViewById(R.id.checkBox2);
        CheckBox c3 = (CheckBox)findViewById(R.id.checkBox3);
        CheckBox c4 = (CheckBox)findViewById(R.id.checkBox4);
        CheckBox c5 = (CheckBox)findViewById(R.id.checkBox5);
        CheckBox c6 = (CheckBox)findViewById(R.id.checkBox6);
        CheckBox c7 = (CheckBox)findViewById(R.id.checkBox7);
        checkBoxList.add(c1);
        checkBoxList.add(c2);
        checkBoxList.add(c3);
        checkBoxList.add(c4);
        checkBoxList.add(c5);
        checkBoxList.add(c6);
        checkBoxList.add(c7);

        c1.setOnCheckedChangeListener(checkboxlistener);
        c2.setOnCheckedChangeListener(checkboxlistener);
        c3.setOnCheckedChangeListener(checkboxlistener);
        c4.setOnCheckedChangeListener(checkboxlistener);
        c5.setOnCheckedChangeListener(checkboxlistener);
        c6.setOnCheckedChangeListener(checkboxlistener);
        c7.setOnCheckedChangeListener(checkboxlistener);


        btn6.setOnClickListener(new View.OnClickListener(){
            public void onClick (View v){
                Intent intent = new Intent();
                intent.setClass(Activity6.this, Activity7.class);
                //在此添加获取数据代码
                //获取多个复选框的值
                StringBuffer sb = new StringBuffer();
                //遍历集合中的checkBox,判断是否选择，获取选中的文本
                for (CheckBox checkbox : checkBoxList) {
                    if (checkbox.isChecked()){
                        sb.append(checkbox.getText().toString() + " ");
                    }
                }

                text = sb.toString();
                data += "|";
                data += text;
                data += "|"; //有点特殊

                intent.putExtra("data",data);//传递结果数据
                startActivity(intent);
                overridePendingTransition(R.anim.out_to_left,R.anim.in_from_right);
            }
        });
    }

    public CheckBox.OnCheckedChangeListener checkboxlistener = new CheckBox.OnCheckedChangeListener(){



        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            Button btn = (Button)findViewById(R.id.btn6Next);
            if(buttonView.isChecked()){
                iCheckedNum++;
            }
            else{
                iCheckedNum--;
            }
            if(iCheckedNum>0){
                btn.setText("NEXT");
                btn.setEnabled(true);
            }
            else {
                btn.setText("At lease Choose one");
                btn.setEnabled(false);
            }
        }

    };


}

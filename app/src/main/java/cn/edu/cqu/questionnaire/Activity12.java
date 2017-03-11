package cn.edu.cqu.questionnaire;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Activity12 extends AppCompatActivity {
    String data;
    String text = "|";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_12);
        //获得上一个activity传来的数据
        Bundle bundle=getIntent().getExtras();
        data =bundle.getString("data");

        final Button btn12Next = (Button)findViewById(R.id.btn12Next) ;
        final EditText email = (EditText)findViewById(R.id.etEmail) ;
        btn12Next.setOnClickListener(new View.OnClickListener(){
            public void onClick (View v){
                if(!isEmail(email.getText().toString())) {
                    Toast.makeText(getBaseContext(), "Please enter correct email address", Toast.LENGTH_SHORT).show();
                }
                else{

                    Intent intent = new Intent();
                    intent.setClass(Activity12.this, ActivityEnd.class);
                    text += email.getText().toString();
                    data += text;
                    Toast.makeText(getBaseContext(), data, Toast.LENGTH_SHORT).show();//toast结果字符串
                    writeTextFile(data);
                    //Toast.makeText(getBaseContext(), "文件写入完成", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                    overridePendingTransition(R.anim.out_to_left, R.anim.in_from_right);


                }
            }
        });
    }

    //判断email格式是否正确
    public boolean isEmail(String email) {
        String str = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
        Pattern p = Pattern.compile(str);
        Matcher m = p.matcher(email);
        return m.matches();
    }

    //文件写入
    public void writeTextFile(String data){
        File surveyFile = new File("sdcard/"+ "yao.txt");
        if (!surveyFile.exists()){
            try{
                surveyFile.createNewFile();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        try{
            BufferedWriter buf = new BufferedWriter(new FileWriter(surveyFile,true));
            buf.write(data);//在肥龙代码基础上添加的代码
            buf.write("\n");
            buf.close();
        }catch(IOException e){
            e.printStackTrace();
        }

    }



}

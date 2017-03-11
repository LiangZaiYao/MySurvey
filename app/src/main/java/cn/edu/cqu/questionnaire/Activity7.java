package cn.edu.cqu.questionnaire;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


public class Activity7 extends ListActivity {
    TextView Kind;//用于显示选择的结果
    String data;
    String text = "|";
    String[] myStringArray = new String[] {
            "RPG(Role Playing Game)",
            "ARPG (Action RPG)" ,
            "SRPG(Simulation RPG)" ,
            "FPS(First Person Shooting)" ,
            "RTS(Real Time Strategy)" ,
            "AVG(Advanture Game)" ,
            "SLG(Simulation Game)" ,
            "RAC(Race Game)" ,
            "EDU(education)" ,
            "TAB(Table Game)" ,
            "SPG(Sport Game)" ,
            "FTG(Fighting Game)" ,
            "SFTG(Simulation FTG)" ,
            "PUZ(Puzzle Game)" ,
            "STG(Shooting Game)" ,
            "ETC(Etcetra Game)" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_7);
        //获得上一个activity传来的数据
        Bundle bundle=getIntent().getExtras();
        data =bundle.getString("data");
        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                myStringArray));

        //Get the activity`s listView, use getListView()
        ListView myListView = getListView();

        //用于显示选择的结果
        Kind = (TextView)this.findViewById(R.id.KindResult);

        //Handle click events

        myListView.setOnItemClickListener(new ListView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Do something based on user clicked
                String s = (String)parent.getItemAtPosition(position);
                text = s;
                Kind.setText(s);
                if(Kind!=null){
                    Button btn =(Button)findViewById(R.id.btn7Next);
                    btn.setText("Next");
                    btn.setEnabled(true);
                }

            }
        });

        final Button btn7Next = (Button)findViewById(R.id.btn7Next) ;
        btn7Next.setOnClickListener(new View.OnClickListener(){
            public void onClick (View v){
                Intent intent = new Intent();
                intent.setClass(Activity7.this, Activity8.class);
                //在此添加获取数据代码

                data += text;

                intent.putExtra("data",data);//传递结果数据
                startActivity(intent);
                overridePendingTransition(R.anim.out_to_left,R.anim.in_from_right);
            }
        });
    }







}

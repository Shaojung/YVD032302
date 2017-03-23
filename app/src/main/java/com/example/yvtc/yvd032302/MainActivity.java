package com.example.yvtc.yvd032302;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int s = -1;
    int tmp;
    boolean chks[] = new boolean[4];
    boolean tmpchk[] = new boolean[4];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void click1(View v)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("對話框測試");
        builder.setMessage("這是一個對話框測試");
        builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.d("DLG", "使用者按下確定");
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.d("DLG", "使用者按下取消");
            }
        });
        builder.setNeutralButton("看說明", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.d("DLG", "使用者按下看說明");
            }
        });
        builder.show();
    }

    public void click2(View v)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("輸入測試");
        final TextView tv = (TextView) findViewById(R.id.textView);
        builder.setMessage("請輸入訊息:");
        builder.setIcon(android.R.drawable.ic_dialog_info);
        final EditText ed = new EditText(MainActivity.this);
        builder.setView(ed);
        builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.d("DLG", "使用者按下確定");
                tv.setText(ed.getText().toString());
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.d("DLG", "使用者按下取消");
            }
        });
        builder.show();
    }

    public void click3(View v)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("選項測試");
        final String fruits[] = getResources().getStringArray(R.array.fruits);
        tmp = s;
        builder.setSingleChoiceItems(R.array.fruits, s, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tmp = which;
            }
        });
        builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.d("DLG", "使用者按下確定");
                if (tmp > -1)
                {
                    TextView tv2 = (TextView) findViewById(R.id.textView2);
                    s = tmp;
                    tv2.setText(fruits[s]);
                }


            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.d("DLG", "使用者按下取消");
            }
        });
        builder.show();
    }
    public void click4(View v)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("列表測試");
        final String fruits[] = getResources().getStringArray(R.array.fruits);
        builder.setItems(R.array.fruits, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                TextView tv3 = (TextView) findViewById(R.id.textView3);
                tv3.setText(fruits[which]);
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.show();
    }

    public void click5(View v)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("多選測試");
        final String fruits[] = getResources().getStringArray(R.array.fruits);
        tmpchk = chks.clone();
        builder.setMultiChoiceItems(R.array.fruits, tmpchk, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {

            }
        });
        builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.d("DLG", "使用者按下確定");
                StringBuilder sb = new StringBuilder();
                int i;
                chks = tmpchk.clone();
                for (i=0;i<fruits.length;i++)
                {
                    if (chks[i])
                    {
                        sb.append(fruits[i] + ",");
                    }
                }
                TextView tv4 = (TextView) findViewById(R.id.textView4);
                tv4.setText(sb.toString());
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.d("DLG", "使用者按下取消");
            }
        });

        builder.show();
    }

    public void click6(View v)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("自訂測試");

        LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
        View mv = inflater.inflate(R.layout.custom_dialog_layout, null);
        Button btn = (Button) mv.findViewById(R.id.button6);
        final TextView tv5 = (TextView) mv.findViewById(R.id.textView5);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv5.setText("Hello World");
            }
        });

        builder.setView(mv);

        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        builder.show();
    }
}

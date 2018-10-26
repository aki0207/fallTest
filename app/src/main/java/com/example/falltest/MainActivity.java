package com.example.falltest;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {


    int coordinate = 0;
    private MyTask task;
    private MyView myView;
    private int count = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        //main.xmlに設定したコンポーネントをid指定で取得します。
        //button = (Button) findViewById(R.id.button);
        myView = (MyView) findViewById(R.id.my_view);

        //無限ループ
        while (true) {

            if (count > 6) {
                break;
            }


            count++;
            //AsyncTaskは使い捨てらしく使いまわせないとのこと。毎回インスタンスを生成する
            // タスクの生成
            task = new MyTask(myView);
            // 非同期処理を開始する
            task.execute(myView);
        }


    }
}
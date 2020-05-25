package swu.xl.broadcastreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    //广播的Action
    public static final String SHOW_ACTION = "SHOW_ACTION";

    //广播
    public ShowBroadcastReceiver showBroadcastReceiver = new ShowBroadcastReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.send).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //发送广播
                Intent intent = new Intent();
                intent.setAction(SHOW_ACTION);
                intent.putExtra("toast","消息来了");
                sendBroadcast(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        //注册广播
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(SHOW_ACTION);
        registerReceiver(showBroadcastReceiver,intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();

        //移除广播
        unregisterReceiver(showBroadcastReceiver);
    }
}

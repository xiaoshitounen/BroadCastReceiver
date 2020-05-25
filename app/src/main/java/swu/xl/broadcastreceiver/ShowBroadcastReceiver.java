package swu.xl.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;

public class ShowBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        //判断Intent是否为空
        if (intent != null){
            //过滤
            if (TextUtils.equals(intent.getAction(),MainActivity.SHOW_ACTION)){
                //接受消息
                String toast_message = intent.getStringExtra("toast");
                Toast.makeText(context, toast_message, Toast.LENGTH_SHORT).show();
            }
        }
    }
}

package fiap.com.br.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class MineBroadcast extends BroadcastReceiver
{

    @Override
    public void onReceive(Context context, Intent intent)
    {
        Bundle myBundle = intent.getExtras();
        SmsMessage[] messages = null;
        String strMessage = "";

        if (myBundle != null) {
            Object[] pdus = (Object[]) myBundle.get("pdus");
            messages = new SmsMessage[pdus.length];

            for ( int i = 0; i < messages.length; i++ ) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    String format = myBundle.getString("format");
                    messages[i] = SmsMessage.createFromPdu((byte[])pdus[i], format);
                } else {
                    messages[i] = SmsMessage.createFromPdu((byte[])pdus[i]);
                }

                strMessage += "Recebido de: " + messages[i].getOriginatingAddress();
                strMessage += " : ";
                strMessage += messages[i].getMessageBody();
                strMessage += "\n";
            }//for

            Toast.makeText(context, strMessage, Toast.LENGTH_SHORT).show();
        }//if
    }
}

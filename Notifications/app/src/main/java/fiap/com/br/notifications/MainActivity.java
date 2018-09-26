package fiap.com.br.notifications;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void send(View view)
    {
        NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel nc = new NotificationChannel(
                    "alertas",
                    "Canal de alertas",
                    NotificationManager.IMPORTANCE_DEFAULT
            );

            nc.setDescription("Alertas emitidos em casos não urgentes.");
            nc.enableLights(true);
            nc.setLightColor(Color.RED);
            nc.setVibrationPattern(new long[]{0, 1000, 500, 1000});
            nc.enableVibration(true);

            nm.createNotificationChannel(nc);

            NotificationCompat.Builder nt = new NotificationCompat.Builder(
                    this,
                    "alertas"
            );
            nt.setContentTitle("Reminder");
            nt.setContentText("fsociety00.dat");
            nt.setSmallIcon(R.mipmap.ic_launcher);
            nt.setContentIntent(
                    PendingIntent.getActivity(
                            this,
                            0,
                            new Intent(MainActivity.this, MainActivity.class),
                            PendingIntent.FLAG_UPDATE_CURRENT
                    )
            );

            nm.notify(50, nt.build());
        }
    }
}

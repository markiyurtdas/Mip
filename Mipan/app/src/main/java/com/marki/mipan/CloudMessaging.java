package com.marki.mipan;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class CloudMessaging extends FirebaseMessagingService {



    //Bildirim Geldiğinde otomatik çağrılan override fonksiyonu
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        showNotification(remoteMessage.getNotification().getTitle(),remoteMessage.getNotification().getBody());
    }

    //Gelen bildirimleri göstermek için
    public  void showNotification(String title,String message){

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,"999")
                .setContentTitle(title)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setAutoCancel(true)
                .setContentText(message);

        NotificationManagerCompat manage = NotificationManagerCompat.from(this);

        manage.notify(999,builder.build());
    }


}






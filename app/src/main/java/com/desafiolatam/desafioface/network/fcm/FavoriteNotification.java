package com.desafiolatam.desafioface.network.fcm;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.NotificationCompat;

import com.desafiolatam.desafioface.R;

import static android.content.Intent.getIntent;


public class FavoriteNotification {

    private static final String NOTIFICATION_TAG = "Favorite";


    public static void notify(final Context context, final String email) {
        final Resources res = context.getResources();

        final String ticker = "Nuevo Favorito";
        final String title = "Nuevo Favorito";
        final String text = email;

        final NotificationCompat.Builder builder = new NotificationCompat.Builder(context)


                .setDefaults(Notification.DEFAULT_ALL)
                .setSmallIcon(R.drawable.ic_stat_favorite)
                .setContentTitle(title)
                .setContentText(text)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setTicker(ticker)
                .setContentIntent(
                        PendingIntent.getActivity(
                                context,
                                0,
                                getIntent(email),
                                PendingIntent.FLAG_CANCEL_CURRENT))

                .setAutoCancel(true);

        notify(context, builder.build());
    }

    @TargetApi(Build.VERSION_CODES.ECLAIR)
    private static void notify(final Context context, final Notification notification) {
        final NotificationManager nm = (NotificationManager) context
                .getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ECLAIR) {
            nm.notify(NOTIFICATION_TAG, 0, notification);
        } else {
            nm.notify(NOTIFICATION_TAG.hashCode(), notification);
        }
    }

    @TargetApi(Build.VERSION_CODES.ECLAIR)
    private static Intent getIntent(String content) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setType("*/*");
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{content});
        return intent;
    }

}
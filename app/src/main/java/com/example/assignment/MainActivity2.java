package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Button;

import com.google.android.material.navigation.NavigationView;

public class MainActivity2 extends AppCompatActivity {

    private ImageButton notificationBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);




        final DrawerLayout drawerLayout = findViewById(R.id.drawerLayout);

        findViewById(R.id.imageMenu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        NavigationView navigationView = findViewById(R.id.navigationView);

        NavController navController = Navigation.findNavController(this, R.id.navHostFragment);
        NavigationUI.setupWithNavController(navigationView, navController);


        notificationBtn = (ImageButton) findViewById(R.id.bt_Notification);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O )
        {
            NotificationChannel nc = new NotificationChannel("01", "Channel", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager nm = getSystemService(NotificationManager.class);
            nm.createNotificationChannel(nc);
        }


        notificationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotificationCompat.Builder ncb = new NotificationCompat.Builder(getApplicationContext(),"01");
                ncb.setSmallIcon(R.drawable.ic_baseline_message_24);
                ncb.setContentTitle("Notification");
                ncb.setContentText("You've received new messages");
                NotificationManagerCompat nmc = NotificationManagerCompat.from(MainActivity2.this);
                ncb.setAutoCancel(true);
                nmc.notify(1, ncb.build());
            }
        });










    }
}
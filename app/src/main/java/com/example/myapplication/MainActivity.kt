package com.example.myapplication
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.NotificationManager.IMPORTANCE_DEFAULT
import android.app.PendingIntent
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.view.Menu
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat


class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val context = applicationContext
        val toast = Toast.makeText(
            context, "Уведомление",
            Toast.LENGTH_LONG
        )
        toast.show()

        val id = "DEFAULT"
        val name = "Все уведомления"
        val channel = NotificationChannel(id, name, IMPORTANCE_DEFAULT)
        getSystemService(NotificationManager::class.java).createNotificationChannel(channel)

        val builder = NotificationCompat.Builder(this, id)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentTitle("test")
            .setContentText("test")
        //.setContentIntent(pendingIntent)

        val notification = builder.build()
        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(1, notification)
    }

    val positiveButtonClick = { dialog: DialogInterface, which: Int ->
        Toast.makeText(applicationContext,
            android.R.string.yes, Toast.LENGTH_SHORT).show()
    }
    val negativeButtonClick = { dialog: DialogInterface, which: Int ->
        Toast.makeText(applicationContext,
            android.R.string.no, Toast.LENGTH_SHORT).show()
    }
    /*val neutralButtonClick = { dialog: DialogInterface, which: Int ->
        Toast.makeText(applicationContext,
            "Maybe", Toast.LENGTH_SHORT).show()
    }*/

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }
    fun basicAlert(view: View){

        val builder = AlertDialog.Builder(this)

        with(builder)
        {
            setTitle("Androidly Alert")
            setMessage("We have a message")
            setPositiveButton("OK", DialogInterface.OnClickListener(function = positiveButtonClick))
            setNegativeButton(android.R.string.no, negativeButtonClick)
            //setNeutralButton("Maybe", neutralButtonClick)
            show()
        }
    }

    fun onClickTasks(view: View) {
        setContentView(R.layout.activity_tasks)
    }
}
package com.dpappdev.uscitizenship.notifications

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.dpappdev.uscitizenship.MainActivity
import com.dpappdev.uscitizenship.R
import com.dpappdev.uscitizenship.data.Question

object NotificationHelper {
    private const val CHANNEL_ID = "quiz_notifications"
    private const val CHANNEL_NAME = "Quiz Notifications"
    private const val CHANNEL_DESCRIPTION = "Practice questions to help you prepare for the citizenship test"
    private const val NOTIFICATION_ID = 1001

    fun createNotificationChannel(context: Context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID, CHANNEL_NAME, importance).apply {
                description = CHANNEL_DESCRIPTION
            }

            val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as? NotificationManager
            notificationManager?.createNotificationChannel(channel)
        }
    }

    fun showQuizNotification(context: Context, question: Question) {
        // Create intent to open the app when notification is tapped
        val intent = Intent(context, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        val pendingIntent = PendingIntent.getActivity(
            context,
            0,
            intent,
            PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
        )

        // Format the question text
        val questionText = "Q${question.questionNumber}: ${question.question}"

        // Build the notification
        val notification = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.outline_book_ribbon_24)
            .setContentTitle("Pop quiz!")
            .setContentText(questionText)
            .setStyle(NotificationCompat.BigTextStyle().bigText(questionText))
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
            .build()

        // Show the notification
        try {
            NotificationManagerCompat.from(context).notify(NOTIFICATION_ID, notification)
        } catch (e: SecurityException) {
            // Handle the case where notification permission is not granted
            e.printStackTrace()
        }
    }
}

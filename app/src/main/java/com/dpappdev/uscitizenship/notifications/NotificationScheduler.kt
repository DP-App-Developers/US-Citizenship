package com.dpappdev.uscitizenship.notifications

import android.content.Context
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import java.util.Calendar
import java.util.concurrent.TimeUnit

object NotificationScheduler {
    private const val WORK_NAME = "weekly_quiz_notification"

    fun scheduleWeeklyNotification(context: Context) {
        // Calculate initial delay to next occurrence at 10 AM
        val currentTime = Calendar.getInstance()
        val targetTime = Calendar.getInstance().apply {
            set(Calendar.HOUR_OF_DAY, 10)
            set(Calendar.MINUTE, 0)
            set(Calendar.SECOND, 0)
            set(Calendar.MILLISECOND, 0)
        }

        // If 10 AM today has passed, schedule for 10 AM tomorrow
        if (targetTime.before(currentTime)) {
            targetTime.add(Calendar.DAY_OF_YEAR, 1)
        }

        val initialDelay = targetTime.timeInMillis - currentTime.timeInMillis

        // Create periodic work request (repeats every 5 days)
        // Initial delay ensures first notification is around 10 AM
        // Subsequent notifications will be approximately every 5 days around that time
        val workRequest = PeriodicWorkRequestBuilder<QuizNotificationWorker>(
            repeatInterval = 5,
            repeatIntervalTimeUnit = TimeUnit.DAYS
        )
        .setInitialDelay(initialDelay, TimeUnit.MILLISECONDS)
        .build()

        // Schedule the work
        WorkManager.getInstance(context).enqueueUniquePeriodicWork(
            WORK_NAME,
            ExistingPeriodicWorkPolicy.KEEP, // Keep existing work if already scheduled
            workRequest
        )
    }

    fun cancelWeeklyNotification(context: Context) {
        WorkManager.getInstance(context).cancelUniqueWork(WORK_NAME)
    }
}

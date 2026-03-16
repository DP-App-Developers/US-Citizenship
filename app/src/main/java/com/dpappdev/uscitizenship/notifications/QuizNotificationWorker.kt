package com.dpappdev.uscitizenship.notifications

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.dpappdev.uscitizenship.data.AllQuestionsLocalDataSource
import com.dpappdev.uscitizenship.data.TestYearDataStore
import com.dpappdev.uscitizenship.data.UserStateDataStore
import com.dpappdev.uscitizenship.data.UsRepresentativeDataStore
import kotlinx.coroutines.flow.first

class QuizNotificationWorker(
    context: Context,
    params: WorkerParameters
) : CoroutineWorker(context, params) {

    override suspend fun doWork(): Result {
        return try {
            // Get user preferences
            val testYearDataStore = TestYearDataStore(applicationContext)
            val userStateDataStore = UserStateDataStore(applicationContext)
            val usRepresentativeDataStore = UsRepresentativeDataStore(applicationContext)

            val testYear = testYearDataStore.getTestYearFlow.first()
            val userState = userStateDataStore.getUserState.first()
            val usRepresentative = usRepresentativeDataStore.getUsRepresentative.first()

            // Get all questions
            val dataSource = AllQuestionsLocalDataSource(
                testYear = testYear,
                userStateOrDistrict = userState,
                usRepresentative = usRepresentative
            )
            val questions = dataSource.allQuestions.first()

            // Select a random question
            val randomQuestion = questions.randomOrNull()

            if (randomQuestion != null) {
                // Show notification
                NotificationHelper.showQuizNotification(
                    context = applicationContext,
                    question = randomQuestion
                )
            }

            Result.success()
        } catch (e: Exception) {
            e.printStackTrace()
            Result.failure()
        }
    }
}

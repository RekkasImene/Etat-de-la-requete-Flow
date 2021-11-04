package fr.mastersid.rekkas.roomdatabase.repository

import android.util.Log
import fr.mastersid.rekkas.roomdatabase.room.QuestionDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class QuestionsRepository @Inject constructor(
    private val stackOverFlowWebServices : QuestionsWebService,
    private val questionDao: QuestionDao
) {
    val questionList = questionDao.getQuestionList()


    suspend fun updateQuestionsList(
        order: String,
        sort: String
    ) {
        try {
            val list = stackOverFlowWebServices
                .getQuestionList(order = order, sort = sort)

            questionDao.insertAll(list)


        } catch (EX: Exception){
            Log.d("tagg",""+EX.message)
        }


    }
}

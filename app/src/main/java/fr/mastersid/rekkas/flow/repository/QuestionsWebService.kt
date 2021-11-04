package fr.mastersid.rekkas.roomdatabase.repository

import fr.mastersid.rekkas.roomdatabase.adapters.Questions
import retrofit2.http.GET
import retrofit2.http.Query

interface QuestionsWebService {
    @GET("questions?site=stackoverflow")

    suspend fun getQuestionList(
        @Query("pagesize") pagesize: Int = 20,
        @Query("order") order: String,
        @Query("sort") sort: String
    ): List<Questions>
}
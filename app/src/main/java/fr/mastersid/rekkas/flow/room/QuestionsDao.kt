package fr.mastersid.rekkas.flow.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import fr.mastersid.rekkas.flow.adapters.Questions

@Dao
interface QuestionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(list: List <Questions>)
    @Query("SELECT * FROM question_table")
    fun getQuestionList (): LiveData<List<Questions>>
}
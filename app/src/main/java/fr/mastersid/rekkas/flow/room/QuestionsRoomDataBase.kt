package fr.mastersid.rekkas.flow.room

import androidx.room.Database
import androidx.room.RoomDatabase
import fr.mastersid.rekkas.flow.adapters.Questions

@Database(
    entities = [Questions ::class],
    version = 2,
    exportSchema = false
)

abstract class QuestionsRoomDataBase : RoomDatabase() {
    abstract fun questionsDao (): QuestionDao
}
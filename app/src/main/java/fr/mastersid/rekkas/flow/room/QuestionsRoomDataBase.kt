package fr.mastersid.rekkas.roomdatabase.room

import androidx.room.Database
import androidx.room.RoomDatabase
import fr.mastersid.rekkas.roomdatabase.adapters.Questions

@Database(
    entities = [Questions ::class],
    version = 1,
    exportSchema = false
)

abstract class QuestionsRoomDataBase : RoomDatabase() {
    abstract fun questionsDao (): QuestionDao
}
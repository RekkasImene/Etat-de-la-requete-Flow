package fr.mastersid.rekkas.roomdatabase.adapters

import com.squareup.moshi.FromJson
import fr.mastersid.rekkas.roomdatabase.models.ClassJsonToKotlin

class QuestionsMoshiAdapter {
    @FromJson
    fun fromJson(classJsonToKotlin: ClassJsonToKotlin): List <Questions> {
        return classJsonToKotlin.items.map {
                Item -> Questions(Item.title, Item.answer_count)
        }
    }
}
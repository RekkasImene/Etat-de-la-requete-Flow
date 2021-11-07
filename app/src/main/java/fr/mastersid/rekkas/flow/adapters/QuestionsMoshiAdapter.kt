package fr.mastersid.rekkas.flow.adapters

import com.squareup.moshi.FromJson
import fr.mastersid.rekkas.flow.models.ClassJsonToKotlin

class QuestionsMoshiAdapter {
    @FromJson
    fun fromJson(classJsonToKotlin: ClassJsonToKotlin): List <Questions> {
        return classJsonToKotlin.items.map {
                Item -> Questions(Item.title, Item.answer_count)
        }
    }
}
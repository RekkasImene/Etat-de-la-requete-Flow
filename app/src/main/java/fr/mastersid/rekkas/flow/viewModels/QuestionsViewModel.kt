package fr.mastersid.rekkas.flow.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.mastersid.rekkas.roomdatabase.repository.QuestionsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class QuestionsViewModel @Inject constructor (
    private val repository : QuestionsRepository
) : ViewModel () {


    val questionList = repository.questionList

    fun  updateQuestionsList() {

        viewModelScope.launch(Dispatchers.IO) {

            repository.updateQuestionsList(
                order = DEFAULT_ORDER ,
                sort = DEFAULT_SORT
            )
        }

    }


    companion object {
        const val DEFAULT_ORDER = "desc"
        const val DEFAULT_SORT = "activity"
    }

}
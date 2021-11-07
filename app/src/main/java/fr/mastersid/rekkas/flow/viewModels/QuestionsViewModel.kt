package fr.mastersid.rekkas.flow.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.mastersid.rekkas.flow.models.RequestState
import fr.mastersid.rekkas.flow.repository.QuestionsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class QuestionsViewModel @Inject constructor (
    private val repository : QuestionsRepository
) : ViewModel () {


    private val _requestState = MutableLiveData(RequestState.NONE_OR_DONE)
    val requestState: LiveData<RequestState>
        get() = _requestState



    val questionList = repository.questionList

    fun  updateQuestionsList() {

        viewModelScope.launch(Dispatchers.IO) {

            repository.updateQuestionsList(
                order = DEFAULT_ORDER ,
                sort = DEFAULT_SORT
            )
        }

    }

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.requestState.collect {
                    value ->
                _requestState.postValue(value)
            }
        }
    }

    companion object {
        const val DEFAULT_ORDER = "desc"
        const val DEFAULT_SORT = "activity"
    }

}
package fr.mastersid.rekkas.flow.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import fr.mastersid.rekkas.flow.viewModels.QuestionsViewModel
import fr.mastersid.rekkas.flow.adapters.QuestionsListAdapter
import fr.mastersid.rekkas.flow.databinding.FragmentQuestionsBinding
import fr.mastersid.rekkas.flow.models.RequestState


@AndroidEntryPoint
class QuestionsFragment : Fragment() {

    private lateinit var _binding: FragmentQuestionsBinding
    private val questionModel: QuestionsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentQuestionsBinding.inflate(inflater)
        return _binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val questionsListAdapter = QuestionsListAdapter()

        _binding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = questionsListAdapter
        }

        _binding.refresh.setOnRefreshListener {
            questionModel.updateQuestionsList()
        }

        questionModel.questionList.observe(viewLifecycleOwner) { value ->
            _binding.refresh.isRefreshing = false
            questionsListAdapter.submitList(value)
        }

        questionModel.requestState.observe(viewLifecycleOwner) { value ->
            when(value) {
                RequestState.PENDING ->
                    _binding.refresh.isRefreshing = true
                RequestState.NONE_OR_DONE ->
                    _binding.refresh.isRefreshing = false
            }
        }


    }

}
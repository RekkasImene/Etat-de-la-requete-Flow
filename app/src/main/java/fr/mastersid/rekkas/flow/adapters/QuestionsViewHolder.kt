package fr.mastersid.rekkas.flow.adapters

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import fr.mastersid.rekkas.flow.R

class QuestionsViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
    val title: TextView = itemView.findViewById(R.id.title)
    val answercount: TextView = itemView.findViewById(R.id.answerCount)
}
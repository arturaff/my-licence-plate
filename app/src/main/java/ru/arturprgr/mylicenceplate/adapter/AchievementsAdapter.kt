package ru.arturprgr.mylicenceplate.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.arturprgr.mylicenceplate.R
import ru.arturprgr.mylicenceplate.databinding.LayoutAchievementBinding
import ru.arturprgr.mylicenceplate.model.Achievement

class AchievementsAdapter : RecyclerView.Adapter<AchievementsAdapter.ViewHolder>() {
    private val adapter = arrayListOf<Achievement>()

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        @SuppressLint("SetTextI18n")
        fun bind(achievement: Achievement) = with(LayoutAchievementBinding.bind(itemView)) {
            textName.text = "Выбить ${achievement.name}"
            textQuantity.text = "Количество: ${achievement.quantity}"
            imageReward.setImageResource(achievement.drawable)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.layout_achievement, parent, false)
    )

    override fun getItemCount(): Int = adapter.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(adapter[position])

    fun addAchievement(achievement: Achievement) {
        adapter.add(achievement)
        notifyItemChanged(achievement.position)
    }
}
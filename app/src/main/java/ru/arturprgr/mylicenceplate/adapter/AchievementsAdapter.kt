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
    private val achievementArrayList = arrayListOf<Achievement>()

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

    override fun getItemCount(): Int = achievementArrayList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(achievementArrayList[position])

    fun addAchievement(achievement: Achievement) {
        achievementArrayList.add(achievement)
        notifyItemInserted(achievement.position)
        notifyItemRangeInserted(achievement.position, achievementArrayList.size)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun editAchievement(index: Int, achievement: Achievement) {
        achievementArrayList[index] = achievement
        notifyDataSetChanged()
    }
}
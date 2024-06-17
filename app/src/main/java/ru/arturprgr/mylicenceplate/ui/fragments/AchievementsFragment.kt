package ru.arturprgr.mylicenceplate.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import ru.arturprgr.mylicenceplate.R
import ru.arturprgr.mylicenceplate.adapter.AchievementsAdapter
import ru.arturprgr.mylicenceplate.data.Database
import ru.arturprgr.mylicenceplate.data.Preferences
import ru.arturprgr.mylicenceplate.databinding.FragmentAchievementsBinding
import ru.arturprgr.mylicenceplate.model.Achievement

class AchievementsFragment : Fragment() {
    private lateinit var binding: FragmentAchievementsBinding
    private lateinit var preferences: Preferences
    private var position = 0
    private val adapter = AchievementsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentAchievementsBinding.inflate(inflater, container, false)
        preferences = Preferences(requireContext())

        addAchievement("111")
        addAchievement("222")
        addAchievement("333")
        addAchievement("444")
        addAchievement("555")
        addAchievement("666")
        addAchievement("777")
        addAchievement("888")
        addAchievement("999")
        addAchievement("001")
        addAchievement("002")
        addAchievement("003")
        addAchievement("004")
        addAchievement("005")
        addAchievement("006")
        addAchievement("007")
        addAchievement("008")
        addAchievement("009")
        addAchievement("100")
        addAchievement("200")
        addAchievement("300")
        addAchievement("400")
        addAchievement("500")
        addAchievement("600")
        addAchievement("700")
        addAchievement("800")
        addAchievement("900")
        addAchievement("ААА")
        addAchievement("ВВВ")
        addAchievement("ССС")
        addAchievement("ЕЕЕ")
        addAchievement("ННН")
        addAchievement("ККК")
        addAchievement("МММ")
        addAchievement("ООО")
        addAchievement("РРР")
        addAchievement("ТТТ")
        addAchievement("УУУ")
        addAchievement("ХХХ")
        addAchievement("ЕКХ")
        addAchievement("ХКХ")
        addAchievement("САС")
        addAchievement("АОО")
        addAchievement("ВОО")
        addAchievement("СОО")
        addAchievement("ЕОО")
        addAchievement("НОО")
        addAchievement("КОО")
        addAchievement("МОО")
        addAchievement("РОО")
        addAchievement("ТОО")
        addAchievement("УОО")
        addAchievement("ХОО")
        addAchievement("АМР")
        addAchievement("АКР")
        addAchievement("ВКР")
        addAchievement("ЕКР")
        addAchievement("ККР")
        addAchievement("ЕРЕ")
        addAchievement("АММ")
        addAchievement("ВММ")
        addAchievement("СММ")
        addAchievement("ЕММ")
        addAchievement("НММ")
        addAchievement("КММ")
        addAchievement("ОММ")
        addAchievement("РММ")
        addAchievement("ТММ")
        addAchievement("УММ")
        addAchievement("ХММ")
        addAchievement("КМР")
        addAchievement("РМР")
        addAchievement("ММР")
        addAchievement("ТМР")
        addAchievement("НАА")
        addAchievement("ТАА")
        addAchievement("САА")
        addAchievement("ХАА")
        addAchievement("СКО")
        addAchievement("АСК")
        addAchievement("АНО")
        addAchievement("МОР")
        addAchievement("НСО")
        addAchievement("МРО")
        addAchievement("ООМ")
        addAchievement("МВУ")
        addAchievement("УВУ")
        addAchievement("УВО")
        addAchievement("ВМР")
        addAchievement("ККХ")
        addAchievement("ОМР")
        addAchievement("УМР")
        addAchievement("АУЕ")

        binding.apply {
            listAchievements.layoutManager = LinearLayoutManager(requireContext())
            listAchievements.adapter = adapter
        }

        return binding.root
    }

    private fun addAchievement(string: String) {
        val achievement = string.uppercase()
        Log.d("Attempt", "${preferences.getAccount()}/achievements/$string")
        Database("${preferences.getAccount()}/achievements/$string").getValue { value ->
            try {
                val quantity = value.toInt()
                position += 1
                Log.d("Attempt", position.toString())
                if (quantity >= 0 || quantity <= 4) adapter.addAchievement(
                    Achievement(
                        achievement,
                        quantity,
                        R.drawable.ic_bronze,
                        position
                    )
                )
                else if (quantity >= 5 || quantity <= 9) adapter.addAchievement(
                    Achievement(
                        achievement,
                        quantity,
                        R.drawable.ic_silver,
                        position
                    )
                )
                else if (quantity >= 10 || quantity <= 24) adapter.addAchievement(
                    Achievement(
                        achievement,
                        quantity,
                        R.drawable.ic_gold,
                        position
                    )
                )
                else if (quantity >= 25 || quantity <= 49) adapter.addAchievement(
                    Achievement(
                        achievement,
                        quantity,
                        R.drawable.ic_platinum,
                        position
                    )
                )
                else if (quantity >= 50) adapter.addAchievement(
                    Achievement(
                        achievement,
                        quantity,
                        R.drawable.ic_titanium,
                        position
                    )
                )
                else if (quantity >= 100) adapter.addAchievement(
                    Achievement(
                        achievement,
                        quantity,
                        R.drawable.ic_achievements,
                        position
                    )
                )
            } catch (_: NumberFormatException) {
            }
        }
    }
}
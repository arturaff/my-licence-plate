package ru.arturprgr.mylicenceplate.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import ru.arturprgr.mylicenceplate.R
import ru.arturprgr.mylicenceplate.adapter.AchievementsAdapter
import ru.arturprgr.mylicenceplate.data.FirebaseHelper
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

        addAchievement(0, "111")
        addAchievement(1, "222")
        addAchievement(2, "333")
        addAchievement(3, "444")
        addAchievement(4, "555")
        addAchievement(5, "666")
        addAchievement(6, "777")
        addAchievement(7, "888")
        addAchievement(8, "999")
        addAchievement(9, "001")
        addAchievement(10, "002")
        addAchievement(11, "003")
        addAchievement(12, "004")
        addAchievement(13, "005")
        addAchievement(14, "006")
        addAchievement(15, "007")
        addAchievement(16, "008")
        addAchievement(17, "009")
        addAchievement(18, "100")
        addAchievement(19, "200")
        addAchievement(20, "300")
        addAchievement(21, "400")
        addAchievement(22, "500")
        addAchievement(23, "600")
        addAchievement(24, "700")
        addAchievement(25, "800")
        addAchievement(26, "900")
        addAchievement(27, "ААА")
        addAchievement(28, "ВВВ")
        addAchievement(29, "ССС")
        addAchievement(30, "ЕЕЕ")
        addAchievement(31, "ННН")
        addAchievement(32, "ККК")
        addAchievement(33, "МММ")
        addAchievement(34, "ООО")
        addAchievement(35, "РРР")
        addAchievement(36, "ТТТ")
        addAchievement(37, "УУУ")
        addAchievement(38, "ХХХ")
        addAchievement(39, "ЕКХ")
        addAchievement(40, "ХКХ")
        addAchievement(41, "САС")
        addAchievement(42, "АОО")
        addAchievement(43, "ВОО")
        addAchievement(44, "СОО")
        addAchievement(45, "ЕОО")
        addAchievement(46, "НОО")
        addAchievement(47, "КОО")
        addAchievement(48, "МОО")
        addAchievement(49, "РОО")
        addAchievement(50, "ТОО")
        addAchievement(51, "УОО")
        addAchievement(52, "ХОО")
        addAchievement(53, "АМР")
        addAchievement(54, "АКР")
        addAchievement(55, "ВКР")
        addAchievement(56, "ЕКР")
        addAchievement(57, "ККР")
        addAchievement(58, "ЕРЕ")
        addAchievement(59, "АММ")
        addAchievement(60, "ВММ")
        addAchievement(61, "СММ")
        addAchievement(62, "ЕММ")
        addAchievement(63, "НММ")
        addAchievement(64, "КММ")
        addAchievement(65, "ОММ")
        addAchievement(66, "РММ")
        addAchievement(67, "ТММ")
        addAchievement(68, "УММ")
        addAchievement(69, "ХММ")
        addAchievement(70, "КМР")
        addAchievement(71, "РМР")
        addAchievement(72, "ММР")
        addAchievement(73, "ТМР")
        addAchievement(74, "НАА")
        addAchievement(75, "ТАА")
        addAchievement(76, "САА")
        addAchievement(77, "ХАА")
        addAchievement(78, "СКО")
        addAchievement(79, "АСК")
        addAchievement(80, "АНО")
        addAchievement(81, "МОР")
        addAchievement(82, "НСО")
        addAchievement(83, "МРО")
        addAchievement(84, "ООМ")
        addAchievement(85, "МВУ")
        addAchievement(86, "УВУ")
        addAchievement(87, "УВО")
        addAchievement(88, "ВМР")
        addAchievement(89, "ККХ")
        addAchievement(90, "ОМР")
        addAchievement(91, "УМР")
        addAchievement(92, "АУЕ")

        binding.apply {
            listAchievements.layoutManager = LinearLayoutManager(requireContext())
            listAchievements.adapter = adapter
        }

        return binding.root
    }

    private fun addAchievement(index: Int, string: String) {
        adapter.addAchievement(
            Achievement(
                string,
                0,
                R.drawable.ic_cancel,
                index
            )
        )

        FirebaseHelper("${preferences.getAccount()}/achievements/$string").getValue { value ->
            if (value != "null") {
                val quantity = value.toInt()
                val drawable = when {
                    quantity <= 4 -> R.drawable.ic_bronze
                    quantity >= 5 -> R.drawable.ic_silver
                    quantity >= 10 -> R.drawable.ic_gold
                    quantity >= 25 -> R.drawable.ic_platinum
                    quantity >= 50 -> R.drawable.ic_titanium
                    quantity >= 100 -> R.drawable.ic_achievements
                    else -> 0
                }
                adapter.editAchievement(
                    index,
                    Achievement(
                        string,
                        value.toInt(),
                        drawable,
                        position
                    )
                )
            }
        }
    }
}
package ru.arturprgr.mylicenceplate.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.appcompat.app.AlertDialog
import androidx.core.view.updateLayoutParams
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.textfield.TextInputEditText
import ru.arturprgr.mylicenceplate.R
import ru.arturprgr.mylicenceplate.adapter.AchievementsAdapter
import ru.arturprgr.mylicenceplate.data.FirebaseHelper
import ru.arturprgr.mylicenceplate.data.Preferences
import ru.arturprgr.mylicenceplate.databinding.FragmentAchievementsBinding
import ru.arturprgr.mylicenceplate.model.Achievement

class AchievementsFragment : Fragment() {
    private lateinit var binding: FragmentAchievementsBinding
    private lateinit var preferences: Preferences
    private val letters = "АВСЕНКМОРТУХ"
    private var position = 0
    private val adapter = AchievementsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentAchievementsBinding.inflate(inflater, container, false)
        preferences = Preferences(requireContext())

        for (index in 1..9) addAchievement(index - 1, "одинаковые цифры", "${index * 111}")
        for (index in 1..9) addAchievement(index + 8, "первые десять в цифрах", "00$index")
        for (index in 1..9) addAchievement(index + 17, "ровные цифры", "${index}00")
        for (index in 0..11) addAchievement(
            index + 27, "одинаковые буквы", "${letters[index]}${letters[index]}${letters[index]}"
        )
        for (index in 1..11) addAchievement(
            index + 38, "комбинацию", "${letters[index]}АА"
        )
        for (index in 0..11) addAchievement(index + 50, "комбинацию", "${letters[index]}АС")
        for (index in 0..11) addAchievement(index + 62, "комбинацию", "${letters[index]}СК")
        for (index in 0..11) addAchievement(index + 74, "комбинацию", "${letters[index]}КР")
        for (index in 0..11) if (index < 6) {
            addAchievement(
                index + 86, "комбинацию", "${letters[index]}ММ"
            )
        } else try {
            addAchievement(index + 86, "комбинацию", "${letters[index + 1]}ММ")
        } catch (_: StringIndexOutOfBoundsException) {
        }
        for (index in 0..11) addAchievement(index + 97, "комбинацию", "${letters[index]}МР")
        for (index in 0..11) if (index < 7) {
            addAchievement(
                index + 108, "комбинацию", "${letters[index]}ОО"
            )
        } else try {
            addAchievement(index + 108, "комбинацию", "${letters[index + 1]}ОО")
        } catch (_: StringIndexOutOfBoundsException) {
        }

        addAchievement(120, "слово", "АКМ")
        addAchievement(121, "слово", "АУЕ")
        addAchievement(122, "слово", "АУТ")
        addAchievement(123, "слово", "ВАМ")
        addAchievement(124, "слово", "ВАУ")
        addAchievement(125, "слово", "ВАХ")
        addAchievement(126, "слово", "ВСЕ")
        addAchievement(127, "слово", "ВСМ")
        addAchievement(128, "слово", "ВЕС")
        addAchievement(129, "слово", "ВОР")
        addAchievement(130, "слово", "ВОТ")
        addAchievement(131, "слово", "ВРУ")
        addAchievement(132, "слово", "САМ")
        addAchievement(133, "слово", "СМС")
        addAchievement(134, "слово", "СРУ")
        addAchievement(135, "слово", "СТС")
        addAchievement(136, "слово", "СТО")
        addAchievement(137, "слово", "ЕВА")
        addAchievement(138, "слово", "ЕРЕ")
        addAchievement(139, "слово", "ЕКХ")
        addAchievement(140, "слово", "НАМ")
        addAchievement(141, "слово", "НЕТ")
        addAchievement(142, "слово", "НОС")
        addAchievement(143, "слово", "КАК")
        addAchievement(144, "слово", "КАР")
        addAchievement(145, "слово", "КВН")
        addAchievement(146, "слово", "КОТ")
        addAchievement(147, "слово", "КТО")
        addAchievement(148, "слово", "МАК")
        addAchievement(149, "слово", "МАТ")
        addAchievement(150, "слово", "МЕР")
        addAchievement(151, "слово", "МЕХ")
        addAchievement(152, "слово", "МНЕ")
        addAchievement(153, "слово", "МКС")
        addAchievement(154, "слово", "МОТ")
        addAchievement(155, "слово", "МРТ")
        addAchievement(153, "слово", "МТА")
        addAchievement(157, "слово", "МТС")
        addAchievement(158, "слово", "МУР")
        addAchievement(159, "слово", "МУТ")
        addAchievement(160, "слово", "ОСА")
        addAchievement(161, "слово", "ОНА")
        addAchievement(162, "слово", "ОНО")
        addAchievement(163, "слово", "ОРУ")
        addAchievement(164, "слово", "РАК")
        addAchievement(165, "слово", "РАМ")
        addAchievement(166, "слово", "РОК")
        addAchievement(167, "слово", "РОТ")
        addAchievement(168, "слово", "РУС")
        addAchievement(169, "слово", "ТОР")
        addAchievement(170, "слово", "ТОТ")
        addAchievement(171, "слово", "ТУТ")
        addAchievement(172, "слово", "УРА")
        addAchievement(173, "слово", "УХА")
        addAchievement(174, "слово", "УХО")
        addAchievement(175, "слово", "ХАН")
        addAchievement(176, "слово", "ХАМ")
        addAchievement(177, "слово", "ХЕР")

        binding.apply {
            listAchievements.layoutManager = LinearLayoutManager(requireContext())
            listAchievements.adapter = adapter

            buttonInfo.setOnClickListener {
                AlertDialog.Builder(requireContext())
                    .setTitle(R.string.what_are_the_achievements)
                    .setMessage(R.string.achievements_info)
                    .setPositiveButton(R.string.understand) { _, _ -> }
                    .create()
                    .show()
            }

            buttonFeedback.setOnClickListener {
                val view = View.inflate(requireContext(), R.layout.layout_edit_feedback, null)
                val editProblem = view.findViewById<TextInputEditText>(R.id.edit_problem)
                AlertDialog.Builder(requireContext())
                    .setTitle(R.string.force_feedback)
                    .setMessage(R.string.feedback_info)
                    .setView(view)
                    .setPositiveButton(R.string.send) { _, _ ->
                        FirebaseHelper("A1licencePlate/reports/${preferences.getAccount().replace("/licencePlate", "")}/report")
                            .setValue("${editProblem.text}")
                    }
                    .create()
                    .show()

                view.updateLayoutParams<FrameLayout.LayoutParams> {
                    this.topMargin = 8
                    this.leftMargin = 48
                    this.rightMargin = 48
                    this.bottomMargin = 8
                }
            }
        }

        return binding.root
    }

    private fun addAchievement(index: Int, type: String, name: String) {
        adapter.addAchievement(
            Achievement(
                type, name, 0, R.drawable.ic_cancel, index
            )
        )

        FirebaseHelper("${preferences.getAccount()}/achievements/$name").getValue { value ->
            if (value != "null") {
                val quantity = value.toInt()
                val drawable = when {
                    quantity <= 4 -> R.drawable.ic_bronze
                    quantity >= 5 -> R.drawable.ic_silver
                    quantity >= 10 -> R.drawable.ic_gold
                    quantity >= 20 -> R.drawable.ic_platinum
                    quantity >= 35 -> R.drawable.ic_titanium
                    quantity >= 50 -> R.drawable.ic_achievements
                    else -> 0
                }
                adapter.editAchievement(
                    index, Achievement(
                        type, name, value.toInt(), drawable, position
                    )
                )
            }
        }
    }
}
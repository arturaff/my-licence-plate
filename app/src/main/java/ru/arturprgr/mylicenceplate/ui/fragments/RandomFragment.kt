package ru.arturprgr.mylicenceplate.ui.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.arturprgr.mylicenceplate.data.FirebaseHelper
import ru.arturprgr.mylicenceplate.data.Preferences
import ru.arturprgr.mylicenceplate.databinding.FragmentRandomBinding
import ru.arturprgr.mylicenceplate.viewToast
import java.util.Random

class RandomFragment : Fragment() {
    private lateinit var binding: FragmentRandomBinding
    private lateinit var preferences: Preferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentRandomBinding.inflate(inflater, container, false)
        preferences = Preferences(requireContext())
        randomizeLicencePlate()

        binding.apply {
            click.setOnClickListener {
                randomizeLicencePlate()
            }
        }

        return binding.root
    }

    @SuppressLint("SetTextI18n")
    private fun randomizeLicencePlate() = with(binding) {
        Handler(Looper.getMainLooper()).postDelayed({
            val numbers = "${randomizeNumber()}${randomizeNumber()}${randomizeNumber()}"
            textNumbers.text = if (numbers == "000") "001"
            else numbers
            val region = "${randomizeNumber()}${randomizeNumber()}${randomizeNumber()}"
            textRegion.text = if (region[0] == '0') "${region[1]}${region[2]}"
            else region
            textLetter.text = randomizeLetter()
            textLetters.text = "${randomizeLetter()}${randomizeLetter()}"

            when (val textNumbers = "${textNumbers.text}") {
                "${textNumbers[0]}${textNumbers[0]}${textNumbers[0]}" -> updateAchievement(textNumbers)
                "00${textNumbers[2]}" -> updateAchievement(textNumbers)
                "${textNumbers[0]}00" -> updateAchievement(textNumbers)
            }
            when (val textLetters = "${textLetter.text}${textLetters.text}") {
                "ААА" -> updateAchievement(textLetters)
                "ВВВ" -> updateAchievement(textLetters)
                "ССС" -> updateAchievement(textLetters)
                "ЕЕЕ" -> updateAchievement(textLetters)
                "ННН" -> updateAchievement(textLetters)
                "ККК" -> updateAchievement(textLetters)
                "МММ" -> updateAchievement(textLetters)
                "ООО" -> updateAchievement(textLetters)
                "РРР" -> updateAchievement(textLetters)
                "ТТТ" -> updateAchievement(textLetters)
                "УУУ" -> updateAchievement(textLetters)
                "ХХХ" -> updateAchievement(textLetters)
                "ЕКХ" -> updateAchievement(textLetters)
                "ХКХ" -> updateAchievement(textLetters)
                "САС" -> updateAchievement(textLetters)
                "АОО" -> updateAchievement(textLetters)
                "ВОО" -> updateAchievement(textLetters)
                "СОО" -> updateAchievement(textLetters)
                "ЕОО" -> updateAchievement(textLetters)
                "НОО" -> updateAchievement(textLetters)
                "КОО" -> updateAchievement(textLetters)
                "МОО" -> updateAchievement(textLetters)
                "РОО" -> updateAchievement(textLetters)
                "ТОО" -> updateAchievement(textLetters)
                "УОО" -> updateAchievement(textLetters)
                "ХОО" -> updateAchievement(textLetters)
                "АМР" -> updateAchievement(textLetters)
                "АКР" -> updateAchievement(textLetters)
                "ВКР" -> updateAchievement(textLetters)
                "ЕКР" -> updateAchievement(textLetters)
                "ККР" -> updateAchievement(textLetters)
                "ЕРЕ" -> updateAchievement(textLetters)
                "АММ" -> updateAchievement(textLetters)
                "ВММ" -> updateAchievement(textLetters)
                "СММ" -> updateAchievement(textLetters)
                "ЕММ" -> updateAchievement(textLetters)
                "НММ" -> updateAchievement(textLetters)
                "КММ" -> updateAchievement(textLetters)
                "ОММ" -> updateAchievement(textLetters)
                "РММ" -> updateAchievement(textLetters)
                "ТММ" -> updateAchievement(textLetters)
                "УММ" -> updateAchievement(textLetters)
                "ХММ" -> updateAchievement(textLetters)
                "КМР" -> updateAchievement(textLetters)
                "РМР" -> updateAchievement(textLetters)
                "ММР" -> updateAchievement(textLetters)
                "ТМР" -> updateAchievement(textLetters)
                "НАА" -> updateAchievement(textLetters)
                "ТАА" -> updateAchievement(textLetters)
                "САА" -> updateAchievement(textLetters)
                "ХАА" -> updateAchievement(textLetters)
                "СКО" -> updateAchievement(textLetters)
                "АСК" -> updateAchievement(textLetters)
                "АНО" -> updateAchievement(textLetters)
                "МОР" -> updateAchievement(textLetters)
                "НСО" -> updateAchievement(textLetters)
                "МРО" -> updateAchievement(textLetters)
                "ООМ" -> updateAchievement(textLetters)
                "МВУ" -> updateAchievement(textLetters)
                "УВУ" -> updateAchievement(textLetters)
                "УВО" -> updateAchievement(textLetters)
                "ВМР" -> updateAchievement(textLetters)
                "ККХ" -> updateAchievement(textLetters)
                "ОМР" -> updateAchievement(textLetters)
                "УМР" -> updateAchievement(textLetters)
                "АУЕ" -> updateAchievement(textLetters)
            }
        }, 0)
    }

    private fun randomizeLetter(): String {
        var letter = "А"
        when (Random().nextInt(11)) {
            0 -> letter = "А"
            1 -> letter = "В"
            2 -> letter = "С"
            3 -> letter = "Е"
            4 -> letter = "Н"
            5 -> letter = "К"
            6 -> letter = "М"
            7 -> letter = "О"
            8 -> letter = "Р"
            9 -> letter = "Т"
            10 -> letter = "У"
            11 -> letter = "Х"
        }
        return letter
    }

    private fun randomizeNumber(): Int = Random().nextInt(8)

    private fun updateAchievement(achievement: String) {
        val reference =
            FirebaseHelper("${Preferences(requireContext()).getAccount()}/achievements/$achievement")
        viewToast(requireContext(), "Новое достижение за комбинацию: $achievement")
        try {
            reference.setValue(preferences.get(achievement).toInt())
        } catch (_: NumberFormatException) {
            reference.setValue(1)
        }
    }
}
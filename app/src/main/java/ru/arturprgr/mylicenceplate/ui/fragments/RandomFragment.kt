package ru.arturprgr.mylicenceplate.ui.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.arturprgr.mylicenceplate.data.Database
import ru.arturprgr.mylicenceplate.data.Preferences
import ru.arturprgr.mylicenceplate.databinding.FragmentRandomBinding
import ru.arturprgr.mylicenceplate.viewToast
import java.util.Random

class RandomFragment : Fragment() {
    private lateinit var binding: FragmentRandomBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentRandomBinding.inflate(inflater, container, false)
        randomizeLicencePlate()

        binding.apply {
            click.setOnClickListener {
                randomizeLicencePlate()
            }
        }

        return binding.root
    }

    private fun randomizeLicencePlate() = with(binding) {
        @Suppress("DEPRECATION") val handler = @SuppressLint("HandlerLeak")
        object : Handler() {
            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)
                textLetter.text = msg.data.getString("letter")
                textNumbers.text = msg.data.getString("numbers")
                textLetters.text = msg.data.getString("letters")
                textRegion.text = msg.data.getString("region")
                when (val numbers = "${textNumbers.text}") {
                    "${numbers[0]}${numbers[0]}${numbers[0]}" -> updateAchievement(numbers)
                    "00${numbers[2]}" -> updateAchievement(numbers)
                    "${numbers[0]}00" -> updateAchievement(numbers)
                }
                when (val letters = "${textLetter.text}${textLetters.text}") {
                    "ААА" -> updateAchievement(letters)
                    "ВВВ" -> updateAchievement(letters)
                    "ССС" -> updateAchievement(letters)
                    "ЕЕЕ" -> updateAchievement(letters)
                    "ННН" -> updateAchievement(letters)
                    "ККК" -> updateAchievement(letters)
                    "МММ" -> updateAchievement(letters)
                    "ООО" -> updateAchievement(letters)
                    "РРР" -> updateAchievement(letters)
                    "ТТТ" -> updateAchievement(letters)
                    "УУУ" -> updateAchievement(letters)
                    "ХХХ" -> updateAchievement(letters)
                    "ЕКХ" -> updateAchievement(letters)
                    "ХКХ" -> updateAchievement(letters)
                    "САС" -> updateAchievement(letters)
                    "АОО" -> updateAchievement(letters)
                    "ВОО" -> updateAchievement(letters)
                    "СОО" -> updateAchievement(letters)
                    "ЕОО" -> updateAchievement(letters)
                    "НОО" -> updateAchievement(letters)
                    "КОО" -> updateAchievement(letters)
                    "МОО" -> updateAchievement(letters)
                    "РОО" -> updateAchievement(letters)
                    "ТОО" -> updateAchievement(letters)
                    "УОО" -> updateAchievement(letters)
                    "ХОО" -> updateAchievement(letters)
                    "АМР" -> updateAchievement(letters)
                    "АКР" -> updateAchievement(letters)
                    "ВКР" -> updateAchievement(letters)
                    "ЕКР" -> updateAchievement(letters)
                    "ККР" -> updateAchievement(letters)
                    "ЕРЕ" -> updateAchievement(letters)
                    "АММ" -> updateAchievement(letters)
                    "ВММ" -> updateAchievement(letters)
                    "СММ" -> updateAchievement(letters)
                    "ЕММ" -> updateAchievement(letters)
                    "НММ" -> updateAchievement(letters)
                    "КММ" -> updateAchievement(letters)
                    "ОММ" -> updateAchievement(letters)
                    "РММ" -> updateAchievement(letters)
                    "ТММ" -> updateAchievement(letters)
                    "УММ" -> updateAchievement(letters)
                    "ХММ" -> updateAchievement(letters)
                    "КМР" -> updateAchievement(letters)
                    "РМР" -> updateAchievement(letters)
                    "ММР" -> updateAchievement(letters)
                    "ТМР" -> updateAchievement(letters)
                    "НАА" -> updateAchievement(letters)
                    "ТАА" -> updateAchievement(letters)
                    "САА" -> updateAchievement(letters)
                    "ХАА" -> updateAchievement(letters)
                    "СКО" -> updateAchievement(letters)
                    "АСК" -> updateAchievement(letters)
                    "АНО" -> updateAchievement(letters)
                    "МОР" -> updateAchievement(letters)
                    "НСО" -> updateAchievement(letters)
                    "МРО" -> updateAchievement(letters)
                    "ООМ" -> updateAchievement(letters)
                    "МВУ" -> updateAchievement(letters)
                    "УВУ" -> updateAchievement(letters)
                    "УВО" -> updateAchievement(letters)
                    "ВМР" -> updateAchievement(letters)
                    "ККХ" -> updateAchievement(letters)
                    "ОМР" -> updateAchievement(letters)
                    "УМР" -> updateAchievement(letters)
                    "АУЕ" -> updateAchievement(letters)
                }
            }
        }
        Thread {
            val bundle = Bundle()
            val msg = handler.obtainMessage()
            bundle.putString("letter", randomizeLetter())
            bundle.putString("letters", "${randomizeLetter()}${randomizeLetter()}")
            val numbers = "${randomizeNumber()}${randomizeNumber()}${randomizeNumber()}"
            if (numbers == "000") bundle.putString("numbers", "001")
            else bundle.putString("numbers", numbers)
            val region = "${randomizeNumber()}${randomizeNumber()}${randomizeNumber()}"
            if (region[0] == '0') bundle.putString("region", "${region[1]}${region[2]}")
            else bundle.putString("region", region)
            msg.data = bundle
            handler.sendMessage(msg)
        }.start()
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
        val preferences = Preferences(requireContext())
        viewToast(requireContext(), "Новое достижение за комбинацию: $achievement")
        try{
            Database("${Preferences(requireContext()).getAccount()}/achievements/$achievement")
                .setValue(preferences.get(achievement).toInt())
        }catch (_: NumberFormatException) {
            Database("${Preferences(requireContext()).getAccount()}/achievements/$achievement")
                .setValue(1)
        }
    }
}
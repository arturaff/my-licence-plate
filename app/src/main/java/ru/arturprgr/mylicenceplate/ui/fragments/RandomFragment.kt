package ru.arturprgr.mylicenceplate.ui.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import ru.arturprgr.mylicenceplate.R
import ru.arturprgr.mylicenceplate.data.FirebaseHelper
import ru.arturprgr.mylicenceplate.data.Preferences
import ru.arturprgr.mylicenceplate.databinding.FragmentRandomBinding
import ru.arturprgr.mylicenceplate.viewToast
import java.util.Random

class RandomFragment : Fragment() {
    private lateinit var binding: FragmentRandomBinding
    private lateinit var preferences: Preferences
    private var randomLetter1: Int = -1
    private var randomLetter2: Int = -1
    private var randomLetter3: Int = -1
    private var randomNumber1: Int = -1
    private var randomNumber2: Int = -1
    private var randomNumber3: Int = -1
    private var randomRegion1: Int = -1
    private var randomRegion2: Int = -1
    private var randomRegion3: Int = -1

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
            randomLetter1 = Random().nextInt(11) + 0
            randomLetter2 = Random().nextInt(11) + 0
            randomLetter3 = Random().nextInt(11) + 0
            randomNumber1 = Random().nextInt(9) + 0
            randomNumber2 = Random().nextInt(9) + 0
            randomNumber3 = Random().nextInt(9) + 0
            randomRegion1 = Random().nextInt(9) + 0
            randomRegion2 = Random().nextInt(9) + 0
            randomRegion3 = Random().nextInt(9) + 0

            randomizeLetters(randomLetter1, imageLetter1)
            randomizeLetters(randomLetter2, imageLetter2)
            randomizeLetters(randomLetter3, imageLetter3)
            randomizeNumbers(randomNumber1, imageNumber1)
            randomizeNumbers(randomNumber2, imageNumber2)
            randomizeNumbers(randomNumber3, imageNumber3)
            randomizeNumbers(randomRegion1, imageRegion1)
            randomizeNumbers(randomRegion2, imageRegion2)
            randomizeNumbers(randomRegion3, imageRegion3)

            imageRegion1.isVisible = randomRegion1 != 0

            when (val textLetters =
                "${getLetter(randomLetter1)}${getLetter(randomLetter2)}${getLetter(randomLetter3)}") {
                "ААА" -> updateAchievement("одинаковые буквы", textLetters)
                "ВВВ" -> updateAchievement("одинаковые буквы", textLetters)
                "ССС" -> updateAchievement("одинаковые буквы", textLetters)
                "ЕЕЕ" -> updateAchievement("одинаковые буквы", textLetters)
                "ННН" -> updateAchievement("одинаковые буквы", textLetters)
                "ККК" -> updateAchievement("одинаковые буквы", textLetters)
                "МММ" -> updateAchievement("одинаковые буквы", textLetters)
                "ООО" -> updateAchievement("одинаковые буквы", textLetters)
                "РРР" -> updateAchievement("одинаковые буквы", textLetters)
                "ТТТ" -> updateAchievement("одинаковые буквы", textLetters)
                "УУУ" -> updateAchievement("одинаковые буквы", textLetters)
                "ХХХ" -> updateAchievement("одинаковые буквы", textLetters)
                "ВАА" -> updateAchievement("комбинацию", textLetters)
                "САА" -> updateAchievement("комбинацию", textLetters)
                "ЕАА" -> updateAchievement("комбинацию", textLetters)
                "НАА" -> updateAchievement("комбинацию", textLetters)
                "КАА" -> updateAchievement("комбинацию", textLetters)
                "МАА" -> updateAchievement("комбинацию", textLetters)
                "ОАА" -> updateAchievement("комбинацию", textLetters)
                "РАА" -> updateAchievement("комбинацию", textLetters)
                "ТАА" -> updateAchievement("комбинацию", textLetters)
                "УАА" -> updateAchievement("комбинацию", textLetters)
                "ХАА" -> updateAchievement("комбинацию", textLetters)
                "ААС" -> updateAchievement("комбинацию", textLetters)
                "ВАС" -> updateAchievement("комбинацию", textLetters)
                "САС" -> updateAchievement("комбинацию", textLetters)
                "ЕАС" -> updateAchievement("комбинацию", textLetters)
                "НАС" -> updateAchievement("комбинацию", textLetters)
                "КАС" -> updateAchievement("комбинацию", textLetters)
                "МАС" -> updateAchievement("комбинацию", textLetters)
                "ОАС" -> updateAchievement("комбинацию", textLetters)
                "РАС" -> updateAchievement("комбинацию", textLetters)
                "ТАС" -> updateAchievement("комбинацию", textLetters)
                "УАС" -> updateAchievement("комбинацию", textLetters)
                "ХАС" -> updateAchievement("комбинацию", textLetters)
                "АСК" -> updateAchievement("комбинацию", textLetters)
                "ВСК" -> updateAchievement("комбинацию", textLetters)
                "ССК" -> updateAchievement("комбинацию", textLetters)
                "ЕСК" -> updateAchievement("комбинацию", textLetters)
                "НСК" -> updateAchievement("комбинацию", textLetters)
                "КСК" -> updateAchievement("комбинацию", textLetters)
                "МСК" -> updateAchievement("комбинацию", textLetters)
                "ОСК" -> updateAchievement("комбинацию", textLetters)
                "РСК" -> updateAchievement("комбинацию", textLetters)
                "ТСК" -> updateAchievement("комбинацию", textLetters)
                "УСК" -> updateAchievement("комбинацию", textLetters)
                "ХСК" -> updateAchievement("комбинацию", textLetters)
                "АКР" -> updateAchievement("комбинацию", textLetters)
                "ВКР" -> updateAchievement("комбинацию", textLetters)
                "СКР" -> updateAchievement("комбинацию", textLetters)
                "ЕКР" -> updateAchievement("комбинацию", textLetters)
                "НКР" -> updateAchievement("комбинацию", textLetters)
                "ККР" -> updateAchievement("комбинацию", textLetters)
                "МКР" -> updateAchievement("комбинацию", textLetters)
                "ОКР" -> updateAchievement("комбинацию", textLetters)
                "РКР" -> updateAchievement("комбинацию", textLetters)
                "ТКР" -> updateAchievement("комбинацию", textLetters)
                "УКР" -> updateAchievement("комбинацию", textLetters)
                "ХКР" -> updateAchievement("комбинацию", textLetters)
                "АММ" -> updateAchievement("комбинацию", textLetters)
                "ВММ" -> updateAchievement("комбинацию", textLetters)
                "СММ" -> updateAchievement("комбинацию", textLetters)
                "ЕММ" -> updateAchievement("комбинацию", textLetters)
                "НММ" -> updateAchievement("комбинацию", textLetters)
                "КММ" -> updateAchievement("комбинацию", textLetters)
                "ОММ" -> updateAchievement("комбинацию", textLetters)
                "РММ" -> updateAchievement("комбинацию", textLetters)
                "ТММ" -> updateAchievement("комбинацию", textLetters)
                "УММ" -> updateAchievement("комбинацию", textLetters)
                "ХММ" -> updateAchievement("комбинацию", textLetters)
                "АМР" -> updateAchievement("комбинацию", textLetters)
                "ВМР" -> updateAchievement("комбинацию", textLetters)
                "СМР" -> updateAchievement("комбинацию", textLetters)
                "ЕМР" -> updateAchievement("комбинацию", textLetters)
                "НМР" -> updateAchievement("комбинацию", textLetters)
                "КМР" -> updateAchievement("комбинацию", textLetters)
                "ММР" -> updateAchievement("комбинацию", textLetters)
                "ОМР" -> updateAchievement("комбинацию", textLetters)
                "РМР" -> updateAchievement("комбинацию", textLetters)
                "ТМР" -> updateAchievement("комбинацию", textLetters)
                "УМР" -> updateAchievement("комбинацию", textLetters)
                "ХМР" -> updateAchievement("комбинацию", textLetters)
                "АОО" -> updateAchievement("комбинацию", textLetters)
                "ВОО" -> updateAchievement("комбинацию", textLetters)
                "СОО" -> updateAchievement("комбинацию", textLetters)
                "ЕОО" -> updateAchievement("комбинацию", textLetters)
                "НОО" -> updateAchievement("комбинацию", textLetters)
                "КОО" -> updateAchievement("комбинацию", textLetters)
                "МОО" -> updateAchievement("комбинацию", textLetters)
                "РОО" -> updateAchievement("комбинацию", textLetters)
                "ТОО" -> updateAchievement("комбинацию", textLetters)
                "УОО" -> updateAchievement("комбинацию", textLetters)
                "ХОО" -> updateAchievement("комбинацию", textLetters)
                "АКМ" -> updateAchievement("слово", textLetters)
                "АУЕ" -> updateAchievement("слово", textLetters)
                "АУТ" -> updateAchievement("слово", textLetters)
                "ВАМ" -> updateAchievement("слово", textLetters)
                "ВАУ" -> updateAchievement("слово", textLetters)
                "ВАХ" -> updateAchievement("слово", textLetters)
                "ВСЕ" -> updateAchievement("слово", textLetters)
                "ВСМ" -> updateAchievement("слово", textLetters)
                "ВЕС" -> updateAchievement("слово", textLetters)
                "ВОР" -> updateAchievement("слово", textLetters)
                "ВОТ" -> updateAchievement("слово", textLetters)
                "ВРУ" -> updateAchievement("слово", textLetters)
                "САМ" -> updateAchievement("слово", textLetters)
                "СМС" -> updateAchievement("слово", textLetters)
                "СРУ" -> updateAchievement("слово", textLetters)
                "СТС" -> updateAchievement("слово", textLetters)
                "СТО" -> updateAchievement("слово", textLetters)
                "ЕВА" -> updateAchievement("слово", textLetters)
                "ЕРЕ" -> updateAchievement("слово", textLetters)
                "ЕКХ" -> updateAchievement("слово", textLetters)
                "НАМ" -> updateAchievement("слово", textLetters)
                "НЕТ" -> updateAchievement("слово", textLetters)
                "НОС" -> updateAchievement("слово", textLetters)
                "КАК" -> updateAchievement("слово", textLetters)
                "КАР" -> updateAchievement("слово", textLetters)
                "КВН" -> updateAchievement("слово", textLetters)
                "КОТ" -> updateAchievement("слово", textLetters)
                "КТО" -> updateAchievement("слово", textLetters)
                "МАК" -> updateAchievement("слово", textLetters)
                "МАТ" -> updateAchievement("слово", textLetters)
                "МЕР" -> updateAchievement("слово", textLetters)
                "МЕХ" -> updateAchievement("слово", textLetters)
                "МНЕ" -> updateAchievement("слово", textLetters)
                "МКС" -> updateAchievement("слово", textLetters)
                "МОТ" -> updateAchievement("слово", textLetters)
                "МРТ" -> updateAchievement("слово", textLetters)
                "МТА" -> updateAchievement("слово", textLetters)
                "МТС" -> updateAchievement("слово", textLetters)
                "МУР" -> updateAchievement("слово", textLetters)
                "МУТ" -> updateAchievement("слово", textLetters)
                "ОСА" -> updateAchievement("слово", textLetters)
                "ОНА" -> updateAchievement("слово", textLetters)
                "ОНО" -> updateAchievement("слово", textLetters)
                "ОРУ" -> updateAchievement("слово", textLetters)
                "РАК" -> updateAchievement("слово", textLetters)
                "РАМ" -> updateAchievement("слово", textLetters)
                "РОК" -> updateAchievement("слово", textLetters)
                "РОТ" -> updateAchievement("слово", textLetters)
                "РУС" -> updateAchievement("слово", textLetters)
                "ТОР" -> updateAchievement("слово", textLetters)
                "ТОТ" -> updateAchievement("слово", textLetters)
                "ТУТ" -> updateAchievement("слово", textLetters)
                "УРА" -> updateAchievement("слово", textLetters)
                "УХА" -> updateAchievement("слово", textLetters)
                "УХО" -> updateAchievement("слово", textLetters)
                "ХАН" -> updateAchievement("слово", textLetters)
                "ХАМ" -> updateAchievement("слово", textLetters)
                "ХЕР" -> updateAchievement("слово", textLetters)
            }

            when (val textNumbers = "$randomNumber1$randomNumber2$randomNumber3") {
                "000" -> updateAchievement("одинаковые цифры", textNumbers)
                "111" -> updateAchievement("одинаковые цифры", textNumbers)
                "222" -> updateAchievement("одинаковые цифры", textNumbers)
                "333" -> updateAchievement("одинаковые цифры", textNumbers)
                "444" -> updateAchievement("одинаковые цифры", textNumbers)
                "555" -> updateAchievement("одинаковые цифры", textNumbers)
                "666" -> updateAchievement("одинаковые цифры", textNumbers)
                "777" -> updateAchievement("одинаковые цифры", textNumbers)
                "888" -> updateAchievement("одинаковые цифры", textNumbers)
                "999" -> updateAchievement("одинаковые цифры", textNumbers)
                "100" -> updateAchievement("ровные цифры", textNumbers)
                "200" -> updateAchievement("ровные цифры", textNumbers)
                "300" -> updateAchievement("ровные цифры", textNumbers)
                "400" -> updateAchievement("ровные цифры", textNumbers)
                "500" -> updateAchievement("ровные цифры", textNumbers)
                "600" -> updateAchievement("ровные цифры", textNumbers)
                "700" -> updateAchievement("ровные цифры", textNumbers)
                "800" -> updateAchievement("ровные цифры", textNumbers)
                "900" -> updateAchievement("ровные цифры", textNumbers)
                "001" -> updateAchievement("первые десять в цифрах", textNumbers)
                "002" -> updateAchievement("первые десять в цифрах", textNumbers)
                "003" -> updateAchievement("первые десять в цифрах", textNumbers)
                "004" -> updateAchievement("первые десять в цифрах", textNumbers)
                "005" -> updateAchievement("первые десять в цифрах", textNumbers)
                "006" -> updateAchievement("первые десять в цифрах", textNumbers)
                "007" -> updateAchievement("первые десять в цифрах", textNumbers)
                "008" -> updateAchievement("первые десять в цифрах", textNumbers)
                "009" -> updateAchievement("первые десять в цифрах", textNumbers)
            }
        }, 0)
    }

    private fun randomizeLetters(random: Int, view: ImageView) {
        when (random) {
            0 -> view.setImageResource(R.drawable.letter_a)
            1 -> view.setImageResource(R.drawable.letter_b)
            2 -> view.setImageResource(R.drawable.letter_c)
            3 -> view.setImageResource(R.drawable.letter_e)
            4 -> view.setImageResource(R.drawable.letter_h)
            5 -> view.setImageResource(R.drawable.letter_k)
            6 -> view.setImageResource(R.drawable.letter_m)
            7 -> view.setImageResource(R.drawable.letter_o)
            8 -> view.setImageResource(R.drawable.letter_p)
            9 -> view.setImageResource(R.drawable.letter_t)
            10 -> view.setImageResource(R.drawable.letter_x)
            11 -> view.setImageResource(R.drawable.letter_y)
        }
    }

    private fun randomizeNumbers(random: Int, view: ImageView) {
        when (random) {
            0 -> view.setImageResource(R.drawable.number_0)
            1 -> view.setImageResource(R.drawable.number_1)
            2 -> view.setImageResource(R.drawable.number_2)
            3 -> view.setImageResource(R.drawable.number_3)
            4 -> view.setImageResource(R.drawable.number_4)
            5 -> view.setImageResource(R.drawable.number_5)
            6 -> view.setImageResource(R.drawable.number_6)
            7 -> view.setImageResource(R.drawable.number_7)
            8 -> view.setImageResource(R.drawable.number_8)
            9 -> view.setImageResource(R.drawable.number_9)
        }
    }

    private fun getLetter(random: Int): String {
        return when (random) {
            0 -> "А"
            1 -> "В"
            2 -> "С"
            3 -> "Е"
            4 -> "Н"
            5 -> "К"
            6 -> "М"
            7 -> "О"
            8 -> "Р"
            9 -> "Т"
            10 -> "Х"
            11 -> "У"
            else -> "А"
        }
    }

    private fun updateAchievement(type: String, achievement: String) {
        val reference =
            FirebaseHelper("${Preferences(requireContext()).getAccount()}/achievements/$achievement")
        viewToast(requireContext(), "Новое достижение за $type: $achievement")
        reference.setValue(preferences.getAchievement(achievement) + 1)
        preferences.setAchievement(achievement, preferences.getAchievement(achievement) + 1)
    }
}
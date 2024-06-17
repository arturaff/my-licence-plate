package ru.arturprgr.mylicenceplate.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import ru.arturprgr.mylicenceplate.R
import ru.arturprgr.mylicenceplate.databinding.FragmentEntranceBinding
import ru.arturprgr.mylicenceplate.ui.activities.MainActivity
import ru.arturprgr.mylicenceplate.viewToast

class EntranceFragment : Fragment() {
    private lateinit var binding: FragmentEntranceBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentEntranceBinding.inflate(inflater, container, false)

        binding.apply {
            buttonEntrance.setOnClickListener {
                val email = "${editEmail.text}"
                val password = "${editPassword.text}"

                if (email != "" && password != "") {
                    Firebase.auth.signInWithEmailAndPassword(email, password)
                        .addOnSuccessListener {
                            ru.arturprgr.mylicenceplate.data.Preferences(requireContext())
                                .setAccount("${email.replace(".", "")}/licencePlate")
                            startActivity(Intent(requireContext(), MainActivity::class.java))
                        }

                        .addOnFailureListener {
                            viewToast(requireContext(), "Что-то пошло не так!")
                        }

                } else viewToast(requireContext(), "Заполните все поля!")
            }

            buttonRegister.setOnClickListener {
                findNavController().navigate(R.id.action_entranceFragment_to_registerFragment)
            }
        }

        return binding.root
    }
}
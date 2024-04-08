package com.example.projectutsanmp160421058.view

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.projectutsanmp160421058.R
import com.example.projectutsanmp160421058.databinding.FragmentRegisterBinding
import com.example.projectutsanmp160421058.util.register


class RegisterFragment : Fragment() {
    private lateinit var binding: FragmentRegisterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
//        return inflater.inflate(R.layout.fragment_register, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnRegister.setOnClickListener {
            val username = binding.txtUsername.text.toString()
            val nama_depan = binding.txtNamaDepan.text.toString()
            val nama_belakang = binding.txtNamaBelakang.text.toString()
            val email = binding.txtEmail.text.toString()
            val password = binding.txtPassw.text.toString()
            val konfPassw = binding.txtKonfirmPassword.text.toString()

            val alert = AlertDialog.Builder(activity)
            alert.setTitle("Informasi")

            if (password == konfPassw) {
                register(username, nama_depan, nama_belakang, email, password)
                alert.setMessage("Berhasil mendaftarkan user.\nSilahkan login menggunakan username dan password")
                alert.setPositiveButton("OK", DialogInterface.OnClickListener { dialog, which ->
                    val action = RegisterFragmentDirections.actionLoginFragment()
                    Navigation.findNavController(it).navigate(action)
                })
            } else {
                alert.setMessage("Gagal mendaftarkan user. \nCek apakah password dengan konfirmasinya sama")
                alert.setPositiveButton("OK", DialogInterface.OnClickListener { dialog, which ->

                })
            }

            alert.create().show()
        }
    }

}
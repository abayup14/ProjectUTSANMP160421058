package com.example.projectutsanmp160421058.view

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.projectutsanmp160421058.R
import com.example.projectutsanmp160421058.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false)
//        return inflater.inflate(R.layout.fragment_login, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLogin.setOnClickListener {
            val username = binding.txtUsername.text.toString()
            val password = binding.txtPassw.text.toString()

            val alert = AlertDialog.Builder(activity)
            alert.setTitle("Informasi")

            if (username == "admin" && password == "admin") {
                alert.setMessage("Login Berhasil")
                alert.setPositiveButton("OK", DialogInterface.OnClickListener { dialog, which ->
                    val intent = Intent(activity, HomeActivity::class.java)
                    startActivity(intent)
                    activity?.finish()
                })
            } else {
                alert.setMessage("Login Gagal")
                alert.setPositiveButton("OK", DialogInterface.OnClickListener { dialog, which ->

                })
            }

            alert.create().show()
        }

        binding.btnRegister.setOnClickListener {
            val action = LoginFragmentDirections.actionRegisterFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }

}
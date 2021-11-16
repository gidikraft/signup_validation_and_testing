package com.example.week_five_login_validation_and_testing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import fragments.SignUpFragment
import fragments.UsersFragment

class MainActivity : AppCompatActivity(), Communicator {
    private var signUpFragment = SignUpFragment()
    private var usersFragment = UsersFragment()
    private lateinit var signup: BottomNavigationItemView
    private lateinit var users: BottomNavigationItemView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//set the signUpFragment to display when the activity loads
        replaceFragment(signUpFragment)
//listener that switches to signup pages when the menu is clicked
        signup = findViewById(R.id.signup)
        signup.setOnClickListener{
            replaceFragment(signUpFragment)
        }
//listener that switches between to user accounts page when the menu is clicked
        users = findViewById(R.id.user_accounts)
        users.setOnClickListener {
            replaceFragment(usersFragment)
        }
    }

//    function that switches between the pages when button is clicked
    private fun replaceFragment(fragment: Fragment){
        if (fragment != null){
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, fragment)
            transaction.commit()
        }
    }

//override abstract method from interface to act as communicator between fragments
    override fun passData(username: String, email: String, phone: String, sex: String) {
        val bundle = Bundle()
        bundle.putString("username", username)
        bundle.putString("userEmail", email)
        bundle.putString("userPhone", phone)
        bundle.putString("userSex", sex)

        val transaction = this.supportFragmentManager.beginTransaction()
        usersFragment.arguments = bundle

        transaction.replace(R.id.fragment_container, usersFragment)
        transaction.commit()
    }

}
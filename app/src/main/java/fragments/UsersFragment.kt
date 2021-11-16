package fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.week_five_login_validation_and_testing.R

class UsersFragment : Fragment() {
    var displayUsername: String? = ""
    var displayEmail: String? = ""
    var displayPhoneNumber: String? = ""
    var displaySex: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_users, container, false)

//      set fragment_users.xml to receive inputs passed into Communicator interface as parameters
        displayUsername = arguments?.getString("username")
        displayEmail = arguments?.getString("userEmail")
        displayPhoneNumber = arguments?.getString("userPhone")
        displaySex = arguments?.getString("userSex")

        view.findViewById<TextView>(R.id.username_entered).text = displayUsername
        view.findViewById<TextView>(R.id.email_entered).text = displayEmail
        view.findViewById<TextView>(R.id.phone_number_entered).text = displayPhoneNumber
        view.findViewById<TextView>(R.id.sex_picked).text = displaySex

        return view
    }
}
package fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.week_five_login_validation_and_testing.Communicator
import com.example.week_five_login_validation_and_testing.R
import com.example.week_five_login_validation_and_testing.RegistrationUtil

class SignUpFragment : Fragment() {
    private lateinit var communicator: Communicator
    private lateinit var username: EditText
    private lateinit var email: EditText
    private lateinit var phoneNumber: EditText
    private lateinit var dropdownMenu: Spinner
    private lateinit var sexPicker : String

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
        val view = inflater.inflate(R.layout.fragment_sign_up, container, false)

//      activate spinner in fragment_signup.xml
        val dropdownList = arrayOf("male", "female") //array of options in dropdown menu
        dropdownMenu = view.findViewById(R.id.sex_dropdown)

//      place the spinner array into the spinner adapter
        dropdownMenu.adapter = ArrayAdapter(requireActivity(), android.R.layout.simple_spinner_item, dropdownList)
        dropdownMenu.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long
            ) {
                sexPicker = parent?.getItemAtPosition(position).toString() //get the position of the item that is clicked
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }

//      set inputs entered in signup fragment to be passed into the interface parameters
        communicator = activity as Communicator

        username = view.findViewById(R.id.username)
        email = view.findViewById(R.id.email)
        phoneNumber = view.findViewById(R.id.phone_number)

        view.findViewById<Button>(R.id.signUpBtn).setOnClickListener {
            if (!RegistrationUtil.validateInput(username.text.toString(), email.text.toString(), phoneNumber.text.toString())){
                username.error = "username required"
                email.error = "unknown required"
                phoneNumber.error ="unknown required"
            } else
            {
                communicator.passData(username.text.toString(), email.text.toString(), phoneNumber.text.toString(), sexPicker.toString())
            }

        }
        return view
    }
}
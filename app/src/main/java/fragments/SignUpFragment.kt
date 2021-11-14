package fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.week_five_login_validation_and_testing.Communicator
import com.example.week_five_login_validation_and_testing.R

class SignUpFragment : Fragment() {
    private lateinit var communicator: Communicator
    private lateinit var username: EditText
    private lateinit var email: EditText
    private lateinit var phoneNumber: EditText
    private lateinit var spinnerItem: Spinner


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
        val dropdownList = arrayOf("Sex", "male", "female") //array of options in dropdown menu
        val dropdownMenu = view.findViewById<Spinner>(R.id.sex_dropdown)

        dropdownMenu.adapter = ArrayAdapter(requireActivity(), android.R.layout.simple_spinner_item, dropdownList)
        dropdownMenu.onItemSelectedListener = object : AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long
            ) {
                val spinner: Spinner = view!!.findViewById(R.id.sex_dropdown)
                if (dropdownMenu.selectedItem == dropdownList[0]){
                    spinnerItem == dropdownMenu
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemClick(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

            }

        }
//      set inputs entered in signup fragment to be passed into the interface parameters
        communicator = activity as Communicator

        username = view.findViewById(R.id.username)
        email = view.findViewById(R.id.email)
        phoneNumber = view.findViewById(R.id.phone_number)

        view.findViewById<Button>(R.id.signUpBtn).setOnClickListener {
            communicator.passData(username.text.toString(), email.text.toString(), phoneNumber.text.toString())

        }
        return view
    }

    companion object
}
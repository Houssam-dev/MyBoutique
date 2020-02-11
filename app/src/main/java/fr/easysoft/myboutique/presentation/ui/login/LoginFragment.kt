package fr.easysoft.myboutique.presentation.ui.login

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.Navigation

import fr.easysoft.myboutique.R
import fr.easysoft.myboutique.presentation.MainActivity
import kotlinx.android.synthetic.main.fragment_login.*


/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [LoginFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment(), View.OnClickListener {
    lateinit var navController: NavController;

    companion object {
        @JvmStatic
        fun newInstance() = LoginFragment()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view);

        skip_btn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.skip_btn -> {
                navController.navigate(R.id.action_loginFragment_to_homeUnregistredFragment)
            };
        }
    }
}

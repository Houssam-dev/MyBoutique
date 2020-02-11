package fr.easysoft.myboutique.presentation.ui.home.client.unregistred

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.google.android.material.bottomnavigation.BottomNavigationView

import fr.easysoft.myboutique.R
import fr.easysoft.myboutique.presentation.MainActivity
import kotlinx.android.synthetic.main.common_unregistred_bottom_nav.*

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [HomeUnregistredFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [HomeUnregistredFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeUnregistredFragment : Fragment(), BottomNavigationView.OnNavigationItemSelectedListener {

    lateinit var navController: NavController;

    companion object {
        @JvmStatic
        fun newInstance() = HomeUnregistredFragment();
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_unregistred, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //(this.activity as MainActivity).makeVisibleUnregistredComponents();

        navController = Navigation.findNavController(view);

        var response = common_unregistred_bottom_navigation.setOnNavigationItemSelectedListener(this);
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.item_action_produits -> navController.navigate(R.id.action_homeUnregistredFragment_to_productsFragment);
        }


        return true;
    }


}

package com.igorpi25.bumblebee

import android.content.pm.PackageManager
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.igorpi25.bumblebee.databinding.FragmentVersionBinding


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class VersionFragment : Fragment() {

    private var _binding: FragmentVersionBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentVersionBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true)
        activity?.let {
            val manager = it.packageManager
            val info = manager.getPackageInfo(it.packageName, PackageManager.GET_ACTIVITIES)
            binding.textviewVersion.text = info.versionName
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_version, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_about -> {
                findNavController().navigate(R.id.action_VersionFragment_to_AboutFragment)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
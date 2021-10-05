package com.jgbravo.tareapp.ui.folder

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.jgbravo.tareapp.databinding.FragmentFolderBinding

class FolderFragment : Fragment() {

    private lateinit var folderViewModel: FolderViewModel
    private var _binding: FragmentFolderBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        folderViewModel =
            ViewModelProvider(this).get(FolderViewModel::class.java)

        _binding = FragmentFolderBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textFolder
        folderViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
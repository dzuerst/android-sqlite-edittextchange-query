package com.neonusa.belajarnavigationdrawer.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.neonusa.belajarnavigationdrawer.databinding.FragmentHomeBinding
import com.neonusa.belajarnavigationdrawer.room.Word
import com.neonusa.belajarnavigationdrawer.ui.adapter.WordAdapter

class HomeFragment : Fragment() {

    private lateinit var fragmentHomeBinding: FragmentHomeBinding
    private lateinit var viewModel: HomeViewModel
    private lateinit var adapter: WordAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        fragmentHomeBinding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return fragmentHomeBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        adapter = WordAdapter()
        viewModel = ViewModelProvider(requireActivity()).get(HomeViewModel::class.java)

        fragmentHomeBinding.rvWords.layoutManager = LinearLayoutManager(requireActivity())
        showData("")

        fragmentHomeBinding.edtTextWord.doAfterTextChanged {
            showData( fragmentHomeBinding.edtTextWord.text.toString() + "%")
        }
    }

    fun showData(word: String){
        viewModel.getWords(word).observe(requireActivity(),
            Observer<List<Word>> { words ->
                if (words != null){
                    adapter.setList(words)
                }
                fragmentHomeBinding.rvWords.adapter = adapter
            })
    }
}
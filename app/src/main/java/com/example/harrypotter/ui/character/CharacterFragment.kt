package com.example.harrypotter.ui.character

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.harrypotter.databinding.FragmentHomeBinding
import com.example.harrypotter.data.repository.Repository
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@AndroidEntryPoint
class CharacterFragment : Fragment() {


    @Inject
    lateinit var repository: Repository
//    private var _binding: FragmentHomeBinding? = null
      val viewmodel:CharacterViewModel by viewModels()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private lateinit var binding: FragmentHomeBinding



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

       // val viewModel: CharacterViewModel by activityViewModels()

        binding = FragmentHomeBinding.inflate(inflater, container, false)

        if(!viewmodel.isLoaded){
            viewmodel.getAllCharacter()
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewmodel.models.observe(viewLifecycleOwner){

            binding.rvCategory.apply {
                layoutManager =
                    StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
                adapter = CharacterAdapter(it)
            }
        }


    }

//      override fun onDestroyView() {
//          super.onDestroyView()
//          binding = null
//      }

    }




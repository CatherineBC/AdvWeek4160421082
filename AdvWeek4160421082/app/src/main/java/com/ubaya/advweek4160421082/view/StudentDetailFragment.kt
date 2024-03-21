package com.ubaya.advweek4160421082.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ubaya.advweek4160421082.R
import com.ubaya.advweek4160421082.databinding.FragmentStudentDetailBinding
import com.ubaya.advweek4160421082.databinding.FragmentStudentListBinding
import com.ubaya.advweek4160421082.viewmodel.DetailViewModel
import com.ubaya.advweek4160421082.viewmodel.ListViewModel


class StudentDetailFragment : Fragment() {
    private lateinit var viewModel: DetailViewModel
    private lateinit var binding: FragmentStudentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStudentDetailBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        viewModel.fetch()

        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.studentLD.observe(viewLifecycleOwner, Observer {student->
            binding.txtPhone.setText(student.phone)
            binding.txtStudentId.setText(student.id)
            binding.txtStudentName.setText(student.name)
            binding.txtBoD.setText(student.bod)

        })

    }

}
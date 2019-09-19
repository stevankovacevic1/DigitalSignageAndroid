package com.consulteer.digital_signage.view.ui.home.profile.editProfile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.consulteer.digital_signage.R
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import  org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance

class EditProfileFragment : Fragment(), KodeinAware {
    override val kodein: by kodein()

    private lateinit var viewModel: EditProfileFragment
    private val factory: EditProfileFragment by instance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ):
            View? {
        val binding: EditProfileFragment =
            DataBindingUtil.inflate(inflater, R.layout.fragment_edit_profile, container, true)
        viewModel = ViewModelProviders.of(this, factory).get(EditProfileViewModel::class.java)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }
}

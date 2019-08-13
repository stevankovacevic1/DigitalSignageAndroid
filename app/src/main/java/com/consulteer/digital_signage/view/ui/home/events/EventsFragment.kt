package com.consulteer.digital_signage.view.ui.home.events

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.consulteer.digital_signage.R
import com.consulteer.digital_signage.utill.Coroutines
import com.consulteer.digital_signage.utill.toast
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance

class EventsFragment : Fragment(), KodeinAware {
    override val kodein by kodein()

    private val factory: EventsViewModelFactory by instance()

    private lateinit var viewModel: EventsViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstaceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_event, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this, factory).get(EventsViewModel::class.java)



        Coroutines.main {

            val events = viewModel.events.await()/// making on memory thread with this function
            events.observe(this, Observer {
                // size of the list and toast
                context?.toast(it.size.toString())
            })


        }

    }


}
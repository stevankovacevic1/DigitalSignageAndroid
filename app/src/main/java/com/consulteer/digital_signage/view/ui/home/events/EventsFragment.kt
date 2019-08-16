package com.consulteer.digital_signage.view.ui.home.events

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.consulteer.digital_signage.R
import com.consulteer.digital_signage.data.db.entities.Event
import com.consulteer.digital_signage.utill.Coroutines
import com.consulteer.digital_signage.utill.hide
import com.consulteer.digital_signage.utill.show
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.fragment_event.*
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
        bindUI()



//        Coroutines.main {
//
//            val events = viewModel.events.await()/// uzima memorijsku nit za ovom funkcijom
//            events.observe(this, Observer {
//                // size of the list and toast
//                context?.toast(it.size.toString())
//            })
//
//
//        }instead of this corotines it is like this below


    }
private fun bindUI() = Coroutines.main{
    progress_bar.show()
    viewModel.events.await().observe(this, Observer {
        initRecyclerView(it.toEventItem())
    })

}

    private fun initRecyclerView(eventItem: List<EventItem>) {
        val mAdapter = GroupAdapter<ViewHolder>().apply{
            progress_bar.hide()
            addAll(eventItem)
        }

        recycleview.apply{
           RecyclerView.LayoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = mAdapter
        }


    }

    private fun List<Event>.toEventItem() : List<EventItem>{
        return this.map{
            EventItem(it)
        }
    }

}
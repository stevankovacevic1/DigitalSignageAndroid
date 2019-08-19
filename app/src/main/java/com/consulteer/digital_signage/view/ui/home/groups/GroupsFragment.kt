package com.consulteer.digital_signage.view.ui.home.groups

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainer
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.consulteer.digital_signage.R
import com.consulteer.digital_signage.data.db.entities.Group
import com.consulteer.digital_signage.utill.Coroutines
import com.consulteer.digital_signage.utill.hide
import com.consulteer.digital_signage.utill.show
import com.consulteer.digital_signage.utill.toast
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.fragment_event.*
import org.kodein.di.KodeinAware
import org.kodein.di.generic.instance
import java.util.Collections.addAll

class GroupsFragment : Fragment(), KodeinAware {
    override val kodein by kodein()
    private val factory: GroupsViewModelFactory by instance()
    private lateinit var viewModel: GroupsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_group, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel= ViewModelProviders.of(this,factory).get(GroupsViewModel::class.java)
        bindUI()

//        Coroutines.main{
//            val groups = viewModel.groups.await()
//            groups.observe(this, Observer{
//                context?.toast(it.size.toString())
//            })
        }
    private fun bindUI() = Coroutines.main{
        progress_bar.show()/// kada popraivs xml fragment onda implementuj
        viewModel.groups.await().observe(this,Observer{
            initRecyclerView(it.toGroupItem())
        })
    }
    private fun initRecyclerView(groupItem: List<GroupItem>){
        val gAdapter = GroupAdapter<ViewHolder>().apply{
            progress_bar.hide()
            addAll(groupItem)
    }
        recycleview.apply{
            layoutManager=LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter= gAdapter
        }

    }
    private fun List<Group>.toGroupItem(): List<GroupItem>{
        return this.map{
            GroupItem(it)
        }
    }

}
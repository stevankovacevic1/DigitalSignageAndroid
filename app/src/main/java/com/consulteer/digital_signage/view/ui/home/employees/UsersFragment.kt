package com.consulteer.digital_signage.view.ui.home.employees

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.consulteer.digital_signage.R
import com.consulteer.digital_signage.data.db.entities.User
import com.consulteer.digital_signage.utill.Coroutines
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.fragment_event.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance

class UsersFragment : Fragment(), KodeinAware{
    override val kodein by kodein()

    private val factory: UsersViewModelFactory by instance()
    private lateinit var viewModel: UsersViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_users, container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this, factory).get(UsersViewModel::class.java)
    bindUI()
    }
    private fun bindUI() = Coroutines.main{
//        progress_bar.show()
        viewModel.users.await().observe(this, Observer{
            initRecyclerView(it.toUserItem())
        })

    }
    private fun initRecyclerView(userItem: List<UserItem>){
        val mAdapter = GroupAdapter<ViewHolder>().apply{
            ///progress_bar.hide()
            addAll(userItem)
        }
        recycleview.apply{
            layoutManager=LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter= mAdapter
        }



    }
    private fun List<User>.toUserItem(): List<UserItem>{
        return this.map{
            UserItem(it)
        }
    }




}
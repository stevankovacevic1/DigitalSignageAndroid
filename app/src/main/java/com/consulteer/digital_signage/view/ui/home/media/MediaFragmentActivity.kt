package com.consulteer.digital_signage.view.ui.home.media

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.consulteer.digital_signage.R

class MediaFragmentActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView

    lateinit var arrayList: ArrayList<DataSetList>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_media)
        recyclerView = findViewById(R.id.recycleview)
        recyclerView.layoutManager = LinearLayoutManager(this) as RecyclerView.LayoutManager?
        recyclerView.setHasFixedSize(false)///stavi true ako hoces fixed broj linkova
        arrayList = ArrayList<DataSetList>()


        var dataSetList = DataSetList("stavi url link 1")
        arrayList.add(dataSetList)
        var dataSetList1 = DataSetList("stavi url link 2")
        arrayList.add(dataSetList1)
        var dataSetList2 = DataSetList("stavi url link 3")
        arrayList.add(dataSetList2)
        var dataSetList3 = DataSetList("stavi url link 4")
        arrayList.add(dataSetList3)
        var dataSetList4 = DataSetList("stavi url link 5")
        arrayList.add(dataSetList4)
        var dataSetList5 = DataSetList("stavi url link 6")
        arrayList.add(dataSetList5)
        var dataSetList6 = DataSetList("stavi url link 7")
        arrayList.add(dataSetList6)
        var dataSetList7 = DataSetList("stavi url link 8")
        arrayList.add(dataSetList7)
        var dataSetList8 = DataSetList("stavi url link 9")
        arrayList.add(dataSetList8)

        var youtubeAdapter = YoutubeAdapter(arrayList, getApplicationContext())
        recyclerView.setAdapter(youtubeAdapter)
    }
}

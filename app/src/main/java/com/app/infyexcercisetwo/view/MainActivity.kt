package com.app.infyexcercisetwo.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.infyexcercisetwo.R
import com.app.infyexcercisetwo.adapter.CountryAdapter
import com.app.infyexcercisetwo.data.CountryModel
import com.app.infyexcercisetwo.databinding.ActivityMainBinding
import com.app.infyexcercisetwo.viewmodel.MainViewmodel

class MainActivity : AppCompatActivity() {

    lateinit var activityMainBindingImpl: ActivityMainBinding
    lateinit var countryAdapter: CountryAdapter
    lateinit var viewmodel: MainViewmodel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBindingImpl = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewmodel = ViewModelProviders.of(this).get(MainViewmodel::class.java)
        setUpObserver()

    }

    fun setUpObserver() {
        viewmodel.getCountryData().observe(this, {
            activityMainBindingImpl.countryRecyclerview.layoutManager = LinearLayoutManager(this)
            countryAdapter =
                CountryAdapter(it as ArrayList<CountryModel>)
            activityMainBindingImpl.countryRecyclerview.addItemDecoration(
                DividerItemDecoration(
                    activityMainBindingImpl.countryRecyclerview.context,
                    (activityMainBindingImpl.countryRecyclerview.layoutManager as LinearLayoutManager).orientation
                )
            )
            activityMainBindingImpl.countryRecyclerview.adapter = countryAdapter
            countryAdapter.notifyDataSetChanged()

        })
    }

    private fun setupUIadapter() {

}

}

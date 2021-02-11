package com.app.infyexcercisetwo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.app.infyexcercisetwo.data.CountryModel
import com.app.infyexcercisetwo.databinding.AdapterLayoutBinding
import com.bumptech.glide.Glide

class CountryAdapter(private val countrylist: ArrayList<CountryModel>) :
    RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {

    inner class CountryViewHolder(val binding: AdapterLayoutBinding) : RecyclerView.ViewHolder(
        binding.root
    ) {
        fun bind(countryModel: CountryModel) {

            with(binding) {
                textViewTitle.text = countryModel.title
                textViewDescription.text = countryModel.description

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AdapterLayoutBinding.inflate(inflater)
        return CountryViewHolder(binding)
    }

    override fun getItemCount(): Int = countrylist.size

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) =
        holder.bind(countrylist[position])

    fun addData(list: List<CountryModel>) {
        countrylist.addAll(list)
    }

    companion object {
        @JvmStatic
        @BindingAdapter("image")
        fun loadImage(view: ImageView, profileImage: Int) {
            Glide.with(view.context)
                .load(profileImage)
                .into(view)
        }
    }
}
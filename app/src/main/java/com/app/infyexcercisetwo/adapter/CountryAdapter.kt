package com.app.infyexerciseone

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.infyexcercisetwo.R
import com.app.infyexcercisetwo.data.CountryModel
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.adapter_layout.view.*

class CountryAdapter(private val countrylist: ArrayList<CountryModel>) :
        RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {

    class CountryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(countryModel: CountryModel) {
            if (countryModel.title != null) {
                itemView.textViewTitle.text = countryModel.title
                itemView.textViewDescription.text = countryModel.description
                Glide.with(itemView.imageViewAvatar.context)
                        .load(countryModel.image)
                        .into(itemView.imageViewAvatar)

                Log.e("SS",countryModel.title)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            CountryViewHolder(
                    LayoutInflater.from(parent.context)
                            .inflate(R.layout.adapter_layout, parent, false)
            )

    override fun getItemCount(): Int = countrylist.size

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) =
            holder.bind(countrylist[position])
}
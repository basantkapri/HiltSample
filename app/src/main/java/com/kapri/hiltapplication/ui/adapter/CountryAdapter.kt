package com.kapri.hiltapplication.ui.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.ahmadrosid.svgloader.SvgLoader
import com.kapri.hiltapplication.R
import com.kapri.hiltapplication.data.db.model.Country

class CountryAdapter(
    private var activity: AppCompatActivity,
    private var listCountry: List<Country>
) : RecyclerView.Adapter<CountryAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private lateinit var country: Country

        fun bind(scan: Country) {
            this.country = scan

            val tvName = itemView!!.findViewById(R.id.tvName) as TextView
            val tvCode = itemView!!.findViewById(R.id.tvCode) as TextView
            val tvRegion = itemView!!.findViewById(R.id.tvRegion) as TextView
            val tvPopulation = itemView!!.findViewById(R.id.tvPopulation) as TextView
            val ivFlag = itemView!!.findViewById(R.id.ivFlag) as ImageView

            tvName.text = country.name
            tvCode.text = country.alpha3Code
            tvRegion.text = country.region + " / " + country.subregion
            tvPopulation.text = "${country.population}"

            try {
                val uri = Uri.parse(country.flag)
                SvgLoader.pluck()
                    .with(activity)
                    .setPlaceHolder(R.mipmap.ic_launcher, R.mipmap.ic_launcher)
                    .load(uri, ivFlag)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun updateSet(scan: List<Country>) {
        listCountry = scan
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.country_cell, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(listCountry.elementAt(position))

    override fun getItemCount(): Int = listCountry.size

}

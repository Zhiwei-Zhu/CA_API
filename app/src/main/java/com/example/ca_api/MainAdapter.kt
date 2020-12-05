package com.example.ca_api

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.cities_row.view.*

class MainAdapter : RecyclerView.Adapter<CustomViewHolder>() {

    val cities = listOf(
        City("London","https://upload.wikimedia.org/wikipedia/commons/thumb/c/c7/Flag_of_the_City_of_London.svg/1200px-Flag_of_the_City_of_London.svg.png"),
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        //  TODO("Not yet implemented")

        val layoutInflater = LayoutInflater.from(parent?.context)

        val cellForRow = layoutInflater.inflate(R.layout.cities_row, parent, false)

        return CustomViewHolder(cellForRow)

    }

    override fun getItemCount(): Int {
        // TODO("Not yet implemented")

        return cities.size
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        // TODO("Not yet implemented")
        holder.itemView.CityName.text = cities[position].name
        val imgView = holder?.itemView?.CityImg
        Picasso.with(holder?.itemView?.context).load(cities[position].imgURL).resize(200, 150).into(imgView)

        holder?.city = cities[position]
    }

}

class CustomViewHolder(view: View, var city: City? = null) : RecyclerView.ViewHolder(view) {

    companion object {
        val LOGCAT_CATEGORY = "JSON"
        val DETAIL_TITLE_KEY = "ActionBarTitle"
        val CITY_NAME = "CITY_NAME"
    }

    init {
        view.setOnClickListener{
            Log.i(LOGCAT_CATEGORY,"Recycler view Item has been clicked")
            Log.i(LOGCAT_CATEGORY, "Name of city is " + city?.name)

            val intent = Intent(view.context, City_Weather_Details_Activity::class.java)
            intent.putExtra(CITY_NAME, city?.name)
            intent.putExtra(DETAIL_TITLE_KEY,"Weather details on "+ city?.name)
            view.context.startActivity(intent)
        }
    }

}

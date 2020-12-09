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
            City("Cologne","https://lh3.googleusercontent.com/proxy/Ly3hrJ-oIapafl5zQJGB-Onsa3HWOUZTvxTuOY8WWSKcoVe13JF3aHkoS9RcIZtUz9oCKBPTOltoSOjhJLyylKdW0YLL2oA"),
            City("Tianjin","https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/8f2555fa-ec78-4745-9796-758bdb3ac3ff/d4uhbyp-cc010b67-c5ae-410f-b524-2322156c948e.png?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOiIsImlzcyI6InVybjphcHA6Iiwib2JqIjpbW3sicGF0aCI6IlwvZlwvOGYyNTU1ZmEtZWM3OC00NzQ1LTk3OTYtNzU4YmRiM2FjM2ZmXC9kNHVoYnlwLWNjMDEwYjY3LWM1YWUtNDEwZi1iNTI0LTIzMjIxNTZjOTQ4ZS5wbmcifV1dLCJhdWQiOlsidXJuOnNlcnZpY2U6ZmlsZS5kb3dubG9hZCJdfQ._U1VdZ-zVOvFWFtI1JfMVaoEcMOQ99hgWKslTEU4HZ4"),
            City("Berlin","https://upload.wikimedia.org/wikipedia/commons/thumb/e/ec/Flag_of_Berlin.svg/1200px-Flag_of_Berlin.svg.png"),
            City("Karaj","https://www.crwflags.com/fotw/images/i/ir-karaj.gif"),
            City("Kanpur","https://www.galaxydigitalprint.in/uploaded-files/product-images/11-56.png"),
            City("Budapest","https://www.crwflags.com/fotw/images/h/hu-bp.gif"),
            City("Sydney","https://www.crwflags.com/fotw/images/a/au-sy830.gif"),
            City("Warsaw","https://www.crwflags.com/fotw/images/p/pl-wa_.gif"),
            City("Ankara","https://www.crwflags.com/fotw/images/t/tr-06-a2.gif"),
            City("Istanbul","https://www.crwflags.com/fotw/images/t/tr-34-i6.png"),
            City("Toronto","https://i.redd.it/fdhj5flzbfe21.png"),
            City("Moscow","https://www.fotw.info/images/r/ru-mow.gif"),
            City("Bretagne","https://www.crwflags.com/fotw/images/f/fr-bz-gd.gif"),
            City("Sapporo","https://vignette.wikia.nocookie.net/flages/images/f/fe/800px-Flag_of_Sapporo%2C_Hokkaido.svg.png/revision/latest/scale-to-width-down/340?cb=20131104215927")
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
            Log.i(LOGCAT_CATEGORY, "Name of city is " + city?.name)

            val intent = Intent(view.context, City_Weather_Details_Activity::class.java)
            intent.putExtra(CITY_NAME, city?.name)
            intent.putExtra(DETAIL_TITLE_KEY,"Weather details on "+ city?.name)
            view.context.startActivity(intent)
        }
    }

}

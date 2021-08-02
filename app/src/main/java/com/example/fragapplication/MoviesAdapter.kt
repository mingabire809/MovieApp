package com.example.fragapplication


import android.app.Activity
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class MoviesAdapter(private val activity: Activity) :
    RecyclerView.Adapter<MoviesAdapter.MyViewHolder>() {

    private var movieList: List<MovieModel>? = null


    fun setMovieList(movieList: List<MovieModel>?) {
        this.movieList = movieList
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int

    ): MoviesAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_layout, parent, false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MoviesAdapter.MyViewHolder, position: Int) {
        Log.i("data", "" + movieList?.size)
        holder.bind(movieList?.get(position)!!, activity)
    }

    override fun getItemCount(): Int {
        if (movieList == null)
            return 0
        else
            return movieList?.size!!
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.image)
        val title: TextView = view.findViewById(R.id.title)
        val des: TextView = view.findViewById(R.id.des)


        fun bind(data: MovieModel, activity: Activity) {
            title.text = data.title
            des.text = "Capital: " + data.des
            Picasso.get().load("https://www.churchapp.co.ke/chama2021/movies/${data.image}")
                .into(image);
        }
    }
}

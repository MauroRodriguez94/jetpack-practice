package com.rodriguezmauro.jetpack_practice.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.rodriguezmauro.jetpack_practice.R
import com.rodriguezmauro.jetpack_practice.model.DogBreed
import com.rodriguezmauro.jetpack_practice.util.getProgressDrawable
import com.rodriguezmauro.jetpack_practice.util.loadImage
import kotlinx.android.synthetic.main.item_dog.view.*

class DogsListAdapter(val dogsList: ArrayList<DogBreed>): RecyclerView.Adapter<DogsListAdapter.DogViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_dog, parent, false)
        return DogViewHolder(view)
    }

    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
        val dog = dogsList[position]
        holder.view.breed.text = dog.dogBreed
        holder.view.lifespan.text = dog.lifeSpan
        holder.view.setOnClickListener {
            Navigation.findNavController(it).navigate(ListFragmentDirections.actionDetailFragment())
        }
        holder.view.image.loadImage(dog.imageUrl, getProgressDrawable(holder.view.context))
    }

    override fun getItemCount() = dogsList.size

    fun updateDogList(newDogList: List<DogBreed>) {
        dogsList.clear()
        dogsList.addAll(newDogList)
        notifyDataSetChanged()
    }

    class DogViewHolder(var view: View): RecyclerView.ViewHolder(view)
}
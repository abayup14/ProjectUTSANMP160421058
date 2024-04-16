package com.example.projectutsanmp160421058.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.projectutsanmp160421058.databinding.CardItemBinding
import com.example.projectutsanmp160421058.model.FootballManager

class HomeListAdapter(val fmList: ArrayList<FootballManager>): RecyclerView.Adapter<HomeListAdapter.HomeViewHolder>() {
    class HomeViewHolder(val binding: CardItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val binding = CardItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return fmList.size
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        with (holder.binding) {
            HomeActivity.load_picture(holder.itemView, fmList[position].photo_url.toString(), imgPhoto)
            txtTitle.text = fmList[position].title
            txtUsername.text = "Dibuat oleh ${fmList[position].creator}"
            txtContent.text = fmList[position].description

            btnRead.setOnClickListener {
                val action = HomeFragmentDirections.actionDetailFragment(fmList[position].id.toString().toInt())
                Navigation.findNavController(it).navigate(action)
            }
        }
    }

    fun updateData(newList: ArrayList<FootballManager>) {
        fmList.clear()
        fmList.addAll(newList)
        notifyDataSetChanged()
    }
}
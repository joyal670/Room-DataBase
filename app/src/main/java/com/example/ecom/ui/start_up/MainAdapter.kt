package com.example.ecom.ui.start_up

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ecom.databinding.ListItemCategory1Binding


class MainAdapter(private var categoryList: List<UserModel>, private var delete: (String) -> Unit, private var update :(String) -> Unit) :
    RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    private var context: Context? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = ListItemCategory1Binding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.email.text = " Email : " + categoryList[position].userEmail
        holder.binding.name.text = " Name :" + categoryList[position].userName
        holder.binding.password.text = " Password :" + categoryList[position].userPassword

        holder.binding.delete.setOnClickListener {
            delete.invoke(categoryList[position].userEmail)
        }

        holder.binding.update.setOnClickListener {
            update.invoke(categoryList[position].userEmail)
        }

    }

    class ViewHolder(var binding: ListItemCategory1Binding) :
        RecyclerView.ViewHolder(binding.root)
}
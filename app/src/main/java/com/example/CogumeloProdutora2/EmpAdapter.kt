package com.example.CogumeloProdutora2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EmpAdapter(private val empList: ArrayList<ClienteModelo>) :
    RecyclerView.Adapter<EmpAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tvEmpName : TextView = itemView.findViewById(R.id.tvEmpName)

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmpAdapter.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_cliente_card, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: EmpAdapter.ViewHolder, position: Int) {
        val currentEmp = empList[position]
        holder.tvEmpName.text = currentEmp.NomeCliente
    }

    override fun getItemCount(): Int {
        return empList.size
    }

}
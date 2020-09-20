package iamrajendra.github.io.apolis.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import iamrajendra.github.io.apolis.R
import iamrajendra.github.io.apolis.api.RockyResponse

class Adapter  : RecyclerView.Adapter<RockyMorthyViewHolder>(){
    private var list: List<RockyResponse.Results> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RockyMorthyViewHolder {
        var v = LayoutInflater.from(parent.context).inflate(R.layout.adapter_item,parent,false)
        return  RockyMorthyViewHolder(v)
    }

    override fun getItemCount() =list.size

    override fun onBindViewHolder(holder: RockyMorthyViewHolder, position: Int) =holder.bind(list.get(position))

    fun replaceItems(items: List<RockyResponse.Results>) {
        list = items
        notifyDataSetChanged()
    }
}
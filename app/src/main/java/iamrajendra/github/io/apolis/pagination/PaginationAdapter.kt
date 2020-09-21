package iamrajendra.github.io.apolis.pagination

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import iamrajendra.github.io.apolis.R
import iamrajendra.github.io.apolis.api.RockyResponse
import iamrajendra.github.io.apolis.main.adapter.RockyMorthyViewHolder

class PaginationAdapter  : PagedListAdapter<RockyResponse.Results,RockyMorthyViewHolder> (DiffUtilCallBack()){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RockyMorthyViewHolder {
        var v = LayoutInflater.from(parent.context).inflate(R.layout.adapter_item,parent,false)
        return  RockyMorthyViewHolder(v)
    }

    override fun onBindViewHolder(holder: RockyMorthyViewHolder, position: Int) {
        var  value  = getItem(position);
        if (value != null) {
            holder.bind(value)
        }

    }
}
package iamrajendra.github.io.apolis.pagination

import androidx.recyclerview.widget.DiffUtil
import iamrajendra.github.io.apolis.api.RockyResponse

class DiffUtilCallBack : DiffUtil.ItemCallback<RockyResponse.Results>() {
    override fun areItemsTheSame(oldItem: RockyResponse.Results, newItem: RockyResponse.Results): Boolean {
        return oldItem.id == newItem.id

    }

    override fun areContentsTheSame(oldItem: RockyResponse.Results, newItem: RockyResponse.Results): Boolean {
        return oldItem.id == newItem.id
                && oldItem.name == newItem.name
                && oldItem.species == newItem.species
    }

}
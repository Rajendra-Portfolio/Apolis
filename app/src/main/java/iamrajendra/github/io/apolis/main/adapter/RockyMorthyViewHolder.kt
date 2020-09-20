package iamrajendra.github.io.apolis.main.adapter

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import iamrajendra.github.io.apolis.api.RockyResponse
import iamrajendra.github.io.apolis.R;

class RockyMorthyViewHolder(item: View) : RecyclerView.ViewHolder(item) {
    var name: TextView? = null
    var status: TextView? = null
    var specis: TextView? = null
    var context:Context?=null
    var  image:ImageView?=null


    init {
        name = item.findViewById<TextView>(R.id.name)
        status = item.findViewById<TextView>(R.id.status)
        specis = item.findViewById<TextView>(R.id.sepsis);
        image = item.findViewById(R.id.image)
        context = item.context;
    }

    fun bind(result: RockyResponse.Results) {
        name?.text = result.name;
        status?.text = result.status;
        specis?.text = result.species;

        image?.let {
            Glide.with(this!!.context!!)
                .load(result.image)
                .apply(
                    RequestOptions()
                    .placeholder(R.drawable.tools_placeholder)
                    .error(R.drawable.tools_placeholder)
                    .diskCacheStrategy(DiskCacheStrategy.ALL))
                .into(it)
        }

    }
}
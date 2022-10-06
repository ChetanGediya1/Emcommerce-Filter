
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommrcefilter.MainActivity
import com.example.ecommrcefilter.R
import com.example.ecommrcefilter.StatusData


class StatusAdpter(val chatFragment : MainActivity, val list: ArrayList<StatusData>) :
    RecyclerView.Adapter<StatusAdpter.viewData>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewData {
        var view = LayoutInflater.from(chatFragment).inflate(R.layout.item_list, parent, false)
        return viewData(view)
    }

    override fun onBindViewHolder(holder: viewData, position: Int) {
        holder.Limages.setImageResource(list[position].images)
        holder.Lmodelname.text = list[position].name
        holder.Lrating.text = list[position].rating
        holder.Lamout.text = list[position].price

    }

    override fun getItemCount(): Int {
        return list.size
    }

    class viewData(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var Limages =itemView.findViewById<ImageView>(R.id.Limages)
        var Lmodelname = itemView.findViewById<TextView>(R.id.Lmodelname)
        var Lrating = itemView.findViewById<TextView>(R.id.Lrating)
        var Lamout = itemView.findViewById<TextView>(R.id.Lamout)

    }
}
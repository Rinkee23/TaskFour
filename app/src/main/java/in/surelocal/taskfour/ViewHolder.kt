package `in`.surelocal.taskfour

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

open class ViewHolder (itemView:View):RecyclerView.ViewHolder(itemView){
    val tName = itemView.findViewById<TextView>(R.id.row_item_name)
    val tAddress = itemView.findViewById<TextView>(R.id.row_item_address)
    val tEmail = itemView.findViewById<TextView>(R.id.row_item_email)
    val tMoblieNo = itemView.findViewById<TextView>(R.id.row_item_mobile)

}
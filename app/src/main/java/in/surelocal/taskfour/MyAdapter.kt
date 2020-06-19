package `in`.surelocal.taskfour

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import data.UserInfo

class MyAdapter(loadActivity: DataLoadActivity, private val mData: ArrayList<UserInfo>) : RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tName.text = mData[position].name
        holder.tEmail.text = mData[position].email
        holder.tAddress.text = mData[position].address
        holder.tMoblieNo.text = mData[position].mobile
    }
}
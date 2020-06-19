package `in`.surelocal.taskfour

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import data.UserInfo
import kotlinx.android.synthetic.main.activity_data_load.*

class DataLoadActivity : AppCompatActivity() {
    lateinit var firestore: FirebaseFirestore
    private var TAG = "DataLoadActivity"
    var mData = ArrayList<UserInfo>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_load)

        firestore = FirebaseFirestore.getInstance()
        firestore.collection("users")
            .get().addOnSuccessListener { document ->
                val data = document.toObjects(UserInfo::class.java)
                storeData(data)
                Log.d(TAG,"Error getting document")

            }

    }
    private fun storeData(data:List<UserInfo>) {
        for (inter in data){
            mData.add(inter)
        }
        data_load_recycler.layoutManager = StaggeredGridLayoutManager(1, RecyclerView.VERTICAL)
        data_load_recycler.adapter=MyAdapter(this,mData)

    }



}


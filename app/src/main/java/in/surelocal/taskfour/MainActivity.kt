package `in`.surelocal.taskfour

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import data.UserInfo
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var firestore: FirebaseFirestore
    private var TAG="MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        firestore = FirebaseFirestore.getInstance()
        main_activity_btn.setOnClickListener() {
            val sName = main_activity_Name.text.toString().trim()
            val sAddress = main_activity_address.text.toString().trim()
            val sEmail = main_activity_Email.text.toString().trim()
            val sMobile = main_activity_MBLNo.text.toString().trim()
            if (sName == "" || sAddress == "" || sEmail == "" || sMobile == "")
            {
            }else{
                val data = UserInfo(name = sName , email = sEmail , address = sAddress,mobile = sMobile)
                firestore.collection("users").document().set(data)
                    .addOnSuccessListener {
                        Toast.makeText(this,"save",Toast.LENGTH_SHORT).show()
                        Log.d(TAG,"{$it:data}")
                    }
            }
            main_activity_loadData.setOnClickListener {
                val intent = Intent(this,DataLoadActivity ::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}

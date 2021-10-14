package school.alihamz.assignment2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import school.alihamz.assignment2.database.UserRepository
import school.alihamz.assignment2.databinding.ActivityHistoryBinding
import school.alihamz.assignment2.databinding.ActivityMainBinding
import school.alihamz.assignment2.model.AppData

class HistoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHistoryBinding

    var userRepository: UserRepository? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userRepository = UserRepository(this)

        binding.ivBack.setOnClickListener { onBackPressed() }
        binding.rvHistory.layoutManager= LinearLayoutManager(this@HistoryActivity)
        Thread(Runnable {
            val adapter = HistoryAdapter(this@HistoryActivity, userRepository!!.getAllUsers() as MutableList<AppData>)
            runOnUiThread {
                binding.rvHistory.adapter=adapter
             }
        }).start()

        binding.tvClear.setOnClickListener {
            Thread(Runnable {
                val dataList =  userRepository!!.getAllUsers() as MutableList<AppData>
                for (data in dataList)
                    userRepository!!.deleteUser(data)
                val adapter = HistoryAdapter(this@HistoryActivity, userRepository!!.getAllUsers() as MutableList<AppData>)
                runOnUiThread {
                    binding.rvHistory.adapter=adapter
                }
            }).start()

        }
    }
}
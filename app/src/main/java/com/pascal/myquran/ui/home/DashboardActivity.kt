package com.pascal.myquran.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.pascal.myquran.databinding.ActivityDashboardBinding
import com.pascal.myquran.ui.adapter.AdapterQuran
import com.pascal.myquran.data.viewModel.ViewModelQuran
import com.pascal.myquran.model.ResponseListQuran
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDashboardBinding
    private lateinit var adapter: AdapterQuran
    private val viewModel: ViewModelQuran by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        attachObserve()
    }

    private fun attachObserve() {
        viewModel.getQuranView()

        viewModel.responseGetQuran.observe(this, Observer { showData(it) })
//        viewModel.isLoading.observe(this, Observer { showLoading(it) })
        viewModel.isError.observe(this, Observer { showError(it) })
    }

    private fun showData(it: Array<ResponseListQuran>) {

        adapter = AdapterQuran(it, object : AdapterQuran.OnClickListener {
            override fun detail(item: ResponseListQuran) {
                val intent = Intent(this@DashboardActivity, DetailActivity::class.java)
                intent.putExtra("data", item)
                startActivity(intent)
            }

        })
        binding.recyclerQuran.adapter = adapter
        adapter.notifyDataSetChanged()
    }

//    private fun showLoading(it: Boolean?) {
//        if (it == true) {
//            binding.progresQuran.visibility = View.VISIBLE
//        } else {
//            binding.progresQuran.visibility = View.GONE
//        }
//    }

    private fun showError(it: Throwable?) {
        showToast(it.toString())
        Log.e("tag error", it.toString())
    }

    private fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}
package com.kapri.hiltapplication.ui.view

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.kapri.hiltapplication.R
import com.kapri.hiltapplication.data.db.model.Country
import com.kapri.hiltapplication.databinding.CountryFragmentBinding
import com.kapri.hiltapplication.network.NetworkHelper
import com.kapri.hiltapplication.ui.adapter.CountryAdapter
import com.kapri.hiltapplication.ui.viewmodel.MainViewModel
import com.kapri.hiltapplication.utils.AlertUtils
import com.kapri.hiltapplication.utils.setActBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.country_fragment.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), CoroutineScope {

    private val job: Job = Job()
    private val viewModel: MainViewModel by viewModels()

    private lateinit var countryAdapter: CountryAdapter

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.country_fragment)
        super.onCreate(savedInstanceState)
        initFlow()

        refresh.setOnClickListener(View.OnClickListener {
            pbProgress.visibility = View.VISIBLE
            initFlow()

        })
    }

    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }

    private fun initFlow() {
        if (NetworkHelper.isNetworkAvailable(this)) {
            launch {
                val it = viewModel.getAllCountries()
                setMainAdapter(it.toList())
                pbProgress.visibility = View.INVISIBLE
                Log.d("Data : ", it.size.toString())
                AlertUtils.showToast(this@MainActivity, "Success...")
            }
        } else
            AlertUtils.showToast(this, "No Internet...")
    }

    private fun setMainAdapter(listCountry: List<Country>) {
        countryAdapter = CountryAdapter(this, listCountry)
        rv.adapter = countryAdapter
    }
}
package co.android.wframadhan.techtest.ui.home

import android.R
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import co.android.wframadhan.techtest.data.model.Address
import co.android.wframadhan.techtest.data.model.Candidate
import co.android.wframadhan.techtest.databinding.ActivityMainBinding
import co.android.wframadhan.techtest.ui.adapter.CandidateAdapter
import co.android.wframadhan.techtest.utils.Coroutines
import co.android.wframadhan.techtest.utils.loadImageRectangle
import co.android.wframadhan.techtest.utils.observe
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<CandidateViewModel>()
    private var candidateLoad: List<Candidate> = listOf()
    private var addressLoad: List<Address> = listOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        observer()
    }

    private fun observer() {

        observe(viewModel.listCandidate) {
            it?.let { listCandidate ->
                binding.ivDisover.loadImageRectangle("https://images.pexels.com/photos/11055830/pexels-photo-11055830.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260")
                val mAdapter = CandidateAdapter(listCandidate)

                with(binding.rvCandidate) {
                    hasFixedSize()
                    layoutManager = GridLayoutManager(this@MainActivity, 2)
                    adapter = mAdapter
                }
            }
        }
        observe(viewModel.listBlog) {
            it?.let { listBlog ->
                val mAdapter = CandidateAdapter(listBlog)
                with(binding.rvBlog) {
                    hasFixedSize()
                    layoutManager = LinearLayoutManager(this@MainActivity)
                    adapter = mAdapter
                }
            }
        }
    }
}
package co.android.wframadhan.techtest.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import co.android.wframadhan.techtest.data.model.Address
import co.android.wframadhan.techtest.data.model.Blog
import co.android.wframadhan.techtest.data.model.Candidate
import co.android.wframadhan.techtest.data.repository.TransactionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CandidateViewModel @Inject constructor(
    private val transactionRepository: TransactionRepository
) : ViewModel() {

    val listCandidate = MutableLiveData<List<Candidate>>()
    val listAddress = MutableLiveData<List<Address>>()
    val listBlog = MutableLiveData<List<Blog>>()

    init {
        CoroutineScope(Dispatchers.IO).launch {
            val candidateResponse = transactionRepository.getCandidate()
            listCandidate.postValue(candidateResponse.results)
        }
        CoroutineScope(Dispatchers.IO).launch {
            val addressResponse = transactionRepository.getAddress()
            listAddress.postValue(addressResponse.results)
        }
        CoroutineScope(Dispatchers.IO).launch {
            val blogResponse = transactionRepository.getBlog()
            listBlog.postValue(blogResponse.results)
        }
    }
}
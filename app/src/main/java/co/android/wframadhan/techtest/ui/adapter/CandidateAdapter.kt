package co.android.wframadhan.techtest.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.android.wframadhan.techtest.data.model.Blog
import co.android.wframadhan.techtest.data.model.Candidate
import co.android.wframadhan.techtest.databinding.ItemAddressBinding
import co.android.wframadhan.techtest.databinding.ItemCandidateBinding
import com.bumptech.glide.Glide

private const val ITEM_CANDIDATE = 0
private const val ITEM_ADDRESS = 1

class CandidateAdapter(
    private val data: List<Any>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        return when (data[position]) {
            is Candidate -> ITEM_CANDIDATE
            is Blog -> ITEM_ADDRESS
            else -> throw IllegalArgumentException("Undefined view type")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val candidateBinding =
            ItemCandidateBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val addressBinding =
            ItemAddressBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return when (viewType) {
            ITEM_CANDIDATE -> CandidateViewHolder(candidateBinding)
            ITEM_ADDRESS -> AddressViewHolder(addressBinding)
            else -> throw throw IllegalArgumentException("Undefined view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            ITEM_CANDIDATE -> {
                val candidateHolder = holder as CandidateViewHolder
                candidateHolder.bindCandidate(data[position] as Candidate)
            }
            ITEM_ADDRESS -> {
                val addressHolder = holder as AddressViewHolder
                addressHolder.bindAddress(data[position] as Blog)
            }
            else -> throw IllegalArgumentException("Undefined view type")
        }
    }

    override fun getItemCount() = data.size


    class CandidateViewHolder(
        private val binding: ItemCandidateBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bindCandidate(candidate: Candidate) {
            with(binding) {
                tvName.text = candidate.name
                tvBirthday.text = candidate.birthday.toString()
                Glide.with(binding.root)
                    .load(candidate.photo)
                    .into(ivCandidate)
            }
        }
    }

    class AddressViewHolder(
        private val binding: ItemAddressBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bindAddress(blog: Blog) {
            with(binding) {
                tvAddress.text = blog.title
                tvCity.text = blog.subTitle
                tvBody.text = blog.content
                Glide.with(binding.root)
                    .load(blog.photo)
                    .into(ivAddress)
            }
        }
    }
}

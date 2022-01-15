package com.l2hyunwoo.phorest.presentation.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.l2hyunwoo.phorest.R
import com.l2hyunwoo.phorest.core.base.BindingActivity
import com.l2hyunwoo.phorest.core.intent.intExtra
import com.l2hyunwoo.phorest.core.view.setOnSingleClickListener
import com.l2hyunwoo.phorest.databinding.ActivityDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DetailActivity : BindingActivity<ActivityDetailBinding>(R.layout.activity_detail) {
    private val id by intExtra()
    private val viewModel by viewModels<DetailViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        with(viewModel) {
            loadImageInfo(id)
        }

        binding.btnBack.setOnSingleClickListener { onBackPressed() }

        lifecycleScope.launch {
            viewModel.imageInfo
                .flowWithLifecycle(lifecycle)
                .collect {
                    when (it) {
                        is DetailViewModel.ImageLoadState.Image -> {
                            Glide.with(this@DetailActivity)
                                .load(it.image.downloadUrl)
                                .into(binding.imgDetail)
                            binding.txtDetailAuthor.text = "Author: ${it.image.author}"
                        }
                    }
                }
        }
    }

    companion object {
        fun getIntent(context: Context, id: Int) =
            Intent(context, DetailActivity::class.java)
                .apply { putExtra("id", id) }
    }
}
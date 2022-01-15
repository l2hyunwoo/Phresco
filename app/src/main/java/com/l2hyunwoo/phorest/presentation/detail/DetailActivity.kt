package com.l2hyunwoo.phorest.presentation.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.l2hyunwoo.phorest.R
import com.l2hyunwoo.phorest.core.base.BindingActivity
import com.l2hyunwoo.phorest.core.intent.intExtra
import com.l2hyunwoo.phorest.databinding.ActivityDetailBinding

class DetailActivity : BindingActivity<ActivityDetailBinding>(R.layout.activity_detail) {
    private val id by intExtra()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    companion object {
        fun getIntent(context: Context, id: Int) =
            Intent(context, DetailActivity::class.java)
                .apply { putExtra("id", id) }
    }
}
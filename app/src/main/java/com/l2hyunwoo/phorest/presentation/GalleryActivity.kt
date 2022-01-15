package com.l2hyunwoo.phorest.presentation

import android.os.Bundle
import com.l2hyunwoo.phorest.R
import com.l2hyunwoo.phorest.core.base.BindingActivity
import com.l2hyunwoo.phorest.databinding.ActivityGalleryBinding

class GalleryActivity : BindingActivity<ActivityGalleryBinding>(R.layout.activity_gallery) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.bnvMain.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.page_home -> {
                    true
                }
                R.id.page_favorite -> {
                    true
                }
                else -> false
            }
        }
    }
}
package com.l2hyunwoo.phorest.presentation.gallery

import android.os.Bundle
import androidx.annotation.IdRes
import com.l2hyunwoo.phorest.R
import com.l2hyunwoo.phorest.core.base.BindingActivity
import com.l2hyunwoo.phorest.databinding.ActivityGalleryBinding
import com.l2hyunwoo.phorest.presentation.gallery.subscreen.FavoriteFragment
import com.l2hyunwoo.phorest.presentation.gallery.subscreen.FeedFragment

class GalleryActivity : BindingActivity<ActivityGalleryBinding>(R.layout.activity_gallery) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager.beginTransaction()
            .replace(R.id.container_main, FeedFragment())
            .commit()
        binding.bnvMain.setOnItemSelectedListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container_main, createFragmentOf(it.itemId))
                .commit()
            true
        }
    }

    private fun createFragmentOf(@IdRes itemId: Int) = when (itemId) {
        R.id.page_home -> FeedFragment()
        R.id.page_favorite -> FavoriteFragment()
        else -> throw IllegalStateException("Id: ${itemId}를 가진 Fragment는 존재하지 않습니다.")
    }
}


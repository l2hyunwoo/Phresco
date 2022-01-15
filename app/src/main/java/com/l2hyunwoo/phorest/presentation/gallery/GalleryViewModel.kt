package com.l2hyunwoo.phorest.presentation.gallery

import androidx.lifecycle.ViewModel
import com.l2hyunwoo.phorest.R

private const val INIT_SUBSCREEN_ID = R.id.page_home

class GalleryViewModel : ViewModel() {
    var currentScreenItemId = INIT_SUBSCREEN_ID
}
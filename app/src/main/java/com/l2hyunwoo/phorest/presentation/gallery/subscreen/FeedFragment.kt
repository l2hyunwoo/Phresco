package com.l2hyunwoo.phorest.presentation.gallery.subscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.l2hyunwoo.phorest.R
import com.l2hyunwoo.phorest.core.base.BindingFragment
import com.l2hyunwoo.phorest.databinding.FragmentFeedBinding

class FeedFragment : BindingFragment<FragmentFeedBinding>(R.layout.fragment_feed) {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}
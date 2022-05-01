package com.l2hyunwoo.phorest.presentation.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.l2hyunwoo.phorest.domain.repository.DetailRepository
import com.l2hyunwoo.phorest.presentation.model.FeedUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: DetailRepository
) : ViewModel() {
    private val _imageInfo: MutableStateFlow<ImageLoadState> = MutableStateFlow(ImageLoadState.Init)
    val imageInfo: StateFlow<ImageLoadState> = _imageInfo.asStateFlow()

    fun loadImageInfo(id: Int) {
        viewModelScope.launch {
            runCatching { repository.loadImageInfo(id) }
                .onSuccess { _imageInfo.value = it.toFeedUiModel().toState() }
                .onFailure(Timber::e)
        }
    }

    sealed class ImageLoadState {
        object Init : ImageLoadState()
        data class Image(val image: FeedUiModel) : ImageLoadState()
    }

    private fun FeedUiModel.toState(): ImageLoadState.Image = ImageLoadState.Image(this)
}

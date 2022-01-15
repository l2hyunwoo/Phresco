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
    // 이 부분은 예상 스펙과 달라 이용하지 못했습니다.
    private val _blurImage: MutableStateFlow<ImageLoadState> = MutableStateFlow(ImageLoadState.Init)
    val blurImage: StateFlow<ImageLoadState> = _blurImage.asStateFlow()

    // 이 부분은 예상 스펙과 달라 이용하지 못했습니다.
    private val _image: MutableStateFlow<ImageLoadState> = MutableStateFlow(ImageLoadState.Init)
    val image: StateFlow<ImageLoadState> = _image.asStateFlow()

    private val _imageInfo: MutableStateFlow<ImageLoadState> = MutableStateFlow(ImageLoadState.Init)
    val imageInfo: StateFlow<ImageLoadState> = _imageInfo.asStateFlow()

    // 이 부분은 예상 스펙과 달라 이용하지 못했습니다.
    fun loadImage(id: Int) {
        viewModelScope.launch {
            runCatching { repository.loadImage(id) }
                .onSuccess { _image.value = it.toFeedUiModel().toState() }
                .onFailure(Timber::e)
        }
    }

    // 이 부분은 예상 스펙과 달라 이용하지 못했습니다.
    fun loadBlurImage(id: Int) {
        viewModelScope.launch {
            runCatching { repository.loadBlurImage(id) }
                .onSuccess { _blurImage.value = it.toFeedUiModel().toState() }
                .onFailure(Timber::e)
        }
    }

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

# Phorest

2021년 12월 기준으로 알고 있었던 지식을 활용하여 개발한 Sample Application

## Tech Stack

- 멀티 모듈(이라고 불리우는 것)
  + app/core 모듈로 Util성 코드를 분리
- Gradle Kotlin Script(gradle.kts)
- Language: Kotlin
- Architecture: [Android App Architecture](https://developer.android.com/topic/architecture)
- JNI: API 주소 숨기기 위함
- 주요 라이브러리
  + Androidx KTX(Kotlin Extensions)
  + Material Design 3: Light/Dark Mode with Material Design System
  + Androidx Lifecycle
    - ViewModel
    - LifecycleObserver
  + Androidx Startup :tada:
  + Androidx Room
  + Androidx Paging3
  + Glide
  + Gson
  + OkHttp
    - Logging Interceptor
    - Retrofit
  + Timber

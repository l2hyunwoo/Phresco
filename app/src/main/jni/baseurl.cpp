//
// Created by Hyun Woo Lee on 2022/01/09.
//

#include <string>
#include <jni.h>

#define PICSUM_BASE_URL "https://picsum.photos/"

extern "C"
JNIEXPORT jstring JNICALL
Java_com_l2hyunwoo_phorest_config_di_BaseUrlStoreImpl_getBaseUrl(
        JNIEnv *env,
        jobject thiz
) {
    return env->NewStringUTF(PICSUM_BASE_URL);
}
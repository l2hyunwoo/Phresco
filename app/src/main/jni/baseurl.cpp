//
// Created by Hyun Woo Lee on 2022/01/09.
//

#include "baseurl.h"
#include <string>

#define PICSUM_BASE_URL "https://picsum.photos/"

extern "C"
JNIEXPORT jstring JNICALL
Java_com_l2hyunwoo_phorest_config_di_BaseUrlStoreImpl_getBaseUrl(
        JNIEnv *jEnv,
        jobject thiz
) {
    return jEnv->NewStringUTF(PICSUM_BASE_URL);
}

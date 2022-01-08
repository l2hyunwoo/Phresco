//
// Created by Hyun Woo Lee on 2022/01/09.
//

#include <jni.h>
#include "android/log.h"

#ifndef PHOREST_BASEURL_H
#define PHOREST_BASEURL_H

extern "C"
JNIEXPORT jstring JNICALL
Java_com_l2hyunwoo_phorest_config_di_BaseUrlStoreImpl_getBaseUrl(
        JNIEnv *jEnv,
        jobject thiz
);

#endif //PHOREST_BASEURL_H

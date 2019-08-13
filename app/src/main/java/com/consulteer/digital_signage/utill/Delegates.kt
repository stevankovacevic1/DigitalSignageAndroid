package com.consulteer.digital_signage.utill

import kotlinx.coroutines.*

fun <T> lazyDeferred(block: suspend CoroutineScope.() -> T): Lazy<Deferred<T>> {

    return lazy {
        GlobalScope.async(start = CoroutineStart.LAZY) { block.invoke(this) } }
}//// T is generic scope for function
package com.kvadgroup.collectionandmap.listeners

import com.kvadgroup.collectionandmap.data.CollectionOperation

interface ProgressListener {
    fun postResult(operation: CollectionOperation)
}
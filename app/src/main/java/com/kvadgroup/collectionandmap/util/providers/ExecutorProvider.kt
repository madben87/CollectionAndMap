package com.kvadgroup.collectionandmap.util.providers

object ExecutorProvider {

    fun getNumberOfCores(): Int {
        return Runtime.getRuntime().availableProcessors()
    }
}
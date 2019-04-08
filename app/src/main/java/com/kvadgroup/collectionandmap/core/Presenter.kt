package com.kvadgroup.collectionandmap.core

interface Presenter<V: MVPView> {
    fun attachView(v: V)
    fun detachView()
}
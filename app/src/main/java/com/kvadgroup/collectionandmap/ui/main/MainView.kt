package com.kvadgroup.collectionandmap.ui.main

import android.support.v4.app.Fragment
import com.kvadgroup.collectionandmap.core.MVPView

interface MainView : MVPView {
    fun getCurrentPage(): Fragment
}
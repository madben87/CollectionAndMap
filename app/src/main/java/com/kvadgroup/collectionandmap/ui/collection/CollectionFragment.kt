package com.kvadgroup.collectionandmap.ui.collection

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.kvadgroup.collectionandmap.R
import com.kvadgroup.collectionandmap.data.CollectionOperation
import com.kvadgroup.collectionandmap.data.CollectionOperationType
import com.kvadgroup.collectionandmap.ui.components.TabCell
import kotlinx.android.synthetic.main.fragment_collection.*
import java.util.*
import java.util.concurrent.CopyOnWriteArrayList

class CollectionFragment : Fragment(), CollectionView {

    private val presenter = CollectionPresenterImpl
    private var alMap: Map<CollectionOperationType, TabCell>? = null
    private var llMap: Map<CollectionOperationType, TabCell>? = null
    private var cwlMap: Map<CollectionOperationType, TabCell>? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view: View = inflater.inflate(R.layout.fragment_collection, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        alMap = mapOf(CollectionOperationType.ADD_IN_BEGIN to alAddBegin,
            CollectionOperationType.ADD_IN_MIDDLE to alAddMiddle,
            CollectionOperationType.ADD_IN_END to alAddEnd,
            CollectionOperationType.SEARCH_BY_VALUE to alSearchValue,
            CollectionOperationType.REMOVE_IN_BEGIN to alRemoveBegin,
            CollectionOperationType.REMOVE_IN_MIDDLE to alRemoveMiddle,
            CollectionOperationType.REMOVE_IN_END to alRemoveEnd)
        llMap = mapOf(CollectionOperationType.ADD_IN_BEGIN to llAddBegin,
            CollectionOperationType.ADD_IN_MIDDLE to llAddMiddle,
            CollectionOperationType.ADD_IN_END to llAddEnd,
            CollectionOperationType.SEARCH_BY_VALUE to llSearchValue,
            CollectionOperationType.REMOVE_IN_BEGIN to llRemoveBegin,
            CollectionOperationType.REMOVE_IN_MIDDLE to llRemoveMiddle,
            CollectionOperationType.REMOVE_IN_END to llRemoveEnd)
        cwlMap = mapOf(CollectionOperationType.ADD_IN_BEGIN to cwlAddBegin,
            CollectionOperationType.ADD_IN_MIDDLE to cwlAddMiddle,
            CollectionOperationType.ADD_IN_END to cwlAddEnd,
            CollectionOperationType.SEARCH_BY_VALUE to cwlSearchValue,
            CollectionOperationType.REMOVE_IN_BEGIN to cwlRemoveBegin,
            CollectionOperationType.REMOVE_IN_MIDDLE to cwlRemoveMiddle,
            CollectionOperationType.REMOVE_IN_END to cwlRemoveEnd)
    }

    override fun calculate(size: Int) {
        showProgress()
        presenter.calculate(size)
    }

    override fun drawResult(operation: CollectionOperation) {

        if (operation.list is ArrayList) {
            alMap?.get(operation.type)?.hideProgress()
            alMap?.get(operation.type)?.setText(operation.time.toString())
        } else if (operation.list is LinkedList) {
            llMap?.get(operation.type)?.hideProgress()
            llMap?.get(operation.type)?.setText(operation.time.toString())
        } else if (operation.list is CopyOnWriteArrayList) {
            cwlMap?.get(operation.type)?.hideProgress()
            cwlMap?.get(operation.type)?.setText(operation.time.toString())
        }
    }

    private fun showProgress() {
        alMap?.forEach{
            (it.value.showProgress())
        }
        llMap?.forEach{
            (it.value.showProgress())
        }
        cwlMap?.forEach{
            (it.value.showProgress())
        }
    }

    override fun onResume() {
        super.onResume()
        presenter.attachView(this)
    }

    override fun onPause() {
        super.onPause()
        presenter.detachView()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        alMap = null
        llMap = null
        cwlMap = null
    }

    override fun showMessage(msg: String) {
        Toast.makeText(this.context, msg, Toast.LENGTH_SHORT).show()
    }
}

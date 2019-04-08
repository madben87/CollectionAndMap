package com.kvadgroup.collectionandmap.data

import android.os.AsyncTask
import com.kvadgroup.collectionandmap.listeners.ProgressListener
import com.kvadgroup.collectionandmap.util.providers.ExecutorProvider
import java.util.*
import java.util.concurrent.CopyOnWriteArrayList
import kotlin.collections.ArrayList

class CalculationManagerImpl() : CalculationManager {

    private var arrayList : ArrayList<Int>? = null
    private var linkedList : LinkedList<Int>? = null
    private var copyWrightList : CopyOnWriteArrayList<Int>? = null

    override fun calculate(size: Int, listener: ProgressListener) {
        arrayList = ArrayList(Collections.nCopies(size, 5))
        linkedList = LinkedList(Collections.nCopies(size, 5))
        copyWrightList = CopyOnWriteArrayList(Collections.nCopies(size, 5))

        val operationsList: MutableList<CollectionOperation> = mutableListOf()

        CollectionOperationType.values().iterator().forEach {
            val operationAL = CollectionOperation()
            operationAL.type = it
            operationAL.list = arrayList
            val operationLL = CollectionOperation()
            operationLL.type = it
            operationLL.list = linkedList
            val operationCWL = CollectionOperation()
            operationCWL.type = it
            operationCWL.list = copyWrightList
            operationsList.add(operationAL)
            operationsList.add(operationLL)
            operationsList.add(operationCWL)
        }

        operationsList.forEach {
            CalculateTask(listener).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, it)
        }
    }

    class CalculateTask(listener: ProgressListener) : AsyncTask<CollectionOperation, Any, CollectionOperation>() {

        private var listener : ProgressListener? = listener

        override fun doInBackground(vararg params: CollectionOperation?): CollectionOperation? {
            val start = System.currentTimeMillis()
            val operation = params[0]
            when (operation?.type) {
                CollectionOperationType.ADD_IN_BEGIN -> {
                    operation.list.add(0, 1)
                    Thread.sleep(1000)
                }
                CollectionOperationType.ADD_IN_MIDDLE -> {
                    operation.list.add(operation.list.size/2, 1)
                    Thread.sleep(1000)
                }
                CollectionOperationType.ADD_IN_END -> {
                    operation.list.add(operation.list.size-1, 1)
                    Thread.sleep(1000)
                }
                CollectionOperationType.SEARCH_BY_VALUE -> {
                    val temp = operation.list.get(operation.list.size/2)
                    Thread.sleep(1000)
                }
                CollectionOperationType.REMOVE_IN_BEGIN -> {
                    operation.list.remove(0)
                    Thread.sleep(1000)
                }
                CollectionOperationType.REMOVE_IN_MIDDLE -> {
                    operation.list.remove(operation.list.size/2)
                    Thread.sleep(1000)
                }
                CollectionOperationType.REMOVE_IN_END -> {
                    operation.list.remove(operation.list.size-1)
                    Thread.sleep(1000)
                }
            }

            val stop = System.currentTimeMillis()

            operation!!.time = stop - start

            return operation
        }

        override fun onPostExecute(result: CollectionOperation?) {
            super.onPostExecute(result)
            if (result != null) {
                listener?.postResult(result)
            }
        }
    }
}
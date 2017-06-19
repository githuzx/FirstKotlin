package com.kotlin.test.origin.test.kotlin

import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import junit.framework.Assert.*

/**
 * Created by Administrator on 2017/6/5.
 */
class KOperator {
    val list = listOf(1, 2, 3, 4, 5, 6)
    val listRepeated = listOf(2, 2, 3, 4, 5, 6)

    /**
     * 总数操作符
     */
    fun zsOperator() {

        //any
        assertTrue(list.any { it % 2 == 0 })
        assertFalse(list.any { it > 10 })

        //all
        assertTrue(list.all { it < 10 })
        assertFalse(list.all { it % 2 == 0 })

        //count
        assertEquals(3, list.count { it % 2 == 0 })

        //fold
        assertEquals(25, list.fold(4) { total, next -> total + next })

        //foldRight
        assertEquals(25, list.foldRight(4) { total, next -> total + next })

        //forEach
        list.forEach { println(it) }

        //forEachIndexed
        list.forEachIndexed { index, value -> println("position $index contains a $value") }

        //max
        assertEquals(6, list.max())

        //maxBy
        assertEquals(1, list.maxBy { -it })

        //min
        assertEquals(1, list.min())

        //minBy
        assertEquals(6, list.minBy { -it })

        //none
        assertTrue(list.none())

        //reduce
        assertEquals(21, list.reduce { total, next -> total + next })

        //reduceRight
        assertEquals(21, list.reduceRight { total, next -> total + next })

        //sumBy
        assertEquals(3, list.sumBy { it % 2 })
    }

    /**
     * 过滤操作符
     */
    fun glOperator() {

        //drop
        assertEquals(listOf(5, 6), list.drop(4))

        //dropWhile
        assertEquals(listOf(3, 4, 5, 6), list.dropWhile { it < 3 })

        //dropLastWhile
        assertEquals(listOf(1, 2, 3, 4), list.dropLastWhile { it > 4 })

        //filter
        assertEquals(listOf(2, 4, 6), list.filter { it % 2 == 0 })

        //filterNot
        assertEquals(listOf(1, 3, 5), list.filterNot { it % 2 == 0 })

        //filterNotNull
        assertEquals(listOf(1, 2, 3, 4), list.filterNotNull())

        //slice
        assertEquals(listOf(2, 4, 5), list.slice(listOf(1, 3, 4)))

        //take
        assertEquals(listOf(1, 2), list.take(2))

        //takeLast
        assertEquals(listOf(5, 6), list.takeLast(2))

        //takeWhile
        assertEquals(listOf(1, 2), list.takeWhile { it < 3 })
    }

    /**
     * 映射操作符
     */
    fun yshOperator() {

        //flatMap
        assertEquals(listOf(1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7), list.flatMap { listOf(it, it + 1) })

        //groupBy
        assertEquals(mapOf("odd" to listOf(1, 3, 5),
                "even" to listOf(2, 4, 6)),
                list.groupBy { if (it % 2 == 0) "even" }
        )

        //map
        assertEquals(listOf(2, 4, 6, 8, 10, 12), list.map { it * 2 })

        //mapIndexed
        assertEquals(listOf(0, 2, 6, 12, 20, 30), list.mapIndexed { index, it -> index * it })

        //mapNotNull
        assertEquals(listOf(2, 4, 6, 8), list.mapNotNull { it * 2 })
    }

    /**
     * 元素操作符
     */
    fun ysuOperator() {

        //contains
        assertTrue(list.contains(2))

        //elementAt
        assertEquals(2, list.elementAt(1))

        //elementAtOrElse
        assertEquals(20, list.elementAtOrElse(10, { 2 * it }))

        //elementAtOrNull
        assertNull(list.elementAtOrNull(10))

        //first
        assertEquals(2, list.first { it % 2 == 0 })

        //firstOrNull
        assertNull(list.firstOrNull { it % 7 == 0 })

        //indexOf
        assertEquals(3, list.indexOf(4))

        //indexOfFirst
        assertEquals(1, list.indexOfFirst { it % 2 == 0 })

        //indexOfLast
        assertEquals(5, list.indexOfLast { it % 2 == 0 })

        //last
        assertEquals(6, list.last { it % 2 == 0 })

        //lastIndexOf
        //lastOrNull
        assertNull(list.lastOrNull { it % 7 == 0 })

        //single
        assertEquals(5, list.single { it % 5 == 0 })

        //singleOrNull
        assertNull(list.singleOrNull { it % 7 == 0 })
    }

    /**
     * 生产操作符
     */
    fun scOperator() {

        //merge
        //assertEquals(listOf(3, 4, 6, 8, 10, 11), list.merge(listRepeated) { it1, it2 -> it1 + it2 })

        //partition
        assertEquals(Pair(listOf(2, 4, 6), listOf(1, 3, 5)), list.partition { it % 2 == 0 })

        //plus
        assertEquals(listOf(1, 2, 3, 4, 5, 6, 7, 8), list + listOf(7, 8))

        //zip
        assertEquals(listOf(Pair(1, 7), Pair(2, 8)), list.zip(listOf(7, 8)))

        //unzip
        assertEquals(Pair(listOf(5, 6), listOf(7, 8)), listOf(Pair(5, 7), Pair(6, 8)).unzip())
    }

    /**
     * 顺序操作符
     */
    fun sxOperator() {

        //reverse
        val unsortedList = listOf(3, 2, 7, 5)
        assertEquals(listOf(5, 7, 2, 3), unsortedList.reversed())

        //sort
        assertEquals(listOf(2, 3, 5, 7), unsortedList.sorted())

        //sortBy
        assertEquals(listOf(3, 7, 2, 5), unsortedList.sortedBy { it % 3 })

        //sortDescending
        assertEquals(listOf(7, 5, 3, 2), unsortedList.sortedDescending())

        //sortDescendingBy
        assertEquals(listOf(2, 7, 7, 3), unsortedList.sortedByDescending { it % 3 })
    }

    /**
     * 表达式
     */
    fun expression(x: Int, view: View, list: ArrayList<String>) {
        //when
        when (x) {
            1 -> print("x==1")
            2 -> print("x==2")
            else -> {
                print("I'm a block")
                print("x is neither 1 nor 2")
            }
        }
        val result = when (x) {
            0, 1 -> "binary"
            else -> "error"
        }
        when (view) {
            is TextView -> print("I'm a TextView")
            is EditText -> print("EditText value:${view.text}")
            is ViewGroup -> print("Number of children :${view.childCount}")
            else -> view.visibility = View.GONE
        }
        val cost = when (x) {
            in 1..10 -> "cheap"
            in 10..100 -> "regular"
            in 100..1000 -> "expensive"
            else -> "not rated"
        }
        val res = when {
            x in 1..10 -> "cheap"
            view is ViewGroup -> print("child count:${view.childCount}")
            else -> ""
        }

        //for
        for (s in list) {
            print(s)
        }
        for (index in 0..list.size - 1) {
            print("s=" + list[index])
        }

        //ranges 默认会自增
        if (x in 0..10)
            print(x)
        var i: Int
        for (i in 0..10)
            print(i)
        for (i in 10 downTo 0)
            print(i)
        for (i in 0 until 4)
            println(i) //类似数学中的开区间 0..3
    }
}
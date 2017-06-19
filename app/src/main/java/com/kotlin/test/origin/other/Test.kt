package com.kotlin.test.origin.other

/**
 * Created by Administrator on 2017/6/19.
 */
class Test {
    val t1 = TypedClass("Hello World!")
    val t2 = TypedClass(25)

    //inner class
    val demo = Outer().Inner().foo() //==1

    //enum
    val searchIconRes = EIcon.SEARCH.res
    val search: EIcon = EIcon.valueOf("SEARCH")
    val iconList: Array<EIcon> = EIcon.values()
    val searchName: String = EIcon.SEARCH.name
    val searchPosition: Int = EIcon.SEARCH.ordinal
}
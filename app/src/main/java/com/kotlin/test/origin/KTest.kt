package com.kotlin.test.origin

import android.content.Context
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import java.util.*
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Created by Administrator on 2017/6/2.
 */
class KTest {
    val i = 7 //自动类型推导
    val str: String = "hello" //显式指明类型
    var name: String? = null //val length=name?.length

    class CustomView(context: Context?, attrs: AttributeSet?) : View(context, attrs)
    class CustomView0(name: String, context: Context?, attrs: AttributeSet?) : View(context, attrs)
    class CustomView1(context: Context?, attrs: AttributeSet?) : TextView(context, attrs) {
        constructor(name: String, context: Context?, attrs: AttributeSet?) : this(context, attrs) {
            text = name
        }
    }
    //val view=CustomView(context,attrs)

    fun ImageView.setImageUrlAsync(url: String?, isRound: Boolean = false) {

    }
    //iv.setImageUrlAsync(url)

    //adapter?.datas?.firstOrNull({it.id==notice.id})?.let{
    //it.status=notice.status
    //adapter?notifyDataSetChanged() //安全操作符
    //}

    object Const {
        val MSG_1 = 1
        fun getCurrentDate(): Date {
            return Date()
        }
    }

    class MyCache {
        companion object {
            val TYPE = 1 //常量
            val instance = MyCache() //单例
        }
    }
    //MyCache.TYPE
    //MyCache.instance

    //内联函数
    inline fun getClassName(): String {
        return T::class.java.name
    }

    val name0 = getClassName()

    object MyExecutor {
        val instance: ExecutorService = Executors.newCachedThreadPool()
    }
    //override fun onCreate(savedInstanceState: Bundle?){
    //super.onCreate(savedInstanceState)
    //setContentView(R.layout.main)
    //doSync{
    //Code:Request network
    //}
    //}

    /**
     * kotlin == -> java equal
     * kotlin ==== -> java ==
     */
    //val a=if(result) "true" else "false"
    //val b=a?:"true"

    //标准委托
    //lazy observable vetoable not_null map


}

private class NotNullSingleValueVar<T>() : ReadWriteProperty<Any?, T> {
    private var value: T? = null

    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return value ?: throw IllegalStateException(/*"${desc.name} " +*/
                "not initialized")
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        this.value = if (this.value == null) value else throw IllegalStateException(/*"${desc.name}+*/" already initialized")
    }
}

//object DelegatesExt {
//    fun notNullSingleValue<T>():
//            ReadWriteProperty<Any?, T> = NotNullSingleValueVar()
//}


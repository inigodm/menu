import java.io.InputStream
import java.io.PrintStream
import java.util.*
import kotlin.properties.Delegates

class Writer (var out: PrintStream = System.out, var input: InputStream = System.`in`){
    var inp: Scanner by Delegates.notNull()

    init{
        inp = Scanner(input)
    }

    fun write(s: String) = out.println(s)

    fun write(s: Array<String>) = s.forEachIndexed { i, it -> write("${i}-$it") }

    fun writeItem(arr: Array<String>, i: Int) = write(arr[i])

    fun waitAndWriteElement(arr: Array<String>) = writeItem(arr, readNext())

    fun readNext(): Int  = inp.next().toInt()
}
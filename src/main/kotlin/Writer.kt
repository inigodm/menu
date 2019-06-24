import java.io.PrintStream
import java.util.function.Consumer

class Writer (var out: PrintStream = System.out){

    fun write(s: String){
        out.println(s)
    }

    fun write(s: Array<String>) {
        s.forEachIndexed { i, it -> out.println("${i + 1}-$it") }
    }
}
import java.io.PrintStream
import java.util.function.Consumer

class Writer (var out: PrintStream = System.out){

    fun write(s: String){
        out.println(s)
    }
}
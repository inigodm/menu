import org.junit.Assert.*
import org.junit.Test
import java.io.PrintStream
import org.mockito.Mockito.*

class steps{
    var out: PrintStream = spy(System.out)

    @Test
    fun write_something_in_io(){
        var w = Writer(out)
        w.write("text")
        verify(out, only()).println("text")
    }
}
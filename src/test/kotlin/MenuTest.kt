import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers
import java.io.PrintStream
import org.mockito.Mockito.*

class steps{
    lateinit var out: PrintStream
    @Before
    fun setup(){
        out = spy(System.out)
    }

    @Test
    fun write_something_in_io(){
        var w = Writer(out)
        println(out)
        w.write("text")
        verify(out, only()).println("text")
    }

    @Test
    fun write_a_list_of_things(){
        var w = Writer(out)
        println(out)
        w.write(arrayOf("text1", "text2"))
        verify(out, times(2)).println(ArgumentMatchers.anyString())
    }
}
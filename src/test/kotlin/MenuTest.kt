import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers
import org.mockito.Mockito.*
import java.io.*
import java.util.*

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

    @Test
    fun write_a_numerated_list_of_things(){
        var w = Writer(out)
        println(out)
        w.write(arrayOf("text1", "text2"))
        verify(out, atLeast(1)).println("0-text1")
        verify(out, atMost(1)).println("0-text1")
        verify(out, atLeast(1)).println("1-text2")
        verify(out, atMost(1)).println("1-text2")
    }

    @Test
    fun write_element(){
        var w = Writer(out)
        w.writeItem(arrayOf("elem1", "elem2"), 1)
        verify(out, atLeast(1)).println("elem2")
    }

    @Test
    fun readed_number(){
        var inString = StringBufferInputStream("1")
        var w = Writer(out, inString)
        assertEquals(1, w.readNext())
    }

    @Test
    fun write_readed_element(){
        var inString = StringBufferInputStream("1${System.lineSeparator()}0")
        var w = Writer(out = out, input = inString)
        w.waitAndWriteElement(arrayOf("elem11", "elem22"))
        w.waitAndWriteElement(arrayOf("elem11", "elem22"))
        verify(out, atLeast(1)).println("elem22")
        verify(out, atLeast(1)).println("elem11")
    }
}
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class FooBarQixTest {

    // Test pour vérifier la fonction compute
    @Test
    public void testCompute() {
        // Tests simples Step 1
        assertEquals("1", FooBarQix.compute("1"));
        assertEquals("2", FooBarQix.compute("2"));
        assertEquals("FooFoo", FooBarQix.compute("3")); // divisible par 3 et contient 3
        assertEquals("4", FooBarQix.compute("4"));
        assertEquals("BarBar", FooBarQix.compute("5")); // divisible par 5 et contient 5
        assertEquals("Foo", FooBarQix.compute("6")); // divisible par 3
        assertEquals("QixQix", FooBarQix.compute("7")); // divisible par 7 et contient 7
        assertEquals("8", FooBarQix.compute("8"));
        assertEquals("Foo", FooBarQix.compute("9")); // divisible par 3
        assertEquals("Bar", FooBarQix.compute("10")); // divisible par 5, contient 0
        assertEquals("Foo", FooBarQix.compute("13")); // contient 3
        assertEquals("FooBarBar", FooBarQix.compute("15")); // divisible par 3 et 5, contient 5
        assertEquals("FooQix", FooBarQix.compute("21")); // divisible par 3 et 7
        assertEquals("FooFooFoo", FooBarQix.compute("33")); // divisible par 3, contient deux 3
        assertEquals("FooBar", FooBarQix.compute("51")); // divisible par 3, contient 5
        assertEquals("BarFoo", FooBarQix.compute("53")); // contient 5 et 3

        // Tests Step 2 (avec les zéros remplacés par des '*')
        assertEquals("1*1", FooBarQix.compute("101")); // 0 -> *
        assertEquals("FooFoo*Foo", FooBarQix.compute("303")); // contient 3 et un 0 remplacé par *
        assertEquals("FooBarQix*Bar", FooBarQix.compute("105")); // divisible par 3 et 5, contient 0
        assertEquals("FooQix**", FooBarQix.compute("10101")); // deux 0 remplacés par *
    }
}

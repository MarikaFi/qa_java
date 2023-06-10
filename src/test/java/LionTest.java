
import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    Feline newFeline = new Feline();
    Lion lionMale = new Lion("Самец", newFeline);
    Lion lionFemale = new Lion("Самка", newFeline);

    public LionTest() throws Exception {
    }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Mock
    Feline feline;

    @Test
    public void getFoodTest() throws Exception {
        Lion lion = new Lion("Самец", feline);
        lion.getFood();
        Mockito.verify(feline).getFood("Хищник");
    }

    @Test
    public void getKittensMaleTest() {
        int actual = lionMale.getKittens();
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void getKittensFemaleTest() {
        int actual = lionFemale.getKittens();
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void testDoesHaveManeException() {
        Exception exception = assertThrows(Exception.class, () -> {
            Lion lion = new Lion("тряу", feline);
            lion.doesHaveMane();
        });
        String expected = "Используйте допустимые значения пола животного - самец или самка";
        String actual = exception.getMessage();
        assertEquals(expected, actual);


    }
}


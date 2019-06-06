package com.example;

import static com.example.App.*;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void createCatsTester() {
        Assert.assertNotNull(createCats());
    }

    @Test
    public void setCatNamesTester() {
        List<Cat> list = createCats();
        setCatNames(list);
        for (int i = 0; i < 98; i++) {
            Assert.assertEquals("cat" + i, list.get(i).getName());
        }
    }
    @Test
    public void setCatBreedsTester() {
        List<Cat> list = createCats();
        setCatBreeds(list);
        List<BreedType> breedTypes= Arrays.asList(BreedType.values());
        for (int i = 0; i < 98; i++) {
            Assert.assertEquals(breedTypes.get(i), list.get(i).getBreed());
        }
    }
    @Test
    public void generateNewBreedTypeListTester(){

    }

}

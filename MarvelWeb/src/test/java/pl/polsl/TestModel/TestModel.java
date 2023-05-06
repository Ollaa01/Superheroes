package pl.polsl.TestModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import pl.polsl.Model.Model;
import pl.polsl.Model.OwnException;
import pl.polsl.Model.Superhero;

/**
 *
 * @author Aleksandra Rusek
 * @version 1.1
 */
public class TestModel {
    /**
     * Map containing some superheroes, using for testing.
     */
    public Map<Integer, Integer> maxFinal;
    /**
     * List containing some superheroes, using for testing.
     */
    public List<Superhero> filteredSuperhero;
    /**
     * ArrayList containing all superheroes, using for testing.
     */
    public ArrayList<Superhero> superheroes;
     /**
     * Fields representing Model of MVC.
     */
    public Model model;
    /**
     * Constructor of class TestModel.
     */
    public TestModel() {
        model = new Model();
    }
    
    /**
     * Setup before all tests.
     * @throws IOException if File to read is not Found.
     */
    @BeforeEach
    public void setUp() throws IOException {
    model.setFilename("Marvel Characters.csv");
    String filename = "Marvel Characters.csv";
    Reader in = new FileReader(filename);
    model.readData(in);
    superheroes = model.getSuperheroes();
    }
    /**
     * Parameterized test testing method "checkString" from model. Should throw an exception if value is empty, null or blank.
     * @param str contating string to test.
     */
    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {" ", ""})
    //@ValueSource(strings = {"a", "b"}) //incorrect value to test
    public void TestOfExceptionwithParameters(String str) {
        OwnException exception = assertThrows(
                OwnException.class,
                () -> model.checkString(str));
        assertEquals("Value can't be empty", exception.getMessage(), "Incorrect message");
    
    }
    /**
     * Parameterized test testing method "readData" from model. Testing if list of superheroes length after using that metod is equal to data in csv file.
     * @param x containing expect number of superheroes.
     */
    @ParameterizedTest
    @ValueSource(ints = {137})
   // @ValueSource(ints = {136, 138, }) //incorrect value to test
    public void TestReadDataSize(int x) {
    int size = superheroes .size();
    assertEquals(size, x, "Incorrect amount");
    }
    /**
     * Parameterized test testing method "readData" from model. Testing if first and last record of list and csv file is the same.
     * @param x containing name of superheroes.
     * @param y contating birth name of superheroes.
     * @param z contating place on list.
     */
    @ParameterizedTest
    @CsvSource({"Silk, 'Cindy Moon', 0", "Iceman, 'Robert Louis Drake', 136"})
    //@CsvSource(value = {"null, 'Cindy Sun', 0", "iceman, 'Robert Louis Drake', 136"}, nullValues = {"null"}) //incorrect value to test
    public void TestReadData(String x, String y, int z) {
    String name = superheroes.get(z).getName();
    String birthname = superheroes.get(z).getBirthname();
    assertEquals(name, x, "Incorrect superheroes");
    assertEquals(birthname, y, "Incorrect superheroes");
    }
    
    /**
     * Parameterized test testing method "sortBySuperpowersNumber" from model. Checking if first superhero on list has 1 superpower and last one has 12 (maximum value).
     * @param x number of superpowers.
     * @param y number on list.
     */
    @ParameterizedTest
    @CsvSource({"1, 0", "12, 136"})
    //@CsvSource({"4,0", "7, 136"}) //incorrect value to test
    public void TestSortBySuperpowersNumber(int x, int y) {
    model.sortBySuperpowersNumber();
    int z = superheroes.get(y).getSuperpowersNumber();
    assertEquals(x, z, "Incorrect superheroes");
    }
    /**
     * Parameterized test testing method "showNameAndUniverse" from model. Checking if method shows data corectly, methos previously sorting superheroes by universes. Checking on fisrt and last objects on the list.
     * @param x contating name of superhero.
     * @param y containing universes of superhero.
     * @param z containing number on the list.
     */
    @ParameterizedTest
    @CsvSource({"Bishop, 'Earth-1191, Marvel Universe', 0", "Shatterstar, 'Mojoverse, Earth-616, Marvel Universe', 136" })
   //@CsvSource(value={"Thunder, 'Mojo Universe', 0", "null, 'Mojoverse, Earth-616, Marvel Universe', 137"}, nullValues={"null"}) //incorrect value to test
    public void TestShowNameAndUniverse(String x, String y, int z) {
    model.showNameAndUniverses();
    String a = superheroes.get(z).getName();
    String b = superheroes.get(z).getUniverse();
    assertEquals(x, a, "Incorrect superheroes");
    assertEquals(y, b, "Incorrect superheroes");
    }
    /**
     * Parameterized test testing method "readData" from model. Checking if superpowers number is not null. Passing NullSource to check.
     * @param superpowers containing superpowers.
     */
    @ParameterizedTest
    @NullSource
    public void TestIfValuePowersNullx(String superpowers) {
        for (Superhero s: superheroes ) {
        superpowers = s.getSuperpowers();
        assertNotNull(superpowers, "Null value");
    }
    }
    /**
     * Parameterized test testing method "searchSuperheroByType" from model.
     * @param x contains name
     * @param y contains number at list
     */
     @ParameterizedTest
     @CsvSource({"Jubilee, 0", "Sauron, 1"})
     //@CsvSource(value={"Jubille, 0", "null, 1"}, nullValues={"null"}) //incorrect value to test
     public void TestSearch(String x, int y) {
     model.searchSuperheroByType("vampire in Marvel Universe");
     filteredSuperhero = model.getFilteredSuperhero();
     String name = filteredSuperhero.get(y).getName();
     assertEquals(name, x, "Incorrect superheroes");
     }
     
     /**
      * Parameterized test testing method "theMostSuperpowers" from model.
      * Checking if returning superheroes have the maximum value of superpowers(12) among superheroes.
      * @param x containing number of superpowers.
      */
     @ParameterizedTest
     @ValueSource(ints = {12})    
     //@ValueSource(ints = {11, 13})  //incorrect value to test
     public void testTheMostSh(int x) {
     model.theMostSuperpowers();
     maxFinal = model.getMaxFinal();
     for (Map.Entry<Integer, Integer> entry : maxFinal.entrySet()) {
        assertEquals(superheroes.get(entry.getKey()).getSuperpowersNumber(), x, "Incorrect superheroes");
     }
     }
     /**
      * Parameterized test testing method "searchSuperheroByUni" from model. Checking if returning list of superheroes contains given universes. 
      * @param x containing universes (variable number of parameters).
      */
     @ParameterizedTest
     @CsvSource(value = {"'Earth-811', 'Mojoverse'", "Mojoverse", "Earth-616"}, nullValues={"null"}) 
     public void TestSearch(String x) {
     model.searchSuperheroByUni(x);
     filteredSuperhero = model.getFilteredSuperhero();
     String name = filteredSuperhero.get(0).getUniverse();
     assertTrue(name.contains(x), "Incorrect superheroes");
     }
     
}

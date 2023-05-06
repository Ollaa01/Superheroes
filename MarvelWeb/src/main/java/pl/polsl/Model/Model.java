/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.Model;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

/**
 * Main class od model package
 * @version 3.0
 * @author Aleksandra Rusek
 */

public class Model {
    ArrayList<Superhero> temp;
   /**
    * String representing filename of data.
    */
   private String filename;
   /**
    * ArrayList of Superhero class objects.
    */
   private final ArrayList<Superhero> superheroes; 
     /**
    * List of filtered superhero.
    */
   private List<Superhero> filteredSuperhero;
   /**
    * Map of some superheroes paramterers (number on list and superpowers number).
    */
   private Map<Integer, Integer> maxsFinal = new HashMap<>();
   /**
    * Constructor od Model class.
    */
    public Model(){
    this.superheroes = new ArrayList<>();
    this.temp = new ArrayList<>();
    }
    /**
     * Getter list of Superhero class objects.
     * @return list of superheroes.
     */
    public ArrayList<Superhero> getSuperheroes() {
    return this.superheroes;
    }
    /**
     * Getter of temporary list of superheroes.
     * @return list of superheroes.
     */
    public ArrayList<Superhero> getTemp() {
    return this.temp;
    }
    /**
     *  Getter of filename.
     * @return filename.
     */
    public String getFilename() {
    return filename;
    }
    /**
     * Setting filename.
     * @param filename representing filename.
     */
    public void setFilename(String filename) {
    this.filename = filename;
    }    
    /**
     * Making list of superheroes by reading data from file and adding them to list.
     * @throws IOException Throws an exception if file is not correct.
     * @param in contating reader.
     */
    public void readData(Reader in) throws IOException {  
    superheroes.clear();
    Iterable<CSVRecord> records = CSVFormat.DEFAULT.withHeader("char","charname","birthname","types","universes","birthplace","superpowers","religions","gender","occupation","memberof").withFirstRecordAsHeader().parse(in);
    for (CSVRecord record : records) {
    String link = record.get("char");
    String name = record.get("charname");
    String birthname = record.get("birthname");
    String types = record.get("types");
    String universes = record.get("universes");
    String birthplace = record.get("birthplace");
    String superpowers = record.get("superpowers");
    String religions = record.get("religions");
    String gender = record.get("gender");
    String occupation = record.get("occupation");
    String memberof = record.get("memberof");
    
    try {
    checkString(superpowers);
    } catch (OwnException e) {
    System.out.println(e); }
        
    String temp = superpowers;
    int chCount = 1;
    for(int a = 0; a < temp.length(); a++) {
        if(temp.charAt(a) == ','){
            chCount ++;
        }
    }
    
    Superhero Hero = new Superhero(link, name, birthname, types, universes, birthplace, superpowers, religions, gender, occupation, memberof, chCount);
    superheroes.add(Hero);
   }
    
  }
    /**
     * Sorting superheroes by SuperpowersNumber.
     */
    public void sortBySuperpowersNumber() {
       superheroes.sort(Comparator.comparing(Superhero::getSuperpowersNumber));
    }
    /**
     * Showing superhero(es) with the most superpowers.
     */
    public void theMostSuperpowers() {
    Map<Integer, Integer> Maxs = new HashMap<>();
    for (int i = 0; i < superheroes.size(); i++) {
    Maxs.put(i, superheroes.get(i).getSuperpowersNumber());
    }
    int maxValueInMap=(Collections.max(Maxs.values()));
    for (Entry<Integer, Integer> entry : Maxs.entrySet()) {  
            if (entry.getValue() == maxValueInMap) {
               maxsFinal.put(entry.getKey(), entry.getValue());
            }
    }
    for (Entry<Integer, Integer> entry : maxsFinal.entrySet()) {
        temp.add(superheroes.get(entry.getKey()));
    }
}
    /**
     * Showing superheores names and universes they belong to, previously sorting by universes for a better reading.
     */
    public void showNameAndUniverses() {
    superheroes.sort(Comparator.comparing(Superhero::getUniverse));
    }
    /**
     * Checking if String is null, empty or blank. Method using in model and controller clases.
     * @param str containg string to be checked.
     * @throws OwnException Throwns an exepction if string is null, empty or blank.
     */
    public void checkString (String str) throws OwnException {
    while (str == null || str.isEmpty() || str.isBlank()) {
        throw new OwnException("Value can't be empty");
    }
    }
    /**
     * Searching for superherhero by universe. Method uses variable numbers of parameters and stream.
     * @param str containing string to be checked
     */
    public void searchSuperheroByUni (String ...str) {
            List<Superhero> newList = new ArrayList<>();
            for (int j = 0; j < superheroes.size(); j++) {
                for (String str1 : str) {
                    if (superheroes.get(j).getUniverse().contains(str1)) {
                        newList.add(superheroes.get(j));
                    }
                }
            }
             filteredSuperhero =
                     newList.stream()
                     .distinct()
                     .collect(Collectors.toList());
    }
    /**
     * Searching superhero by type, additional function.
     * @param str containing string containing name to be checked
     */
   public void searchSuperheroByType (String str) {
        filteredSuperhero =
            superheroes.stream() 
            .filter(s -> s.getTypes().contains(str))
            .collect(Collectors.toList());
    }
    
    /**
     * Getter of list of filtered superheroes.
     * @return list of filtered superheroes.
     */
    public List<Superhero> getFilteredSuperhero() {
    return this.filteredSuperhero;
    }
    /**
     * Getter of map of some superheores (Key = number on list, Value = superpowers number);
     * @return map of some superheroes.
     */
    public Map<Integer, Integer> getMaxFinal() {
    return this.maxsFinal;
    }   
}

    
    


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.Model;

/**
 * Module package class representing single superhero.
 * @version 1.1
 * @author Aleksandra Rusek
 */

public class Superhero {
    /**
     * String representing link to wikipedia of superhero.
     */
    private String link;
    /**
     * String representing name of superhero.
     */
    private String name;
    /**
     * String representing birth name of superhero.
     */
    private String birthname;
    /**
     * String representing types of superhero.
     */
    private String types;
    /**
     * String representing universes of superhero.
     */
    private String universe;
    /**
     * String representing birth place of superhero.
     */
    private String birthplace;
    /**
     * String representing superpowers of superhero.
     */
    private String superpowers;
    /**
     * String representing religions of superhero.
     */
    private String religions;
    /**
     * String representing gender of superhero.
     */
    private String gender;
    /**
     * String representing occupation of superhero.
     */
    private String occupation;
    /**
     * String representing member of superhero.
     */
    private String memberof;
    /**
     * String representing superpowers number of superhero.
     */
    private int superpowersNumber;
    /**
     * Constructor of Superhero class object.
     * @param link representing link.
     * @param name representing name.
     * @param birthname representing birth name.
     * @param types representing types.
     * @param universe representing universes.
     * @param birthplace representing birth place.
     * @param superpowers representing superpowers.
     * @param religions representing religions.
     * @param gender representing gender.
     * @param occupation representing occupation.
     * @param memberof representing mamberof.
     * @param superpowersNumber representing superpowers number.
     */       
    public Superhero(String link, String name, String birthname, String types, String universe, String birthplace, String superpowers, String religions, String gender, String occupation, String memberof, int superpowersNumber) {
    this.link=link;
    this.name=name;
    this.birthname=birthname;
    this.types=types;
    this.universe=universe;
    this.birthplace=birthplace;
    this.superpowers=superpowers;
    this.religions=religions;
    this.gender=gender;
    this.occupation=occupation;
    this.memberof=memberof;
    this.superpowersNumber=superpowersNumber;
    }
    /**
     * Getter returning link.
     * @return String containing link.
     */
    public String getLink() {
    return link;
    }
    /**
     * Setting link.
     * @param link representing link.
     */
    public void setLink(String link) {
    this.link = link;
    }
    /**
     * Getter returning name.
     * @return String containing name.
     */
    public String getName() {
    return name;
    }
    /**
     * Setting name.
     * @param name representing name.
     */
    public void setName(String name) {
    this.name = name;
    }
    /**
     * Getter returning birth name.
     * @return String containing birth name.
     */
    public String getBirthname() {
    return birthname;
    }
    /**
     * Setting birth name.
     * @param birthname representing Birth name.
     */
    public void setBirthname(String birthname) {
    this.birthname = birthname;
    }
    /**
     * Getter returning types.
     * @return String containing types.
     */
    public String getTypes() {
    return types;
    }
    /**
     * Setting types.
     * @param types representing types.
     */
    public void setTypes(String types) {
    this.types = types;
    }
    /**
     * Getter returning universes.
     * @return STring containing universes
     */
    public String getUniverse() {
    return universe;
    }
    /**
     * Settinh universes.
     * @param universe representing universe.
     */
    public void setUniverse(String universe) {
    this.universe = universe;
    }
    /**
     * Getter returning birth place.
     * @return String containg birth place
     */
    public String getBirthplace() {
    return birthplace;
    }
    /**
     * Setting birthplace.
     * @param birthplace representing birth place.
     */
    public void setBirthplace(String birthplace) {
    this.birthplace = birthplace;
    }
    /**
     * Getter returning superpowers.
     * @return String containing superpowers.
     */
    public String getSuperpowers() {
    return superpowers;
    }
    /**
     * Serring superpowers.
     * @param superpowers representing superpowers. 
     */
    public void setSuperpowers(String superpowers) {
    this.superpowers = superpowers;
    }
    /**
     * Getter returning religions.
     * @return String containing religions.
     */
    public String getReligions() {
    return religions;
    }
    /**
     * Setting religions.
     * @param religions representing religions.
     */
    public void setReligions(String religions) {
    this.religions = religions;
    }
    /**
     * Getter returning gender.
     * @return String containing gender.
     */
    public String getGender() {
    return gender;
    }
    /**
     * Setting gender.
     * @param gender representing gender.
     */
    public void setGender(String gender) {
    this.gender = gender;
    }
    /**
     * Getter returning occupation.
     * @return String containing occupation.
     */
    public String getOccupation() {
    return occupation;
    }
    /**
     * Setting occupation.
     * @param occupation representing occupation.
     */
    public void setOccupation(String occupation) {
    this.occupation = occupation;
    }
    /**
     * Getter returning memberof.
     * @return String containing member of.
     */
    public String getMemberof() {
    return memberof;
    }
    /**
     * Setting member of.
     * @param memberof representing member of.
     */
    public void setMemberof(String memberof) {
    this.memberof = memberof;
    }
    /**
     * Getter returning superpowers number.
     * @return Int containg superpowers number.
     */
    public int getSuperpowersNumber() {
    return superpowersNumber;
    }
    /**
     * Setting superpowers number.
     * @param superpowersNumber representing superpowers number.
     */
    public void setSuperpowersNumber(int superpowersNumber) {
    this.superpowersNumber = superpowersNumber;
    }
    /**
     * Return information information about superhero.
     * @return String containing link, name, birth name, types, universes, birth place, superpowers, religions, gender, occupation, member of.
     */
    public String toString(){
        return link + " " + name + " " + birthname + " " + types + " " + universe + " " + birthplace + " " + superpowers + " " + religions + " " + gender + " " + occupation + " " + memberof;
    }
   
}

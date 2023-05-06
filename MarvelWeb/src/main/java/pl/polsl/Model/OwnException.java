/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.Model;

/**
 * Class with own exception.
 * @version 1.1
 * @author Aleksandra Rusek
 */
public class OwnException extends Exception {
    /**
     * Constructor of OwnEsception
     * @param errorMessage Message thrown with exception.
     */
    public OwnException(String errorMessage) {
        super(errorMessage);
    }
}

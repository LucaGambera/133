/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ch.gambera.javagateway.beans;

/**
 *
 * @author gamberal01
 */
public class Response {

    public Response() {
    }

    public boolean isResult() {
        return result;
    }

    public void setCode(boolean result) {
        this.result = result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private boolean result;
    private String name;
}

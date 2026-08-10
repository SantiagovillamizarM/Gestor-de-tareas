//Indica la ubicacion delarchivo dentro del proyecto 
package com.gestor.dominio.excepciones;

//Una clase publica para la excepcion llamada "TareaNoEncontradaException" la cual es de tipo RuntimeException
//Las RuntimeException son del tipo de excepciones No Comprobadas la cual hace mas facil su manejo ya que no se necesita un try catch
// extends es una palabra clave de Java que se utiliza para implementar el concepto de Herencia en la Programación Orientada a Objetos
// es para que Java reconozca tu clase como una excepción que se puede lanzar
public class TareaNoEncontradaException extends RuntimeException {
    //Esto es un constructor y por eso en vez de void lleva el "TareaNoEncontradaException" (ES UNA REGLA)
    //El entre parentesis dice que va a devolver un "message" del tipo String
    public TareaNoEncontradaException (String message){
    //En esta parte dice "invoca al constructor de mi clase padre (RuntimeException) y entrégale este texto que me acaban de pasar en message"
    //Lo que hace el super es utilizar la clase padre y interactua con ella y entrega el mensaje
    super(message);
    }
}

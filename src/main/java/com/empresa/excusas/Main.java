package com.empresa.excusas;

import com.empresa.excusas.model.clases.EmpleadoExcusador;
import com.empresa.excusas.model.clasesAbstractas.Empleado;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        EmpleadoExcusador emp = new EmpleadoExcusador("Axel Cichello", "csaxel49@gmail.com", 40143488);




        System.out.println(emp.toString());
    }
}
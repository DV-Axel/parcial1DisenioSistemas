package com.empresa.excusas.clases;

import com.empresa.excusas.interfaces.IAdministradorProntuarios;
import com.empresa.excusas.interfaces.ObserverProntuario;

import java.util.ArrayList;
import java.util.List;

public class AdministradorProntuarios implements IAdministradorProntuarios {

    private static AdministradorProntuarios instancia;
    private List<Prontuario> prontuarios;
    private List<ObserverProntuario> observers;

    private AdministradorProntuarios() {
        prontuarios = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public static synchronized AdministradorProntuarios getInstancia() {
        if (instancia == null) {
            instancia = new AdministradorProntuarios();
        }
        return instancia;
    }

    @Override
    public void agregarProntuario(Prontuario prontuario) {
        prontuarios.add(prontuario);
        notificarObservers(prontuario);
    }

    @Override
    public void agregarObserver(ObserverProntuario observer) {
        observers.add(observer);
    }

    @Override
    public void removerObserver(ObserverProntuario observer) {
        observers.remove(observer);
    }

    @Override
    public void notificarObservers(Prontuario prontuario) {
        for (ObserverProntuario o : observers) {
            o.actualizar(prontuario);
        }
    }

    public List<Prontuario> getProntuarios() {
        return new ArrayList<>(prontuarios);
    }
}

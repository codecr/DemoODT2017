/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flecharoja.demohalloween.view;

import com.flecharoja.demohalloween.model.Clientes;
import com.flecharoja.demohalloween.service.ClientesService;
import java.io.Serializable;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Codecr
 */
@Named
@ViewScoped
public class ClientesView implements Serializable {

    @Inject
    ClientesService service;

    private Long id;

    private Clientes currentClient;

    private List<Clientes> lista = null;

    public List<Clientes> getAll() {

        if (lista == null) {
            lista = service.getAll();
        }
        return lista;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the currentClient
     */
    public Clientes getCurrentClient() {
        return currentClient;
    }

    /**
     * @param currentClient the currentClient to set
     */
    public void setCurrentClient(Clientes currentClient) {
        this.currentClient = currentClient;
    }

    public String editar() {
        service.edit(currentClient);

        return "clientes";
    }

    public void load() {
        currentClient = service.find(id);
    }
}
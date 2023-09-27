package com.cesi.process;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import java.util.List;

import static jakarta.transaction.Transactional.TxType.REQUIRED;
import static jakarta.transaction.Transactional.TxType.SUPPORTS;

@ApplicationScoped
@Transactional(REQUIRED)
public class ProcessService {

    @Transactional(SUPPORTS)
    public List<Process> findAllProcesses() {
        return Process.listAll();
    }

    @Transactional(SUPPORTS)
    public Process findProcessById(Long id) {
        return Process.findById(id);
    }

    public Process createProcess(@Valid Process process) {
        process.persist();
        return process;
    }

    public Process updateProcess(@Valid Process process) {
        Process entity = Process.findById(process.id);
        entity.nom = process.nom;
        entity.description = process.description;
        entity.product = process.product;
        entity.commentaire = process.commentaire;
        return entity;
    }

    public void deleteProcess(Long id) {
        Process process = Process.findById(id);
        process.delete();
    }
}

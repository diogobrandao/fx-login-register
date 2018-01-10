package org.academiadecodigo.bootcamp.service;

import org.academiadecodigo.bootcamp.model.Bootcamp;
import org.academiadecodigo.bootcamp.model.CodeCadet;

import java.util.ArrayList;

public interface BootcampService extends Service {

    Bootcamp findById(Integer id);

    void addBootcamp(Bootcamp bootcamp);

    CodeCadet findCadet(CodeCadet codeCadet, int id);

    void addCadet(CodeCadet codeCadet,int id);

    ArrayList<Bootcamp> getAllBootcamps();

    ArrayList<CodeCadet> getAllCadets(Bootcamp bootcamp);


}

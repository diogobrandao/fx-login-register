package org.academiadecodigo.bootcamp.service;

import org.academiadecodigo.bootcamp.model.CodeCadet;
import org.academiadecodigo.bootcamp.model.Bootcamp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MockBootcampService implements BootcampService{
    Map<Integer, Bootcamp> bootcamps;

    public MockBootcampService() {

        bootcamps = new HashMap<>();
    }


    @Override
    public void addBootcamp(Bootcamp bootcamp) {
        if(!bootcamps.containsKey(bootcamp.getId())){
            bootcamps.put(bootcamp.getId(), bootcamp);
        }
    }

    @Override
    public CodeCadet findCadet(CodeCadet codeCadet, int id) {
        Bootcamp bootcamp = bootcamps.get(findById(id));
        CodeCadet[][] arraybootcamp;
        arraybootcamp = (CodeCadet[][]) bootcamp.getCodeCadets().toArray();
        for(int i=0; i < arraybootcamp.length; i++){
            return codeCadet;
        }
        //return codeCadet;
        return null;
    }


    public Map<Integer, Bootcamp> printBootcamps(){
        return bootcamps;
    }

    @Override
    public Bootcamp findById(Integer id) {
        return bootcamps.get(id);
    }  //the # of the bootcamp



    @Override
    public void addCadet(CodeCadet codeCadet, int id) {
        Bootcamp bootcamp = bootcamps.get(id);  //which bootcamp
        bootcamp.addCadet(codeCadet);

        //if(bootcamps.get(findById(id).hashCode()!= codeCadet.hashCode()){  //verify if the user doesn't already exist
            //bootcamps.put(, codeCadet);     //if it doesnt exist, put him in
        }

    public Map<Integer, Bootcamp> getBootcamps() {
        return bootcamps;
    }

    @Override
     public ArrayList<Bootcamp> getAllBootcamps(){
        return new ArrayList<>(bootcamps.values());
     }

    @Override
    public ArrayList<CodeCadet> getAllCadets(Bootcamp bootcamp) {
        return new ArrayList<>(bootcamp.getCodeCadets());
    }


}

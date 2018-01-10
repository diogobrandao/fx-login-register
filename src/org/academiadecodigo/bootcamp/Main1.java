package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.model.Bootcamp;
import org.academiadecodigo.bootcamp.model.CodeCadet;
import org.academiadecodigo.bootcamp.model.Gender;
import org.academiadecodigo.bootcamp.model.User;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Main1 {
    public static void main(String[] args) {
        HashMap<Integer, Bootcamp> bootcamps = new HashMap<Integer, Bootcamp>();



        Bootcamp bootcamp = new Bootcamp(1, "Angra", new Date(30-10-2017), new Date(14-02-2018));
        System.out.println(bootcamp);
        User user = new User("diogo", "diogo@", "diogopass");
        CodeCadet codeCadet = new CodeCadet("Diogo", user, Gender.MALE, "Pombal Street","Angra", "963446895", bootcamp, new Date(8-10-1991));
        bootcamp.addCadet(codeCadet);
        System.out.println(bootcamp);
        System.out.println(codeCadet);
        System.out.println(bootcamp.getCodeCadets().toArray().length);
        User user1 = new User("angelo", "angelo@", "angelopass");
        User user2 = new User("angelo", "aluis@", "aluispass");
        CodeCadet codeCadet1 = new CodeCadet("Soraia",user1, Gender.MALE, "praia street", "praia", "965554343", bootcamp, new Date(10-10-1980));
        CodeCadet codeCadet2 = new CodeCadet("Ferreira", user1, Gender.MALE, "praia street", "praia", "967887877", bootcamp, new Date(10-10-1980));
        bootcamp.addCadet(codeCadet1);
        bootcamp.addCadet(codeCadet2);
        System.out.println("if 2 works, if 3 equal user limitation doesnt work:" + bootcamp.getCodeCadets().toArray().length);
        CodeCadet codeCadet3 = new CodeCadet("Di",user2, Gender.MALE, "praia street", "praia", "922332342", bootcamp, new Date(8-9-1990));
        bootcamp.addCadet(codeCadet3);
        System.out.println("if 3 it added after noticing a previous equal user:" + bootcamp.getCodeCadets().toArray().length);
        System.out.println(user);
        System.out.println(user1);
        Bootcamp bootcamp1 = new Bootcamp(2,"Praia", new Date(15-2-2018), new Date(15-5-2018));
        System.out.println(bootcamp1);
        User user3 = new User("luis", "luis@", "luispass");
        CodeCadet codeCadet4 = new CodeCadet("lu", user3, Gender.MALE, "garoupa street", "Angra", "912335356", bootcamp1, new Date(12-11-1990));
        bootcamp1.addCadet(codeCadet4);
        System.out.println("bootcamp 2 size:" + bootcamp1.getCodeCadets().toArray().length);
        System.out.println(bootcamp.getCodeCadets());
        System.out.println();
        bootcamps.put(1, bootcamp);
        bootcamps.put(2, bootcamp1);
        System.out.println(bootcamps);


    }
}

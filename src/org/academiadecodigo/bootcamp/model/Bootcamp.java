package org.academiadecodigo.bootcamp.model;

import java.util.Date;
import java.util.*;

public class Bootcamp {

    private int id;
    private String location;
    private Date start;
    private Date end;
    private Set<CodeCadet> codeCadets = new HashSet<>();

    public Bootcamp(int id, String location, Date start, Date end){
        this.id = id;
        this.location = location;
        this.start = start;
        this.end = end;
    }




    public int getId() {
        return id;
    }

    public void addCadet(CodeCadet codeCadet){
        codeCadets.add(codeCadet);
    }

    public String getLocation() {
        return location;
    }

    public Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end;
    }

    public Set<CodeCadet> getCodeCadets() {
        return codeCadets;
    }

    public ArrayList<CodeCadet> getCadets(){
        return new ArrayList<>(codeCadets);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bootcamp bootcamp = (Bootcamp) o;

        return id == bootcamp.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "Bootcamp{" +
                "id=" + id +
                ", location='" + location + '\'' +
                ", start=" + start +
                ", end=" + end +
                //", codeCadets=" + codeCadets +
                '}';
    }
}

package com.infosupport.minr.case_01_backend.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Cursist {

  @Id
  @GeneratedValue
  private int id;

  private String firstName;

  private String lastName;

  @ManyToMany(mappedBy = "cursistList", cascade = CascadeType.ALL)
  private List<Cursus> cursusList;

  public Cursist() {
    this.cursusList = new ArrayList<>();
  }

  public Cursist(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.cursusList = new ArrayList<>();
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public List<Cursus> getCursusList() {
    return cursusList;
  }

  public void setCursusList(List<Cursus> cursusList) {
    this.cursusList = cursusList;
  }

  public void addCursus(Cursus cursus) {
    this.cursusList.add(cursus);
  }

  @Override
  public String toString() {
    return "Cursist{" +
        "id=" + id +
        ", firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        '}';
  }
}

package com.infosupport.minr.case_01_backend.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Cursus {

  private static final int CURSUS_CAPACITY = 12;
  @Id
  @GeneratedValue
  private int id;
  private String title;
  private String cursusCode;
  private String duration;
  private String startDate;
  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(
      name = "cursist_cursus",
      joinColumns = {@JoinColumn(name = "CURSIST_ID")},
      inverseJoinColumns = {@JoinColumn(name = "CURSUS_ID")}
  )
  private List<Cursist> cursistList;

  public Cursus() {
    this.cursistList = new ArrayList<>();
  }

  public Cursus(String title, String cursusCode, String duration, String startDate) {
    this.title = title;
    this.cursusCode = cursusCode;
    this.duration = duration;
    this.startDate = startDate;
    this.cursistList = new ArrayList<>();
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getCursusCode() {
    return cursusCode;
  }

  public void setCursusCode(String cursusCode) {
    this.cursusCode = cursusCode;
  }

  public String getDuration() {
    return duration;
  }

  public void setDuration(String duration) {
    this.duration = duration;
  }

  public String getStartDate() {
    return startDate;
  }

  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }

  public List<Cursist> getCursistList() {
    return cursistList;
  }

  public void setCursistList(List<Cursist> cursistList) {
    this.cursistList = cursistList;
  }

  /**
   * Add a cursist to the cursist list, only if the
   * amount of enrolled cursists is under the cursus capacity.
   *
   * @param cursist a cursist
   */
  public boolean addCursist(Cursist cursist) {
    if (this.cursistList.size() < CURSUS_CAPACITY) {
      this.cursistList.add(cursist);
      return true;
    }

    return false;
  }

  /**
   * Counts the amount of enrolled cursists for this cursus.
   *
   * @return number of enrolled cursists
   */
  public int enrolledCursistCount() {
    return this.cursistList.size();
  }

  /**
   * Checks whether the cursist list has a certain Cursist Instance
   *
   * @param cursist a cursist
   * @return true if the cursist is already in the list, false otherwise
   */
  public boolean hasCursist(Cursist cursist) {
    return this.cursistList.contains(cursist);
  }

  @Override
  public String toString() {
    return "Cursus{" +
        "id=" + id +
        ", title='" + title + '\'' +
        ", cursusCode='" + cursusCode + '\'' +
        ", duration='" + duration + '\'' +
        ", startDate='" + startDate + '\'' +
        '}';
  }
}

package com.yrw.test.equalsandhashcode;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class Employee1
{
 private Integer id;
 private String firstname;
 private String lastName;
 private String department;
public Integer getId() {
    return id;
 }
 public void setId(Integer id) {
    this.id = id;
 }
 public String getFirstname() {
    return firstname;
 }
 public void setFirstname(String firstname) {
    this.firstname = firstname;
 }
 public String getLastName() {
    return lastName;
 }
 public void setLastName(String lastName) {
    this.lastName = lastName;
 }
 public String getDepartment() {
    return department;
 }
 public void setDepartment(String department) {
    this.department = department;
 }
@Override
 public int hashCode()
 {
    final int PRIME = 31;
    return new HashCodeBuilder(getId()%2==0?getId()+1:getId(), PRIME).
           toHashCode();
 }
@Override
 public boolean equals(Object o) {
    if (o == null)
       return false;
    if (o == this)
       return true;
    if (o.getClass() != getClass())
       return false;
    Employee1 e = (Employee1) o;
       return new EqualsBuilder().
              append(getId(), e.getId()).
              isEquals();
    }
 }
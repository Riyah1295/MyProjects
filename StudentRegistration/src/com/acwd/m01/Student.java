package com.acwd.m01;

import java.util.Scanner;
import java.sql.*;

/**
 * Author: Nur Syazriyah
 * Since: 29/04/2019
 * This program is about com.acwd.m01.Student Registration Form Validation.
 */

public class Student {
    private String firstName;
    private String lastName;
    private String gender;
    private String residentialAddr;
    private String phoneNum;
    private String courseSelected;

    /**
     * To get the first name of the student.
     * @return - The first name.
     */
    public String getFirstName() {

        return firstName;
    }

    /**
     * To set the first name.
     * @param firstName
     */
    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }

    /**
     * To get the last name of the student.
     * @return - The last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * To set the last name.
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * To get the gender of the student.
     * @return - The gender.
     */
    public String getGender() {
        return gender;
    }

    /**
     * To set the gender of the student.
     * @param gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * To get the residential of the student.
     * @return - The residential address.
     */
    public String getResidentialAddr() {
        return residentialAddr;
    }

    /**
     * To set the residential address.
     * @param residentialAddr
     */
    public void setResidentialAddr(String residentialAddr) {
        this.residentialAddr = residentialAddr;
    }

    /**
     * To get the phone number of the student.
     * @return - The phone number.
     */
    public String getPhoneNum() {
        return phoneNum;
    }

    /**
     * To set the phone number of the student.
     * @param phoneNum
     */
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    /**
     * To get the course selected by the student.
     * @return - The course selected.
     */
    public String getCourseSelected() {
        return courseSelected;
    }

    /**
     * To set the course selected by the student.
     * @param courseSelected
     */
    public void setCourseSelected(String courseSelected) {
        this.courseSelected = courseSelected;
    }

    /**
     * Validation of first name.
     * @return - It returns a boolean.
     */
    public boolean validFirstName(){
        boolean result = true;

        if (this.firstName.length() == 0){
            result = false;
        }
        else if (this.firstName.matches(".*\\d.*")){
            result = false;
        }
        return result;
    }

    /**
     * Validation of last name.
     * @return - It returns a boolean.
     */
    public boolean validLastName(){
        boolean result = true;

        if (this.lastName.length() == 0){
            result = false;
        }
        else if (this.lastName.matches(".*\\d.*")){
            result = false;
        }
        return result;
    }

    /**
     * Validation of gender.
     * @return - It returns a boolean.
     */
    public boolean validGender(){
        boolean result = true;

        if (!(this.gender.equalsIgnoreCase("Male") || this.gender.equalsIgnoreCase("Female"))){
            result = false;
        }
        return result;
    }

    /**
     * Validation of residential address.
     * @return - It returns a boolean.
     */
    public boolean validResidentialAddr(){
        boolean result = true;

        if (this.residentialAddr.length() == 0){
            result = false;
        }
        return result;
    }

    /**
     * Validation of phone number.
     * @return - It returns a boolean.
     */
    public boolean validPhoneNum(){
        boolean result = true;

        if (this.phoneNum.length() == 0 || this.phoneNum.length() > 11){
            result = false;
        }
        else if (!this.phoneNum.matches("[0-9]+")){
            result = false;
        }
        return result;
    }

    /**
     * Connection to the database in MySQL and to insert value in the database.
     * @return - Submit the information to the database if it is true.
     * @throws Exception
     */
    public boolean insert()throws Exception{

        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/m01_abc_learning","root","R1295@snsd");

            String sql = "insert into registration (student_first_name, student_last_name, gender, residential_addr, phone_num, course_selected) values (?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1,firstName);
            pstmt.setString(2,lastName);
            pstmt.setString(3,gender);
            pstmt.setString(4,residentialAddr);
            pstmt.setString(5,phoneNum);
            pstmt.setString(6,courseSelected);

            int rowInserted = pstmt.executeUpdate();

            return true;
        }
        catch (Exception e){
            throw new Exception(e.getMessage());

        }
    }
}

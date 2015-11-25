/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Jackie
 */
public class User {

    private int userID;
    private String userName;
    private String userPassword;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    /**
     * User constructor
     */
    public User() {
        this.userName = "";
        this.userPassword = "";
        this.firstName = "";
        this.lastName = "";
        this.phone = "";
        this.address = "";
    }

    /**
     * User constructor
     * @param userName
     * @param userPassword
     */
    public User(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }

    /**
     * User constructor
     * @param userID
     * @param userName
     * @param userPassword
     */
    public User(int userID, String userName, String userPassword) {
        this.userID = userID;
        this.userName = userName;
        this.userPassword = userPassword;
    }

    /**
     * User constructor
     * @param userName
     * @param userPassword
     * @param firstName
     * @param lastName
     * @param phone
     * @param address
     */
    public User(String userName, String userPassword, String firstName, String lastName, String phone, String address) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    /**
     * Get user id
     * @return user id
     */
    public int getUserID() {
        return userID;
    }

    /**
     * Set the user id
     * @param userID User id
     */
    public void setUserID(int userID) {
        this.userID = userID;
    }

    /**
     * Get user name
     * @return Username
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Set user name
     * @param userName Username
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Get user password
     * @return User password
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * Set user password
     * @param userPassword user password
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    /**
     * Get user first name
     * @return First name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set user first name
     * @param firstName first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Get user last name
     * @return Last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set user last name
     * @param lastName last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Get user phone number
     * @return Phone number
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Set user phone number
     * @param phone User phone number
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Get user address
     * @return User Address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Set user address
     * @param address User address
     */
    public void setAddress(String address) {
        this.address = address;
    }

}

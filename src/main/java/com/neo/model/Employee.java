package com.neo.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
@Document(collection = "employee")
public class Employee {
    @Id
    private ObjectId _id;
    @NotEmpty(message = "Không được bỏ trống")
    private String name;
    @NotEmpty(message = "Không được bỏ trống")
    private String gender;
    @Positive(message = "tuổi lớn hơn 0")
    private int age;
    @NotEmpty(message = "Không được bỏ trống")
    private String address;
    @NotEmpty(message = "Không được bỏ trống")
    private String email;

    public Employee() {
    }

    public Employee(ObjectId _id, String name, String gender, int age, String address, String email) {
        this._id = _id;

        this.name = name;
        this.gender = gender;
        this.age = age;
        this.address = address;
        this.email = email;
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

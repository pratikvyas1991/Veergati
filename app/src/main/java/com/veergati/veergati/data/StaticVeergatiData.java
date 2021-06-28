package com.veergati.veergati.data;

public enum StaticVeergatiData {
    Kent("myLast","Kfirst","kfoo"),
    Someone("sLast", "sFirst", "sfoo");

    private String lastname;
    private String firstname;
    private String foo;

    StaticVeergatiData(String lastname, String firstname, String foo) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.foo = foo;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getFoo() {
        return foo;
    }
}

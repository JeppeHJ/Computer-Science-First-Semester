package Opgave4;

public class Lejer {
    private String name;
    private String education;

    public Lejer(String name, String address) {
        this.name = name;
        this.education = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }
}

package by.tms.calculator;

public class Usera {
    private int id;
    private String name;
    private String surname;
    private int uniq;

    public Usera() {
        //empty
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setUniq(int uniq) {
        this.uniq = uniq;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }



    public int getUniq() {
        return uniq;
    }
    @Override
    public String toString() {
        return "Usera{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", uniq=" + uniq +
                '}';
    }
}

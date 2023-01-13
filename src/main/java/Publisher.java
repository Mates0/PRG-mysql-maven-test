public class Publisher {
    private String superhero_name;
    private String full_name;
    private int gender;
    private int race;
    private int aligment_id;
    public Publisher(String superhero_name, String full_name, int gender, int race, int aligment_id) {
        this.superhero_name = superhero_name;
        this.full_name = full_name;
        this.gender = gender;
        this.race = race;
        this.aligment_id = aligment_id;
    }

    public String getSuperhero_name() {
        return superhero_name;
    }

    public void setSuperhero_name(String superhero_name) {
        this.superhero_name = superhero_name;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getRace() {
        return race;
    }

    public void setRace(int race) {
        this.race = race;
    }

    public int getAligment_id() {
        return aligment_id;
    }

    public void setAligment_id(int aligment_id) {
        this.aligment_id = aligment_id;
    }
}

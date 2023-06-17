package pages;

public class P01_CreateUser {

    // define request attributes
    private String name;
    private String job;

    // define setter and getter methods

    public String getName() {
        return name;
    }

    public P01_CreateUser setName(String name) {
        this.name = name;
        return this;
    }

    public String getJob() {
        return job;
    }

    public P01_CreateUser setJob(String job) {
        this.job = job;
        return this;
    }



}

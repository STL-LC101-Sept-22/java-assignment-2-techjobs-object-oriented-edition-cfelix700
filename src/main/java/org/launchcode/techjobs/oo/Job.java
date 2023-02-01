package org.launchcode.techjobs.oo;

import javax.lang.model.element.Name;
import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.
    public Job(){
        this.id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency){
       this.name = name;
       this.employer = employer;
       this.location = location;
       this.positionType = positionType;
       this.coreCompetency = coreCompetency;
       this.id = 1;
    }




    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Job)) return false;
        Job job = (Job) o;
        return id == job.id && Objects.equals(name, job.name) && Objects.equals(employer, job.employer) && Objects.equals(location, job.location) && Objects.equals(positionType, job.positionType) && Objects.equals(coreCompetency, job.coreCompetency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, employer, location, positionType, coreCompetency);
    }


    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    public int getId() {
        return id;
    }

    public void setId(int i) {
    }

    @Override
    public String toString() {
        String jobString = "\n";
        if (id == 0 && name == null && employer == null && location == null && positionType == null && coreCompetency == null){
            return "OOPS! This job does not seem to exist,";
        } else {
            if (id != 0){
                jobString += "Job ID: " + id + "\n";
            } if (name != null){
                jobString += "Name: " + name + "\n";
            } else {
                jobString += "Name: Data not available\n";
            } if (employer != null){
                jobString += "Employer: " + employer + "\n";
            } else {
                jobString += "Employer: Data not available\n";
            } if (location != null){
                jobString += "Location: " + location + "\n";
            } else {
                jobString += "Location: Data not available\n";
            } if (positionType != null){
                jobString += "Position Type: " + positionType + "\n";
            } else {
                jobString += "Position Type: Data not available\n";
            } if (coreCompetency != null){
                jobString += "Core Competency: " + coreCompetency + "\n";
            } else {
                jobString += "Core Competency: Data not available\n";
            }
            return jobString + "\n";
        }

    }
}

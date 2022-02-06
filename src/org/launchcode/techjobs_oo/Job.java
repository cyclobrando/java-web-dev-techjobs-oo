package org.launchcode.techjobs_oo;

import java.lang.reflect.Field;
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

    public Job() {
        id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;

    }

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PositionType)) return false;
        Job that = (Job) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        String notAvailable = "Data not available!";

        String name;
        if (getName() == null) {
            name = notAvailable;
        } else if (Objects.equals(getName(), "")) {
            name = notAvailable;
        } else name = getName();

        String employer;
        if (getEmployer() == null) {
            employer = notAvailable;
        } else if (getEmployer().toString().equals("")){
            employer = notAvailable;
        } else employer = getEmployer().toString();

        String location;
        if (getLocation() == null) {
            location = notAvailable;
        } else if (getLocation().toString().equals("")){
            location = notAvailable;
        } else location = getLocation().toString();

        String positionType;
        if (getPositionType() == null) {
            positionType = notAvailable;
        } else if (getPositionType().toString().equals("")){
            positionType = notAvailable;
        } else positionType = getPositionType().toString();

        String coreCompetency;
        if (getCoreCompetency() == null) {
            coreCompetency = notAvailable;
        } else if (getCoreCompetency().toString().equals("")){
            coreCompetency = notAvailable;
        } else coreCompetency = getCoreCompetency().toString();

        if (name.equals(notAvailable) && employer.equals(notAvailable) && location.equals(notAvailable) && positionType.equals(notAvailable) && coreCompetency.equals(notAvailable)) {
            return "OOPS! This job does not seem to exist!";
        } else return " \nID: " + getId() + "\nName: " + name + "\nEmployer: " + employer + "\nLocation: " + location + "\nPosition Type: " + positionType + "\nCore Competency: " + coreCompetency + "\n ";
    }


    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.


    public int getId() {
        return id;
    }

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
}

package org.launchcode.techjobs_oo.Tests;

import org.junit.Test;
import org.launchcode.techjobs_oo.*;
import org.junit.Before;

import static org.junit.Assert.*;

public class JobTest {
    Job test_job;
    Job test_job_2;
    Job test_job_3;
    Job test_job_4;

    @Before
    public void createJobObjects() {
        test_job = new Job();
        test_job_2 = new Job();
        test_job_3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality Control"), new CoreCompetency("Persistence"));
        test_job_4 = new Job("Product tester", new Employer(""), new Location("Desert"), new PositionType("Quality Control"), new CoreCompetency("Persistence"));
    }

    @Test
    public void testSettingJobId() {
        assertTrue(test_job.getId() == 1);
        assertTrue(test_job_2.getId() == 2);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        assertSame("Product tester", test_job_3.getName());
        assertEquals(3, test_job_3.getId());

        assertTrue(test_job_3.getEmployer() instanceof Employer);
        assertTrue(test_job_3.getLocation() instanceof Location);
        assertTrue(test_job_3.getPositionType() instanceof PositionType);
        assertTrue(test_job_3.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality() {
        test_job_2.setName("Job");
        test_job_2.setEmployer(new Employer("ACME"));
        test_job_2.setLocation(new Location("Desert"));
        test_job_2.setPositionType(new PositionType("Quality Control"));
        test_job_2.setCoreCompetency(new CoreCompetency("Persistence"));

        assertNotEquals(test_job_3, test_job_2);
    }

    @Test
    public void testToStringBlankLine() {
        assertTrue(test_job_3.toString().startsWith(" "));
        assertTrue(test_job_3.toString().endsWith(" "));
    }

    @Test
    public void testToStringContainsInfo() {
        assertTrue(test_job_3.toString().contains(" \nID: " + test_job_3.getId() + "\nName: " + test_job_3.getName() + "\nEmployer: " + test_job_3.getEmployer() + "\nLocation: " + test_job_3.getLocation() + "\nPosition Type: " + test_job_3.getPositionType() + "\nCore Competency: " + test_job_3.getCoreCompetency() + "\n "));
    }

    @Test
    public void testDataNotAvailable() {
        assertTrue(test_job_4.toString().contains("Data not available!"));
    }

    @Test
    public void testJobDoesNotExist() {
        assertTrue(test_job.toString().contains("OOPS! This job does not seem to exist!"));
    }

}
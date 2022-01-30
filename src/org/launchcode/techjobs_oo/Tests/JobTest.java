package org.launchcode.techjobs_oo.Tests;

import org.junit.Test;
import org.launchcode.techjobs_oo.*;
import org.junit.Before;

import static org.junit.Assert.*;

public class JobTest {
    Job test_job;
    Job test_job_2;

    @Before
    public void createJobObjects() {
    test_job = new Job();
    test_job_2 = new Job();
    }

    @Test
    public void testSettingJobId() {
        assertTrue(test_job.getId() == 1 && test_job_2.getId() == 2);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality Control"), new CoreCompetency("Persistence"));
        assertSame("Product tester", job.getName());
        assertEquals(3, job.getId());

        //assertTrue(job.getEmployer() instanceof Employer);
        assertNotNull(job.getEmployer());
        assertNotNull(job.getLocation());
        assertNotNull(job.getPositionType());
        assertNotNull(job.getCoreCompetency());
    }

    @Test
    public void testJobsForEquality() {
        test_job.setName("Job");
        test_job.setEmployer(new Employer("ACME"));
        test_job.setLocation(new Location("Desert"));
        test_job.setPositionType(new PositionType("Quality Control"));
        test_job.setCoreCompetency(new CoreCompetency("Persistence"));

        test_job_2.setName("Job");
        test_job_2.setEmployer(new Employer("ACME"));
        test_job_2.setLocation(new Location("Desert"));
        test_job_2.setPositionType(new PositionType("Quality Control"));
        test_job_2.setCoreCompetency(new CoreCompetency("Persistence"));

        //assertFalse(test_job.equals(test_job_2));
        assertNotEquals(test_job, test_job_2);
    }
}
package com.hummer.hospital_heroes;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * The test class ConstantsTest.
 *
 * @author Fareed Faisal
 * @version 1.0
 */
public class ConstantsTest
{

    @Before
    public void setUp() throws Exception
    {
    }

    @After
    public void tearDown() throws Exception
    {
    }

    /**
     * Test that the food is correctly initialised.
     */
    @Test
    public void foodTest()
    {
        Constants constantsTest = new Constants();
        constantsTest.setIsFood(true);
        assertEquals(true, constantsTest.isFood());
    }

    /**
     * Test that the color is correctly initialised.
     */
    @Test
    public void colorTest()
    {
        Constants constantsTest = new Constants();
        constantsTest.setIsBlack(true);
        assertEquals(true, constantsTest.isBlack());
    }

    /**
     * Test that the character is correctly initialised.
     */
    @Test
    public void playerChairTest()
    {
        Constants constantsTest = new Constants();
        constantsTest.setPlayerChair(1);
        assertEquals(1, constantsTest.getPlayerChair());
    }

    /**
     * Test that the sitting is correctly initialised.
     */
    @Test
    public void playerSittingTest()
    {
        Constants constantsTest = new Constants();
        constantsTest.setPlayerSitting(2);
        assertEquals(2, constantsTest.getPlayerSitting());
    }

    /**
     * Test that the standing is correctly initialised.
     */
    @Test
    public void playerStandingTest()
    {
        Constants constantsTest = new Constants();
        constantsTest.setPlayerStanding(3);
        assertEquals(3, constantsTest.getPlayerStanding());
    }
}
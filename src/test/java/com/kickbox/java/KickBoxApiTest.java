package com.kickbox.java;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author szagriichuk.
 */
public class KickBoxApiTest {

    @Test
    public void testVerifyInvalidEmail() throws Exception {
        KickBoxApi kickBoxApi = new KickBoxApi("KEY");
        boolean valid = kickBoxApi.verify("test@test.com");
        Assert.assertFalse(valid);
    }

    @Test
    public void testVerifyValidEmail() throws Exception {
        KickBoxApi kickBoxApi = new KickBoxApi("KEY");
        boolean valid = kickBoxApi.verify("sergii.zagriichuk@gmail.com");
        Assert.assertTrue(valid);
    }
}
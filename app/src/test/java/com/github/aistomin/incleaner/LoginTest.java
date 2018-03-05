package com.github.aistomin.incleaner;

import java.net.HttpURLConnection;
import java.net.URL;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by aistomin on 05.03.18.
 * <p>
 * Test that checks Instagram login.
 */
public final class LoginTest {

    /**
     * Test for playing around with Instagram login.
     * @throws Exception If something goes wrong.
     */
    @Test
    public void testLogin() throws Exception {
        Assert.assertEquals(
            200,
            (
                (HttpURLConnection) new URL("https://www.instagram.com/")
                    .openConnection()
            ).getResponseCode()
        );
    }
}

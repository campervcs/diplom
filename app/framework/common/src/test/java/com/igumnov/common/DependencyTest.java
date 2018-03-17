package com.igumnov.common;


import com.igumnov.common.dependency.DependencyException;
import com.igumnov.common.dependency.Inject;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.Assert.*;

public class DependencyTest {


    @Inject("inject")
    private InjectClass injectTest;



    @Test
    public void testDependency() throws IOException, URISyntaxException, IllegalAccessException, InstantiationException, ClassNotFoundException, DependencyException {
        Dependency.scan("com.igumnov.common");
        assertEquals(InjectClass.test(), "1");
        DependencyTest obj = new DependencyTest();
        Dependency.inject(obj);
        assertEquals(obj.testInject(), "1");
        assertEquals(((InjectClass)Dependency.find("inject")).ret(), "1");

    }

    public String testInject() {
        return injectTest.ret();
    }
}

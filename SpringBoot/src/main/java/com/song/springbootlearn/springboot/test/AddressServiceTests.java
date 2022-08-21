package com.song.springbootlearn.springboot.test;

import com.sun.xml.internal.ws.wsdl.writer.document.http.Address;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AddressServiceTests.class)
public class AddressServiceTests {
    @Autowired
    private AddressServiceTests addressServiceTests;
    @Test
    public void testService(){
        
    }
}

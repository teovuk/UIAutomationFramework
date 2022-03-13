package org.example.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.listener.TestListener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

@Listeners({ TestListener.class })
public class BaseTest {

    static Logger log = LogManager.getLogger(BaseTest.class);

    @BeforeClass
public void beforeClass() throws InterruptedException {
      //  WebBasePage page = new WebBasePage();

      //  Thread.sleep(600);

    }

}

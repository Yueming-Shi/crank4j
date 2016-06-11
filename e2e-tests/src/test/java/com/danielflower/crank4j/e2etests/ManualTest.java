package com.danielflower.crank4j.e2etests;

import com.danielflower.crank4j.connector.ConnectorEntryPoint;
import com.danielflower.crank4j.router.RouterEntryPoint;
import com.danielflower.crank4j.sharedstuff.Dirs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import scaffolding.FileFinder;

import java.io.File;
import java.io.IOException;

public class ManualTest {
    private static final Logger log = LoggerFactory.getLogger(ManualTest.class);

    public static void main(String[] args) throws IOException {
        log.info("Starting router");
        RouterEntryPoint.main(config("manual-test-router.properties"));
        log.info("Starting connector");
        ConnectorEntryPoint.main(config("manual-test-connector.properties"));
        log.info("Ready for manual testing");
    }

    private static String[] config(String filename) {
        return new String[] {Dirs.dirPath(new File(FileFinder.e2eTestResourcesDir(), filename))};
    }


}
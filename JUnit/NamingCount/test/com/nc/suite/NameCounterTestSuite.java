package com.nc.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.nc.beans.NameCounterTest;
import com.nc.helper.FileReaderTest;

@RunWith(Suite.class)
@SuiteClasses({ FileReaderTest.class, NameCounterTest.class })
public class NameCounterTestSuite {

}

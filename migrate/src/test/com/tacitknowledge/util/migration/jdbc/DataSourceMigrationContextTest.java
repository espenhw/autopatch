/* Copyright 2005 Tacit Knowledge LLC
 * 
 * Licensed under the Tacit Knowledge Open License, Version 1.0 (the "License");
 * you may not use this file except in compliance with the License. You may
 * obtain a copy of the License at http://www.tacitknowledge.com/licenses-1.0.
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.tacitknowledge.util.migration.jdbc;

import junit.framework.TestCase;

/**
 * Exercise the data source migration context
 * 
 * @author Mike Hardy <mailto:mike@tacitknowledge.com/>
 */
public class DataSourceMigrationContextTest extends TestCase
{
    /**
     * Test the system name setting
     */
    public void testSystemName()
    {
        DataSourceMigrationContext context = new DataSourceMigrationContext();
        
        StringBuffer testNameBuffer = new StringBuffer("");
        for (int i = 0; i < JdbcMigrationContext.MAX_SYSTEMNAME_LENGTH; i++)
        {
            testNameBuffer.append("a");
        }
        String testName = testNameBuffer.toString();
        
        try
        {
            context.setSystemName(null);
            fail("Should have thrown an exception on a null system name");
        }
        catch (IllegalArgumentException iae)
        {
            // we expect this
        }
        try
        {
            context.setSystemName(testName + ".");
            fail("We should have thrown an exception on a too-long system name");
        }
        catch (IllegalArgumentException iae)
        {
            // we expect this
        }
        context.setSystemName(testName);
    }
}
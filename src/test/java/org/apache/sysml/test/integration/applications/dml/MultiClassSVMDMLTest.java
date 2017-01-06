/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.sysml.test.integration.applications.dml;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.apache.sysml.api.DMLScript;
import org.apache.sysml.test.integration.applications.MultiClassSVMTest;

@RunWith(value = Parameterized.class)
public class MultiClassSVMDMLTest extends MultiClassSVMTest {

	public MultiClassSVMDMLTest(int rows, int cols, int nc, boolean intercept, double sp) {
		super(rows, cols, nc, intercept, sp);
		TEST_CLASS_DIR = TEST_DIR + MultiClassSVMDMLTest.class.getSimpleName() + "/";
	}

	@Test
	public void testMultiClassSVMDml() {
		testMultiClassSVM(ScriptType.DML);
	}
	
	@Test
	public void testMultiClassSVMDmlDisableSparseNCaching() {
		try {
			DMLScript.DISABLE_SPARSE = true;
			DMLScript.DISABLE_CACHING = true;
			testMultiClassSVM(ScriptType.DML);
		}
		finally {
			DMLScript.DISABLE_SPARSE = false;
			DMLScript.DISABLE_CACHING = false;
		}
	}

}
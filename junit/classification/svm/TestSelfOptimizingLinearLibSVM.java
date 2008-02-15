/**
 * TestSelfOptimizingSMO.java
 *
 * %SVN.HEADER%
 */
package junit.classification.svm;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import net.sf.javaml.core.Dataset;
import net.sf.javaml.tools.data.FileHandler;

import org.junit.Assert;
import org.junit.Test;

import external.libsvm.SelfOptimizingLinearLibSVM;

public class TestSelfOptimizingLinearLibSVM {

	@Test
	public void testSelfOptimizingLinearLibSVM() {
		try {
			Dataset data = FileHandler.loadDataset(new File(
					"devtools/data/iris.tsv"), 4);
			System.out.println("Size: " + data.size());
			System.out.println("numAtt: " + data.numAttributes());
			SelfOptimizingLinearLibSVM smo = new SelfOptimizingLinearLibSVM();
			smo.buildClassifier(data);
			System.out.println(smo.getC());
			System.out.println(Arrays.toString(smo.getWeights()));
		} catch (IOException e) {

			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}

	@Test
	public void testPow2() {
		for (int i = -10; i < 11; i++)
			System.out.println(Math.pow(2, i));
	}

}

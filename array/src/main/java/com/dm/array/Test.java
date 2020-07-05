package com.dm.array;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Random;

/**
 * Description: 测试用例
 *
 * @param:
 * @return:
 * @auther: dm
 * @date: 2019/11/18 21:41
 */
public class Test {
	public static void main(String[] args) throws Exception {
		final String fileName = "D:\\IdeaProjects\\DataStructureAlgorithm\\src\\array\\age1.txt";
		final Random random = new Random();
		BufferedWriter objWriter = null;
		objWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName)));
		for (int i = 0; i < 1400000000; i++) {
			int age = Math.abs(random.nextInt()) % 180;
			objWriter.write(age + "\r\n");
		}
		objWriter.flush();
		objWriter.close();

	}
}

package com.example.tyb;

import com.example.tyb.generator.MysqlGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class TybApplicationTests {

	@Test
	public void tybReportGenerator() {
		MysqlGenerator generator = new MysqlGenerator();
		generator.defaultGenerator("student_book");
	}

}

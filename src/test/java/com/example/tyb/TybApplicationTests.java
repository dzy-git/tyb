package com.example.tyb;

import com.example.tyb.generator.MysqlGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class TybApplicationTests {

	@Test
	public void defaultGenerator() {
		MysqlGenerator generator = new MysqlGenerator();
		generator.defaultGenerator("student_book");
	}
	@Test
	public void dataCenterGenerator() {
		MysqlGenerator generator = new MysqlGenerator();
		generator.datacenterGenerator("index_book");
	}

}

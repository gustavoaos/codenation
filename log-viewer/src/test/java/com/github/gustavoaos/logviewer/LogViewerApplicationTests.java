package com.github.gustavoaos.logviewer;

import com.github.gustavoaos.logviewer.model.Level;
import com.github.gustavoaos.logviewer.model.LogViewer;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class LogViewerApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void testErrorLogLevel() {
		assertNotNull(Level.ERROR);
		// assertNotNull(new LogViewer());
	}

}

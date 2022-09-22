import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class IndexTester {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		Path p = Paths.get("junit.txt");
        try {
            Files.writeString(p, "JackB Test", StandardCharsets.ISO_8859_1);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
        
		
	}

	@AfterAll
	//FINISH THIS, DELETE OBJ FOLDER AND INDEX FILE
	static void tearDownAfterClass() throws Exception {
		File file= new File("junit.txt");
		file.delete();
		
	
	}

	@Test
	void testIndex() {
				
		Index ind= new Index();
				
		File file=new File("index");
		assertTrue(file.exists());
				
		Path path=Paths.get("objects");
		assertTrue(Files.exists(path));
	}
	
	@Test
	void testBlob() throws IOException, NoSuchAlgorithmException {		
		Blob b=new Blob("junit.txt");
		
		File file=new File("objects/f85d527604444aa350aa09dfe93baefbd88f804c");// PUT IN SHA1 STRING
		assertTrue(file.exists());// this is returning false bc file never gets created
	}
	
	@Test
	void testGetSha() throws NoSuchAlgorithmException, IOException {
		Blob b=new Blob("junit.txt");
		assertTrue(b.sha1Code("JackB Test").equals("f85d527604444aa350aa09dfe93baefbd88f804c"));
		
	}
	

}

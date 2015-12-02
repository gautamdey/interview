import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.interview.BoggleWordFinder;
import com.interview.exception.ApplicationException;

import junitx.framework.ListAssert;
public class TestBoggleWordFinder {



	@Test
	public void test_array_pass()
	{

		Character[][] wordMatrix = {{'a','n','t','d'},{'f','i','r','e'},{'s','o','e','l'},{'t','u','p','p'}};

		List<String> expected = new ArrayList<String>() {{
			add("ant");
			add("tupple");
			add("in");
			add("red");
		}};
		BoggleWordFinder boogleWordFinder = new BoggleWordFinder();
		List<String> wordList = null;
		try {
			wordList = boogleWordFinder.findWord(wordMatrix);
		} catch (ApplicationException e) {
			fail("exception" );
			e.printStackTrace();
		}
		

		ListAssert.assertEquals(expected,wordList);


	}
}

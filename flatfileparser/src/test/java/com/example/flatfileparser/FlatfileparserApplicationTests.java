package com.example.flatfileparser;

import java.io.BufferedReader;
import java.io.Reader;
import java.io.StringReader;

import org.beanio.BeanReader;
import org.beanio.BeanReaderErrorHandlerSupport;
import org.beanio.StreamFactory;
import org.beanio.builder.FixedLengthParserBuilder;
import org.beanio.builder.StreamBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.flatfileparser.model.WrapperObject;

@RunWith(SpringRunner.class)
@SpringBootTest
/// https://stackoverflow.com/questions/51383474/minoccurs-attribute-in-group-annotation-causes-unexpectedrecordexception
public class FlatfileparserApplicationTests {
	@Test
	public void test() {

		final StreamFactory factory = StreamFactory.newInstance();

		final StreamBuilder builder = new StreamBuilder("Jaydeep23").format("fixedlength")
				.parser(new FixedLengthParserBuilder()).addGroup(WrapperObject.class);

		factory.define(builder);

		final String scenario1 = "560866\n670972\n560866\n670972\n560866\n670972";
		final String scenario2 = "560866\n670972\n560866\n670972\n560866\n670972\n57086659\n57086659\n57086659\n"
				+ "57086659\n560866\n670972\n57086659\n560866\n670972";
		// invalid
		final String scenario3 = "57086659\n57086659\n57086659\n57086659\n57086659";
		final String scenario4 = "52022\n52066\n52054\n52120";
		final String scenario5 = scenario1;
		final String scenario6 = "560866\n670972\n560866\n670972\n560866\n670972\n57086659\n57086659\n57086659\n"
				+ "57086659\n52021\n52022\n52023\n560866\n670972\n57086659\n52023";

		final String scenario7 = "560866\n670972\n57086659\n57086659\n57086659\n57086659\n57086659";

		final String message = scenario7;
		BeanReader beanReader = null;
		Object object = null;
		try (final Reader in = new BufferedReader(new StringReader(message))) {
			beanReader = factory.createReader("Jaydeep23", in);
			beanReader.setErrorHandler(new BeanReaderErrorHandlerSupport());
			while ((object = beanReader.read()) != null) {
				System.out.println("Object = " + object);
			}
		} catch (final Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (beanReader != null) {
				beanReader.close();
			}
		}
	}
}

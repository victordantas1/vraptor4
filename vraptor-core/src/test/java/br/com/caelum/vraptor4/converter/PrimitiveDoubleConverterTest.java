/***
 * Copyright (c) 2009 Caelum - www.caelum.com.br/opensource
 * All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 * 
 * 	http://www.apache.org/licenses/LICENSE-2.0 
 * 
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and 
 * limitations under the License. 
 */

package br.com.caelum.vraptor4.converter;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.util.ResourceBundle;

import org.junit.Before;
import org.junit.Test;

public class PrimitiveDoubleConverterTest {

	private PrimitiveDoubleConverter converter;
	private ResourceBundle bundle;

	@Before
	public void setup() {
		this.converter = new PrimitiveDoubleConverter();
		this.bundle = ResourceBundle.getBundle("messages");
	}

	@Test
	public void shouldBeAbleToConvertNumbers() {
		assertThat((Double) converter.convert("2.3", double.class, bundle), is(equalTo(2.3d)));
	}

	@Test
	public void shouldComplainAboutInvalidNumber() {
		try {
			converter.convert("---", double.class, bundle);
		} catch (ConversionException e) {
			assertThat(e.getMessage(), is(equalTo("--- is not a valid number.")));
		}
	}

	@Test
	public void shouldConvertToZeroWhenNull() {
		assertThat((Double) converter.convert(null, double.class, bundle), is(equalTo(0D)));
	}

	@Test
	public void shouldConvertToZeroWhenEmpty() {
		assertThat((Double) converter.convert("", double.class, bundle), is(equalTo(0D)));
	}

}
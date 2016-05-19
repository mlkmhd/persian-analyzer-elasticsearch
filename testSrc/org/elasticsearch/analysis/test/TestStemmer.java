package org.elasticsearch.analysis.test;

import java.io.StringReader;

import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.standard.StandardTokenizer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.junit.Test;

public class TestStemmer {
	
	@Test
	public void testName() throws Exception {
		String txt = "انبار دار , دیپلمه حسابداری , با 2سال سابقه آشنا به";
		
//		PTBTokenizer ptb = new PTBTokenizer(new StringReader(txt), new CoreLabelTokenFactory(), null);
//		while(ptb.hasNext())
//			System.out.println(ptb.next());
		
		Tokenizer tokenizer = new StandardTokenizer();
		tokenizer.setReader(new StringReader(txt));
		tokenizer.reset();
		CharTermAttribute attr = tokenizer.addAttribute(CharTermAttribute.class);
		while(tokenizer.incrementToken()) {
			System.out.println(attr.toString());
		}
//		FarsiStemmer stem = new FarsiStemmer();
//		stem.stem("کتابها");
//		stem.stem("شهرها");
	}
	
}

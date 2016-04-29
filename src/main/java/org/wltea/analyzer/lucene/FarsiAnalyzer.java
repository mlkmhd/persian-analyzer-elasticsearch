package org.wltea.analyzer.lucene;

import java.io.StringReader;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenFilter;
import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.core.WhitespaceTokenizer;

public class FarsiAnalyzer extends Analyzer {
	
	@Override
	protected TokenStreamComponents createComponents(String paramString) {
		
		Tokenizer tokenizer = new WhitespaceTokenizer();
		tokenizer.setReader(new StringReader(paramString));
		TokenFilter filter = new FarsiStopWordTokenFilter(tokenizer);
		
		return new TokenStreamComponents(tokenizer, filter);
	}

}

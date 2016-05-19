package ir.areka.analyzer.lucene;

import java.io.StringReader;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.ar.ArabicNormalizationFilter;
import org.apache.lucene.analysis.core.LowerCaseFilter;
import org.apache.lucene.analysis.fa.PersianNormalizationFilter;
import org.apache.lucene.analysis.standard.StandardTokenizer;

public class FarsiAnalyzer extends Analyzer {
	
	@Override
	protected TokenStreamComponents createComponents(String paramString) {
		
		/**
		 * tokenization 
		 */
		Tokenizer tokenizer = new StandardTokenizer();
		tokenizer.setReader(new StringReader(paramString));
		
		/**
		 * normilization 
		 */
		TokenStream res = new ArabicNormalizationFilter(tokenizer);
		res = new LowerCaseFilter(res);
		res = new PersianNormalizationFilter(res);
		res = new FarsiNormilizerFilter(res);
		
		/**
		 * filter stop words
		 */
		TokenFilter filter = new FarsiStopWordTokenFilter(res);
		
		return new TokenStreamComponents(tokenizer, filter);
	}

}

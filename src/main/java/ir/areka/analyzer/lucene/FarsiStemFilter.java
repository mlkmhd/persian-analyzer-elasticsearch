package ir.areka.analyzer.lucene;

import java.io.IOException;

import org.apache.lucene.analysis.TokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.KeywordAttribute;

public class FarsiStemFilter extends TokenFilter {

	private final FarsiStemmer farsiStemmer = new FarsiStemmer();
	private final CharTermAttribute termAtt = addAttribute(CharTermAttribute.class);
	private final KeywordAttribute keywordAttr = addAttribute(KeywordAttribute.class);

	protected FarsiStemFilter(TokenStream input) {
		super(input);
	}

	@Override
	public boolean incrementToken() throws IOException {
		if (input.incrementToken()) {
			if (!keywordAttr.isKeyword()) {
				String newlen = farsiStemmer.stem(termAtt.toString());
				termAtt.setEmpty().append("");
			}
			return true;
		} else {
			return false;
		}
	}

}

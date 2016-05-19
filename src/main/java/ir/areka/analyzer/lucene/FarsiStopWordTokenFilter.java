package ir.areka.analyzer.lucene;

import java.io.IOException;

import org.apache.lucene.analysis.TokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.fa.PersianAnalyzer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.PositionIncrementAttribute;

public class FarsiStopWordTokenFilter extends TokenFilter {

	private CharTermAttribute charTermAtt;
	private PositionIncrementAttribute posIncrementAtt;

	protected FarsiStopWordTokenFilter(TokenStream input) {
		super(input);

		charTermAtt = addAttribute(CharTermAttribute.class);
		posIncrementAtt = addAttribute(PositionIncrementAttribute.class);
	}

	@Override
	public boolean incrementToken() throws IOException {
		int extraIncrement = 0;
		boolean returnValue = false;
		while (input.incrementToken()) {
			if (PersianAnalyzer.DEFAULT_STOPWORD_FILE.contains(charTermAtt.toString())) {
				extraIncrement++;// filter this word
				continue;
			}
			returnValue = true;
			break;
		}
		
		if (extraIncrement > 0) 
			posIncrementAtt.setPositionIncrement(posIncrementAtt.getPositionIncrement() + extraIncrement);
		
		return returnValue;
	}

}

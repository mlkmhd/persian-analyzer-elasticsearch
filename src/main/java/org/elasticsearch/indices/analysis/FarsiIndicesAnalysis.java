package org.elasticsearch.indices.analysis;

import org.elasticsearch.common.component.AbstractComponent;
import org.elasticsearch.common.inject.Inject;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.env.Environment;
import org.elasticsearch.index.analysis.AnalyzerScope;
import org.elasticsearch.index.analysis.PreBuiltAnalyzerProviderFactory;

import ir.areka.analyzer.lucene.FarsiAnalyzer;

public class FarsiIndicesAnalysis extends AbstractComponent {

	@Inject
    public FarsiIndicesAnalysis(final Settings settings,
                                   IndicesAnalysisService indicesAnalysisService,Environment env) {
        super(settings);
        
        indicesAnalysisService.analyzerProviderFactories().put("farsi_analyzer",
                new PreBuiltAnalyzerProviderFactory("farsi_analyzer", AnalyzerScope.GLOBAL,
                        new FarsiAnalyzer()));
	}

}

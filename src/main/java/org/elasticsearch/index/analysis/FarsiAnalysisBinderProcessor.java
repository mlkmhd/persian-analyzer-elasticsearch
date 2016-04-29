package org.elasticsearch.index.analysis;

public class FarsiAnalysisBinderProcessor extends AnalysisModule.AnalysisBinderProcessor {


    @Override
    public void processTokenFilters(TokenFiltersBindings tokenFiltersBindings) {

    }


    @Override
    public void processAnalyzers(AnalyzersBindings analyzersBindings) {
    	analyzersBindings.processAnalyzer("farsi", FarsiAnalyzerProvider.class);
    }

}
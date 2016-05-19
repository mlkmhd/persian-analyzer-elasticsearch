package org.elasticsearch.index.analysis;

import org.elasticsearch.common.inject.Inject;
import org.elasticsearch.common.inject.assistedinject.Assisted;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.env.Environment;
import org.elasticsearch.index.Index;
import org.elasticsearch.index.settings.IndexSettingsService;

import ir.areka.analyzer.lucene.FarsiAnalyzer;

public class FarsiAnalyzerProvider extends AbstractIndexAnalyzerProvider<FarsiAnalyzer> {
	
	protected FarsiAnalyzer analyzer = new FarsiAnalyzer();
	public static final String NAME = "custome_analyzer";

	@Inject
	public FarsiAnalyzerProvider(Index index, IndexSettingsService indexSettingsService, Environment env, @Assisted String name, @Assisted Settings settings) {
		super(index, indexSettingsService.getSettings(), name, settings);
	}

	@Override
	public FarsiAnalyzer get() {
		return analyzer;
	}

}

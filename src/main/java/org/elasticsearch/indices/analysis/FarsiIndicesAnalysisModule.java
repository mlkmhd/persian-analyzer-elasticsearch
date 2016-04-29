package org.elasticsearch.indices.analysis;

import org.elasticsearch.common.inject.AbstractModule;

public class FarsiIndicesAnalysisModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(FarsiIndicesAnalysis.class).asEagerSingleton();
	}

}

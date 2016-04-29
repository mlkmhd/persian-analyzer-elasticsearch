package org.elasticsearch.plugin.analysis.ik;

import java.util.Collection;
import java.util.Collections;

import org.elasticsearch.common.inject.Module;
import org.elasticsearch.index.analysis.AnalysisModule;
import org.elasticsearch.index.analysis.FarsiAnalysisBinderProcessor;
import org.elasticsearch.indices.analysis.FarsiIndicesAnalysisModule;
import org.elasticsearch.plugins.Plugin;

public class AnalysisFarsiPlugin extends Plugin {

	@Override
	public String description() {
		return "an analyzer for persian";
	}

	@Override
	public String name() {
		return "farsi_analyzer";
	}

	@Override
	public Collection<Module> nodeModules() {
		return Collections.<Module> singletonList(new FarsiIndicesAnalysisModule());
	}

	public void onModule(AnalysisModule module) {
		module.addProcessor(new FarsiAnalysisBinderProcessor());
	}
}

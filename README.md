Persian Analysis for Elasticsearch
=============================

The Persian Analysis plugin integrates Lucene Farsi analyzer into elasticsearch.

Analyzer: `farsi_analyzer` 

Install
-------

1.change `elasticsearch.version` property in `pom.xml` file to your elasticsearch version. by default it's 2.2.1

2.compile

`mvn package`

copy and unzip `target/releases/elasticsearch-analysis-farsi-{version}.zip` to `your-es-root/plugins/farsi`

2.restart elasticsearch

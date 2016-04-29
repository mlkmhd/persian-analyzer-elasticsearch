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


Quick Example
-------
1.create a index

curl -XPUT http://localhost:9200/index


2.create a mapping

`curl -XPOST http://localhost:9200/index/fulltext/_mapping -d'
{
    "fulltext": {
             "_all": {
            "analyzer": "farsi_analyzer",
            "search_analyzer": "farsi_analyzer",
            "term_vector": "no",
            "store": "false"
        },
        "properties": {
            "content": {
                "type": "string",
                "store": "no",
                "term_vector": "with_positions_offsets",
                "analyzer": "farsi_analyzer",
                "search_analyzer": "farsi_analyzer",
                "include_in_all": "true",
                "boost": 8
            }
        }
    }
}'`


3.index some docs

`curl -XPOST http://localhost:9200/index/fulltext/1 -d'
{"content":"سلام امروز هوا خیلی خوبه"}
'`

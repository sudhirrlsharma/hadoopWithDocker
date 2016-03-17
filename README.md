# Goal of this project is to run [Word Count](https://hadoop.apache.org/docs/current/hadoop-mapreduce-client/hadoop-mapreduce-client-core/MapReduceTutorial.html#Example:_WordCount_v1.0) inside docker

## Build the image
```
docker build  -t sequenceiq/hadoop-docker:2.7.1 .
```

## Pull the image
```
docker pull sequenceiq/hadoop-docker:2.7.1
```

### Testing

You can run one of the stock examples:

## Start a container

```
docker run -it sequenceiq/hadoop-docker:2.7.1 /etc/bootstrap.sh -bash
docker -v $PROJECT_ROOT/deploy:/user/susharma/wordcount run -it sequenceiq/hadoop-docker:2.7.1 /etc/bootstrap.sh -bash
```

## Testing
```
cd $HADOOP_PREFIX
# run the mapreduce
bin/hadoop jar share/hadoop/mapreduce/hadoop-mapreduce-examples-2.7.1.jar grep input output 'dfs[a-z.]+'
```

# check the output
bin/hdfs dfs -cat output/*


## Run word count example

###Copy the file into hadoop cluster
```
cd $HADOOP_PREFIX
bin/hadoop fs -mkdir -p /wordcount/input
bin/hadoop fs -put /user/susharma/wordcount/file01 /wordcount/input/file01
bin/hadoop fs -put /user/susharma/wordcount/file01 /wordcount/input/file02
bin/hadoop fs -put /user/susharma/wordcount/Hadooplearning.jar .
```

###Check the content
```
bin/hadoop fs -ls /wordcount/input/
bin/hadoop fs -cat /wordcount/input/file01
bin/hadoop fs -cat /wordcount/input/file02
```

###run program to calculate the word count
```
bin/hadoop jar /user/susharma/wordcount/Hadooplearning.jar hadoop.WordCount /wordcount/input/file01 /wordcount/output
```

###Checkoutput
```
bin/hadoop fs -ls /wordcount/output/
bin/hadoop fs -cat /wordcount/output/part-00000
```
